package com.min.service;

import java.util.List;
import java.util.Map;

import com.min.vo.CareerVo;
import com.min.vo.MemberVo;
import com.min.vo.RowNumVo;


public interface IMemberService{

	//*********관리자 **********
		//관리자 회원 탈퇴 승인
		public int adminDelTra(Map<String, Object> map);
		
		
		//*********일반회원 **********
		//시큐리티 일반회원 로그인
		public MemberVo loginTra(Map<String, Object> map);
		//일반회원 회원가입
		public int traSignUp(Map<String, Object> map);
		//일반회원 아이디 찾기
		public MemberVo findTraId(Map<String, Object> map);
		//일반회원 탈퇴 신청
		public int delTra(Map<String, Object> map);
		//일반회원 개인정보 수정
		public int updateTra(Map<String, Object> map);
		//일반회원 프로필 수정
		public int updateProfile(Map<String, Object> map);
		//일반회원 아이디 중복 체크
		public int checkTraId(String id);
		
		//*********강사 **********
		//시큐리티 강사 로그인
		public MemberVo loginIns(Map<String, Object> map);
		//강사 로그인 시 경력 
		public CareerVo loginCar(Map<String, Object> map);
		//강사 회원가입
		public int InsSignUp(Map<String, Object> map);
		//강사 아이디 찾기
		public MemberVo findInsId(Map<String, Object> map);
		//강사 탈퇴 신청
		public int delIns(Map<String, Object> map);
		//강사 개인정보 수정
		public int updateIns(Map<String, Object> map);
		//강사 아이디 중복 체크
		public int checkInsId(String id);
		//강사  회원가입시 경력 자동 등록
		public int insertCar(Map<String, Object> map);
		//강사 경력 등록
		public int updateCar(Map<String, Object> map);
		
		
		//페이징처리
		public List<MemberVo> adminUserListRow(RowNumVo rvo);
		public int adminUserListTotal();
		
}
