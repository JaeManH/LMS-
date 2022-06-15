package com.min.ctrl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.min.vo.FileVo;
import com.min.service.IMemberService;

import com.min.vo.MemberVo;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;
import okhttp3.internal.framed.Header;


@Controller
@Slf4j
@RequestMapping(value = "/user/*")
public class UserLoginController {

	@Autowired
	IMemberService service;
	@Autowired
	PasswordEncoder password;
	

	
	
	//로그인 후 일반회원 메인페이지
	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model,Authentication user) {
		log.info("Welcome home! The client locale is {}.", locale);
		
		
		return "main";
	}
	//일반회원 로그인페이지에서 로그인페이지로
	@RequestMapping(value = "/reMain.do", method = RequestMethod.GET)
	public String redirectHome(Locale locale, Model model,Authentication user) {
		log.info("Welcome home! The client locale is {}.", locale);
		
		
		return "redirect:/app/";
	}
	// 로그인 페이지로 가는 매핑
	@RequestMapping(value = "/loginPage.do", method = {RequestMethod.GET,RequestMethod.POST})
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Authentication user, Model model, HttpServletRequest req) {
		
		log.info("일반회원 로그인");
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
			return "redirect:/user/result.do";
		}
		log.info("일반회원 로그인 페이지로 이동");
		return "TraLoginForm";
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
	@RequestMapping(value = "/traSignUp.do", method = RequestMethod.GET)
	public String traSignUp() {
		return "traRegister";
	}


	// 회원가입 성공 매핑
	@RequestMapping(value = "/traSingUpSc.do", method = RequestMethod.POST)
	public String maingo(@RequestParam Map<String, Object> map, Model model) {
		System.out.println("회원가입 정보"+map);
		service.traSignUp(map);
		return "redirect:/user/loginPage.do";
	}
	
	//일반회원 개인정보 수정
	@RequestMapping(value = "/editUser.do", method = RequestMethod.POST)
	public String editUserProfile(@RequestParam Map<String, Object> map, Model model,Authentication user) {
		MemberVo mvo = (MemberVo) user.getDetails();
		map.put("id", mvo.getId());
		
		log.info("개인정보 수정",mvo);
		System.out.println(map);
		service.updateTra(map);
		return "redirect:/user";
	}
	
	
	
	//아이디 찾기
		@RequestMapping(value = "/findTraIdView.do", method = RequestMethod.GET)
		public String findTraIdView() {
			
			return "findTraId";
		}


		//아이디 찾기
		@RequestMapping(value = "/findTraId.do", method = RequestMethod.POST)
		public @ResponseBody  Map<String, String> findTraId (@RequestParam Map<String, Object> map, Model model) {
			Map<String, String> rMap = new HashMap<String, String>();
			log.info("********* Welcome Member_Controller findTraId! : {} *********", map);
			MemberVo mVo = service.findTraId(map);
			
			log.info("********* Welcome! Member_Controller findTraId : {} *********", mVo);
			if(mVo == null) {
				rMap.put("isc", "실패");
			}else {
				rMap.put("isc", "성공");
				rMap.put("test", mVo.getId());
			}
			return rMap;
		}
		
		
