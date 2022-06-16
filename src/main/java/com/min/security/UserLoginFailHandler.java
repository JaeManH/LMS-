package com.min.security;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Service;

/* 로그인 실패 대응 로직 */
@Service
public class UserLoginFailHandler implements AuthenticationFailureHandler {

	private String id;			// 로그인 id값이 들어오는 input 태그 name
	private String pw;		// 로그인 password 값이 들어오는 input 태그 name
	private String loginredirectname;		// 로그인 성공시 redirect 할 URL이 지정되어 있는 input 태그 name
	private String exceptionmsgname;		// 예외 메시지를 request의 Attribute에 저장할 때 사용될 key 값
	private String defaultFailureUrl;		// 화면에 보여줄 URL(로그인 화면)
	
	public UserLoginFailHandler(){
		this.id = "id";
		this.pw = "pw";
		this.loginredirectname = "loginRedirect";
		this.exceptionmsgname = "securityexceptionmsg";
		this.defaultFailureUrl = "/loginPage.do";
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getExceptionmsgname() {
		return exceptionmsgname;
	}
	public String getLoginredirectname() {
		return loginredirectname;
	}
	public void setLoginredirectname(String loginredirectname) {
		this.loginredirectname = loginredirectname;
	}
	public void setExceptionmsgname(String exceptionmsgname) {
		this.exceptionmsgname = exceptionmsgname;
	}
	public String getDefaultFailureUrl() {
		return defaultFailureUrl;
	}
	public void setDefaultFailureUrl(String defaultFailureUrl) {
		this.defaultFailureUrl = defaultFailureUrl;
	}
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

		// Request 객체의 Attribute에 사용자가 실패시 입력했던 로그인 ID와 비밀번호를 저장해두어 로그인 페이지에서 이를 접근하도록 한다
		String loginid = request.getParameter(id);
		String loginpasswd = request.getParameter(pw);
		String loginRedirect = request.getParameter(loginredirectname);
		
		request.setAttribute(id, loginid);
		request.setAttribute(pw, loginpasswd);
		request.setAttribute(loginredirectname, loginRedirect);
		
		
		// Request 객체의 Attribute에 예외 메시지 저장
		request.setAttribute(exceptionmsgname, exception.getMessage());
		
		request.getRequestDispatcher(defaultFailureUrl).forward(request, response);
	}
	
}