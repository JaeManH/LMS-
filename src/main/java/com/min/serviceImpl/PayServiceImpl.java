package com.min.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.dao.PayDao;
import com.min.service.IPayService;
import com.min.vo.CouponVo;
import com.min.vo.MemberVo;
import com.min.vo.PayVo;

@Service
public class PayServiceImpl implements IPayService{

	@Autowired
	PayDao dao;
	
	@Override
	public List<PayVo> paySelectAll() {
		return dao.paySelectAll();
	}

	@Override
	public List<PayVo> paySelectStatus(Map<String, Object> map) {
		return dao.paySelectStatus(map);
	}

	@Override
	public int payInsert(Map<String, Object> map) {
		int n1 = dao.payInsert(map);
		int n2 = dao.plusMileage(map);
		return n1 + n2;
	}

	@Override
	public List<CouponVo> couponSelect(Map<String, Object> map) {
		return dao.couponSelect(map);
	}

	@Override
	public int updateCoupon(Map<String, Object> map) {
		return dao.updateCoupon(map);
	}

	@Override
	public int updateMileage(Map<String, Object> map) {
		return dao.updateMileage(map);
	}

	@Override
	public PayVo getPayDetail(Map<String, Object> map) {
		return dao.getPayDetail(map);
	}

	//환불시 상태 변경 , 마일리지 반환, 쿠폰 반환
	@Override
	public int statusUpdate(Map<String, Object> map) {
		int n1 = dao.statusUpdate(map);
		int n2 = dao.returnCoupon(map);
		int n3 = dao.returnMileage(map);
		return n1 + n2 + n3;
	}

	@Override
	public List<PayVo> selectMyPay(Map<String, Object> map) {
		return dao.selectMyPay(map);
	}

	@Override
	public int cancelUpdate(Map<String, Object> map) {
		return dao.cancelUpdate(map);
	}

	@Override
	public int myMilage(Map<String, Object> map) {
		return dao.myMilage(map);
	}

	@Override
	public List<CouponVo> myCoupon(Map<String, Object> map) {
		return dao.myCoupon(map);
	}

	@Override
	public int countCoupon(Map<String, Object> map) {
		return dao.countCoupon(map);
	}

	@Override
	public int plusCoupon(Map<String, Object> map) {
		return dao.plusCoupon(map);
	}

	@Override
	public String selectPhone(Map<String, Object> map) {
		return dao.selectPhone(map);
	}

//	@Override
//	public int insertSalary(Map<String, Object> map) {
//		return dao.insertSalary(map);
//	}

	@Override
	public int updateClaPeople(Map<String, Object> map) {
		return dao.updateClaPeople(map);
	}

}
