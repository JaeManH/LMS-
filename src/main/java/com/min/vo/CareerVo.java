package com.min.vo;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class CareerVo {
	private String car_code;
	private String car_ins_id;
	private String car_file;
	private String car_depart;
	private String car_position;
	private String car_period;
	private String car_content;
}
