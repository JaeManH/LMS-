package com.min.ctrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.dao.PayDao;
import com.min.service.IPayService;
import com.min.serviceImpl.coolSMS;
import com.min.vo.CouponVo;
import com.min.vo.MemberVo;
import com.min.vo.PayVo;
import com.min.vo.SalaryVo;


@Controller
@RequestMapping(value = "/user/*")
public class payController{
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private IPayService service;
	
	@Autowired
	private coolSMS SMSservice;
	
	//결제페이지 이동
	@RequestMapping(value = "/pay.do", method = RequestMethod.GET)
	public String home(Model model,Authentication user) {
		logger.info("----------- payments 이동 -----------");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tra_id", user.getPrincipal());
		map.put("cou_tra_id", user.getPrincipal());
		int mile = service.myMilage(map);
		List<CouponVo> lists = service.couponSelect(map);
		model.addAttribute("lists",lists);
		model.addAttribute("mile",mile);
		return "user/payments";
	}
	
	//결제완료시 결제완료 페이지로 이동
	@RequestMapping(value = "/paySuccess.do", method = RequestMethod.GET)
	public String paySuccess(Model model,String paynum,String finalAmount,String plusMile,Authentication user,String claNum) {
		logger.info("--------결제성공 이동 ---------");
		System.out.println(paynum);
		System.out.println(finalAmount);
		int finalPrice = Integer.parseInt(finalAmount);
		if(finalPrice >= 100000) {
			Map<String, Object> map = new  HashMap<String, Object>();
			map.put("cou_codeper", "10");
			map.put("cou_per", "10");
			map.put("cou_tra_id", user.getPrincipal());
			map.put("cou_name", "10만원 이상 구매고객 10%쿠폰");
			int n = service.plusCoupon(map);
			System.out.println("쿠폰발급!!@@"+n);
			model.addAttribute("coupon","10만원 이상 구매고객 10%쿠폰");
		}else {
			model.addAttribute("coupon","0");
		}
		model.addAttribute("paynum",paynum);
		model.addAttribute("finalAmount",finalAmount);
		model.addAttribute("plusMile",plusMile);
		//수강자 등록하기
		Map<String, Object> claMap = new HashMap<String, Object>();
		claMap.put("tra_id", user.getPrincipal());
		claMap.put("claNum", claNum);
		int claResult = service.updateClaPeople(claMap);
		
		System.out.println("수강자 등록 확인 !!"+claResult);
		//회원 전화번호 가져오기
		Map<String, Object> phoneMap = new HashMap<String, Object>();
		phoneMap.put("tra_id", user.getPrincipal());
		String phone = service.selectPhone(phoneMap); 
		String phoneNum = phone.substring(0, 3)+"-"+phone.substring(3,7)+"-"+phone.substring(7,phone.length());
		SMSservice.certifiedPhoneNumber(phoneNum , paynum,"pay");
		return "user/paySuccess";
	}
	