//		@RequestMapping(value = "/CheckTraId.do", method = RequestMethod.POST)
//		public @ResponseBody  Map<String, String> CheckTraId (@RequestParam Map<String, Object> map, Model model) {
//			Map<String, String> rMap = new HashMap<String, String>();
//			log.info("********* Welcome Member_Controller CheckTraId! : {} ", map);
//			int n = service.CheckTraId(map);
//			
//			log.info("********* Welcome! Member_Controller CheckTraId : {}", n);
//			if(n == 1) {
//				rMap.put("isc", "중복");
//			}else {
//				rMap.put("isc", "가능");
//				
//			}
//			return rMap;
//		}
		
		@RequestMapping(value = "/CheckTraId.do", method = RequestMethod.GET)
		@ResponseBody
		public int idCheck(@RequestParam("id") String id) {
			log.info("*id : ", id);
			return service.checkTraId(id);
		}

	
	@RequestMapping(value = "/AuthError.do", method = RequestMethod.GET)
	public String AuthError(Model model) {
		return "AuthError";
	}
	//로그아웃
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout() {
		log.info("로그아웃 완료");
		return "redirect:/";
	}
	
	@RequestMapping(value = "/duplicateLogin.do", method = RequestMethod.GET)
	public String duplicateLogin() {
		return "duplicateLogin";
	}
	
	
	@PostMapping(value="/traUploadAjaxAction.do" , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 @ResponseBody
	 public ResponseEntity<FileVo> uploadFormPost(MultipartFile uploadFile) {
	
		
		 String uploadFolder = "C:\\upload\\tmp";

			String uploadFolderPath = getFolder();
		 File uploadPath = new File(uploadFolder, uploadFolderPath);
		 // make folder --------
		 log.info("upload path: " + uploadPath);
		
		 if (uploadPath.exists() == false) {
		 uploadPath.mkdirs();
		 }
		 // make yyyy/MM/dd folder
			
				FileVo fVo = new FileVo();
				MultipartFile multipartFile = uploadFile; //파일을 등록하면 여기로 들어옴
				String uploadFileName = multipartFile.getOriginalFilename(); //원본파일이름
			
				log.info("-------------------------------------");
				log.info("Upload File Name: " + multipartFile.getOriginalFilename());
				log.info("Upload File Size: " + multipartFile.getSize());
				
				uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
						log.info("only file name: " + uploadFileName);
				fVo.setOriginal_file_name(uploadFileName); //파일vo에 원본파일이름 넣어줌
				 UUID uuid = UUID.randomUUID();	
				 uploadFileName = uuid.toString() + "_" + uploadFileName;
			

				try {
					File saveFile = new File(uploadPath, uploadFileName);
					multipartFile.transferTo(saveFile);
					fVo.setStored_file_name(uuid.toString());
					fVo.setFile_path(uploadFolderPath);
					 // check image type file
					 if (checkImageType(saveFile)) {
					//원본파일은 그대로 저장되고, 파일이름이 s_로 시작하는 섬네일 파일이 생성되는 것을 볼 수 있다.
						 //반면에 일반 파일의 경우는 그냥 파일만 업로드 되는 것을 볼 수 있습니다.
						fVo.setFile_type(true);
					 FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" +
					 uploadFileName));
					log.info("섬네일",thumbnail);
					 //뒤에 사이즈에 대한 부분을 파라미터로 width와 height를 지정할 수 있습니다.
					 Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100,
					 100);
					
					 thumbnail.close();
					 }
					 
					
				} catch (Exception e) {
					log.error(e.getMessage());
				} // end catch
			 // end for
			return new ResponseEntity<>(fVo, HttpStatus.OK);
	 		}
	 //날짜별로 폴더를 생성해줌
	 private String getFolder() {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			Date date = new Date();

			String str = sdf.format(date);

			return str.replace("-", File.separator);
		}
	 	//이미지파일의 판단을 해줌
		private boolean checkImageType(File file) {

			try {
				String contentType = Files.probeContentType(file.toPath());

				return contentType.startsWith("image");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return false;
		}
	 
		@GetMapping("/traDisplay.do")	
		@ResponseBody
		public ResponseEntity<byte[]> getFile(String fileName) {

			log.info("fileName: " + fileName);

			File file = new File("c:\\upload\\tmp\\" + fileName);
			
			log.info("file: " + file);

			ResponseEntity<byte[]> result = null;

			try {
				HttpHeaders header = new HttpHeaders();

				header.add("Content-Type", Files.probeContentType(file.toPath()));
				result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			log.info("file이름 : "+result);
			log.info("file이름 : "+result);
			return result;
		}
	
		
		@GetMapping("/traUpdateProfile.do")	
		@ResponseBody
		public ResponseEntity<byte[]> getFileName(String fileName,Authentication user,HttpSession session) throws IOException {
			Map<String, Object> map = new HashMap<String, Object>();
			log.info("fileName: " + fileName);
			   File fileput = new File(fileName);
			   map.put("profile",fileName);
			System.out.println(map);
			
			   
			   File file = new File("c:\\upload\\tmp\\" + fileName);
				
				log.info("file: " + file.toString());

				ResponseEntity<byte[]> result = null;
				try {
					HttpHeaders header = new HttpHeaders();

					header.add("Content-Type", Files.probeContentType(file.toPath()));
				
					result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				log.info("file 후 : "+result.toString());
				
				map.put("id",user.getPrincipal().toString());
			    service.updateProfile(map);
			session.invalidate();
			return result;
		}
	
		


	
	
	

}
