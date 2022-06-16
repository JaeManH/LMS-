package com.min.ctrl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.min.service.ITagService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.min.service.IClassService;
import com.min.vo.ClassPeopleVo;
import com.min.vo.ClassVo;
import com.min.vo.InstructorVo;
import com.min.vo.SubjectVo;
import com.min.vo.VoteVo;

@Controller
@RequestMapping(value = "/user/*")
public class ClassController {

	@Autowired
	private IClassService service;
	@Autowired
	private ITagService tagService;

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "/classListForm.do", method = RequestMethod.GET)
	public String classListForm(Model model, HttpSession session) {
		List<ClassVo> lists = service.classSelectAll();
		model.addAttribute("lists", lists);
		return "admin/admin_classList";
	}
	
//	@RequestMapping(value = "/classListed.do", method = RequestMethod.GET)
//	public String classListed(Model model) {
//		List<ClassVo> lists = service.classSelectAll();
//		model.addAttribute("lists", lists);
//		return "admin/admin_classList";
//	}
	
	@RequestMapping(value = "/classSelectDetail.do", method = RequestMethod.GET, produces = "application/json")
	public String classSelectDetail(@RequestParam String cla_num, Model model, HttpSession session) throws org.json.simple.parser.ParseException {
		LocalDate now = LocalDate.now();
		model.addAttribute("now", now);
		
		ClassPeopleVo vo = new ClassPeopleVo();
		vo.setCpe_cla_num(cla_num);
		List<String> list = service.classVotedSelectAll(vo);
		System.out.println(list);
		model.addAttribute("idList", list);
		
		JSONParser parser = new JSONParser();
		session.setAttribute("cla_num", cla_num);
		ClassVo result = service.classSelectDetail(cla_num);
		String like = result.getCla_like();
		JSONArray likeArr = (JSONArray) parser.parse(like);
		result.setCla_like(String.valueOf(likeArr.size()));
		List<SubjectVo> lists = service.classSelectedSub(cla_num);
		
		model.addAttribute("result", result);
		model.addAttribute("lists", lists);
		System.out.println(result);
		
//		VoteVo voed = new VoteVo();
//		voed.setVot_cla_num(cla_num);
//		List<VoteVo> insList = service.votedPeople(voed);
		List<InstructorVo> insList = service.classInsInfo(cla_num);
		model.addAttribute("insList", insList);
		
		System.out.println(insList);
		
		JSONObject obj = new JSONObject();
		String res = "";
		
		List<Double> per = new ArrayList<Double>();
		
		
		JSONArray cnt = new JSONArray();
		JSONObject json = new JSONObject();
		try {
			for (int i = 0; i < insList.size(); i++) {
				res = insList.get(i).getVot_voter();
//				res = insList.get(i).getVot_voter();
				System.out.println("원본 : "+res);
				if(res==null) {
					res = "0";
					cnt.add(Integer.parseInt(res));
				}else {
					JSONArray listed = (JSONArray) parser.parse(res.toString());
					System.out.println("listed : "+listed);
					int voted = 0;
					for (int j = 0; j < listed.size(); j++) {
						voted++;
//						json.put("size", ss);
						System.out.println("횟수 : "+voted);
					}
					cnt.add(voted);
				}
			}
			System.out.println("확인 "+cnt);
			
			// 총 투표자
			System.out.println("투표자 수 : "+cnt);
//			ClassVo result2 = service.classSelectDetail("CLA027");
			Double total = (double) result.getCla_maxpeo();
			System.out.println("정원 : "+total);
			for (int j = 0; j < cnt.size(); j++) {
				System.out.println("비율 : "+cnt.get(j).toString());
				int ratio = (int) cnt.get(j);
				Double percent = ratio*100/total;
				Double pe = (double) Math.round(percent*100)/100.0;
				System.out.println(percent);
				per.add(pe);
			}
		} catch (Exception e) {
			System.out.println("투표자가 없습니다.");
		}
		
		
		model.addAttribute("percent", per);
		
		return "admin/admin_classDetail";
	}
	
	
	@RequestMapping(value = "/classInsertForm.do", method = RequestMethod.GET)
	public String classInsertForm(Model model) {
		logger.info("classInsertForm : 과정 생성폼");
		List<SubjectVo> lists = service.subjectSelected();
		model.addAttribute("lists", lists);
		return "admin/admin_classInsertForm";
	}
	
	@RequestMapping(value = "/classInsert.do", method = RequestMethod.POST)
	public String classInsert(@RequestParam String title, @RequestParam String content, @RequestParam List<String> subList) throws ParseException {
		JSONParser parser = new JSONParser();
		logger.info("classInsert : 과정 생성");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cla_title", title);
		map.put("cla_content", content);
		int n = service.classFormInsert(map);
		
//		ClassVo classVo = service.classSelectLastInsert();
//		String classNum = classVo.getCla_num();
		
		map.clear();
		for (String listed : subList) {
			map.put("csu_sub_num", listed);
			map.put("vot_sub_num", listed);
			int m = service.classSubjectInsert(map);
			
//			map.clear();
//			String tag = tagService.selectSubjectTag(listed);
//			Matcher matcher = TagController.TAG_REGEX.matcher(tag);
//			while (matcher.find()){
//				String temp = matcher.group().replace(" ", "_").replace("#", "").toString().toLowerCase();
//				JSONObject object = (JSONObject) parser.parse(tagService.selectTagJson(temp));
//				JSONArray array = (JSONArray) object.get("class");
//				array.add(classNum);
//				object.replace("class",array);
//				map.put("id",object.toJSONString());
//				map.put("name",temp);
//				tagService.updateTag(map);
//			}
			map.clear();
		}
		service.classTimeUpdate();
		return "redirect:/user/classListForm.do";
	}
	
	
	@RequestMapping(value = "/classModifyForm.do", method = RequestMethod.GET)
	public String classModifyForm(@SessionAttribute("cla_num") String cla_num, Model model) {
		logger.info("classModifyForm : 과정 수정 화면이동");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 15); // one day increment
		String result = String.valueOf(cal.get(Calendar.YEAR))+"-"+ String.format("%02d", cal.get(Calendar.MONTH)+1)+"-"+String.format("%02d", cal.get(Calendar.DATE));
		
		model.addAttribute("now", result);
		return "admin/admin_classModifyForm";
	}
	
	@RequestMapping(value = "/classModify.do", method = RequestMethod.POST)
	public String classModify(@RequestParam Map<String,Object> map, @RequestParam String cla_startdate, @SessionAttribute("cla_num") String cla_num) throws IOException, org.json.simple.parser.ParseException{
		logger.info("classModify : 과정 수정");
		map.put("cla_num", cla_num);
		List<String> res = new ArrayList<String>();
		int cla_addtime = 0;
		Calendar calen = Calendar.getInstance();
 		int nowYear = calen.get(Calendar.YEAR);
		int ch = nowYear;
		do {
		for (int j = 1; j < 13; j++) {
		String serviceKey = "zy%2FZZCSwzH2XN%2FGYNR%2FGFFKJ2z6s368WViy%2FwfzkHNxge5pG99WjgHiLmuFP9KQl60hNZPmAU9D8jExKOL9AiQ%3D%3D";
        String addr = "http://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService";
        String query = "/getRestDeInfo?";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(addr);
        stringBuffer.append(query);
        stringBuffer.append("solYear="+ch);
        stringBuffer.append("&solMonth="+String.format("%02d", j));
        stringBuffer.append("&_type=json");
        stringBuffer.append("&ServiceKey=" + serviceKey);
        
        try {
            URL url = new URL(stringBuffer.toString());
            URLConnection conn = url.openConnection();
            BufferedReader rd = null;
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
            
            String line= rd.readLine();
            
            JSONParser jsonParser = new JSONParser();//JSON데이터를 넣어 JSON Object 로 만들어 준다.
            JSONObject jsonObject = (JSONObject) jsonParser.parse(line);
            JSONObject obj = (JSONObject) jsonObject.get("response");
            JSONObject obj2 = (JSONObject) obj.get("body");
            
            try {
            	JSONObject obj3 = (JSONObject) obj2.get("items");
                JSONArray holidays = (JSONArray) obj3.get("item");
                
                System.out.println(holidays);
                
                System.out.println("■■■■■■■■■■■■■■■ 휴일 ■■■■■■■■■■■■■■■");
                for (int i = 0; i < holidays.size(); i++) {
                	JSONObject holiday = (JSONObject) holidays.get(i);
                	long selholi = (long) holiday.get("locdate");
                	res.add(String.valueOf(selholi));
                	System.out.println(selholi);
    			}
                System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
                System.out.println(res);
                
			} 
            catch (Exception e) {
            	try {
            		JSONObject obj3 = (JSONObject) obj2.get("items");
//    	            System.out.println(obj3);
    	            JSONObject obj4 = (JSONObject) obj3.get("item");
//    	            System.out.println(obj4);
    	            long selholi = (long) obj4.get("locdate");
    	            System.out.println("■■■■■■■■■■■■■■■ 휴일 ■■■■■■■■■■■■■■■");
    	            System.out.println(selholi);
    	            System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				} catch (Exception e2) {
					System.out.println("==해당 월에는 공휴일이 없습니다==");
				}
			}
            rd.close();
        } 
        catch (IOException e) {
        	e.printStackTrace();
        }
    }
		ch++;	
		} while (ch<nowYear+2);
		
		 Calendar cal = Calendar.getInstance();
		// 사용자가 등록하는 월, 일을 여기다 매핑
 		// Calendar의 Month는 0부터 시작하므로 -1 해준다.
		
		String first = cla_startdate.substring(0, 4);
		int year = Integer.parseInt(first)-1;
		String second = cla_startdate.substring(5, 7);
		int month = Integer.parseInt(second)-1;
		String last = cla_startdate.substring(8, 10);
		int date = Integer.parseInt(last)-1;
 		cal.set(year , month, date);
// 		System.out.println(cal.getTime());
 		map.put("cla_addtime", cla_addtime);
 		service.classUpdate(map);
 		
 		// 이걸 사용 ---------------
 		ClassVo voed = new ClassVo();
 		voed.setCla_num(cla_num);
 		
 		
 		int cnt = 0;
 		List<VoteVo> tm = service.classTimeSearch(voed);
 		for (VoteVo voteVo : tm) {
			cnt = voteVo.getClassvo().getCla_totaltime();
		}
 		
 		for (int i = 0; i < cnt; i++) {
 			// cal.set = 2022-10-20
 			// 실제 = 2022-11-21
 			cal.add(Calendar.DATE, 1); // one day increment
 			String result = String.valueOf(cal.get(Calendar.YEAR)) + String.format("%02d", cal.get(Calendar.MONTH)+1)+String.format("%02d", cal.get(Calendar.DATE));
 			
 			int day = cal.get(Calendar.DAY_OF_WEEK);
 			System.out.println("----------------------------");
 			System.out.println("최종 폼 : "+result);
 			System.out.println("월 : "+ cal.get(Calendar.MONTH));
 			System.out.println(cal.getTime());
 			System.out.println("----------------------------");
 			// 일요일 : 1 , 토요일 : 7
 			if(day == 1 || day == 7 || res.contains(result)) {
 				cla_addtime++;
 				i--;
 				System.out.println(cla_addtime+ "번째");
 			}
 		}
		map.put("cla_addtime", cla_addtime);
		service.classUpdate(map);
		System.out.println(year);
		System.out.println(month);
		System.out.println(date);
		
		return "redirect:/user/classListForm.do";
	}
	
	
	@RequestMapping(value = "/votedResult.do", method = RequestMethod.GET)
	public String votedResult(@SessionAttribute("cla_num") String cla_num) throws IOException, org.json.simple.parser.ParseException {
		ClassVo voed = new ClassVo();
 		voed.setCla_num(cla_num);
		List<VoteVo> tm = service.classTimeSearch(voed);
		
		for (int h = 0; h < tm.size(); h++) {
		
//		String sub = "20220523SUB100";
		
		VoteVo vo = new VoteVo();
		vo.setVot_sub_num(tm.get(h).getVot_sub_num());
//		vo.setVot_sub_num(sub);
		vo.setVot_cla_num(cla_num);
		List<VoteVo> lists = service.voteRatio(vo);
//		String vot_sub_num = "20220523SUB100";
		
		JSONParser parser = new JSONParser();
		String resu = "";
		String ins = "";
//		String sub_num = "";
		int max = 0;
		int voted = 0;
		JSONArray cnted = new JSONArray();
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		JSONArray arr = new JSONArray();
			try {
			for (int i = 0; i < lists.size(); i++) {
				JSONObject obj = new JSONObject();
				resu = lists.get(i).getVot_voter();
				ins = lists.get(i).getVot_ins_id();
				
				System.out.println("원본 : "+resu);
				System.out.println("강사 : "+ins);
				
				if(lists.get(i).getVot_voter() == null) {
					continue;
				}
				array = (JSONArray) parser.parse(resu.toString());
				System.out.println("array : "+array);
				JSONObject obj2 = new JSONObject();
				for (int j = 0; j < array.size(); j++) {
					obj2 = (JSONObject) parser.parse(array.get(j).toString());
					arr.add(obj2);
				}
				
				
				if(resu==null) {
					resu = "0";
					obj.put("voted", resu);
					obj.put("id", ins);
					cnted.add(obj);
				}else {
					JSONArray listed = (JSONArray) parser.parse(resu.toString());
					System.out.println("listed : "+listed);
					voted = 0;
					for (int j = 0; j < listed.size(); j++) {
						voted++;
						
					}
					
					System.out.println("횟수 : "+voted);
					obj.put("voted", voted);
					obj.put("id", ins);
					cnted.add(obj);
				}
			}
			System.out.println("arr : "+arr.toJSONString());
			System.out.println("확인 "+cnted);
			
			JSONObject r = new JSONObject();
			JSONArray re = new JSONArray();
			for (int i = 0; i < cnted.size(); i++) {
				JSONObject obj = (JSONObject) cnted.get(i);
				
				if(Integer.parseInt(obj.get("voted").toString()) > max) {
					max = Integer.parseInt(obj.get("voted").toString());
					r.put("voted", max);
					r.put("id", obj.get("id"));
					re.add(r);
						
				}
			}
			
			System.out.println("최종 뽑힌 강사 : "+re);
			
			
			for (int i = 0; i < re.size(); i++) {
				json = (JSONObject) parser.parse(re.get(i).toString());
			}
			if(json.get("id").equals(null)) {
				continue;
			}
			System.out.println(json.get("id"));
			
			Map<String, Object> mapped = new HashMap<String, Object>();
			mapped.put("vot_cla_num", cla_num);
			mapped.put("vot_sub_num", tm.get(h).getVot_sub_num());
			service.voteDelete(mapped);
			mapped.clear();
			
			mapped.put("vot_cla_num", cla_num);
			mapped.put("vot_sub_num", tm.get(h).getVot_sub_num());
			mapped.put("vot_ins_id", json.get("id"));
			mapped.put("vot_voter", arr.toJSONString());
			service.votedInsert(mapped);
			System.out.println(mapped);
			
			
			
			
		} catch (Exception e) {
			System.out.println("투표자가 없습니다.");
		}
	}
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■");
		VoteVo vo = new VoteVo();
		vo.setVot_cla_num("CLA032");
		List<VoteVo> list = service.votedPeople(vo);
		for (int i = 0; i < list.size(); i++) {
			list.get(i).getVot_voter();
			System.out.println("널값 체크 : "+list.get(i).getVot_voter());
			System.out.println("널값 체크용 서브 : "+list.get(i).getVot_sub_num());
			if(list.get(i).getVot_voter()==null) {
				System.out.println("삭제 : "+list.get(i).getVot_sub_num());
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("vot_cla_num", "CLA032");
				map.put("vot_sub_num", list.get(i).getVot_sub_num());
				service.voteDelete(map);
			}
		}
		
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("cla_num", cla_num);
			map.put("cla_status", "개강전");
			service.classStatusUpdate(map);
			return "redirect:/user/classListForm.do";
		}
	
	
	@RequestMapping(value = "/voteBoxInsert.do", method = RequestMethod.POST)
	public String voteBoxInsert(@RequestParam String sub_num, @SessionAttribute("cla_num") String cla_num, 
			Authentication user) {
		VoteVo vo = new VoteVo();
		vo.setVot_cla_num(cla_num);
		vo.setVot_sub_num(sub_num);
		List<VoteVo> list = service.voteRatio(vo);
		for (int i = 0; i < list.size(); i++) {
//			if(list.get(i).getVot_ins_id().equals(user.toString())) {
			if(list.get(i).getVot_ins_id().equals("thdwndrlrkdtk123")) {
				return "redirect:/user/classSelectDetail.do?cla_num="+cla_num;
			}
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("vot_sub_num", sub_num);
		map.put("vot_cla_num", cla_num);
//		map.put("vot_ins_id", user.getPrincipal());
		map.put("vot_ins_id", "thdwndrlrkdtk123");
		service.voteBoxInsert(map);
		return "redirect:/user/classSelectDetail.do?cla_num="+cla_num;
	}
	
	@RequestMapping(value = "/updateVote.do", method = RequestMethod.POST)
	public String updateVote(@SessionAttribute("cla_num") String cla_num, HttpServletRequest req, @RequestParam String vot_sub_num, @RequestParam String ins_id, 
			Authentication user) throws ParseException {
		
		JSONParser parser = new JSONParser();
		JSONArray id = new JSONArray();
		JSONArray arr = new JSONArray();
//		String cla_num = "CLA027";
//		String vot_sub_num = "20220523SUB101";
//		String ins_id = "thdwndrlrkdtk123";
//		String inputId = user.getPrincipal();
		Map<String, Object> mapped = new HashMap<String, Object>();
		
		
//		try {
		JSONObject fin = new JSONObject();
		
		VoteVo vo = new VoteVo();
		vo.setVot_sub_num(vot_sub_num);
		vo.setVot_cla_num(cla_num);
		vo.setVot_ins_id(ins_id);
		
		// 첫번째 =================================
		// 기존 투표자들을 추출해서 다시 업데이트 과정 전초
		try {
			VoteVo result = service.voteIns(vo);
			System.out.println(result);
			JSONArray json = (JSONArray) parser.parse(result.getVot_voter());
			
			for (int i = 0; i < json.size(); i++) {
//				System.out.println("listed : "+listed);
				JSONObject obj = (JSONObject) parser.parse(json.get(i).toString());
				System.out.println(obj.get("id"));
				obj.put("id", obj.get("id")); 
				obj.put("pay", obj.get("pay"));
				id.add(obj);
			}
			
			System.out.println(id);
		} catch (Exception e) {
		}
		
		
		// 두번째 =================================
		// 새로 투표하는 사람이 전에 투표했는지 확인 과정
		
		String ids = "";
		VoteVo all = new VoteVo();
		JSONArray array = new JSONArray();
		all.setVot_sub_num(vot_sub_num);
		all.setVot_cla_num(cla_num);
		List<VoteVo> lists = service.voteRatio(all);
		System.out.println("원본 : "+lists);
		System.out.println("■■■■■■■■■■");
//		for (int i = 0; i < lists.size(); i++) {
//			JSONArray list = (JSONArray) parser.parse(lists.toString());
		
		
//		JSONArray list = (JSONArray) parser.parse(lists.toString());
//		System.out.println(list.toJSONString());
		for (int i = 0; i < lists.size(); i++) {
			
			System.out.println("lists : "+ lists.get(i).getVot_voter());
			String res = lists.get(i).getVot_voter();
			
			if(lists.get(i).getVot_voter() == null) {
//				result = lists.get(i).getVot_voter();
//				res = "";
				continue;
//				System.out.println("result1 : "+res);
			}
			
			array = (JSONArray) parser.parse(res);
			
			for (int j = 0; j < array.size(); j++) {
				JSONObject obj = (JSONObject) array.get(j);
				System.out.println(obj);
				arr.add(obj);
			}
			
			
		}
		
		System.out.println(array);
		if(arr.equals("")) {
			System.out.println("투표한 사람이 없습니다.");
			
			fin.put("id", user.getPrincipal());
			fin.put("pay", "before");
			id.add(fin);
			
			
			Map<String, Object> map = new HashMap();
			map.put("vot_cla_num", cla_num);
			map.put("vot_sub_num", vot_sub_num);
			map.put("vot_ins_id", ins_id);
			map.put("vot_voter", id.toJSONString());
			
			service.updateVote(map);
			
			System.out.println("ID : "+id);
			
			ClassPeopleVo voed = new ClassPeopleVo();
			voed.setCpe_cla_num(cla_num);
			voed.setCpe_mem_id(user.getPrincipal().toString());
			int n = service.classPeoSelectAll(voed);
			if(n>0) {
				return "redirect:/app/classSelectDetail.do?cla_num="+cla_num;
			}else {
				mapped.put("cpe_mem_id", user.getPrincipal());
				mapped.put("cpe_cla_num", cla_num);
				service.classPeoInsert(mapped);
				System.out.println("maped : "+mapped);
			}
			
			return "redirect:/user/classSelectDetail.do?cla_num="+cla_num;
		}
		for (Object object : arr) {
			JSONObject list2 = (JSONObject) parser.parse(object.toString());
			System.out.println("obj : "+list2);
			ids = list2.get("id").toString();
			System.out.println(ids);
			
//			JSONObject ided = (JSONObject)parser.parse(list.toJSONString());
//			
			if(ids.equals(user.getPrincipal())) {
				System.out.println("중복된 아이디가 있습니다.");
				return "redirect:/user/classSelectDetail.do?cla_num="+cla_num;
			}
			
		}
//		System.out.println("id값 구하기 : "+list.get("id"));
		System.out.println("result2 : "+ arr);
		
		
		fin.put("id", user.getPrincipal());
		fin.put("pay", "before");
		id.add(fin);
		
		System.out.println("id : "+id);
		Map<String, Object> map = new HashMap();
		map.put("vot_cla_num", cla_num);
		map.put("vot_sub_num", vot_sub_num);
		map.put("vot_ins_id", ins_id);
		map.put("vot_voter", id.toJSONString());
		
		service.updateVote(map);
		
		System.out.println("ID : "+id);
	
		ClassPeopleVo voed = new ClassPeopleVo();
		voed.setCpe_cla_num(cla_num);
		voed.setCpe_mem_id(user.getPrincipal().toString());
		int n = service.classPeoSelectAll(voed);
		if(n>0) {
			return "redirect:/user/classSelectDetail.do?cla_num="+cla_num;
		}else {
			mapped.put("cpe_mem_id", user.getPrincipal());
			mapped.put("cpe_cla_num", cla_num);
			service.classPeoInsert(mapped);
			System.out.println("maped : "+mapped);
		}
		
		return "redirect:/user/classSelectDetail.do?cla_num="+cla_num;
	}
	
	
	
	
	
}
