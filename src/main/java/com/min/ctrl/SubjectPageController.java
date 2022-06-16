package com.min.ctrl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.min.service.SubjectService;
import com.min.vo.MemberVo;
import com.min.vo.RowNumVo;
import com.min.vo.SubjectVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/user/*")
public class SubjectPageController {
	
	@Autowired
	private SubjectService sService;

	@RequestMapping(value = "/page.do", method = RequestMethod.POST, produces = "application/text; charset=UTF-8;")
	public String paging(HttpSession session, RowNumVo rowVo,Authentication user) {
		log.info("PageController row : {}", session.getAttribute("row"));
		log.info("PageController rowVo : {}", session.getAttribute("rowVo"));
		log.info("SubjectController subjectList 세션확인 : {}", user);
		
		MemberVo mvo = (MemberVo) user.getDetails();
		System.out.println("**********************************************pageController"+mvo);
		JSONObject json = null;
		
		//로그인한 회원이 관리자일경우
		if(user.getAuthorities().toString().indexOf("ADMIN")!=-1) {
			System.out.println("pageControllerAdmin"+user.getAuthorities());
			System.out.println("pageControllerAdmin"+mvo);
			rowVo.setTotal(sService.subjectTotalAdmin());
			json=jsonForm(sService.subSelectAllAdmin(rowVo),rowVo, mvo);
		}
//		else if(user.getAuthorities().toString().indexOf("USER")!=-1) {
//			System.out.println("**********************************************일반회원인지 확인용 " +user.getAuthorities());
//			rowVo.setTotal(sService.subjectTotalUser());
//			json=jsonForm(sService.subSelectAllUser(rowVo),rowVo, mvo);
//		}
		
		session.removeAttribute("row");
		session.setAttribute("row", rowVo);
		
		log.info(json.toJSONString());
		
		return json.toJSONString();
		
	}
	
	@RequestMapping(value = "/approvePage.do", method = RequestMethod.POST, produces = "application/text; charset=UTF-8;")
	public String approvePaging(HttpSession session, RowNumVo rowVo,Authentication user) {
		log.info("PageController approvePaging row : {}", session.getAttribute("row"));
		log.info("PageController approvePaging rowVo : {}", session.getAttribute("rowVo"));
		log.info("SubjectController approvePagingsubjectList 세션확인 : {}", user);
		
		MemberVo mvo = (MemberVo) user.getDetails();
		System.out.println("**********************************************pageController"+mvo);
		JSONObject json = null;
		
		//로그인한 회원이 관리자-승인처리할 경우
		if(user.getAuthorities().toString().indexOf("ADMIN")!=-1) {
			System.out.println("pageControllerAdmin"+user.getAuthorities());
			System.out.println("pageControllerAdmin"+mvo);
			rowVo.setTotal(sService.subjectTotalAdmin());
			json=jsonForm(sService.subSelectToApproveAdmin(rowVo),rowVo, mvo);
		}
//		else if(user.getAuthorities().toString().indexOf("USER")!=-1) {
//			System.out.println("**********************************************일반회원인지 확인용 " +user.getAuthorities());
//			rowVo.setTotal(sService.subjectTotalUser());
//			json=jsonForm(sService.subSelectAllUser(rowVo),rowVo, mvo);
//		}
		
		session.removeAttribute("row");
		session.setAttribute("row", rowVo);
		
		log.info(json.toJSONString());
		
		return json.toJSONString();
		
	}
	
	@SuppressWarnings("unchecked")
	private JSONObject jsonForm(List<SubjectVo> subjectListRow, RowNumVo rowVo, MemberVo mvo) {
		//반환되는 , 전송되는 객체
		JSONObject json = new JSONObject(); 
		//글들을 담는 객체
		JSONArray jList = new JSONArray();
		//페이지를 담는 객체
		JSONObject jRow = new JSONObject();
		
		for (SubjectVo sVo : subjectListRow){
			JSONObject obj = new  JSONObject();
			obj.put("sub_num", sVo.getSub_num());
			obj.put("sub_title", sVo.getSub_title());
			obj.put("sub_content", sVo.getSub_content());
			obj.put("cod_name", sVo.getCod_name());
			obj.put("sub_reg_id", sVo.getSub_reg_id());
			obj.put("sub_ins", sVo.getSub_ins());
			obj.put("sub_regdate", sVo.getSub_regdate());
			obj.put("sub_status", sVo.getSub_status());
			jList.add(obj);
		}
		
		log.info("JSON으로 변환된 글 리스트 :  {}", jList.toString());
		
		//페이징 처리
		jRow.put("pageList", rowVo.getPageList());
		jRow.put("index", rowVo.getIndex());
		jRow.put("pageStartNum", rowVo.getPageStartNum());
		jRow.put("pageListNum", rowVo.getPageListNum());
		jRow.put("total", rowVo.getTotal());
		jRow.put("count", rowVo.getCount());
		
		json.put("lists", jList);
		json.put("row", jRow);
		
		return json;
		
	}
}
