package com.min.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.dao.IMemberDao;
import com.min.service.IMemberService;
import com.min.vo.CareerVo;
import com.min.vo.MemberVo;
import com.min.vo.RowNumVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberServiceImpl implements IMemberService{
	
	@Autowired
	private IMemberDao dao;

	@Override
	public MemberVo loginTra(Map<String, Object> map) {
		log.info("MemberVo loginTra 서비스 실행");
		return dao.loginTra(map);
	}
	@Override
	public CareerVo loginCar(Map<String, Object> map) {
		log.info("MemberVo loginCar 서비스 실행");
		return dao.loginCar(map);
	}
	@Override
	public int traSignUp(Map<String, Object> map) {
		log.info("MemberVo traSignUp");
		return dao.traSignUp(map);
	}

	@Override
	public MemberVo loginIns(Map<String, Object> map) {
		return dao.loginIns(map);
	}

	@Override
	public int InsSignUp(Map<String, Object> map) {
		return dao.InsSignUp(map);
	}

	@Override
	public List<MemberVo> adminUserListRow(RowNumVo rvo) {
		log.info("MemberServiceImpl adminUserListRow {}", rvo);
		return dao.adminUserListRow(rvo);
	}

	@Override
	public int adminUserListTotal() {
		log.info("MemberServiceImpl adminUserListTotal");
		return dao.adminUserListTotal();
	}

	@Override
	public int adminDelTra(Map<String, Object> map) {
		log.info("MemberServiceImpl adminDelTra");
		return dao.adminDelTra(map);
	}

	@Override
	public MemberVo findTraId(Map<String, Object> map) {
		log.info("MemberServiceImpl findTraId");
		return dao.findTraId(map);
	}

	@Override
	public int delTra(Map<String, Object> map) {
		log.info("MemberServiceImpl delTra");
		return dao.delTra(map);
	}

	@Override
	public int updateTra(Map<String, Object> map) {
		log.info("MemberServiceImpl updateTra");
		return dao.updateTra(map);
	}

	@Override
	public MemberVo findInsId(Map<String, Object> map) {
		log.info("MemberServiceImpl findInsId");
		return dao.findInsId(map);
	}

	@Override
	public int delIns(Map<String, Object> map) {
		log.info("MemberServiceImpl delIns");
		return dao.delIns(map);
	}

	@Override
	public int updateIns(Map<String, Object> map) {
		log.info("MemberServiceImpl updateIns");
		return dao.updateIns(map);
	}

	@Override
	public int updateProfile(Map<String, Object> map) {
		log.info("MemberServiceImpl updateProfile");
		return dao.updateProfile(map);
	}

	@Override
	public int checkTraId(String id) {
		log.info("MemberServiceImpl CheckTraId");
		log.info(id);
		return dao.checkTraId(id);
	}

	@Override
	public int checkInsId(String id) {
		log.info("MemberServiceImpl checkInsId");
		return dao.checkInsId(id);
	}

	@Override
	public int insertCar(Map<String, Object> map) {
		log.info("MemberServiceImpl insertCar");

		int n = dao.insertCar(map);
		int m = dao.insCarUpdate(map);
		return (n>0 || m>0) ? 1:0 ;
	}

	@Override
	public int updateCar(Map<String, Object> map) {
		log.info("MemberServiceImpl updateCar");
		
		int n = dao.updateCar(map);
		int m = dao.updateCarDelflag(map);
		return (n>0 || m>0) ? 1:0 ;
	}

	


}
