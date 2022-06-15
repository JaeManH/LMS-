package com.min.bean;

import java.util.List;

import org.springframework.security.core.Authentication;

import com.min.vo.MemberVo;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberListBean {

	private List<MemberVo> lists;
	private MemberVo user;
//	private InfoUser user;
	

	// 전체 리스트
	public String getListForm() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < lists.size(); i++) {
			sb.append(listRowForm(lists.get(i)));
		}
		return sb.toString();
	}
	
	// 화면의 구성
	private String listRowForm(MemberVo memberVo) {
		StringBuffer sb = new StringBuffer();
	    sb.append("<tr>                                                                                                					" );
	    sb.append("  <td><input type='checkbox' name='chk' value='"+memberVo.getId()+"'></td>                                       " );                                    	         
	    sb.append("  <td>"+replyImage(memberVo.getProfile())+"</td>                                                                  " );                                                                                    
	    sb.append("   <td onclick='modalOpen("+memberVo.getId()+")'><a href='#' data-bs-toggle='modal' data-original-title='test' data-bs-target='#exampleModal'>"+memberVo.getId()+"</a></td>");                                                                                        
	    sb.append("  <td>"+memberVo.getName()+"</td>                                                                  " );  
	    sb.append("  <td>"+memberVo.getEmail()+"</td>                                                                  " );  
	    sb.append("  <td>"+memberVo.getRegdate()+"</td>                                                                            " );
	    sb.append("  <td>"+memberVo.getDelflag()+"</td>                                                                         " );
	    sb.append("</tr>                                                                                               " );
		return sb.toString();
	}
	
	private String replyImage(String mem) {
		StringBuffer sb = new StringBuffer();
		if(mem == null)
	
			sb.append("<img src='./images/reply.png' alt='' >");
		
		if(mem != null) {
//			sb.append("<img src='./images/reply.png>");
			sb.append("<img class='img-50 rounded-circle' src='\"+memberVo.getProfile()+\"'>");
		}
		
		return sb.toString();
	}
}
