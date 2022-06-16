package com.min.bean;

import java.util.List;

import com.min.vo.MemberVo;
import com.min.vo.SubjectVo;

public class SubjectApproveListBeanAdmin {

	private List<SubjectVo> lists;
	private MemberVo mem;

	public void setLists(List<SubjectVo> lists) {
		this.lists = lists;
		System.out.println(lists);
	}
	public void setMem(MemberVo mem) {
		this.mem = mem;
	}

	//전체 구성
	public String getListForm() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < lists.size(); i++) {
			sb.append(listRowForm(lists.get(i)));
		}
		return sb.toString();
	}

	//화면 구성
	private String listRowForm(SubjectVo subVo) {
		StringBuffer sb = new StringBuffer();
		sb.append("<tr>");
		sb.append("   <td><a href='#'>"+subVo.getSub_num()+"</a></td>");
		sb.append("   <td><a href='./admin_subjectDetail.do?sub_num="+subVo.getSub_num()+"'>"+subVo.getSub_title()+"</a></td>");
		sb.append("   <td>");
		if(subVo.getCod_name().equals("JAVA")) {
			sb.append("          <span class='badge rounded-pill' style='background-color:#006400'>"+subVo.getCod_name()+"</span>");
		}else if (subVo.getCod_name().equals("C")) {
			sb.append("          <span class='badge rounded-pill' style='background-color:#AFEEEE'>"+subVo.getCod_name()+"</span>");
		}else if (subVo.getCod_name().equals("HTML")) {
			sb.append("          <span class='badge rounded-pill' style='background-color:#6A5ACD'>"+subVo.getCod_name()+"</span>");
		}else if (subVo.getCod_name().equals("PYTHON")) {
			sb.append("          <span class='badge rounded-pill' style='background-color:#C71585'>"+subVo.getCod_name()+"</span>");
		}else if (subVo.getCod_name().equals("CSS")) {
			sb.append("          <span class='badge rounded-pill' style='background-color:#FFF8DC'>"+subVo.getCod_name()+"</span>");
		}else if (subVo.getCod_name().equals("LINUX")) {
			sb.append("          <span class='badge rounded-pill' style='background-color:#40E0D0'>"+subVo.getCod_name()+"</span>");
		}else if (subVo.getCod_name().equals("C#")) {
			sb.append("          <span class='badge rounded-pill' style='background-color:#8FBC8F'>"+subVo.getCod_name()+"</span>");
		}else if (subVo.getCod_name().equals("JAVASCRIPT")) {
			sb.append("          <span class='badge rounded-pill' style='background-color:#8A2BE2'>"+subVo.getCod_name()+"</span>");
		}else if (subVo.getCod_name().equals("AI")) {
			sb.append("          <span class='badge rounded-pill' style='background-color:#FFB6C1'>"+subVo.getCod_name()+"</span>");
		}else if (subVo.getCod_name().equals("BIGDATA")) {
			sb.append("          <span class='badge rounded-pill' style='background-color:#000080'>"+subVo.getCod_name()+"</span>");
		}else if (subVo.getCod_name().equals("DEEPLEARNING")) {
			sb.append("          <span class='badge rounded-pill' style='background-color:#FA8072'>"+subVo.getCod_name()+"</span>");
		}else if (subVo.getCod_name().equals("VR")) {
			sb.append("          <span class='badge rounded-pill' style='background-color:#FFA500'>"+subVo.getCod_name()+"</span>");
		}else if (subVo.getCod_name().equals("AR")) {
			sb.append("          <span class='badge rounded-pill' style='background-color:#F0E68C'>"+subVo.getCod_name()+"</span>");
		}else if (subVo.getCod_name().equals("EXCEL")) {
			sb.append("          <span class='badge rounded-pill' style='background-color:#B0C4DE'>"+subVo.getCod_name()+"</span>");
		}else if (subVo.getCod_name().equals("POWERPOINT")) {
			sb.append("          <span class='badge rounded-pill' style='background-color:#2F4F4F'>"+subVo.getCod_name()+"</span>");
		}else if (subVo.getCod_name().equals("KOTLIN")) {
			sb.append("          <span class='badge rounded-pill' style='background-color:#D8BFD8'>"+subVo.getCod_name()+"</span>");
		}else if (subVo.getCod_name().equals("SPRING")) {
			sb.append("          <span class='badge rounded-pill' style='background-color:#1E90FF'>"+subVo.getCod_name()+"</span>");
		}else if (subVo.getCod_name().equals("기타")) {
			sb.append("          <span class='badge rounded-pill' style='background-color:#008080'>"+subVo.getCod_name()+"</span>");
		}else if (subVo.getCod_name().equals("형상관리")) {
			sb.append("          <span class='badge rounded-pill' style='background-color:#FFD700'>"+subVo.getCod_name()+"</span>");
		}else if (subVo.getCod_name().equals("DATABASE")) {
			sb.append("          <span class='badge rounded-pill' style='background-color:#A52A2A'>"+subVo.getCod_name()+"</span>");
		}else{
			sb.append("          <span class='badge rounded-pill' style='background-color:#556B2F'>"+subVo.getCod_name()+"</span>");
		}
		sb.append("  </td>");
		sb.append("<td>"+subVo.getSub_reg_id()+"</td>");
		sb.append("<td>"+subVo.getSub_regdate()+"</td>");
		
		if(subVo.getSub_status().equals("A")) {
			sb.append("   		<td><span class='badge rounded-pill' style='background-color: 	#1E90FF'>승인</span></td>    ");
		}else if (subVo.getSub_status().equals("W")) {
			sb.append("   		<td><span class='badge rounded-pill badge-info'>대기중</span></td>                           ");
		}else if(subVo.getSub_status().equals("R")) {
			sb.append("   		<td><span class='badge rounded-pill badge-warning'>반려</span></td>                          ");
		}else if(subVo.getSub_status().equals("D")) {
			sb.append("   		<td><span class='badge rounded-pill badge-danger'>삭제</span></td>                           ");
		}
		sb.append("</tr>                                                                                                       ");
		return sb.toString();
	}


}
