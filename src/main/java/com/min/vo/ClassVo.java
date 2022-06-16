package com.min.vo;

import java.io.Serializable;
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
public class ClassVo implements Serializable{
	private static final long serialVersionUID = -8295356121986686775L;
	private String cla_num;
	private String cla_title;
	private String cla_content;
	private int cla_maxpeo;
	private int cla_price;
	private int cla_dailytime;
	private String cla_startdate;
	private int cla_totaltime;
	private String cla_like;
	private String cla_status;
	private String cla_regdate;
	private String cla_enddate;
	private String cla_endrecruit;
	private String cla_endvote;
	private int cla_addtime;
	private List<String> cla_tags;
}
