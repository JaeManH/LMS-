package com.min.daoImpl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.dao.SubjectDao;
import com.min.vo.MemberVo;
import com.min.vo.RowNumVo;
import com.min.vo.SubjectVo;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Repository
public class SubjectDaoImpl implements SubjectDao{
	
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	private final String NS = "com.min.daoImpl.SubjectDaoImpl.";

	//1) 과목 등록
	//1-1) 과목 등록시 과목정보(과목명, 과목설명, 과목카테고리코드, 과목등록자ID)입력
	@Override
	public int subInsertSubject(Map<String, Object> map) {
		log.info("========== SubjectDaoImpl/subInsertSubject ==========");
		log.info("========== subInsertSubject : "+map+" ==========");
		return sqlSession.insert(NS+"subInsertSubject", map);
	}
	//1-2) 과목 등록시 등록자정보(등록자 코드, 등록자 권한, 과목등록자ID)입력
	@Override
	public int subInsertRegister(Map<String, Object> map) {
		log.info("========== SubjectDaoImpl/subInsertRegister ==========");
		log.info("========== subInsertRegister : "+map+" ==========");
		return sqlSession.insert(NS+"subInsertRegister", map);
	}
	//1-3) 과목 등록시 커리큘럼정보(과목번호,기타내용,상세내용,버전,시간,난이도,첨부파일)입력
	@Override
	public int subInsertCurriculum(Map<String, Object> map) {
		log.info("========== SubjectDaoImpl/subInsertCurriculum ==========");
		log.info("========== subInsertCurriculum : "+map+" ==========");
		return sqlSession.insert(NS+"subInsertCurriculum", map);
	}
	//1-4) 과목 등록시 등록자 회원/강사 구분 후 강사일시 담당강사 등록, 일반회원일시 담당강사 null
	@Override
	public int subUpdateInstructor(Map<String, Object> map) {
		log.info("========== SubjectDaoImpl/subUpdateInstructor ==========");
		log.info("========== subUpdateInstructor : "+map+" ==========");
		return sqlSession.insert(NS+"subUpdateInstructor", map);
	}
	
	//2) 관리자의 과목 조회
	//2-0) 페이징 처리를 위한 과목 전체 갯수 출력(관리자)
	@Override
	public int subjectTotalAdmin() {
		log.info("========== SubjectDaoImpl/subjectTotalAdmin ==========");
		return sqlSession.selectOne(NS+"subjectTotalAdmin");
	}
	
	//2-1) 관리자의 과목 전체 목록 조회
	@Override
	public List<SubjectVo> subSelectAllAdmin(RowNumVo rVo) {
		log.info("========== SubjectDaoImpl/subSelectAllAdmin ==========");
		log.info("========== subSelectAllAdmin : "+rVo+" ==========");
		return sqlSession.selectList(NS+"subSelectAllAdmin", rVo);
	}
	//2-) 관리자의 과목 전체 목록 조회 상태별
	@Override
	public List<SubjectVo> subSelectStatusAdmin(RowNumVo rVo) {
		log.info("========== SubjectDaoImpl/subSelectStatusAdmin ==========");
		log.info("========== subSelectStatusAdmin : "+rVo+" ==========");
		return sqlSession.selectList(NS+"subSelectStatusAdmin");
	}
	//2-2) 관리자의 과목 상세 조회
	@Override
	public SubjectVo adminSubjectDetail(String sub_num) {
		log.info("========== SubjectDaoImpl/adminSubjectDetail ==========");
		log.info("========== adminSubjectDetail : "+sub_num+" ==========");
		return sqlSession.selectOne(NS+"adminSubjectDetail", sub_num);
	}
	//2-3) 관리자의 과목 승인을 위한 전체 목록 조회
	@Override
	public List<SubjectVo> subSelectToApproveAdmin(RowNumVo rVo) {
		log.info("========== SubjectDaoImpl/subSelectToApproveAdmin ==========");
		log.info("========== subSelectAllAdmin : "+rVo+" ==========");
		return sqlSession.selectList(NS+"subSelectToApproveAdmin", rVo);
	}

	
	//3) 비회원/일반회원/강사의 과목 조회
	//3-0) 페이징 처리를 위한 과목 전체 갯수 출력(일반회원)
		@Override
		public int subjectTotalUser() {
			log.info("========== SubjectDaoImpl/subjectTotalUser ==========");
			return sqlSession.selectOne(NS+"subjectTotalUser");
		}
	//3-1) 비회원/일반회원/강사의 과목 전체 목록 조회
	@Override
	public List<SubjectVo> subSelectAllUser(SubjectVo sVo) {
		log.info("========== SubjectDaoImpl/subSelectAllUser ==========");
		log.info("========== subSelectAllUser : "+sVo+" ==========");
		return sqlSession.selectList(NS+"subSelectAllUser", sVo);
	}
	//3-2) 비회원/일반회원/강사의 과목 상세 조회
	@Override
	public SubjectVo userSubjectDetail(String sub_num) {
		log.info("========== SubjectDaoImpl/userSubjectDetail ==========");
		log.info("========== userSubjectDetail : "+sub_num+" ==========");
		return sqlSession.selectOne(NS+"userSubjectDetail", sub_num);
	}
	//3-3) 일반회원/강사의 마이페이지에서의 등록과목 목록 조회	
	@Override
	public List<SubjectVo> subSelectMySubject(SubjectVo sVo) {
		log.info("========== SubjectDaoImpl/subSelectMySubject ==========");
		log.info("========== userSubjectDetail : "+sVo+" ==========");
		return sqlSession.selectList(NS+"subSelectMySubject",sVo);
	}
	

