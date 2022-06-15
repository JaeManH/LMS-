//package com.min;
//
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import com.min.dao.IMemberDao;
//import com.min.vo.MemberVo;
//import com.min.vo.RowNumVo;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@WebAppConfiguration
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
//public class MemberTest {
//
//	@Autowired
//	private SqlSessionTemplate sqlSession;
//
//	@Autowired
//	private IMemberDao mDao;
//
//
//	//@Test
//		//1)일반회원 로그인(아이디,비밀번호,사용여부N)
//		public void loginTra() {
//			Map<String, Object> map = new HashMap<String, Object>();
//			log.info("＃＃＃＃＃＃＃＃＃ DEMOMEMBER_TEST_01 loginMember Test 실행 ＃＃＃＃＃＃＃＃＃");
//			map.put("id", "admin");
//			map.put("pw", "1234");
//			MemberVo loginVo = mDao.loginTra(map);
//			log.info("＃＃＃＃＃＃＃＃＃ DEMOMEMBER_TEST_01 loginMember Test  "
//					+ "로그인한 회원 정보 :"
//					+ " {} ＃＃＃＃＃＃＃＃＃", loginVo);
//			System.out.println("로그인한 회원정보 : "+loginVo);
//		}
//
//	//@Test
//		//2)일반회원 회원가입
//	    public void traSignUp() {
//		log.info("MemberTest traSignUp");
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("id","test03");
//		map.put("pw","1234");
//		map.put("name","test");
//		map.put("email","test@naver.com");
//		map.put("phone","test");
//		map.put("birth","test");
//		map.put("profile","test");
//		int n = mDao.traSignUp(map);
//		log.info("＃＃＃＃＃＃＃＃＃ DEMOMEMBER_TEST_01 traSigntra Test  "
//				+ "회원가입 성공 :"
//				+ " {} ＃＃＃＃＃＃＃＃＃", n);
//	}
//
//	//@Test
//	//1)일반회원 로그인(아이디,비밀번호,사용여부N)
//	public void loginIns() {
//		Map<String, Object> map = new HashMap<String, Object>();
//		log.info("＃＃＃＃＃＃＃＃＃ DEMOMEMBER_TEST_01 loginMember Test 실행 ＃＃＃＃＃＃＃＃＃");
//		map.put("id", "testIns01");
//		map.put("pw", "1234");
//		MemberVo loginVo = mDao.loginIns(map);
//		log.info("＃＃＃＃＃＃＃＃＃ DEMOMEMBER_TEST_01 loginMember Test  "
//				+ "로그인한 회원 정보 :"
//				+ " {} ＃＃＃＃＃＃＃＃＃", loginVo);
//		System.out.println("로그인한 회원정보 : "+loginVo);
//	}
//
////@Test
//	//2)일반회원 회원가입
//    public void InsSignUp() {
//	log.info("MemberTest traSignUp");
//	Map<String, Object> map = new HashMap<String, Object>();
//	map.put("id","testIns01");
//	map.put("pw","1234");
//	map.put("name","강사");
//	map.put("email","test@naver.com");
//	map.put("phone","test");
//	map.put("birth","test");
//	map.put("profile","test");
//	map.put("banknum","0444-444-444");
//	map.put("bank", "우리");
//	int n = mDao.InsSignUp(map);
//	log.info("＃＃＃＃＃＃＃＃＃ DEMOMEMBER_TEST_01 traSigntra Test  "
//			+ "회원가입 성공 :"
//			+ " {} ＃＃＃＃＃＃＃＃＃", n);
//}
//
//	//@Test
//	//15) 일반회원 페이징
//	public void TraPaging() {
//		log.info("TraPaging");
//		RowNumVo vo = new RowNumVo();
//		List<MemberVo> lists = mDao.adminUserListRow(vo);
//		System.out.println(lists);
//	}
//
//
//	//@Test
//	//3) 회원가입
//	public void signupMember() {
//		log.info("MemberTest insertMemberTest");
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("id","GD300");
//		map.put("pw","1234");
////		int n = mDao.signupMember(map);
////		System.out.println("회원가입된 회원 : "+n);
//	}
//	@Test
//	public void CheckTraId() {
//		log.info("MemberTest CheckTraId");
//		String id = "admin";
//		Map<String, Object> map = new HashMap<String, Object>();
//		int n = mDao.checkTraId(id);
//		System.out.println("회원가입된 회원 : "+n);
//	}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//}
