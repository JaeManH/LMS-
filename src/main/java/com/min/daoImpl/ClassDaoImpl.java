package com.min.daoImpl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.dao.IClassDao;
import com.min.vo.ClassPeopleVo;
import com.min.vo.ClassSubjectVo;
import com.min.vo.ClassVo;
import com.min.vo.InstructorVo;
import com.min.vo.SubjectVo;
import com.min.vo.VoteVo;

@Repository
public class ClassDaoImpl implements IClassDao{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired 
	private SqlSessionTemplate sqlSession;
	
	private String NS = "com.min.daoImpl.Class.";
	
	@Override
	public List<ClassVo> classSelectAll() {
		logger.info("ClassDaoImpl classSelectAll / 전체조회");
		return sqlSession.selectList(NS+"classSelectAll");
	}
	
	@Override
	public List<ClassVo> classSelected() {
		logger.info("ClassDaoImpl classSelectAll / 구분조회");
		return sqlSession.selectList(NS+"classSelected");
	}
	
	@Override
	public ClassVo classSelectDetail(String vo) {
		logger.info("ClassDaoImpl classSelectDetail / 상세조회 : {}",vo);
		return sqlSession.selectOne(NS+"classSelectDetail",vo);
	}

	@Override
	public List<SubjectVo> classSelectedSub(String cla_num) {
		return sqlSession.selectList(NS+"classSelectedSub",cla_num);
	}
	
	@Override
	public int classFormInsert(Map<String, Object> vo) {
		logger.info("ClassDaoImpl classFormInsert / 과정등록폼 생성 : {}",vo);
		return sqlSession.insert(NS+"classFormInsert",vo);
	}

	@Override
	public int classSubjectInsert(Map<String, Object> vo) {
		logger.info("ClassDaoImpl classSubjectInsert / 과정 과목리스트 생성 : {}",vo);
		return sqlSession.insert(NS+"classSubjectInsert",vo);
	}
	
	@Override
	public int classUpdate(Map<String, Object> vo) {
		logger.info("ClassDaoImpl classUpdate / 과정 담당강사 과정 수정 : {}", vo);
		return sqlSession.update(NS+"classUpdate", vo);
	}
	
	@Override
	public int classTimeUpdate() {
		logger.info("ClassDaoImpl classUpdate / 과정 과목 총 수업시간 계산");
		return sqlSession.update(NS+"classTimeUpdate");
	}
	
	@Override
	public List<VoteVo> classTimeSearch(ClassVo vo) {
		logger.info("ClassDaoImpl classTimeSearch / 과정 과목 총 수업시간 계산을 위한 계산");
		return sqlSession.selectList(NS+"classTimeSearch",vo);
	}

	@Override
	public int voteBoxInsert(Map<String, Object> map) {
		logger.info("ClassDaoImpl voteBoxInsert / 과정 투표박스 생성 : {}", map);
		return sqlSession.insert(NS+"voteBoxInsert", map);
	}
	
	@Override
	public int updateVote(Map<String, Object> map) {
		logger.info("ClassDaoImpl updateVote / 과정 과목 당 강사 투표 : {}",map);
		return sqlSession.update(NS+"updateVote",map);
	}
	
	@Override
	public List<InstructorVo> classInsInfo(String id) {
		return sqlSession.selectList(NS+"classInsInfo",id);
	}
	
	@Override
	public List<VoteVo> voteRatio(VoteVo vo) {
		return sqlSession.selectList(NS+"voteRatio",vo);
	}
	
	@Override
	public VoteVo voteIns(VoteVo vo) {
		return sqlSession.selectOne(NS+"voteIns",vo);
	}
	
	@Override
	public List<VoteVo> votedPeople(VoteVo vo) {
		return sqlSession.selectList(NS+"votedPeople",vo);
	}
	
	@Override
	public int voteDelete(Map<String, Object> map) {
		logger.info("ClassDaoImpl voteDelete : {}",map);
		return sqlSession.delete(NS+"voteDelete",map);
	}

	@Override
	public int votedInsert(Map<String, Object> map) {
		logger.info("ClassDaoImpl votedInsert : {}",map);
		return sqlSession.insert(NS+"votedInsert", map);
	}

	@Override
	public int classStatusUpdate(Map<String, Object> map) {
		return sqlSession.update(NS+"classStatusUpdate",map);
	}
	
	@Override
	public int classPeoInsert(Map<String, Object> map) {
		return sqlSession.insert(NS+"classPeoInsert",map);
	}
	
	
	@Override
	public List<SubjectVo> subjectSelected() {
		logger.info("ClassDaoImpl subjectSelected / 과목 선택 리스트");
		return sqlSession.selectList(NS+"subjectSelected");
	}

	@Override
	public int classPeoSelectAll(ClassPeopleVo vo) {
		return sqlSession.selectOne(NS+"classPeoSelectAll",vo);
	}
	
	
	@Override
	public ClassVo classSelectLastInsert() {
		return sqlSession.selectOne(NS+"classSelectLastInsert");
	}

	@Override
	public List<String> classVotedSelectAll(ClassPeopleVo vo) {
		return sqlSession.selectList(NS+"classVotedSelectAll",vo);
	}

	@Override
	public int endRecruit() {
		return sqlSession.update(NS+"endRecruit");
	}

	@Override
	public int endVote() {
		return sqlSession.update(NS+"endVote");
	}

	@Override
	public int classStart() {
		return sqlSession.update(NS+"classStart");
	}

	@Override
	public int classEnd() {
		return sqlSession.update(NS+"classEnd");
	}

	
	@Override
	public int classPeoDelete(String cla_num) {
		return sqlSession.delete(NS+"classPeoDelete",cla_num);
	}
	
	
	@Override
	public int classSubDelete(String cla_num) {
		return sqlSession.delete(NS+"classSubDelete",cla_num);
	}
	
	@Override
	public int classDelete(String cla_num) {
		return sqlSession.delete(NS+"classDelete",cla_num);
	}
	
	@Override
	public int classVoteDelete(String cla_num) {
		return sqlSession.delete(NS+"classVoteDelete",cla_num);
	}
	
}
