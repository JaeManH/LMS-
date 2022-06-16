package com.min.ctrl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.min.vo.FileVo;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;

@Slf4j
@Controller
public class FileUploadController {
	
	//**파일업로드 컨트롤러
		@RequestMapping(value = "/user/uploadForm.do", method = RequestMethod.GET)
		public String uploadForm() {
			log.info("********* uploadForm *********");
			System.out.println("여기까지 이동성공");
			return "user/uploadForm";
		}
		
		//년,월,일의 폴더 생성
		private String getFolder() {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String str = sdf.format(date);
			return str.replace("-", File.separator);
		}
		
		//파일업로드 부분 (폴더 생성 및 랜덤 파일이름 생성 부분)
		@PostMapping(value = "/user/uploadAjaxAction.do", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ResponseBody
		//ResponseEntity : Http header와 body를 포함하는 클래스 
		public ResponseEntity<List<FileVo>> uploadFormPost(MultipartFile[] uploadFile, Model model) {
			//MultipartFile[] 로 for문 이용해서 다중 업로드 해준다.
			System.out.println("ajax 이동 성공");
			List<FileVo> list = new ArrayList<>();
			
			String uploadFolder = "C:\\upload"; //C에 upload폴더에 저장
			String uploadFolderPath = getFolder();
			//make Folder 폴더 새성 부분 ------------------------------------------------------------
			File uploadPath = new File(uploadFolder, uploadFolderPath);
			log.info("upload path : "+uploadPath);
			
			if(uploadPath.exists()==false) {
				uploadPath.mkdirs();
			} //make yyyy/MM/dd folder생성
			
			for(MultipartFile multipartFile : uploadFile) {
				FileVo fileVo = new FileVo();
				log.info("=============================================================================");
				log.info("Upload File Name : " + multipartFile.getOriginalFilename()); //업로드되는 파일의 이름
				log.info("Upload File Size : " + multipartFile.getSize());//파일의 경로
				
				String uploadFileName = multipartFile.getOriginalFilename();
				uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\")+1);
				log.info("only file name : "+ uploadFileName);
				log.info("=============================================================================");
				fileVo.setFileName(uploadFileName);
				UUID uuid = UUID.randomUUID();
				uploadFileName = uuid.toString()+"_"+uploadFileName;

			try {
				//File saveFile = new File(uploadFolder, uploadFileName);
				File saveFile = new File(uploadPath, uploadFileName);
				multipartFile.transferTo(saveFile); //파일의 저장
				fileVo.setUuid(uuid.toString());
				fileVo.setUploadPath(uploadFolderPath);
				log.info("getUuid : "+ fileVo.getUuid());
				log.info("getUploadPath : "+ fileVo.getUploadPath());
				log.info("=============================================================================");
				//check image type file
				if(checkImageType(saveFile)) {
					fileVo.setImage(true);
					//원본파일은 그대로 저장 , 파일이름이 s_로 시작되는 섬네일 파일이 생성
					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_"+uploadFileName));
					//뒤에 사이즈에 대한 부분을 파라미터로 width, height 지정
					Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100, 100);
					thumbnail.close();
				}
				//add to list
				list.add(fileVo);
			} catch (Exception e) {
				log.error(e.getMessage());
			} //end catch
			
			}//end for
			return new ResponseEntity<>(list, HttpStatus.OK);
		}

		
		//이미지 파일을 판단하는 메소드
		private boolean checkImageType(File file) {
			String contentType;
			try {
				contentType = Files.probeContentType(file.toPath());
				log.info("contentType : "+contentType);
				log.info("=============================================================================");
				return contentType.startsWith("image");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return false;
		}

		//이미지일 경우 섬네일 데이터 전송하기
		@GetMapping("/user/display.do")
		@ResponseBody
		public ResponseEntity<byte[]> getFile(String fileName){
			System.out.println("이미지 섬네일 데이터 전송~~~~~~~~~~~~~~~~~~~~~~");
			log.info("display fileName : "+fileName);
			File file = new File("c:\\upload\\"+fileName);
			log.info("file : "+file);
			ResponseEntity<byte[]> result = null;
			
			try {
				HttpHeaders header = new HttpHeaders();
				header.add("Content-Type", Files.probeContentType(file.toPath())); //적절한 MIME타입 데이터를 Http의 헤더 메시지에 포함
				result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return result;
		}
		
		//첨부파일 다운로드
		@GetMapping(value = "/user/download.do", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
		@ResponseBody
		public ResponseEntity<Resource> downloadFile(@RequestHeader("User-Agent") String userAgent, String fileName){
			log.info("download file : " + fileName);
			FileSystemResource resource = new FileSystemResource("C:\\upload\\"+fileName);
			log.info("resource: " + resource);
			
			if(resource.exists()==false) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			String resourceName = resource.getFilename();
			
			//UUID 제거
			String resourceOriginalName = resourceName.substring(resourceName.indexOf("_")+1);
			HttpHeaders headers = new HttpHeaders();
			try {
			String downloadName = null;
			if(userAgent.contains("Trident")) {
				log.info("IE browser");
					downloadName = URLEncoder.encode(resourceOriginalName,"UTF-8").replaceAll("\\+","");
			}else if(userAgent.contains("Edge")){
				log.info("Edge browser");
				downloadName = URLEncoder.encode(resourceOriginalName,"UTF-8");
				log.info("Edge name : " + downloadName);
				}else {
					log.info("Chrome browser");
					downloadName = new String(resourceOriginalName.getBytes("UTF-8"), "ISO-8859-1");
				}
			log.info("downloadName : "+downloadName);
				headers.add("Content-Disposition", "attachment; filename=" + downloadName);
			}catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
		}
		
//		@GetMapping(value = "/user/download.do", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
//		@ResponseBody
//		public ResponseEntity<Resource> downloadFile(@RequestHeader("User-Agent") String userAgent, String fileName){
//			System.out.println("첨부파일 다운로드~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//			log.info("download file : " + fileName);
//			Resource resource = new FileSystemResource("C:\\upload\\"+fileName);
//			log.info("resource: "+resource);
//			
//			if(resource.exists()==false) {
//				return new ResponseEntity<> (HttpStatus.NOT_FOUND);
//			}
//			
//			String resourceName = resource.getFilename();
//			HttpHeaders headers = new HttpHeaders();
//			try {
//				String downloadName = null;
//				if(userAgent.contains("Trident")) {
//					log.info("IE Browser");
//					downloadName = URLEncoder.encode(resourceName,"UTF-8");
//					log.info("Edge name : " + downloadName);
//				}else {
//					log.info("Chrome browser");
//					downloadName = new String(resourceName.getBytes("UTF-8"), "ISO-8859-1");
//				}
//				headers.add("Content-Disposition", "attachment; filename = "+downloadName);
//			} catch (UnsupportedEncodingException e) {
//				e.printStackTrace();
//			}
//			
//			return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
//		}

}
