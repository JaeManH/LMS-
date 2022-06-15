package com.min;


import static org.hamcrest.CoreMatchers.endsWith;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.min.dao.IClassBoardDao;
import com.min.dao.IClassDao;
import com.min.dao.IStatisticsDao;
import com.min.dao.ITagDao;
import com.min.service.IClassService;
import com.min.service.IStatisticsService;
import com.min.service.ITagService;
import com.min.vo.ClassBoardVo;
import com.min.vo.ClassPeopleVo;
import com.min.vo.ClassVo;
import com.min.vo.InstructorVo;
import com.min.vo.SubjectVo;
import com.min.vo.TagVo;
import com.min.vo.VoteVo;

import lombok.EqualsAndHashCode.Include;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/*.xml"})
public class Class_Test {

	@Autowired
	private IClassDao dao;

	@Autowired
	private IClassBoardDao bDao;

	@Autowired
	private IClassService service;
	
	@Autowired
    private ITagDao tDao;
    @Autowired
    private IStatisticsDao sDao;
    @Autowired
    private ITagService tagService;
    @Autowired
    private IStatisticsService statisticsService;
//
//
////	@Test
//	public void classSelectAll() {
//		List<ClassVo> lists = dao.classSelectAll();
//		System.out.println(lists);
//	}
//
////	@Test
//	public void classSelectDetail() {
//		ClassVo vo = new ClassVo();
////		String like = vo.cla_like.toString();
//		ClassVo list = dao.classSelectDetail("CLA001");
//		System.out.println(list);
//	}
//
////	@Test
//	public void classFormInsert() {
//		Map<String, Object> lists = new HashMap<String, Object>();
//		lists.put("cla_title", "JAVA 전문가 과정 배우기");
//		lists.put("cla_content", "JAVA 전문가 과정을 통해 현장에서도 문제없이!");
//		int n = dao.classFormInsert(lists);
//	}
//
////	@Test
//	public void classSubjectInsert() {
//		Map<String, Object> lists = new HashMap<String, Object>();
//		lists.put("csu_sub_num", "20220523SUB100");
//		int n = dao.classSubjectInsert(lists);
//	}
//
////	@Test
////package com.min;
////
////
////import static org.hamcrest.CoreMatchers.endsWith;
////
////import java.io.BufferedReader;
////import java.io.File;
////import java.io.IOException;
////import java.io.InputStreamReader;
////import java.io.UnsupportedEncodingException;
////import java.net.HttpURLConnection;
////import java.net.MalformedURLException;
////import java.net.ProtocolException;
////import java.net.URL;
////import java.net.URLConnection;
////import java.net.URLEncoder;
////import java.text.ParseException;
////import java.text.SimpleDateFormat;
////import java.util.ArrayList;
////import java.util.Calendar;
////import java.util.Date;
////import java.util.HashMap;
////import java.util.List;
////import java.util.Map;
////import java.util.UUID;
////
////import org.json.simple.JSONArray;
////import org.json.simple.JSONObject;
////import org.json.simple.parser.JSONParser;
////import org.junit.Test;
////import org.junit.runner.RunWith;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.test.context.ContextConfiguration;
////import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
////
////import com.google.gson.JsonObject;
////import com.min.dao.IClassBoardDao;
////import com.min.dao.IClassDao;
////import com.min.service.IClassService;
////import com.min.vo.ClassBoardVo;
////import com.min.vo.ClassVo;
////import com.min.vo.InstructorVo;
////import com.min.vo.SubjectVo;
////import com.min.vo.VoteVo;
////
////@RunWith(SpringJUnit4ClassRunner.class)
////@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/*.xml"})
////public class Class_Test {
////
////	@Autowired
////	private IClassDao dao;
////
////	@Autowired
////	private IClassBoardDao bDao;
////
////	@Autowired
////	private IClassService service;
////
////
//////	@Test
////	public void classSelectAll() {
////		List<ClassVo> lists = dao.classSelectAll();
////		System.out.println(lists);
////	}
////
//////	@Test
////	public void classSelectDetail() {
////		ClassVo vo = new ClassVo();
//////		String like = vo.cla_like.toString();
////		ClassVo list = dao.classSelectDetail("CLA001");
////		System.out.println(list);
////	}
////
//////	@Test
////	public void classFormInsert() {
////		Map<String, Object> lists = new HashMap<String, Object>();
////		lists.put("cla_title", "JAVA 전문가 과정 배우기");
////		lists.put("cla_content", "JAVA 전문가 과정을 통해 현장에서도 문제없이!");
////		int n = dao.classFormInsert(lists);
////	}
////
//////	@Test
////	public void classSubjectInsert() {
////		Map<String, Object> lists = new HashMap<String, Object>();
////		lists.put("csu_sub_num", "20220523SUB100");
////		int n = dao.classSubjectInsert(lists);
////	}
////
//////	@Test
//////	public void subjectSelected() {
//////		List<SubjectVo> lists = dao.subjectSelected();
//////		System.out.println(lists);
//////	}
////
//////	@Test
////	public void subjectSelected() {
////		List<SubjectVo> lists = dao.subjectSelected();
////		System.out.println(lists);
////	}
////
//////	@Test
////	public void classTimeUpdate() {
////		dao.classTimeUpdate();
////	}
////
////
////
//////	@Test
//////	public void classBoardSelectAll() {
//////		ClassBoardVo vo = new ClassBoardVo();
//////		vo.setCbo_cate("동영상");
//////		vo.setCbo_cla_num("CLA001");
//////		List<ClassBoardVo> lists = bDao.classBoardSelectAll(vo);
//////		System.out.println(lists);
//////	}
////
//////	@Test
////	public void classBoardSelectDetail() {
////		ClassBoardVo vo = bDao.classBoardSelectDetail(1);
////		System.out.println(vo);
////	}
////
//////	@Test
////	public void classVideoInsert() {
////		Map<String, Object> map = new HashMap<String, Object>();
////		map.put("cbo_cla_num", "CLA001");
////		map.put("cbo_cate", "동영상");
////		map.put("cbo_ins_id", "thdwndrlrkdtk123");
////		map.put("cbo_title", "대충 제목");
////		map.put("cbo_content", "대충 내용");
////		map.put("cbo_youtubeadd", "어떤 주소");
////		bDao.classVideoInsert(map);
////	}
//////	@Test
////	public void classDocInsert() {
////		Map<String, Object> map = new HashMap<String, Object>();
////		map.put("doc_file", "강의계획서054");
////		map.put("doc_originname", "강의계획서00054");
////		map.put("doc_savename", "강의자료54");
////		map.put("doc_path", "C:/Users/user/Desktop/강의계획서pdf_files");
////		map.put("doc_extention", ".png");
////		bDao.classDocInsert(map);
////	}
//////	@Test
////	public void classBoardDocInsert() {
////		Map<String, Object> map = new HashMap<String, Object>();
////		map.put("cbo_cla_num", "CLA001");
////		map.put("cbo_cate", "자료");
////		map.put("cbo_ins_id", "thdwndrlrkdtk123");
////		map.put("cbo_title", "제목");
////		map.put("cbo_content", "내용");
////		bDao.classBoardDocInsert(map);
////		System.out.println(map);
////	}
////
//////	@Test
////	public void test() throws ParseException, org.json.simple.parser.ParseException {
////		for (int j = 1; j < 13; j++) {
////		String serviceKey = "zy%2FZZCSwzH2XN%2FGYNR%2FGFFKJ2z6s368WViy%2FwfzkHNxge5pG99WjgHiLmuFP9KQl60hNZPmAU9D8jExKOL9AiQ%3D%3D";
////        String addr = "http://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService";
////        String query = "/getHoliDeInfo?";
////        StringBuffer stringBuffer = new StringBuffer();
////        stringBuffer.append(addr);
////        stringBuffer.append(query);
////        stringBuffer.append("solYear=2022");
////        stringBuffer.append("&solMonth="+String.format("%02d", j));
//////        stringBuffer.append("&solMonth=06");
////        stringBuffer.append("&_type=json");
////        stringBuffer.append("&ServiceKey=" + serviceKey);
////
////        int cnt = 0;
////
////        System.out.println("stringBuffer.toString() "+ stringBuffer.toString());
////
////
////
////        try {
////            URL url = new URL(stringBuffer.toString());
////            URLConnection conn = url.openConnection();
////            BufferedReader rd = null;
////
////            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
////
////            String line= rd.readLine();
////
////            JSONParser jsonParser = new JSONParser();//JSON데이터를 넣어 JSON Object 로 만들어 준다.
////            JSONObject jsonObject = (JSONObject) jsonParser.parse(line);
////            System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
////            System.out.println(jsonObject);
////            System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
////            JSONObject obj = (JSONObject) jsonObject.get("response");
////            System.out.println(obj);
////            JSONObject obj2 = (JSONObject) obj.get("body");
////            System.out.println(obj2);
////
////            try {
////            	JSONObject obj3 = (JSONObject) obj2.get("items");
////                JSONArray holidays = (JSONArray) obj3.get("item");
////                System.out.println(holidays);
////
////                List<String> res = new ArrayList<String>();
////                for (int i = 0; i < holidays.size(); i++) {
////                	JSONObject holiday = (JSONObject) holidays.get(i);
////                	long selholi = (long) holiday.get("locdate");
////                	res.add(String.valueOf(selholi));
////                	System.out.println(selholi);
////    			}
////                System.out.println(res);
////
////                Calendar cal = Calendar.getInstance();
////        		// Calendar의 Month는 0부터 시작하므로 -1 해준다.
////        		cal.set(2022, 5, 20);
////        		System.out.println(cal.getTime());
////
////        		for (int i = 0; i < 10; i++) {
////        			String result = cal.get(Calendar.YEAR)+""+String.format("%02d", cal.get(Calendar.MONTH))+String.format("%02d", cal.get(Calendar.DATE));
////
////        			cal.add(Calendar.DATE, 1); // one day increment
////        			int day = cal.get(Calendar.DAY_OF_WEEK);
////
////        			System.out.println("최종 폼 : "+result);
////        			System.out.println("월 : "+ cal.get(Calendar.MONTH));
////        			System.out.println(cal.getTime());
////        			System.out.println(day);
////        			System.out.println(cnt + "번째");
////
////        			// 일요일 : 1 , 토요일 : 7
////        			if(day == 1 || day == 7) {
////        				i--;
////        			}
////        			if(res.contains(result)) {
////        				i--;
////        			}
////
////        			cnt++;
////        		}
////
////
////
////			}
////
////            catch (Exception e) {
////            	try {
////            		JSONObject obj3 = (JSONObject) obj2.get("items");
////    	            System.out.println(obj3);
////    	            JSONObject obj4 = (JSONObject) obj3.get("item");
////    	            System.out.println(obj4);
////    	            long selholi = (long) obj4.get("locdate");
////    	            System.out.println("■■■■■■■■■■■■■■■ 휴일 ■■■■■■■■■■■■■■■");
////    	            System.out.println(selholi);
////    	            System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
////				} catch (Exception e2) {
////					System.out.println("==해당 월에는 공휴일이 없습니다==");
////				}
////			}
////
////            rd.close();
////
////        }
////        catch (IOException e) {
////        	e.printStackTrace();
////        }
////    }
////
////		ch++;
////		} while (ch<2024);
////
////
////		 Calendar cal = Calendar.getInstance();
////		// 사용자가 등록하는 월, 일을 여기다 매핑
//// 		// Calendar의 Month는 0부터 시작하므로 -1 해준다.
//// 		cal.set(2022, 12-1, 24-1);
////// 		System.out.println(cal.getTime());
////
//// 		for (int i = 0; i < 30; i++) {
//// 			// cal.set = 2022-10-20
//// 			// 실제 = 2022-11-21
//// 			cal.add(Calendar.DATE, 1); // one day increment
//// 			String result = String.valueOf(cal.get(Calendar.YEAR)) + String.format("%02d", cal.get(Calendar.MONTH)+1)+String.format("%02d", cal.get(Calendar.DATE));
////
//// 			int day = cal.get(Calendar.DAY_OF_WEEK);
//// 			System.out.println("----------------------------");
//// 			System.out.println("최종 폼 : "+result);
//// 			System.out.println("월 : "+ cal.get(Calendar.MONTH));
//// 			System.out.println(cal.getTime());
//// 			System.out.println("----------------------------");
//// 			// 일요일 : 1 , 토요일 : 7
//// 			if(day == 1 || day == 7 || res.contains(result)) {
//// 				cnt++;
//// 				i--;
//// 				System.out.println(cnt+ "번째");
//// 			}
////
//// 		}
////
////
////	}
//
//
////	@Test
//	public void Stringsub() {
//		String end= "2022-06-15";
//		String first = end.substring(0, 4);
//		String second = end.substring(5, 7);
//		String last = end.substring(8, 10);
//
//		System.out.println(first);
//		System.out.println(Integer.parseInt(first)-1);
//		System.out.println(second);
//		System.out.println(last);
//	}
//
////	@Test
//	public void Upload() {
//		String originalFile = "C:/upload/tmp/Spring표.jpg";
//		String originalFileExtention = originalFile.substring(originalFile.indexOf("."));
//		String storedFileName = UUID.randomUUID().toString().replaceAll("-", "") + originalFileExtention;
////		String filePath = "C:/upload/tmp";
//		System.out.println("originalFile :" + originalFile);
//		System.out.println("originalFileExtention :" + originalFileExtention);
//		System.out.println("storedFileName :" + storedFileName);
////		System.out.println("filename :" + filename);
//
////		File file = new File(filePath + storedFileName);
//
////		filename.transferTo(file);
//	}
//
////	@Test
//	public void test4(){
//		String filePath = "C:/upload/tmp/";
//		String result = filePath.substring(14);
//		System.out.println(result);
//	}
//
//	@Test
	public void test3() {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("cpe_mem_id", "altkdlf2273");
//		map.put("cpe_cla_num", "CLA027");
//		service.classPeoInsert(map);
//		
		System.out.println(service.classInsInfo("CLA019"));
	}
	@Test
	 public void selectTagTest() throws ParseException, org.json.simple.parser.ParseException {
	        //새로운 태그 추가하는 곳
//	        logger.info("selectTagTest 실행");
	        List<TagVo> lists = tDao.selectTagClassAndSubject();
	        String temp;

	        Pattern p = Pattern.compile("#([a-zA-Z0-9가-힣]*)");
	        JSONParser parser = new JSONParser();
	        JSONArray tags = new JSONArray();
	        JSONArray arr = new JSONArray();
	        List<String> addTags = new ArrayList<String>();
	        List<String> insertTags = new ArrayList<String>();
	        for (TagVo vo : lists) {
	            if (vo.getTag() != null) {
	                arr = (JSONArray) parser.parse(vo.getTag().toString());
	            }else{
	                continue;
	            }
	            //TODO 태그 추가하기
	            for (int i = 0; i < arr.size(); i++) {
	                Matcher m = p.matcher(arr.get(i).toString());
	                while (m.find()) {
	                    temp = m.group().replace(" ", "_").replace("#", "").toString().toLowerCase();
	                    //만약에 기존 태그중에 없으면 새로운 태그 추가
	                    if (!tags.contains(temp) && !addTags.contains(temp)) {
	                        addTags.add(temp);
	                    }
	                }
	            }
	        }
	        int result = tagService.insertTagNew(addTags);
	        System.out.println(result);
	    }
	
//	@Test
	public void te() {
//		LocalDate myNow = LocalDate.now();
//		LocalDate now = LocalDate.of(myNow.getYear(), myNow.getMonth(), myNow.getDayOfMonth()+15);
//		
//		System.out.println(now);
		VoteVo vo = new VoteVo();
		vo.setVot_cla_num("CLA027");
		List<VoteVo> list = service.votedPeople(vo);
		String id = "thdwndrlrkdtk123";
		System.out.println("list : "+list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getVot_ins_id());
			if(list.get(i).getVot_ins_id().equals(id)) {
				System.out.println("중복된 id가 존재합니다.");
				return;
			}
		}
		
	}
	
	// 최종본
//	@Test
	public void test5() throws org.json.simple.parser.ParseException {
			JSONParser parser = new JSONParser();
			JSONArray id = new JSONArray();
			String cla_num = "CLA027";
			String vot_sub_num = "20220523SUB101";
			String ins_id = "thdwndrlrkdtk123";
			String inputId = "kdellenbrook2p640";
			JSONArray arr = new JSONArray();
			String ids = "";
			Map<String, Object> maped = new HashMap<String, Object>();
//			try {
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
//				JSONObject json = (JSONObject) parser.parse(result.getVot_voter());
				
//				System.out.println("json : "+json);
				
				for (int i = 0; i < json.size(); i++) {
//					System.out.println("listed : "+listed);
					JSONObject obj = (JSONObject) parser.parse(json.get(i).toString());
					System.out.println(obj.get("id"));
					obj.put("id", obj.get("id")); 
					obj.put("pay", obj.get("pay"));
					id.add(obj);
				}
				
				System.out.println(id);
			} catch (Exception e) {
			}
//			VoteVo result = service.voteIns(vo);
//			System.out.println(result);
//			
//			JSONArray json = (JSONArray) parser.parse(result.getVot_voter());
////			JSONObject json = (JSONObject) parser.parse(result.getVot_voter());
//			
//			JSONArray id = new JSONArray();
//			
//			
////			System.out.println("json : "+json);
//			
//			for (int i = 0; i < json.size(); i++) {
////				System.out.println("listed : "+listed);
//				JSONObject obj = (JSONObject) parser.parse(json.get(i).toString());
//				System.out.println(obj.get("id"));
//				obj.put("id", obj.get("id")); 
//				obj.put("pay", obj.get("pay"));
//				id.add(obj);
//			}
//			
//			System.out.println(id);
			
			
			// 두번째 =================================
			// 새로 투표하는 사람이 전에 투표했는지 확인 과정
			
//			try {
				
			
			
//			List<String> array = new ArrayList<String>();
			JSONArray array = new JSONArray();
			VoteVo all = new VoteVo();
			all.setVot_sub_num(vot_sub_num);
			all.setVot_cla_num(cla_num);
			List<VoteVo> lists = service.voteRatio(all);
			System.out.println("원본 : "+lists);
			System.out.println("■■■■■■■■■■");
//			for (int i = 0; i < lists.size(); i++) {
//				JSONArray list = (JSONArray) parser.parse(lists.toString());
			
			
//			JSONArray list = (JSONArray) parser.parse(lists.toString());
//			System.out.println(list.toJSONString());
			for (int i = 0; i < lists.size(); i++) {
				
				System.out.println("lists : "+ lists.get(i).getVot_voter());
				String res = lists.get(i).getVot_voter();
				
				if(lists.get(i).getVot_voter() == null) {
//					result = lists.get(i).getVot_voter();
//					res = "";
					continue;
//					System.out.println("result1 : "+res);
				}
				
				array = (JSONArray) parser.parse(res);
				
				for (int j = 0; j < array.size(); j++) {
					JSONObject obj = (JSONObject) array.get(j);
					System.out.println(obj);
					arr.add(obj);
				}
				
				
			}
			
			System.out.println(array);
			
			System.out.println("최종 : " + arr);
			if(lists.equals("") || arr == null) {
				System.out.println("투표한 사람이 없습니다.");
				
				fin.put("id", inputId);
				fin.put("pay", "before");
				id.add(fin);
				
				Map<String, Object> map = new HashMap();
				map.put("vot_cla_num", cla_num);
				map.put("vot_sub_num", vot_sub_num);
				map.put("vot_ins_id", ins_id);
				map.put("vot_voter", id.toJSONString());
				
				service.updateVote(map);
				
				System.out.println("ID : "+id);
				// insert 문구 넣기 ----------------------
				ClassPeopleVo voed = new ClassPeopleVo();
				voed.setCpe_cla_num(cla_num);
				voed.setCpe_mem_id(inputId);
				int n = service.classPeoSelectAll(voed);
				if(n>0) {
					return;
				}else {
					maped.put("cpe_mem_id", inputId);
					maped.put("cpe_cla_num", cla_num);
					service.classPeoInsert(maped);
					System.out.println("maped : "+maped);
				}
				return;
			}
//			}
//			JSONArray list = (JSONArray) parser.parse(arr);
//			JSONObject list = (JSONObject) parser.parse(result);
//			System.out.println(list.toJSONString());
			for (Object object : arr) {
				JSONObject list2 = (JSONObject) parser.parse(object.toString());
				System.out.println("obj : "+list2);
				ids = list2.get("id").toString();
				System.out.println(ids);
				
//				JSONObject ided = (JSONObject)parser.parse(list.toJSONString());
//				
				if(ids.equals(inputId)) {
					System.out.println("중복된 아이디가 있습니다.");
					return;
				}
				
			}
//			System.out.println("id값 구하기 : "+list.get("id"));
//			System.out.println("result2 : "+ re);
			
			
			fin.put("id", inputId);
			fin.put("pay", "before");
			id.add(fin);
			
			Map<String, Object> map = new HashMap();
			map.put("vot_cla_num", cla_num);
			map.put("vot_sub_num", vot_sub_num);
			map.put("vot_ins_id", ins_id);
			map.put("vot_voter", id.toJSONString());
			
			service.updateVote(map);
			
			System.out.println("ID : "+id);
		
			// insert 문구 넣기 ----------------------
			ClassPeopleVo voed = new ClassPeopleVo();
			voed.setCpe_cla_num(cla_num);
			voed.setCpe_mem_id(inputId);
			int n = service.classPeoSelectAll(voed);
			if(n>0) {
				return;
			}else {
				maped.put("cpe_mem_id", inputId);
				maped.put("cpe_cla_num", cla_num);
				service.classPeoInsert(maped);
				System.out.println("maped : "+maped);
			}
			
//			// 여기부터 x
//			
//			
////			} catch (Exception e) {
////				JSONObject fin = new JSONObject();
////				JSONArray id = new JSONArray();
////				fin.put("id", "wndrl01");
////				fin.put("pay", "before");
////				id.add(fin);
////				
////				Map<String, Object> map = new HashMap();
////				map.put("vot_cla_num", "CLA027");
////				map.put("vot_sub_num", "20220523SUB100");
////				map.put("vot_ins_id", "mweinberg5v779");
////				map.put("vot_voter", id.toJSONString());
////				
////				service.updateVote(map);
////				
////				System.out.println("ID : "+id);
////				
////			}
	}
//	
////	@Test
//	public void test10() throws org.json.simple.parser.ParseException {
//		// 두번째 =================================
//			String ids = "";
//			String res = "";
//			VoteVo all = new VoteVo();
//			all.setVot_sub_num("20220523SUB100");
//			all.setVot_cla_num("CLA027");
//			List<VoteVo> lists = service.voteRatio(all);
//			System.out.println("원본 : "+lists);
//			System.out.println("■■■■■■■■■■");
//			JSONParser parser = new JSONParser();
////			for (int i = 0; i < lists.size(); i++) {
////				JSONArray list = (JSONArray) parser.parse(lists.toString());
//			
////			JSONArray list = (JSONArray) parser.parse(lists.toString());
////			System.out.println(list.toJSONString());
//			for (int i = 0; i < lists.size(); i++) {
//				System.out.println("lists : "+ lists.get(i).getVot_voter());
//				res += lists.get(i).getVot_voter();
//				
//				if(lists.get(i).getVot_voter() == null) {
////					result = lists.get(i).getVot_voter();
//					res = "";
//					System.out.println("result1 : "+res);
//				}
//			}
////			
//			JSONArray list = (JSONArray) parser.parse(res);
////			JSONObject list = (JSONObject) parser.parse(result);
//			System.out.println(list.toJSONString());
//			for (Object object : list) {
//				JSONObject list2 = (JSONObject) parser.parse(object.toString());
//				System.out.println("obj : "+list2);
//				ids = list2.get("id").toString();
//				System.out.println(ids);
//				
////				JSONObject ided = (JSONObject)parser.parse(list.toJSONString());
////				
//				if(ids.equals("guswls001")) {
//					System.out.println("중복된 아이디가 있습니다.");
//					return;
//				}
//				
//			}
////			System.out.println("id값 구하기 : "+list.get("id"));
//			System.out.println("result2 : "+ res);
//			
//	}
//	
//	//투표
////	@Test
//	public void test0() throws org.json.simple.parser.ParseException{
//		
//		String sub_num = "20220523SUB100";
//		String cla_num = "CLA027";
//		String ins_id = "dtrowbridge5u337";
//		String inputId = "guswls123";
//		
//		JSONArray id = new JSONArray();
//		JSONParser parser = new JSONParser();
//		try {
//			VoteVo vo = new VoteVo();
//			vo.setVot_sub_num(sub_num);
//			vo.setVot_cla_num(cla_num);
//			vo.setVot_ins_id(ins_id);
//			
//			// 첫번째 =================================
//			VoteVo result = service.voteIns(vo);
//			System.out.println(result);
//			System.out.println(result.getVot_voter().toString());
//			
//			
//			JSONArray json = (JSONArray) parser.parse(result.getVot_voter());
//				
//			
//			
//			System.out.println("json : "+json);
//			
//			for (Object listed : json) {
//				System.out.println("json1 : "+listed);
//				id.add(listed.toString());
//				JSONObject obj = new JSONObject();
//				
//			}
//			
//			System.out.println("이미 투표한 아이디 : "+id);
//		} catch (Exception e) {
//			
//		}
//		
//		
//		// 두번째 =================================
//		try {
//			VoteVo all = new VoteVo();
//			all.setVot_sub_num(sub_num);
//			all.setVot_cla_num(cla_num);
//			List<VoteVo> lists = service.voteRatio(all);
//			System.out.println("원본 : "+lists);
//			System.out.println("■■■■■■■■■■");
//			
//			for (VoteVo voteVo : lists) {
//				JSONArray list = (JSONArray) parser.parse(voteVo.getVot_voter());
//				System.out.println("넘어가는지 확인용");
//				System.out.println(list);
//				for (int i = 0; i < list.size(); i++) {
//					String votedList = list.get(i).toString();
//					JSONArray cert = new JSONArray();
//					cert.add(votedList);
//					 System.out.println("투표한 사람 : "+ votedList);
//					if(!cert.contains(inputId)) {
//						id.add(inputId);
//					}
//				}
//			}
//			
//		
//			// 세번째 =================================
//			Map<String, Object> map = new HashMap();
//			map.put("vot_cla_num", cla_num);
//			map.put("vot_sub_num", sub_num);
//			map.put("vot_ins_id", ins_id);
//			
//			JSONObject obj = new JSONObject();
//			obj.put("id", inputId);
//			obj.put("voted", "Y");
//			obj.put("Before", "pay");
//			obj.put("After", "ready");
//			id.add(obj);
//			map.put("vot_voter", id.toJSONString());
//			service.updateVote(map);
//			
//			System.out.println("새로 투표한 아이디 : "+id);
//			
//			}
//				catch (Exception e) {
//				
//				Map<String, Object> map = new HashMap();
//				map.put("vot_cla_num", cla_num);
//				map.put("vot_sub_num", sub_num);
//				map.put("vot_ins_id", ins_id);
//				
//				
//				JSONArray json = new JSONArray();
//				JSONObject obj = new JSONObject();
//				obj.put("id", inputId);
//				obj.put("voted", "Y");
//				obj.put("Before", "pay");
//				obj.put("After", "ready");
//				json.add(obj);
//				System.out.println(obj);
//				map.put("vot_voter", json.toJSONString());
//				
//				service.updateVote(map);
//				
////				Map<String, Object> map = new HashMap();
////				map.put("vot_cla_num", cla_num);
////				map.put("vot_sub_num", sub_num);
////				map.put("vot_ins_id", ins_id);
////				
////				JSONArray json = new JSONArray();
////				json.add(inputId);
////				map.put("vot_voter", json.toJSONString());
////				
////				service.updateVote(map);
//			}
//		System.out.println("확인용 : "+id);
//		
//		
//		
//		
////		if(id.equals(null)) {
////			System.out.println("넘어가냐?");
////			Map<String, Object> map = new HashMap();
////			map.put("vot_cla_num", cla_num);
////			map.put("vot_sub_num", sub_num);
////			map.put("vot_ins_id", ins_id);
////			
////			JSONArray json = new JSONArray();
////			json.add(inputId);
////			map.put("vot_voter", json.toJSONString());
////			
////			service.updateVote(map);
////		}
//	}
//	
//	//투표하기
////	@Test
//	public void jsonTest() throws JsonProcessingException, org.json.simple.parser.ParseException{
////		int cnt=0;
//		
//		Map<String, Object> map = new HashMap();
//		map.put("vot_cla_num", "CLA027");
//		map.put("vot_sub_num", "20220523SUB100");
//		map.put("vot_ins_id", "dtrowbridge5u337");
//		
//		
//		JSONArray json = new JSONArray();
//		JSONObject obj = new JSONObject();
//		obj.put("id", "dkshk01");
//		obj.put("pay", "before");
//		json.add(obj);
//		
//		System.out.println(obj);
//		
////		JSONObject obj = new JSONObject();
//		System.out.println(json);
//		map.put("vot_voter", json.toJSONString());
////		
//		service.updateVote(map);
//		System.out.println(obj.get("id"));
//		System.out.println(obj.values());
//		for (Object list : json) {
//			System.out.println("jsonarray : "+list);
//			JSONObject jsonobj = new JSONObject();
//			jsonobj.put("id", list);
//			System.out.println(jsonobj);
//			jsonobj.get("id");
//			System.out.println(jsonobj.get("id"));
//		}
//		
//		
////		JSONArray json = new JSONArray();
////		JSONObject data = new JSONObject();
////		data.put("id", "thdwndrl1234");
////		json.add(data);
////		data.put("id", "ghkdwoaks1234");
////		json.add(data);
////		data.put("id", "bewbanche5f967");
////		json.add(data);
////		
////		vo.setVot_voter(json.toString());
////		for (Object object : json) {
////			cnt++;
////		}
////		System.out.println(cnt);
////		dao.updateVote(vo);
////	}
//	
////	@Test
////	public void ratio() throws org.json.simple.parser.ParseException {
////		List<InstructorVo> insList = service.classInsInfo("CLA026");
////		System.out.println(insList);
////		
////		JSONObject obj = new JSONObject();
////		JSONParser parser = new JSONParser();
////		String res = "";
////		
////		JSONArray cnt = new JSONArray();
////		JSONObject json = new JSONObject();
////		try {
////			for (int i = 0; i < insList.size(); i++) {
////				res = insList.get(i).getVoteVo().getVot_voter();
////				System.out.println("원본 : "+res);
////				if(res==null) {
////					res = "0";
////					cnt.add(Integer.parseInt(res));
////				}else {
////					JSONArray listed = (JSONArray) parser.parse(res.toString());
////					System.out.println("listed : "+listed);
////					int voted = 0;
////					for (int j = 0; j < listed.size(); j++) {
////						voted++;
//////						json.put("size", ss);
////						System.out.println("횟수 : "+voted);
////					}
////					cnt.add(voted);
////				}
////			}
////			System.out.println("확인 "+cnt);
////			
////			// 총 투표자
//////			JSONArray obj2 = (JSONArray) parser.parse(res);
//////			System.out.println("사이즈"+obj2.size());
//////			
//////			for (int i = 0; i < obj2.size(); i++) {
//////				System.out.println(obj2.get(i).toString()); 
//////			}
////			
////			System.out.println("투표자 수 : "+cnt);
////			ClassVo result2 = service.classSelectDetail("CLA027");
////			Double total = (double) result2.getCla_maxpeo();
////			System.out.println("정원 : "+total);
////			for (int j = 0; j < cnt.size(); j++) {
////				System.out.println("비율 : "+cnt.get(j).toString());
////				int ratio = (int) cnt.get(j);
////				Double percent = ratio*100/total;
////				System.out.println(percent);
////			}
////		} catch (Exception e) {
////			System.out.println("투표자가 없습니다.");
////		}
////		
////	}
////	
	
	// 투표된 강사 선정
	@Test
	public void vo3() throws org.json.simple.parser.ParseException {
//		String sub[] = {"20220523SUB102", "20220523SUB108", "20220523SUB109"};
		String cla_num="CLA032";
		
		
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
				return;
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
				System.out.println("삭제해야대용 : "+list.get(i).getVot_sub_num());
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("vot_cla_num", "CLA032");
				map.put("vot_sub_num", list.get(i).getVot_sub_num());
				service.voteDelete(map);
			}
		}
	}
	
	
//	@Test
	public void del() {
		VoteVo vo = new VoteVo();
		vo.setVot_cla_num("CLA032");
		service.votedPeople(vo);
		System.out.println(vo.getVot_voter());
	}
////	
////	@Scheduled(fixedDelay=1000)
////	@Test
////	public void vo() {
////		List<InstructorVo> insList = service.classInsInfo("CLA026");
////		System.out.println(insList);
////		
////		JSONObject obj = new JSONObject();
////		JSONParser parser = new JSONParser();
////		String res = "";
////		
////		JSONArray cnt = new JSONArray();
////		JSONObject json = new JSONObject();
////		try {
////			for (int i = 0; i < insList.size(); i++) {
////				res = insList.get(i).getVoteVo().getVot_voter();
////				System.out.println("원본 : "+res);
////				if(res==null) {
////					res = "0";
////					cnt.add(Integer.parseInt(res));
////				}else {
////					JSONArray listed = (JSONArray) parser.parse(res.toString());
////					System.out.println("listed : "+listed);
////					int voted = 1;
////					for (int j = 0; j < listed.size(); j++) {
////						voted++;
////						System.out.println("횟수 : "+voted);
////					}
////					cnt.add(voted);
////				}
////				
////				
////				
////			}
////			System.out.println("확인 "+cnt);
////			
////			System.out.println("투표자 수 : "+cnt);
////			ClassVo result2 = service.classSelectDetail("CLA027");
////			Double total = (double) result2.getCla_maxpeo();
////			System.out.println("정원 : "+total);
////			for (int j = 0; j < cnt.size(); j++) {
////				System.out.println("비율 : "+cnt.get(j).toString());
////				int ratio = (int) cnt.get(j);
////				Double percent = ratio*100/total;
////				System.out.println(percent);
////			}
////			
////		} catch (Exception e) {
////			System.out.println("투표자가 없습니다.");
////		}
////	}
//	
////	@Test
////	public void compLi() throws org.json.simple.parser.ParseException {
////		
////		JSONObject ob = new JSONObject();
////		JSONParser parser = new JSONParser();
////		JSONArray array = new JSONArray();
////		JSONArray arr = new JSONArray();
////		
////		String cla_num = "CLA028";
////		String vot_sub_num = "20220523SUB100";
//////		String ins_id = "thdwndrlrkdtk123";
//////		String inputId = "ghgh1234";
////		
////		String ids = "";
////		String re = "";
////		VoteVo vo = new VoteVo();
////		vo.setVot_cla_num(cla_num);
////		List<VoteVo> lists = service.votedPeople(vo);
////		System.out.println("원본 : "+lists);
////		System.out.println("■■■■■■■■■■");
////		
////		
////		for (int i = 0; i < lists.size(); i++) {
////			
////			System.out.println("lists : "+ lists.get(i).getVot_voter());
////			String res = lists.get(i).getVot_voter();
////			String ins = lists.get(i).getVot_ins_id();
////			System.out.println("ins : "+ins);
////			if(lists.get(i).getVot_ins_id() == null) {
////				continue;
////			}
////			System.out.println("res : "+res);
////			array = (JSONArray) parser.parse(res.toString());
//////			ob = (JSONObject) parser.parse(res);
////			System.out.println("음?");
////			for (int j = 0; j < array.size(); j++) {
////				JSONObject obj = (JSONObject) array.get(j);
////				System.out.println(obj);
//////				obj.put("ins", ins);
////				arr.add(obj);
////				ob = (JSONObject) arr.get(i);
////			}
////			
////			
////		}
////		
////		System.out.println("최종 : "+arr);
////		System.out.println("ob : "+	ob);
////		System.out.println(ob.get("id"));
////		
////		Map<String, Object> map = new HashMap<String, Object>();
////		map.put("vot_cla_num", cla_num);
////		map.put("vot_sub_num", vot_sub_num);
////		service.voteDelete(map);
////		map.clear();
////		map.put("vot_cla_num", cla_num);
////		map.put("vot_sub_num", vot_sub_num);
////		map.put("vot_ins_id", ob.get("id"));
//////		map.put("vot_ins_id", "mweinberg5v779");
////		map.put("vot_voter", arr.toString());
////		service.votedInsert(map);
////		System.out.println(map);
//		
////	}
//	
////	@Test
////	public void dd() {
////		ClassVo voed = new ClassVo();
//// 		voed.setCla_num("CLA027");
//// 		int cnt = 0;
//// 		List<VoteVo> tm = service.classTimeSearch(voed);
//// 		for (VoteVo voteVo : tm) {
////			cnt = voteVo.getClassvo().getCla_totaltime();
////		}
//// 		System.out.println(cnt);
//// 		System.out.println(tm);
//// 		Calendar cal = Calendar.getInstance();
//// 		int year = cal.get(Calendar.YEAR);
//// 		int year = Calendar.YEAR;
//// 		System.out.println(year+2);
////	}
//	
//
//
////    	            long selholi = (long) obj4.get("locdate");
////    	            String res = String.valueOf(selholi);
////    	            System.out.println(selholi);
////
////
////    	            Calendar cal = Calendar.getInstance();
////    	    		// Calendar의 Month는 0부터 시작하므로 -1 해준다.
////    	    		cal.set(2022, 5, 20);
////    	    		System.out.println(cal.getTime());
////
////    	    		for (int i = 0; i < 10; i++) {
////    	    			String result = cal.get(Calendar.YEAR)+""+String.format("%02d", cal.get(Calendar.MONTH))+String.format("%02d", cal.get(Calendar.DATE));
////
////    	    			cal.add(Calendar.DATE, 1); // one day increment
////    	    			int day = cal.get(Calendar.DAY_OF_WEEK);
////
////    	    			System.out.println("최종 폼 : "+result);
////    	    			System.out.println("월 : "+ cal.get(Calendar.MONTH));
////    	    			System.out.println(cal.getTime());
////    	    			System.out.println(day);
////    	    			System.out.println(cnt + "번째");
////
////    	    			// 일요일 : 1 , 토요일 : 7
////    	    			if(day == 1 || day == 7) {
////    	    				i--;
////    	    			}
////    	    			if(res.contains(result)) {
////    	    				i--;
////    	    			}
////    	    			cnt++;
////
////
////    	    		}
////
////				} catch (Exception e2) {
////					System.out.println("해당 월에는 공휴일이 없습니다");
////				}
////
////			}
//////            Calendar cal = Calendar.getInstance();
//////    		// Calendar의 Month는 0부터 시작하므로 -1 해준다.
//////    		cal.set(2022, 5, 20);
//////    		System.out.println(cal.getTime());
//////
//////    		for (int i = 0; i < 10; i++) {
//////    			String result = cal.get(Calendar.YEAR)+""+String.format("%02d", cal.get(Calendar.MONTH))+String.format("%02d", cal.get(Calendar.DATE));
//////
//////    			cal.add(Calendar.DATE, 1); // one day increment
//////    			int day = cal.get(Calendar.DAY_OF_WEEK);
//////
//////    			System.out.println("최종 폼 : "+result);
//////    			System.out.println("월 : "+ cal.get(Calendar.MONTH));
//////    			System.out.println(cal.getTime());
//////    			System.out.println(day);
//////    			System.out.println(cnt + "번째");
//////
//////    			// 일요일 : 1 , 토요일 : 7
//////    			if(day == 1 || day == 7) {
//////    				i--;
//////    			}
//////    			if(res.contains(result)) {
//////    				i--;
//////    			}
//////    			cnt++;
//////
//////
//////    		}
////
////            rd.close();
////
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////	}
////	}
////
////
////
//	@Test
//	public void calDate() throws IOException, org.json.simple.parser.ParseException {
//		List<String> res = new ArrayList<String>();
//		int cnt = 0;
//		int ch = 2022;
//		do {
//		for (int j = 1; j < 13; j++) {
//		String serviceKey = "zy%2FZZCSwzH2XN%2FGYNR%2FGFFKJ2z6s368WViy%2FwfzkHNxge5pG99WjgHiLmuFP9KQl60hNZPmAU9D8jExKOL9AiQ%3D%3D";
//        String addr = "http://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService";
//        String query = "/getRestDeInfo?";
//        StringBuffer stringBuffer = new StringBuffer();
//        stringBuffer.append(addr);
//        stringBuffer.append(query);
//        stringBuffer.append("solYear="+ch);
//        stringBuffer.append("&solMonth="+String.format("%02d", j));
//        stringBuffer.append("&solMonth=01");
//        stringBuffer.append("&_type=json");
//        stringBuffer.append("&ServiceKey=" + serviceKey);
//
//        System.out.println("stringBuffer.toString() "+ stringBuffer.toString());
//
//        try {
//            URL url = new URL(stringBuffer.toString());
//            URLConnection conn = url.openConnection();
//            BufferedReader rd = null;
//            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
//
//            String line= rd.readLine();
//
//            JSONParser jsonParser = new JSONParser();//JSON데이터를 넣어 JSON Object 로 만들어 준다.
//            JSONObject jsonObject = (JSONObject) jsonParser.parse(line);
//            JSONObject obj = (JSONObject) jsonObject.get("response");
//            JSONObject obj2 = (JSONObject) obj.get("body");
//
//            try {
//            	JSONObject obj3 = (JSONObject) obj2.get("items");
//                JSONArray holidays = (JSONArray) obj3.get("item");
//
//                System.out.println(holidays);
//
//
//                System.out.println("■■■■■■■■■■■■■■■ 휴일 ■■■■■■■■■■■■■■■");
//                for (int i = 0; i < holidays.size(); i++) {
//                	JSONObject holiday = (JSONObject) holidays.get(i);
//                	long selholi = (long) holiday.get("locdate");
//                	res.add(String.valueOf(selholi));
//                	System.out.println(selholi);
//    			}
//                System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
//                System.out.println(res);
//
//			}
//            catch (Exception e) {
//            	try {
//            		JSONObject obj3 = (JSONObject) obj2.get("items");
//    	            System.out.println(obj3);
//    	            JSONObject obj4 = (JSONObject) obj3.get("item");
//    	            System.out.println(obj4);
//    	            long selholi = (long) obj4.get("locdate");
//    	            System.out.println("■■■■■■■■■■■■■■■ 휴일 ■■■■■■■■■■■■■■■");
//    	            System.out.println(selholi);
//    	            System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
//				} catch (Exception e2) {
//					System.out.println("==해당 월에는 공휴일이 없습니다==");
//				}
//			}
//
//            rd.close();
//
//        }
//        catch (IOException e) {
//        	e.printStackTrace();
//        }
//    }
//
//		ch++;
//		} while (ch<2024);
//
//
//		 Calendar cal = Calendar.getInstance();
//		// 사용자가 등록하는 월, 일을 여기다 매핑
// 		// Calendar의 Month는 0부터 시작하므로 -1 해준다.
// 		cal.set(2022, 12-1, 24-1);
// 		System.out.println(cal.getTime());
//
// 		for (int i = 0; i < 30; i++) {
// 			// cal.set = 2022-10-20
// 			// 실제 = 2022-11-21
// 			cal.add(Calendar.DATE, 1); // one day increment
// 			String result = String.valueOf(cal.get(Calendar.YEAR)) + String.format("%02d", cal.get(Calendar.MONTH)+1)+String.format("%02d", cal.get(Calendar.DATE));
//
// 			int day = cal.get(Calendar.DAY_OF_WEEK);
// 			System.out.println("----------------------------");
// 			System.out.println("최종 폼 : "+result);
// 			System.out.println("월 : "+ cal.get(Calendar.MONTH));
// 			System.out.println(cal.getTime());
// 			System.out.println("----------------------------");
// 			// 일요일 : 1 , 토요일 : 7
// 			if(day == 1 || day == 7 || res.contains(result)) {
// 				cnt++;
// 				i--;
// 				System.out.println(cnt+ "번째");
// 			}
//
// 		}
//
//
//	}
////
////
//////	@Test
////	public void Stringsub() {
////		String end= "2022-06-15";
////		String first = end.substring(0, 4);
////		String second = end.substring(5, 7);
////		String last = end.substring(8, 10);
////
////		System.out.println(first);
////		System.out.println(Integer.parseInt(first)-1);
////		System.out.println(second);
////		System.out.println(last);
////	}
////
//////	@Test
////	public void Upload() {
////		String originalFile = "C:/upload/tmp/Spring표.jpg";
////		String originalFileExtention = originalFile.substring(originalFile.indexOf("."));
////		String storedFileName = UUID.randomUUID().toString().replaceAll("-", "") + originalFileExtention;
//////		String filePath = "C:/upload/tmp";
////		System.out.println("originalFile :" + originalFile);
////		System.out.println("originalFileExtention :" + originalFileExtention);
////		System.out.println("storedFileName :" + storedFileName);
//////		System.out.println("filename :" + filename);
////
//////		File file = new File(filePath + storedFileName);
////
//////		filename.transferTo(file);
////	}
////
//////	@Test
////	public void test4(){
////		String filePath = "C:/upload/tmp/";
////		String result = filePath.substring(14);
////		System.out.println(result);
////	}
////
//////	@Test
////	public void test3() {
////		String result = bDao.findFile(7);
////		System.out.println(result);
////	}
////
//////	@Test
////	public void test5() {
////		List<SubjectVo> lists = service.classSelectedSub("CLA001");
////		System.out.println(lists);
////
////	}
////
////	//투표하기
//////	@Test
////	public void jsonTest() {
////		int cnt=0;
////		VoteVo vo = new VoteVo();
////		vo.setVot_cla_num("CLA027");
////		vo.setVot_sub_num("20220523SUB101");
////		JSONArray json = new JSONArray();
////		json.add("thdwndrl1234");
////		json.add("ghkdwoaks1234");
////		json.add("mkirkam5g337");
////		vo.setVot_voter(json.toString());
////		for (Object object : json) {
////			cnt++;
////		}
////		System.out.println(cnt);
////		dao.updateVote(vo);
////	}
////
////	@Test
////	public void classInsInfo() {
////		List<InstructorVo> vo = service.classInsInfo("CLA027");
////		System.out.println(vo);
//////		System.out.println((vo.toString().substring(1,vo.toString().length()-1).replace("[", "(")).replace("]", ")"));
//////		char[] result = (vo.toString().substring(1,vo.toString().length()-1).replace("[", "(")).replace("]", ")").toCharArray();
//////		System.out.println(result);
////	}
	
//		@Test
//		public void dd() {
//			ClassVo result = service.classSelectDetail("CLA027");
//			System.out.println(result);
//			result.getCla_enddate();
//			
//		}
	
	
	
}
////
