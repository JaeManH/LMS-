package com.min.ctrl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.min.service.ITagService;
import org.json.simple.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.min.service.SubjectService;
import com.min.vo.ClassBoardVo;
import com.min.vo.InfoUser;
import com.min.vo.MemberVo;
import com.min.vo.PayVo;
import com.min.vo.RowNumVo;
import com.min.vo.SubjectVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SubjectUserController {

	@Autowired
	private SubjectService sService;

	@Autowired
	private ITagService tagService;
	// 1) 과목 등록양식 페이지로 이동
	@RequestMapping(value = { "/user/user_subjectInsertForm.do",
			"/ins/user_subjectInsertForm.do" }, method = RequestMethod.GET)
	public String subInsertForm(Authentication user, Model model) {
		log.info("********* Welcome SubjectController! subInsertForm 과목 등록양식 페이지로 이동합니다. subjectInsertForm *********");

		return "user/user_subjectInsertForm";
	}

	// 1-2)과목 등록하기

	@RequestMapping(value = {"/user/subjectInsert.do","/ins/subjectInsert.do"},method = RequestMethod.POST)
	public String userInsertSubject(@RequestParam Map<String, Object> map, Authentication user, HttpSession session) {
		MemberVo mvo = (MemberVo) user.getDetails(); String code = map.get("sub_cod_code").toString();
		String tags = tagService.selectTagSubjectCode(code);
		Matcher matcher = TagController.TAG_REGEX.matcher(tags);
		List<String> tagList = new ArrayList<String>();
		while (matcher.find()){
			tagList.add(matcher.group().replace(" ","").replace("#",""));
		}
		System.out.println(tagList);
		System.out.println(mvo);
		map.put("sub_reg_id", mvo.getId());
		int n = sService.InsertSubject(map);
		System.out.println(map);
		map.put("reg_auth",mvo.getAuth());
		map.put("reg_id", mvo.getId());
		if(mvo.getAuth().equals("ROLE_INSTRUCTOR")) {
			map.put("sub_ins_id", mvo.getId());
		}else {
			map.put("sub_ins_id","담당 강사 미정");
		}

		int m = sService.UpdateSubIns(map);
		System.out.println("두번쨰 "+map);

		return "redirect:/user/user_subjectList.do";
	}
	




//	 @RequestMapping(value = {"/user/subjectInsert.do","/ins/subjectInsert.do"},method = RequestMethod.POST)
//	 public String userInsertSubject(@RequestParam Map<String, Object> map, Authentication user, HttpSession session) {
//
////		 JSONArray arry = new JSONArray();
////		 arry =
//	 return "";
//	 }

	// 2) 과목 조회
	// 2-3) 비회원/일반회원/강사 과목 전체조회 페이지로 이동
	@RequestMapping(value = { "/user/user_subjectList.do", "/ins/user_subjectList.do" }, method = RequestMethod.GET)
	public String userSelectSubject(SubjectVo sVo, Model model) {
		log.info("********* Welcome SubjectController! userSelectSubject 로 이동합니다. userSelectSubject *********");

		List<SubjectVo> list = sService.subSelectAllUser(sVo);
		model.addAttribute("list", list);
		System.out.println(list);
		return "user/user_subjectList";
	}

	// 2-3) 일반회원 과목 전체조회 페이지로 이동 spa방식 페이징까지
//	@RequestMapping(value = "/user/user_subjectList.do", method = RequestMethod.GET)
//	public String subjectListUser(HttpSession session, Model model,Authentication user) {
//		MemberVo mVo = (MemberVo) session.getAttribute("mem");
//		log.info("SubjectController subjectList");
//		log.info("SubjectController subjectList 세션확인 : {}", user);
//		MemberVo mvo = (MemberVo) user.getDetails();
//		
//		List<SubjectVo> lists = null;
//		RowNumVo rowVo = null;
//		
//		if(session.getAttribute("row")==null) {
//			rowVo = new  RowNumVo();
//		}else {
//			rowVo=(RowNumVo) session.getAttribute("row");
//		}
//		System.out.println(rowVo);
////		user.getPrincipal();//아이디
//		if(user.getAuthorities().toString().indexOf("USER")!=-1) {
//			System.out.println(user.getAuthorities());
//			rowVo.setTotal(sService.subjectTotalUser());
//			lists=sService.subSelectAllUser(rowVo);
//		}
//		
//			System.out.println(lists);
//		model.addAttribute("lists",lists);
//		model.addAttribute("row",rowVo);
//		
//		return "user/user_subjectList";
//	}
//	@RequestMapping(value = "/user/user_subjectList.do", method = {RequestMethod.GET, RequestMethod.POST})
//	public ModelAndView selectSubjectUser(RowNumVo rVo) {
//		ModelAndView mav = new ModelAndView();
//		log.info("********* Welcome SubjectController ! selectSubjectUser 일반회원 페이징처리 과목전체조회페이지로 이동합니다. selectSubjectUser *********");
//		rVo.setTotal(sService.subjectTotalUser());
//		List<SubjectVo> subLists = sService.subSelectAllUser(rVo);
//		mav.addObject("subLists", subLists);
//		mav.addObject("paging", rVo);
//		mav.setViewName("user_subjectList");
//		return mav;
//	}

	// 2-4) 일반회원 과목 상세조회
	@RequestMapping(value = { "/user/user_subjectDetail.do", "/ins/user_subjectDetail.do" }, method = RequestMethod.GET)
	public String userSubjectDetail(SubjectVo sVo, HttpSession session, Model model, @RequestParam String sub_num) {
		log.info("********* Welcome SubjectController! userSubjectDetail 상세조회 subSelectDetail *********");
		SubjectVo results = sService.userSubjectDetail(sub_num);

		model.addAttribute("results", results);
		return "user/user_subjectDetail";
	}

	// 2-5) 일반회원 과목 마이페이지 과목조회 페이지로 이동
	/*
	 * @RequestMapping(value =
	 * {"/user/user_mySubjectList.do","/ins/user_mySubjectList.do"}, method =
	 * RequestMethod.GET) public String subSelectMySubjectPage(Authentication user,
	 * Model model) { log.
	 * info("********* Welcome SubjectController! subSelectMySubject 과목 마이페이지 과목조회 페이지로 이동합니다. subSelectMySubject *********"
	 * ); return "user/user_mySubjectList"; }
	 */
	@RequestMapping(value = { "/user/user_subSelectMySubject.do",
			"/ins/user_subSelectMySubject.do" }, method = RequestMethod.GET)
	public String subSelectMySubject(SubjectVo sVo, HttpSession session, Model model, Authentication user) {
		log.info(
				"********* Welcome SubjectController! subSelectMySubject 과목 마이페이지 과목조회 페이지로 이동합니다. subSelectMySubject *********");
		log.info("********* Welcome SubjectController! subSelectMySubject 마이페이지 목록 조회 subSelectMySubject *********");
		MemberVo mvo = (MemberVo) user.getDetails();
		System.out.println(mvo);

		sVo.setSub_reg_id(mvo.getId());
		System.out.println("++++++++++++++++++++++++++++++" + mvo.getId());
		List<SubjectVo> list = sService.subSelectMySubject(sVo);
		model.addAttribute("list", list);
		log.info("컨트롤러에서 찍는 아이디에 해당하는 리스트 " + list);
		log.info("세션 저장된 아이디 : " + mvo.getId());
		return "user/user_subSelectMySubject";
	}

	// 5) 일반회원/강사 과목 수정 페이지로 이동
	@RequestMapping(value = { "/user/user_subjectModifyForm.do",
			"/ins/user_subjectModifyForm.do" }, method = RequestMethod.GET)
	public String subUpdateSubject(SubjectVo sVo, Model model, Authentication user, @RequestParam String sub_num) {
		log.info("********* Welcome SubjectController! subUpdateSubject 로 이동합니다. subUpdateSubject *********");

		SubjectVo results = sService.userSubjectDetail(sub_num);

		model.addAttribute("results", results);

		return "user/user_subjectModifyForm";
	}

}