	//4) 과목 승인
	//4-1) 과목 등록 후 관리자의 과목 검수 후 과목상태를 승인'A'으로 변경
	@Override
	public int subUpdateStatusA(Map<String, Object> map) {
		log.info("========== SubjectDaoImpl/subUpdateStatusA ==========");
		log.info("========== subUpdateStatusA : "+map+" ==========");
		int n = sqlSession.update(NS+"subUpdateStatusA");
		return sqlSession.update(NS+"subUpdateStatusA",map);
	}
	//4-2) 과목 등록 후 관리자의 과목 검수 후 과목상태를 삭제'D'으로 변경
	@Override
	public int subUpdateStatusD(Map<String, Object> map) {
		log.info("========== SubjectDaoImpl/subUpdateStatusD ==========");
		log.info("========== subUpdateStatusD : "+map+" ==========");
		int n = sqlSession.update(NS+"subUpdateStatusD");
		return sqlSession.update(NS+"subUpdateStatusD",map);
	}
	//4-3) 과목 등록 후 관리자의 과목 검수 후 과목상태를 반려'R'으로 변경
	@Override
	public int subUpdateStatusR(Map<String, Object> map) {
		log.info("========== SubjectDaoImpl/subUpdateStatusR ==========");
		log.info("========== subUpdateStatusR : "+map+" ==========");
		int n = sqlSession.update(NS+"subUpdateStatusR");
		return sqlSession.update(NS+"subUpdateStatusR",map);
	}
	//4-4) 과목 반려시 관리자의 과목 반려 사유 입력
	@Override
	public int subUpdateRejection(Map<String, Object> map) {
		log.info("========== SubjectDaoImpl/subUpdateRejection ==========");
		log.info("========== subUpdateRejection : "+map+" ==========");
		int n = sqlSession.update(NS+"subUpdateRejection");
		return sqlSession.update(NS+"subUpdateRejection",map);
	}
	
	//5) 과목 수정
	//5-1) 일반회원/강사 과목 수정시 과목 정보 수정
	@Override
	public int subUpdateSubject(Map<String, Object> map) {
		log.info("========== SubjectDaoImpl/subUpdateSubject ==========");
		log.info("========== subUpdateSubject : "+map+" ==========");
		int n = sqlSession.update(NS+"subUpdateSubject");
		return sqlSession.update(NS+"subUpdateSubject",map);
	}
	//5-2) 일반회원/강사 과목 수정시 커리큘럼 정보 수정
	@Override
	public int subUpdateCurriculum(Map<String, Object> map) {
		log.info("========== SubjectDaoImpl/subUpdateCurriculum ==========");
		log.info("========== subUpdateCurriculum : "+map+" ==========");
		int n = sqlSession.update(NS+"subUpdateCurriculum");
		return sqlSession.update(NS+"subUpdateCurriculum",map);
	}


	}




	


