package com.min.utils;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;

import com.min.service.IMemberService;
import com.min.vo.MemberVo;

public class MailUtil {
	@Autowired 
	IMemberService service;
	
	public void sendEmail(MemberVo vo) throws Exception{
		
		//Mail Server 설정
		String charSet="utf-8";
		String hostSMTP="smtp.naver.com";
		String hostSMTPid=""; //관리자 이메일 아이디
		String hostSMTPpw=""; //관리자 이메일 비밀번호
		
		//보내는 사람 
		String fromEmail="modali05@naver.com"; //보내는 사람 이메일 
		String fromName="관리자"; //보내는 사람 이름
		
		String subject="LMS 비밀번호 메일입니다"; //메일 제목
		String msg="";
		
		msg +="<div align='lift'";
		msg +="<h3>";
		msg +=vo.getId() + "님의 임시 비밀번호입니다. <br>로그인 후 비밀번호를 변경해 주세요</h3>";
		msg +="<p>임시 비밀번호:";
		msg +=vo.getPw() + "</p></div>";
		
		//email전송
		String mailRecipient=vo.getEmail();//받는 사람 이메일 주소
		try {
			//객체 선언
			HtmlEmail mail = new HtmlEmail();
			mail.setDebug(true);
			mail.setCharset(charSet);
			mail.setSSLOnConnect(true);
			mail.setHostName(hostSMTP);
			mail.setSmtpPort(587); 
			mail.setAuthentication(hostSMTPid, hostSMTPpw);
			mail.setStartTLSEnabled(true);
			mail.addTo(mailRecipient,charSet);
			mail.setFrom(fromEmail, fromName, charSet);
			mail.setSubject(subject);
			mail.setHtmlMsg(msg);
			mail.send();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void findPw(HttpServletResponse response,MemberVo vo) {
		response.setContentType("text/html;charset=utf-8");
		
	}

}