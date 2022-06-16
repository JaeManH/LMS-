//package com.min;
//
//import static org.junit.Assert.*;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.min.dao.SubjectDao;
//import com.min.vo.SubjectVo;
//
//import lombok.extern.slf4j.Slf4j;
//
//
//
//@Slf4j
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/*.xml"})
//public class Subject_test {
//
//	@Autowired
//	private SubjectDao sDao;
//
//	private Logger logger = LoggerFactory.getLogger(Subject_test.class);
//
////	@Test
//	public void test() {
//		logger.info("Subject_test JUnit Test 실행");
//	}
//
////	@Test
//	public void test2() {
//		log.info("Subject_test JUnit Test 실행");
//	}
//
//	//1) 과목 등록 (과목정보 입력 - 등록자 입력 - 커리큘럼 입력 - 강사 업데이트)
////	@Test
//	public void subInsertSubjectTest() {
//		log.info("subInsertSubject JUnit Test 실행");
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("sub_title", "0602subInsertSubject/sub_title JUnit Test");
//		map.put("sub_content", "0602subInsertSubject/sub_content JUnit Test");
//		map.put("sub_cod_code", "SUB101");
//		map.put("sub_reg_id", "ssoff23247");
//
////		int result = sDao.subInsertSubject(map);
////		log.info("---------- JUnit Test/Subject_test/subInsertSubject ----------");
////		log.info("---------- subInsertSubject 입력된 과목 수 : "+result+" ----------");
////		System.out.println(result);
////
////		log.info("subInsertRegister JUnit Test 실행");
////		Map<String, Object> map2 = new HashMap<String, Object>();
////		map2.put("reg_auth", "ROLE_INSTRUCTOR");
////		map2.put("reg_id", "ssoff23247");
////
////		int result2 = sDao.subInsertRegister(map2);
////		log.info("---------- JUnit Test/Subject_test/subInsertRegister ----------");
////		log.info("---------- subInsertRegister 입력된 등록자 수 : "+result2+" ----------");
////		System.out.println(result2);
//
//		log.info("subInsertCurriculum JUnit Test 실행");
//		Map<String, Object> map3 = new HashMap<String, Object>();
//		map3.put("cur_detail", "0602subInsertSubject/cur_detail JUnit Test");
//		map3.put("cur_subcontent", "0602subInsertSubject/cur_subcontent JUnit Test");
//		map3.put("cur_version", "cur_version");
//		map3.put("cur_time", "cur_time");
//		map3.put("cur_level", "cur_level");
//		map3.put("cur_file", "cur_file");
//
////		int result3 = sDao.subInsertCurriculum(map3);
////		log.info("---------- JUnit Test/Subject_test/subInsertCurriculum ----------");
////		log.info("---------- subInsertCurriculum 입력된 커리큘럼 수 : "+result3+" ----------");
////		System.out.println(result3);
////
////		log.info("subInsertCurriculum JUnit Test 실행");
////		Map<String, Object> map4 = new HashMap<String, Object>();
////		map4.put("reg_auth", "ROLE_INSTRUCTOR");
////		map4.put("sub_reg_id", "ssoff23247");
////
////		int result4 = sDao.subUpdateInstructor(map4);
////		log.info("---------- JUnit Test/Subject_test/subUpdateInstructor ----------");
////		log.info("---------- subUpdateInstructor 입력된 담당강사 수 : "+result4+" ----------");
////		System.out.println(result4);
//	}
//
////	@Test
////	public void subInsertRegister() {
////
////		log.info("subInsertRegister JUnit Test 실행");
////		Map<String, Object> map = new HashMap<String, Object>();
////		map.put("reg_auth", "ROLE_INSTRUCTOR");
////		map.put("reg_id", "ssoff23247");
////
////		int result = sDao.subInsertRegister(map);
////		log.info("---------- JUnit Test/Subject_test/subInsertRegister ----------");
////		log.info("---------- subInsertRegister 입력된 등록자 수 : "+result+" ----------");
////		System.out.println(result);
////
////	}
//
////	@Test
////	public void subInsertCurriculum() {
////		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
////		definition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
////		TransactionStatus status = txManager.getTransaction(definition);
////
////		log.info("subInsertCurriculum JUnit Test 실행");
////		Map<String, Object> map = new HashMap<String, Object>();
////		map.put("cur_detail", "0602subInsertSubject/cur_detail JUnit Test");
////		map.put("cur_subcontent", "0602subInsertSubject/cur_subcontent JUnit Test");
////		map.put("cur_version", "cur_version");
////		map.put("cur_time", "cur_time");
////		map.put("cur_level", "cur_level");
////		map.put("cur_file", "cur_file");
////
////		int result = sDao.subInsertCurriculum(map);
////		log.info("---------- JUnit Test/Subject_test/subInsertCurriculum ----------");
////		log.info("---------- subInsertCurriculum 입력된 커리큘럼 수 : "+result+" ----------");
////		System.out.println(result);
////
////		txManager.commit(status);
////	}
//
////	@Test
////	public void subUpdateInstructor() {
////		log.info("subInsertCurriculum JUnit Test 실행");
////		Map<String, Object> map = new HashMap<String, Object>();
////		map.put("reg_auth", "ROLE_INSTRUCTOR");
////		map.put("sub_reg_id", "ssoff23247");
////
////		int result = sDao.subUpdateInstructor(map);
////		log.info("---------- JUnit Test/Subject_test/subUpdateInstructor ----------");
////		log.info("---------- subUpdateInstructor 입력된 담당강사 수 : "+result+" ----------");
////		System.out.println(result);
////	}
//	//1-5) 과목 등록시 관리자 승인상태 변경
////	@Test
//	public void subUpdateStatusATest() {
//		log.info("subUpdateStatusA JUnit Test 실행");
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("sub_num", "20220602SUB174");
//
////		int result = sDao.subUpdateStatusA(map);
//		log.info("---------- JUnit Test/Subject_test/subUpdateStatusATest ----------");
////		log.info("---------- subUpdateStatusATest 과목상태 변경된 과목의 수 : "+result+" ----------");
////		System.out.println(result);
//	}
//	//2-1) 관리자의 과목 전체 목록 조회
////	@Test
//	public void subSelectAllAdminTest() {
//		log.info("subSelectAllAdmin JUnit Test 실행");
////		List<SubjectVo> lists = sDao.subSelectAllAdmin();
//		log.info("---------- JUnit Test/Subject_test/subSelectAllAdminTest ----------"
//				+ "과목 전체 리스트 :"
//				+ " {} " /*, lists*/);
////		System.out.println("과목 게시글 조회 : "+lists);
//	}
//	//2-2) 관리자의 과목 상세 조회
////	@Test
//	public void adminSubjectDetail() {
//		log.info("comSubjectDetail JUnit Test 실행");
//		String sub_num = "20220602SUB174";
//		SubjectVo sVo =  sDao.adminSubjectDetail(sub_num);
//		System.out.println(sVo);
//	}
//	//2-3) 일반회원의 과목 전체 목록 조회
////	@Test
////	public void subSelectAllUserTest() {
////		log.info("subSelectAllUser JUnit Test 실행");
////		MemberVo mVo = new MemberVo();
////		mVo.setId("DEMO01");
////		List<SubjectVo> lists = sDao.subSelectAllAdmin(mVo);
////		log.info("---------- JUnit Test/Subject_test/subSelectAllUserTest ----------"
////				+ "과목 전체 리스트 :"
////				+ " {} ", lists);
////		System.out.println("과목 게시글 조회 : "+lists);
////	}
//	//2-4) 일반회원의 과목 상세 조회
////	@Test
////	public void comSubjectDetailTest() {
////		log.info("comSubjectDetail JUnit Test 실행");
////		String sub_num = "20220602SUB174";
////		SubjectVo sVo =  sDao.comSubjectDetail(sub_num);
////		System.out.println(sVo);
////	}
//
//
//}
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
//
