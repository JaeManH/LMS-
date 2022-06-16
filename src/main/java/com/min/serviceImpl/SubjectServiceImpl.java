package com.min.serviceImpl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.min.service.SubjectService;
import com.min.vo.MemberVo;
import com.min.vo.RowNumVo;
import com.min.vo.SubjectVo;
import com.min.dao.SubjectDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SubjectServiceImpl implements SubjectService{


	@Autowired
	private SubjectDao sDao;

	//1) 과목 등록
	@Override
	public int InsertSubject(Map<String, Object> map) {
		log.info("========== SubjectServiceImpl/InsertSubject ==========");
		log.info("========== SubjectServiceImpl/InsertSubject : {} "+map+"==========");
		int n = sDao.subInsertSubject(map);
		int m = sDao.subInsertCurriculum(map);
		return (n>0||m>0)?1:0;
	}
	@Override
	public int UpdateSubIns(Map<String, Object> map) {
		log.info("========== SubjectServiceImpl/UpdateSubIns : {} "+map+" ==========");
		int n = sDao.subInsertRegister(map);
		int m = sDao.subUpdateInstructor(map);
		return (n>0||m>0)?1:0;
	}


	//2) 관리자의 과목 조회
	//2-0) 페이징 처리를 위한 전체목록 갯수 조회
	@Override
	public int subjectTotalAdmin() {
		log.info("========== SubjectServiceImpl/subjectTotalAdmin 관리자의 과목 전체목록 갯수 ==========");
		return sDao.subjectTotalAdmin();
	}
	//2-1) 관리자의 과목 전체목록 조회
	@Override
	public List<SubjectVo> subSelectAllAdmin(RowNumVo rVo) {
		log.info("========== SubjectServiceImpl/subSelectAllAdmin 관리자의 과목 전체목록 갯수 ==========");
		return sDao.subSelectAllAdmin(rVo);
	}
	@Override
	public List<SubjectVo> subSelectStatusAdmin(RowNumVo rVo) {
		log.info("========== SubjectServiceImpl/subSelectAllAdmin 관리자의ㄴ 과목 전체목록 갯수 ==========");
		return sDao.subSelectStatusAdmin(rVo);
	}
	//2-2) 관리자의 과목 상세 조회
	@Override
	public SubjectVo adminSubjectDetail(String sub_num) {
		log.info("========== SubjectServiceImpl/adminSubjectDetail 관리자의 과목 상세 조회 ==========");
		log.info("========== SubjectServiceImpl/adminSubjectDetail 관리자의 과목 상세 조회 : "+sub_num+ " ==========");
		return sDao.adminSubjectDetail(sub_num);
	}
	//2-3) 관리자의 과목승인을 위한 전체목록 조회
	@Override
	public List<SubjectVo> subSelectToApproveAdmin(RowNumVo rVo) {
		log.info("========== SubjectServiceImpl/subSelectToApproveAdmin 관리자의 과목승인을 위한 전체목록 조회 ==========");
		return sDao.subSelectAllAdmin(rVo);
	}

	//3) 비회원/일반회원/강사의 과목 조회
	//3-0) 페이징 처리를 위한 전체목록 갯수 조회
	@Override
	public int subjectTotalUser() {
		log.info("========== SubjectServiceImpl/subjectTotalUser 관리자의 과목 전체목록 갯수 ==========");
		return sDao.subjectTotalUser();
	}
	//3-1) 비회원/일반회원/강사의 과목 전체목록 조회
	@Override
	public List<SubjectVo> subSelectAllUser(SubjectVo sVo) {
		log.info("========== SubjectServiceImpl/subSelectAllUser 일반회원의 과목 전체목록 조회 ==========");
		return sDao.subSelectAllUser(sVo);
	}
	//3-2) 비회원/일반회원/강사의 과목 상세 조회
	@Override
	public SubjectVo userSubjectDetail(String sub_num) {
		log.info("========== SubjectServiceImpl/comSubjectDetail 일반회원의 과목 상세 조회 ==========");
		log.info("========== SubjectServiceImpl/comSubjectDetail 일반회원의 과목 상세 조회 : "+sub_num+ "==========");
		return sDao.userSubjectDetail(sub_num);
	}
	//3-3) 일반회원/강사의 마이페이지에서의 등록 과목 목록 조회
	@Override
	public List<SubjectVo> subSelectMySubject(SubjectVo sVo) {
		log.info("========== SubjectServiceImpl/subSelectMySubject  마이페이지에서의 등록 과목 목록 조회 ==========");
		log.info("========== SubjectServiceImpl/subSelectMySubject  마이페이지에서의 등록 과목 목록 조회 : "+sVo+ "==========");
		return sDao.subSelectMySubject(sVo);
	}

	//4) 과목 승인
	//4-1) 과목 등록 후 관리자의 과목 검수 후 과목상태를 승인'A'으로 변경
	@Override
	public int subUpdateStatusA(Map<String, Object> map) {
		log.info("========== SubjectServiceImpl/subUpdateStatusA 과목 등록 후 관리자의 과목 검수 후 과목상태를 승인'A'으로 변경 ==========");
		log.info("========== SubjectServiceImpl/subUpdateStatusA 과목 등록 후 관리자의 과목 검수 후 과목상태를 승인'A'으로 변경 : {} "+map+"==========");
		return sDao.subUpdateStatusA(map);
	}
	//4-2) 과목 등록 후 관리자의 과목 검수 후 과목상태를 삭제'D'으로 변경
	@Override
	public int subUpdateStatusD(Map<String, Object> map) {
		log.info("========== SubjectServiceImpl/subUpdateStatusD 과목 등록 후 관리자의 과목 검수 후 과목상태를 삭제'D'으로 변경 ==========");
		log.info("========== SubjectServiceImpl/subUpdateStatusD 과목 등록 후 관리자의 과목 검수 후 과목상태를 삭제'D'으로 변경 : {} "+map+"==========");
		return sDao.subUpdateStatusD(map);
	}
	//4-3) 과목 반려시 과목상태 반려 'R'로 변경 및 반려사유 입력
	@Override
	public int subReject(Map<String, Object> map) {
		log.info("========== SubjectServiceImpl/subUpdateStatusD 과목 반려시 과목상태 반려'R'로 변경 및 반려사유 입력 ==========");
		log.info("========== SubjectServiceImpl/subUpdateStatusD 과목 반려시 과목상태 반려'R'로 변경 및 반려사유 입력 : {} "+map+"==========");
		int n = sDao.subUpdateStatusR(map);
		int m = sDao.subInsertRegister(map);
		return (n>0||m>0)?1:0;
	}

	//5) 과목 수정
	//5-1) 일반회원/강사 과목 수정시 과목 정보 수정
	@Override
	public int subUpdateSubject(Map<String, Object> map) {
		log.info("========== SubjectServiceImpl/subUpdateSubject 일반회원/강사 과목 수정시 과목 정보 수정 ==========");
		log.info("========== SubjectServiceImpl/subUpdateSubject 일반회원/강사 과목 수정시 과목 정보 수정 : {} "+map+"==========");
		return sDao.subUpdateSubject(map);
	}
	//5-2) 일반회원/강사 과목 수정시 커리큘럼 정보 수정
	@Override
	public int subUpdateCurriculum(Map<String, Object> map) {
		log.info("========== SubjectServiceImpl/subUpdateCurriculum 일반회원/강사 과목 수정시 커리큘럼 정보 수정 ==========");
		log.info("========== SubjectServiceImpl/subUpdateCurriculum 일반회원/강사 과목 수정시 커리큘럼 정보 수정 : {} "+map+"==========");
		return sDao.subUpdateCurriculum(map);
	}








}
