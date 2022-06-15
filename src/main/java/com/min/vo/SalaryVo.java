package com.min.vo;

public class SalaryVo {
	
	private int sal_seq         ;
	private String sal_cla_num     ;
	private int sal_totalprice  ;
	private String sal_ins_id      ;
	private String sal_banknum     ;
	private String sal_bank        ;
	private int sal_price       ;
	private String sal_status      ;
	private String sal_date        ;
	public int getSal_seq() {
		return sal_seq;
	}
	public void setSal_seq(int sal_seq) {
		this.sal_seq = sal_seq;
	}
	public String getSal_cla_num() {
		return sal_cla_num;
	}
	public void setSal_cla_num(String sal_cla_num) {
		this.sal_cla_num = sal_cla_num;
	}
	public int getSal_totalprice() {
		return sal_totalprice;
	}
	public void setSal_totalprice(int sal_totalprice) {
		this.sal_totalprice = sal_totalprice;
	}
	public String getSal_ins_id() {
		return sal_ins_id;
	}
	public void setSal_ins_id(String sal_ins_id) {
		this.sal_ins_id = sal_ins_id;
	}
	public String getSal_banknum() {
		return sal_banknum;
	}
	public void setSal_banknum(String sal_banknum) {
		this.sal_banknum = sal_banknum;
	}
	public String getSal_bank() {
		return sal_bank;
	}
	public void setSal_bank(String sal_bank) {
		this.sal_bank = sal_bank;
	}
	public int getSal_price() {
		return sal_price;
	}
	public void setSal_price(int sal_price) {
		this.sal_price = sal_price;
	}
	public String getSal_status() {
		return sal_status;
	}
	public void setSal_status(String sal_status) {
		this.sal_status = sal_status;
	}
	public String getSal_date() {
		return sal_date;
	}
	public void setSal_date(String sal_date) {
		this.sal_date = sal_date;
	}
	@Override
	public String toString() {
		return "SalaryVo [sal_seq=" + sal_seq + ", sal_cla_num=" + sal_cla_num + ", sal_totalprice=" + sal_totalprice
				+ ", sal_ins_id=" + sal_ins_id + ", sal_banknum=" + sal_banknum + ", sal_bank=" + sal_bank
				+ ", sal_price=" + sal_price + ", sal_status=" + sal_status + ", sal_date=" + sal_date + "]";
	}
	public SalaryVo(int sal_seq, String sal_cla_num, int sal_totalprice, String sal_ins_id, String sal_banknum,
			String sal_bank, int sal_price, String sal_status, String sal_date) {
		super();
		this.sal_seq = sal_seq;
		this.sal_cla_num = sal_cla_num;
		this.sal_totalprice = sal_totalprice;
		this.sal_ins_id = sal_ins_id;
		this.sal_banknum = sal_banknum;
		this.sal_bank = sal_bank;
		this.sal_price = sal_price;
		this.sal_status = sal_status;
		this.sal_date = sal_date;
	}
	public SalaryVo() {
		super();
	}
	
}
