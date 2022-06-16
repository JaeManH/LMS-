package com.min.security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.min.service.IMemberService;
import com.min.vo.CareerVo;
import com.min.vo.MemberVo;


public class UserAuthService  implements AuthenticationProvider{

	@Autowired
	private IMemberService service;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		System.out.println("-------------------------");
		// 
		String username = (String)authentication.getPrincipal();		
		String user_pw = (String)authentication.getCredentials();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", username);
		System.out.println("user: id:{} , pwd:{} "+ username +"//"+ user_pw);
		
		MemberVo dto = new MemberVo();
		
		try{
			 dto = service.loginTra(map);
			 if ( dto.getAuth() == null || dto.getAuth() == ""  ) {
				throw new BadCredentialsException("Member 로그인 암호가 없습니다." + dto.getAuth() );
				}
			 if(!passwordEncoder.matches(user_pw, dto.getPw())) {
					throw new BadCredentialsException("아이디 및 비밀번호가 틀렸습니다." + dto.getAuth() );

			 }
				// 정보가 없으면 나간다.
				if ( username == null || username == "" ) {
					throw new BadCredentialsException("Member 로그인 아이디가 없습니다." + username );
				}
				if ( user_pw == null || user_pw == ""  ) {
					throw new BadCredentialsException("Member 로그인 암호가 없습니다." + user_pw );
				}
			} catch (NullPointerException e){
				e.printStackTrace();
				throw new BadCredentialsException("아이디 및 비밀번호가 틀렸습니다.");
				
			}
		
			
			
		
		
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		roles.add(new SimpleGrantedAuthority(dto.getAuth())); // ADMIN
				
		
//		// 로그인한 사용자의 부가정보를 담아준다.
		MemberVo user_info = new MemberVo();
		user_info.setId(dto.getId());
		user_info.setPw(dto.getPw());
		user_info.setAuth(dto.getAuth());
		user_info.setName(dto.getName());
		user_info.setEmail(dto.getEmail());
		user_info.setBirth(dto.getBirth());
		user_info.setPhone(dto.getPhone());
		user_info.setMilage(dto.getMilage());
		user_info.setProfile(dto.getProfile());
		user_info.setRegdate(dto.getRegdate());
		user_info.setDelflag(dto.getDelflag());
		user_info.setLike(dto.getLike());
		user_info.setPrefer(dto.getPrefer());
		
        // 반환할 값을 만든다.
        UsernamePasswordAuthenticationToken result 
        	= new UsernamePasswordAuthenticationToken(username, user_pw, roles);
        
        // 로그인한 사용자의 정보를 detail 에 넣어준다.
        result.setDetails(user_info);
        
		return result;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
