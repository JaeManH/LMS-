package com.min.vo;


import java.io.Serializable;

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
public class ClassPeopleVo implements Serializable{
	private static final long serialVersionUID = 8897720271723684145L;
	private int cpe_seq;
	private String cpe_mem_id;
	private String cpe_cla_num;
	
	private VoteVo votevo;
}