	//관리자 결제정보 상세조회
	@RequestMapping(value = "/getPayDetail.do",method = RequestMethod.POST)
	@ResponseBody
	public PayVo getPayDetail(String paynum) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pay_num", paynum);
		PayVo vo = service.getPayDetail(map);
		map.put("pay_num", vo);
		return vo;
	}
	
	//관리자 결제정보 전체조회로 이동
	@RequestMapping(value = "/adminSelectPay.do", method = RequestMethod.GET)
	public String adminSelectPay(Model model) {
		logger.info("--------adminSelectPay 이동--------");
		List<PayVo> lists = service.paySelectAll();
		model.addAttribute("lists",lists);
		return "admin/adminSelectPay";
	}
	
	//관리자 전체조회 상태별 조회
	@RequestMapping(value = "/changePage.do", method = RequestMethod.GET)
	public String changePage(String getText,Model model) {
		System.out.println(getText);
		
		Map<String, Object> map= new HashMap<String, Object>();
		map.put("pay_status", getText);
		List<PayVo> lists = service.paySelectStatus(map);
		model.addAttribute("lists",lists);
		model.addAttribute("status",getText);
		return "admin/adminSelectPay";
	}
	
	//관리자 환불신청 페이지 이동
	@RequestMapping(value = "/changeStatus.do", method = RequestMethod.GET)
	public String changeStatus(Model model) {
		logger.info("-----changeStatus 이동 -------");
		Map<String, Object> map= new HashMap<String, Object>();
		map.put("pay_status","환불대기");
		List<PayVo> lists = service.paySelectStatus(map);
		model.addAttribute("lists",lists);
		return "admin/changeStatus";
	}
	
	//관리자 환불신청 상태별 페이지 변경
	@RequestMapping(value = "/changeStatusSelect.do", method = RequestMethod.GET)
	public String changeStatusSelect(String getText,Model model) {
		System.out.println(getText);
			
		Map<String, Object> map= new HashMap<String, Object>();
		map.put("pay_status", getText);
		List<PayVo> lists = service.paySelectStatus(map);
		model.addAttribute("lists",lists);
		model.addAttribute("status",getText);
		return "admin/changeStatus";
	}
	
	//관리자 환불요청 승인
	@RequestMapping(value = "/statusUpdate.do" , method = RequestMethod.GET)
	public String statusUpdate(String paynum,Authentication user) {
		System.out.println(paynum+"@!@!@!@!@!");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pay_num", paynum);
		int n = service.statusUpdate(map);
		
		
		Map<String, Object> phoneMap = new HashMap<String, Object>();
		phoneMap.put("tra_id", user.getPrincipal());		
		String phone = service.selectPhone(phoneMap); 
		String phoneNum = phone.substring(0, 3)+"-"+phone.substring(3,7)+"-"+phone.substring(7,phone.length());
		SMSservice.certifiedPhoneNumber(phoneNum , paynum,"refund");
		System.out.println(n + "성공입니다~");
		return "redirect:/user/changeStatus.do";
	}
	
	//회원 결제조회 페이지
	@RequestMapping(value = "/user_Mypay.do" ,method = RequestMethod.GET)
	public String userMypay(Authentication user,Model model) {
		logger.info("-------------user_Mypay 이동 -------------");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pay_tra_buyer", user.getPrincipal());
		List<PayVo> list = service.selectMyPay(map);
		model.addAttribute("lists",list);
		return "user/user_Mypay";
	}
	
	//마이페이지 환불신청
	@RequestMapping(value = "/cancelUpdate.do", method = RequestMethod.POST)
	public void cancelUpdate(String pay_num,String pay_cancate,String pay_status,String pay_cancontent) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pay_cancate", pay_cancate);
		map.put("pay_status", pay_status);
		map.put("pay_cancontent", pay_cancontent);
		map.put("pay_num", pay_num);
		int n = service.cancelUpdate(map);
		System.out.println(n);
	}
	
	//내 마일리지,쿠폰 조회페이지 이동
	@RequestMapping(value = "/user_MyDiscount.do",method = RequestMethod.GET)
	public String user_MyDiscount(Model model,Authentication user) {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(user.getPrincipal()+"@@@");
		map.put("tra_id", user.getPrincipal());
		map.put("cou_tra_id", user.getPrincipal());
		map.put("cou_delflag", "Y");
		
		List<CouponVo> coulists = service.myCoupon(map);
		int mile = service.myMilage(map);
		int count = service.countCoupon(map);
		
		model.addAttribute("coulists",coulists);
		model.addAttribute("mile",mile);
		model.addAttribute("count",count);
		
		return "user/user_MyDiscount";
	}
	
	//수강료 지급 페이지 이동하기
	@RequestMapping(value = "/salary.do" ,method = RequestMethod.GET)
	public String salary(Model model) {
		List<SalaryVo> getSal = service.getSalary();
		model.addAttribute("lists",getSal);
		return "admin/admin_salary";
	}
}
