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

import com.min.service.IMemberService;
import com.min.vo.MemberVo;
import com.min.vo.RowNumVo;



@RestController
@RequestMapping(value = "/user/*")
public class UserPage_Controller {

	private static final Logger logger = LoggerFactory.getLogger(UserPage_Controller.class);
	
	@Autowired
	private IMemberService iService;
	
	@RequestMapping(value = "/userpage.do", method = RequestMethod.POST, produces = "application/text; charset=UTF-8;")
	public String userPaging(HttpSession session,
						RowNumVo rowVo,Authentication user) {
		logger.info("Page_Controller \t 요청 값 확인 rowVo : {}", rowVo);
		
		MemberVo mvo = (MemberVo) user.getDetails();		
		JSONObject json = null;
		
		
			rowVo.setTotal(iService.adminUserListTotal());
			json = jsonForm(iService.adminUserListRow(rowVo), rowVo, (MemberVo) mvo); // 현재 index 의 글 start, last, 요청row, 사용자 정보
		
			
		
		
		session.removeAttribute("row");
		session.setAttribute("row", rowVo);
		

		
		logger.info("반환될 JSON 객체 : " + json.toString());
		
		return json.toString();
	}

	// 생성된 글 리스트(userBoardListRow)와 화면에서 요청된 페이징 값(rowVo), 세션의 정보(mVo)
	// 반환을 Map 으로 생성하고 jackson-databind.jar 를 사용하여 자동으로 JSON 으로 처리
	// test -> javascript JSON 처리
	// 1) dataType : "json",
	// 2) dataType : "text" 라면
	//   var jObj = JSON.parse("값");
	
	@SuppressWarnings("unchecked")
	private JSONObject jsonForm(List<MemberVo> MemberListRow, RowNumVo rowVo, MemberVo mvo) {
		// 최종형태 {"lists":[{"id":"~","title":"~","content":"~"},{"id":"~~","title":"~~","content":"~~"}],
		//          "row":{"index":"1","pageNum":"1","listNum":"5"}}
		JSONObject json = new JSONObject(); // 전송(반환)객체
		
		JSONArray jList = new JSONArray(); // 글을 담는 객체
		JSONObject jRow = new JSONObject(); // 페이지를 담는 객체
		
		for (MemberVo mVo : MemberListRow) {
			JSONObject obj = new JSONObject();
			obj.put("profile", mVo.getProfile());
			obj.put("id", mVo.getId());
			obj.put("name",mVo.getName());
			obj.put("email", mVo.getEmail());
			obj.put("phone", mVo.getPhone());
			obj.put("bank", mVo.getBank());
			obj.put("banknum", mVo.getBanknum());
			obj.put("career", mVo.getCareer());
			obj.put("regdate", mVo.getRegdate());
			obj.put("delflag", mVo.getDelflag());
			obj.put("auth", mVo.getAuth());
			jList.add(obj);
		}
		
		logger.info("JSON 으로 변경된 글 List : {}", jList.toString());
		
		// 페이지 관련
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
