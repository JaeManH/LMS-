package com.min.dao;

import java.util.List;
import java.util.Map;

import com.min.vo.CouponVo;
import com.min.vo.MemberVo;
import com.min.vo.PayVo;

public interface PayDao {
	
	//관리자 전체조회
	public List<PayVo> paySelectAll();
	
	//관리자 결제상태별 조회
	public List<PayVo> paySelectStatus(Map<String, Object> map);
	
	//결제시 테이블 insert
	public int payInsert(Map<String, Object> map);
	
	//결제시 쿠폰조회
	public List<CouponVo> couponSelect(Map<String, Object> map);
	
	//쿠폰사용 결제시 보우큐폰 상태 수정
	public int updateCoupon(Map<String,Object> map);
	
	//마일리지사용 결제시 마일리지 차감
	public int updateMileage(Map<String,Object> map);
	
	//결제 상세조회
	public PayVo getPayDetail(Map<String,Object> map);
	
	//환불 상태 업데이트
	public int statusUpdate(Map<String, Object> map);
	
	//마이페이지 내 결제조회
	public List<PayVo> selectMyPay(Map<String,Object> map);
	
	//마이페이지 결제내역 내의 환불신청
	public int cancelUpdate(Map<String, Object> map);
	
	//환불승인시 쿠폰 반환
	public int returnCoupon(Map<String,Object> map);
	
	//환불승인시 마일리지 반환
	public int returnMileage(Map<String,Object> map);
	
	//내 마일리지 조회
	public int myMilage(Map<String, Object> map);
	
	//내 쿠폰 조회
	public List<CouponVo> myCoupon(Map<String, Object> map);
	
	//내 보유쿠폰 장수 조회
	public int countCoupon(Map<String, Object> map);
	
	//결제시 마일리지 적립
	public int plusMileage(Map<String, Object> map);
	
	//10만원 이상 결제 시에 쿠폰 발급
	public int plusCoupon(Map<String, Object> map);
	
	//sms서비스를위해 번호 가져오기
	public String selectPhone(Map<String, Object> map);
	
//	//수강료 지급
//	public int insertSalary(Map<String, Object> map);
	
	//수강자로 등록
	public int updateClaPeople(Map<String, Object> map);
	
}
