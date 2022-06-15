package com.min.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.min.dao.IClassDao;
import com.min.service.IClassService;
import com.min.vo.ClassPeopleVo;
import com.min.vo.ClassSubjectVo;
import com.min.vo.ClassVo;
import com.min.vo.InstructorVo;
import com.min.vo.SubjectVo;
import com.min.vo.VoteVo;

@Service
@Transactional
public class ClassServiceImpl implements IClassService {
	
	@Autowired
	private IClassDao dao;
	
	@Override
	public List<ClassVo> classSelectAll() {
		return dao.classSelectAll();
	}

	@Override
	public List<ClassVo> classSelected() {
		return dao.classSelected();
	}
	
	@Override
	public ClassVo classSelectDetail(String vo) {
		return dao.classSelectDetail(vo);
	}
	
	@Override
	public List<SubjectVo> classSelectedSub(String cla_num) {
		return dao.classSelectedSub(cla_num);
	}
	
	@Override
	public int classFormInsert(Map<String, Object> vo) {
		return dao.classFormInsert(vo);
	}

	@Override
	public int classSubjectInsert(Map<String, Object> vo) {
		return dao.classSubjectInsert(vo);
	}
	
	@Override
	public int classUpdate(Map<String, Object> vo) {
		return dao.classUpdate(vo);
	}
	
	@Override
	public int classTimeUpdate() {
		return dao.classTimeUpdate();
	}
	
	@Override
	public List<VoteVo> classTimeSearch(ClassVo vo) {
		return dao.classTimeSearch(vo);
	}
	
	@Override
	public int voteBoxInsert(Map<String, Object> map) {
		return dao.voteBoxInsert(map);
	}
	
	@Override
	public int updateVote(Map<String, Object> map) {
		return dao.updateVote(map);
	}
	
	@Override
	public List<InstructorVo> classInsInfo(String id) {
		return dao.classInsInfo(id);
	}
	
	@Override
	public List<VoteVo> voteRatio(VoteVo vo) {
		return dao.voteRatio(vo);
	}
	
	@Override
	public VoteVo voteIns(VoteVo vo) {
		return dao.voteIns(vo);
	}
	
	@Override
	public List<VoteVo> votedPeople(VoteVo vo) {
		return dao.votedPeople(vo);
	}
	
	
	@Override
	public int classStatusUpdate(Map<String, Object> map) {
		return dao.classStatusUpdate(map);
	}
	
	@Override
	public int voteDelete(Map<String, Object> map) {
		return dao.voteDelete(map);
	}
	
	@Override
	public int votedInsert(Map<String, Object> map) {
		return dao.votedInsert(map);
	}
	
	@Override
	public int classPeoInsert(Map<String, Object> map) {
		return dao.classPeoInsert(map);
	}
	
	
	@Override
	public int classPeoSelectAll(ClassPeopleVo vo) {
		return dao.classPeoSelectAll(vo);
	}
	
	@Override
	public List<String> classVotedSelectAll(ClassPeopleVo vo) {
		return dao.classVotedSelectAll(vo);
	}
	// 크론처리
	@Override
	public int classStatusChange() {
		int i = dao.endRecruit();
		int j = dao.endVote();
		int n = dao.classStart();
		int m = dao.classEnd();
		return (i>0||j>0||n>0||m>0)? 1:0;
	}
	
	@Override
	public List<SubjectVo> subjectSelected() {
		return dao.subjectSelected();
	}

	@Override
	public ClassVo classSelectLastInsert() {
		return dao.classSelectLastInsert();
	}
	

//	@Override
//	public int classPeoDelete(String cla_num) {
//		return dao.classPeoDelete(cla_num);
//	}
//	
//	@Override
//	public int classSubDelete(String cla_num) {
//		return dao.classSubDelete(cla_num);
//	}
//	
//	@Override
//	public int classDelete(String cla_num) {
//		return dao.classDelete(cla_num);
//	}
//	
//	@Override
//	public int classVoteDelete(String cla_num) {
//		return dao.classVoteDelete(cla_num);
//	}
	@Override
	public int classAllDelete(String cla_num) {
		int n = dao.classPeoDelete(cla_num);
		int m = dao.classSubDelete(cla_num);
		int u = dao.classVoteDelete(cla_num);
		int i = dao.classDelete(cla_num);
		return (n>0||m>0||u>0||i>0)? 1:0;
	}
	
	
}
