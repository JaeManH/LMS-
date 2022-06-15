package com.min.service;

import java.util.List;
import java.util.Map;

import com.min.vo.ClassPeopleVo;
import com.min.vo.ClassSubjectVo;
import com.min.vo.ClassVo;
import com.min.vo.InstructorVo;
import com.min.vo.SubjectVo;
import com.min.vo.VoteVo;

public interface IClassService {
	// 과정 전체조회
	public List<ClassVo> classSelectAll();
	// 과정 구분조회
	public List<ClassVo> classSelected();
	// 과정 상세조회
	public ClassVo classSelectDetail(String vo);
	// 과정 상세조회 > 과목 리스트 조회
	public List<SubjectVo> classSelectedSub(String cla_num);
	// 과정 등록 폼 생성
	public int classFormInsert(Map<String, Object> vo);
	// 과정 과목리스트 생성
	public int classSubjectInsert(Map<String, Object> vo);
	// 과정 수정
	public int classUpdate(Map<String, Object> vo);
	// 과정 과목 리스트 총 시간 입력
	public int classTimeUpdate();
	// 과정 종료일 계산 필요 수
	public List<VoteVo> classTimeSearch(ClassVo vo);
	// 과정 과목 투표박스 생성
	public int voteBoxInsert(Map<String, Object> map);
	// 투표
	public int updateVote(Map<String, Object> map);
	// 과정 강사 정보 출력
	public List<InstructorVo> classInsInfo (String id);
	// 과정 강사 투표율
	public List<VoteVo> voteRatio(VoteVo vo);
	// 투표자 리스트 출력
	public VoteVo voteIns(VoteVo vo);
	
	// 해당 과정 투표자 전체 출력
	public List<VoteVo> votedPeople(VoteVo vo);
	// 투표 후 기존 과정 삭제
	public int voteDelete(Map<String, Object> map); 
	// 최종 뽑힌 강사의 과정 생성
	public int votedInsert(Map<String, Object> map);
	
	// 과정 상태변경
	public int classStatusUpdate(Map<String, Object> map);
	
	// 투표한 수강자 추가
	public int classPeoInsert(Map<String, Object> map);
	
	// 해당 과정 수강생과 강사 리스트
	public List<String> classVotedSelectAll(ClassPeopleVo vo);
	
	// 투표자 찾기
	public int classPeoSelectAll(ClassPeopleVo vo);
	// 과정 상태변경
	public int classStatusChange();
	
	// 과정 삭제
//	public int classPeoDelete(String cla_num);
//	public int classSubDelete(String cla_num);
//	public int classDelete(String cla_num);
//	public int classVoteDelete(String cla_num);
	public int classAllDelete(String cla_num);
	
	// 과목 리스트 뽑기(임시)
	public List<SubjectVo> subjectSelected();
	//최근에 등록된 과정 불러오기
	public ClassVo classSelectLastInsert();
	
	
	
	
}
