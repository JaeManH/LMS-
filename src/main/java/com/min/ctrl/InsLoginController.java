package com.min.ctrl;

import java.text.DateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.service.IMemberService;
import com.min.utils.MailUtil;
import com.min.vo.MemberVo;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
@RequestMapping(value = "/ins/*")
public class InsLoginController {

	@Autowired
	IMemberService service;

	@Autowired
	PasswordEncoder password;
	
	//강사로 로그인 후 메인페이지 
	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model,Authentication user) {
		log.info("Welcome home! The client locale is {}.", locale);
		
		
		return "main";
	}
	
	//메인페이지 헤더초기화
	@RequestMapping(value = "/reMain.do", method = RequestMethod.GET)
	public String redirectHome(Locale locale, Model model,Authentication user) {
		log.info("Welcome home! 리다이렉트 {}.", locale);
		
		
		return "redirect:/";
	}
	// 로그인 페이지로 가는 매핑
	@RequestMapping(value = "/loginPage.do", method = {RequestMethod.GET,RequestMethod.POST})
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Authentication user, Model model, HttpServletRequest req) {
		
		log.info("강사 로그인");
//		UserDetails userdto = (UserDetails) user.getPrincipal();
//		System.out.println("---------------"+userdto);
//		model.addAttribute("user", userdto.toString());
		  
		if (error != null) {
			model.addAttribute("msg", "로그인 에러");
		}

		if (logout != null) {
			model.addAttribute("msg", "로그아웃 성공");
		}
		
		if(user != null) {
			return "redirect:/ins/result.do";
		}
		log.info("강사 로그인 페이지로 이동");
		return "InsLoginForm";
	}
  

 
	//로그인 완료 후 메인 페이지로 가는 매핑
	@RequestMapping(value = "/result.do", method = RequestMethod.GET)
	public String maingo(Authentication user, Model model , HttpSession session) {
		
		System.out.println("인증후  생성된 세션 확인");
		Enumeration<?> session_attributes = session.getAttributeNames();
		while(session_attributes.hasMoreElements()) {
	        String session_name  = session_attributes.nextElement().toString();
	        String session_value = session.getAttribute(session_name).toString();
	        System.out.println("세션키: "+ session_name);
	        System.out.println("세션값: " +session_value);
		}
		
		System.out.println("SecurityContextHolder 에 등록된 정보 확인");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if ( auth != null) {
			
			System.out.println("Authentication getAuthorities: " + auth.getAuthorities().toString());
			System.out.println("Authentication getPrincipal: " + auth.getPrincipal());
			System.out.println("Authentication getName: " +auth.getName());
			System.out.println("Authentication getCredentials: " + auth.getCredentials());
			System.out.println("Authentication getDetails: " + auth.getDetails());
			System.out.println("Authentication isAuthenticated: " + auth.isAuthenticated());
			
		}
	
//		UserDetails userdto = (UserDetails) auth.getDetails();
//		model.addAttribute("user", userdto.toString());
//		System.out.println(":::::::::::::::::::::::: " +auth.getPrincipal());
//		System.out.println("비밀번호 : " + userdto.getPassword());
		return "main";
	}


	//회원가입으로 가는 매핑
	@RequestMapping(value = "/InsSingUpgo.do", method = RequestMethod.GET)
	public String SignUpgo() {
		return "insRegister";
	}
   
	//강사 아이디 중복확인
	@RequestMapping(value = "/CheckInsId.do", method = RequestMethod.GET)
	@ResponseBody
	public int idCheck(@RequestParam("id") String id) {
		log.info("*id : ", id);
		return service.checkInsId(id);
	}
	//강사 개인정보 수정
	@RequestMapping(value = "/editIns.do", method = {RequestMethod.POST,RequestMethod.GET})
	public String  editUserProfile(@RequestParam Map<String, Object> map, Model model,Authentication user) {
		MemberVo mvo = (MemberVo) user.getDetails();
		map.put("id", mvo.getId());
		
		log.info("개인정보 수정",mvo);
		System.out.println(map);
	   service.updateIns(map);
		
		
		
		return "redirect:/user/logout.do";
	
	}
	//이메일 중복 체크
			@RequestMapping(value = "/CheckInsEmail.do", method = RequestMethod.GET)
			@ResponseBody
			public int emailCheck(@RequestParam("email") String email) {
				log.info("일반회원 이메일 중복체크 : ", email);
				
				return service.checkInsEmail(email);
			}

	// 회원가입 성공 매핑
	@RequestMapping(value = "/InsSingUpSc.do", method = RequestMethod.POST)
	public String maingo(@RequestParam Map<String, Object> map, Model model) {
		System.out.println("회원가입 정보"+map);
		service.InsSignUp(map);
		service.insertCar(map);
		return "redirect:/ins/loginPage.do";
	}
	// 강사 경력 등록 페이지 이동
	@RequestMapping(value = "/InsCareer.do", method = RequestMethod.GET)
	public String InsCareer( ) {
		log.info("강사 경력등록 페이지 ");
		return "InsCareer";
	}
	
	@RequestMapping(value="/insertCar.do",method = RequestMethod.POST)
	public String insertCar(@RequestParam Map<String,Object> map, Model model,Authentication user) {
		log.info("경력 등록 :",map);
		MemberVo mvo = (MemberVo) user.getDetails();
		map.put("id", mvo.getId() );
		service.updateCar(map);
		
		log.info("경력자 아이디 등록 :",map);
		
		return "redirect:/ins/logout.do";
	}
	
	
			//아이디 찾기
			@RequestMapping(value = "/findInsIdView.do", method = RequestMethod.GET)
			public String findTraIdView() {
				
				return "findInsId";
			}


			//아이디 찾기
			@RequestMapping(value = "/findInsId.do", method = RequestMethod.POST)
			public @ResponseBody  Map<String, String> findTraId (@RequestParam Map<String, Object> map, Model model) {
				Map<String, String> rMap = new HashMap<String, String>();
				log.info("********* Welcome Member_Controller findTraId! : {} *********", map);
				MemberVo mVo = service.findInsId(map);
				
				log.info("********* Welcome! Member_Controller findTraId : {} *********", mVo);
				if(mVo == null) {
					rMap.put("isc", "실패");
				}else {
					rMap.put("isc", "성공");
					rMap.put("test", mVo.getId());
				}
				return rMap;
			}
			
			/* 비밀번호 찾기 */
			@RequestMapping(value = "/findInsPwView", method = RequestMethod.GET)
			public String findInsPw(){
				
				return "findInsPw";
			}

			@GetMapping(value = "/findInspw.do",produces = {MediaType.APPLICATION_JSON_VALUE})
			public @ResponseBody String findInsPw (@RequestParam Map<String, Object> map, Model model) throws Exception {
				
				String result=null;
				System.out.println(map);
				//회원정보 불러오기
				MemberVo vo1 = service.findInsPw(map);
				System.out.println(vo1);
				
				//가입된 이메일이 존재한다면 이메일 전송
				if(vo1!=null) {
					
					//임시 비밀번호 생성(UUID이용)
					String tempPw=UUID.randomUUID().toString().replace("-", "");//-를 제거
					tempPw = tempPw.substring(0,10);//tempPw를 앞에서부터 10자리 잘라줌
					
					vo1.setPw(tempPw);//임시 비밀번호 담기
					MailUtil mail=new MailUtil(); //메일 전송하기
					mail.sendEmail(vo1);
					
					String securePw = password.encode(tempPw);//회원 비밀번호를 암호화하면 vo객체에 다시 저장
					map.put("pw", securePw);
					service.updateInsPw(map);
					result="true";

				}else {
					result="false";
				}
				return result;
			}
			
		
	//관리자 페이지
	@RequestMapping(value = "/admin/adminPage.do", method = RequestMethod.GET)
	public String adminPasge(Model model) {
		System.out.println("관리자 페이지");
		System.out.println();
		return "adminPage";
	}
	
	@RequestMapping(value = "/AuthError.do", method = RequestMethod.GET)
	public String AuthError(Model model) {
		return "AuthError";
	}
	
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout() {
		log.info("로그아웃 완료");
		return "redirect:/";
	}
	
	@RequestMapping(value = "/duplicateLogin.do", method = RequestMethod.GET)
	public String duplicateLogin() {
		return "duplicateLogin";
	}
	


}
