package com.min.daoImpl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.dao.PayDao;
import com.min.vo.CouponVo;
import com.min.vo.MemberVo;
import com.min.vo.PayVo;

@Repository
public class PayDaoImpl implements PayDao{
	
	private final String NS="com.min.daoImpl.PayDaoImpl.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//관리자 주문 전체조회
	@Override
	public List<PayVo> paySelectAll() {
		return sqlSession.selectList(NS+"paySelectAll");
	}
	
	//관리자페이지 상태별 조회
	@Override
	public List<PayVo> paySelectStatus(Map<String, Object> map) {
		return sqlSession.selectList(NS+"paySelectStatus",map);
	}
		
	//결제 insert
	@Override
	public int payInsert(Map<String, Object> map) {
		return sqlSession.insert(NS+"payInsert",map);
	}

	//결제시 쿠폰조회
	@Override
	public List<CouponVo> couponSelect(Map<String, Object> map) {
		return sqlSession.selectList(NS+"couponSelect",map);
	}

	//쿠폰사용 결제시 보유쿠폰 상태 변경
	@Override
	public int updateCoupon(Map<String, Object> map) {
		return sqlSession.update(NS+"updateCoupon",map);
	}

	//마일리지사용 결제시 마일리지 상태 변경
	@Override
	public int updateMileage(Map<String, Object> map) {
		return sqlSession.update(NS+"updateMileage",map);
	}
	
	//결제 상세조회
	@Override
	public PayVo getPayDetail(Map<String, Object> map) {
		return sqlSession.selectOne(NS+"getPayDetail",map);
	}

	//환불 상태 변경
	@Override
	public int statusUpdate(Map<String, Object> map) {
		return sqlSession.update(NS+"statusUpdate",map);
	}

	//마이페이지 내 결제조회
	@Override
	public List<PayVo> selectMyPay(Map<String, Object> map) {
		return sqlSession.selectList(NS+"selectMyPay",map);
	}

	//마이페이지 내의 환불상태 업데이트
	@Override
	public int cancelUpdate(Map<String, Object> map) {
		return sqlSession.update(NS+"cancelUpdate",map);
	}

	//환불승인시에 쿠폰반환
	@Override
	public int returnCoupon(Map<String, Object> map) {
		return sqlSession.update(NS+"returnCoupon",map);
	}

	//환불승인시에 마일리지 반환
	@Override
	public int returnMileage(Map<String, Object> map) {
		return sqlSession.update(NS+"returnMileage",map);
	}

	//내 마일리지 조회
	@Override
	public int myMilage(Map<String, Object> map) {
		return sqlSession.selectOne(NS+"myMilage",map);
	}

	//내 보유쿠폰 조회
	@Override
	public List<CouponVo> myCoupon(Map<String, Object> map) {
		return sqlSession.selectList(NS+"myCoupon",map);
	}

	//내 보유쿠폰장수 조회
	@Override
	public int countCoupon(Map<String, Object> map) {
		return sqlSession.selectOne(NS+"countCoupon",map);
	}

	//결제시 마일리지 10% 적립 
	@Override
	public int plusMileage(Map<String, Object> map) {
		return sqlSession.update(NS+"plusMileage",map);
	}

	//10만원 이상 결제시에 쿠폰 발급
	@Override
	public int plusCoupon(Map<String, Object> map) {
		return sqlSession.insert(NS+"plusCoupon",map);
	}

	//sms발송시 회원의 전화번호 가져오기
	public String selectPhone(Map<String, Object> map) {
		return sqlSession.selectOne(NS+"selectPhone",map);
	}
	
	//수강료 지급
	@Override
	public int insertSalary(Map<String, Object> map) {
		return sqlSession.insert(NS+"insertSalary",map);
	}

	//수강자로 등록
	@Override
	public int updateClaPeople(Map<String, Object> map) {
		return sqlSession.update(NS+"updateClaPeople",map);
	}

	//강사 아이디 가져오기
	@Override
	public List<String> getIns(Map<String, Object> map) {
		return sqlSession.selectList(NS+"getIns",map);
	}

	
}
