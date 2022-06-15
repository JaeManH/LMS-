package com.min.vo;

import java.util.List;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class InstructorVo {
	private String ins_id;
	private String ins_name;
	private String ins_email;
	private String ins_carrer;
	
	private String vot_cla_num;
	private String vot_sub_num;
	private String vot_ins_id;
	private String vot_voter;
}
