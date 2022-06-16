package com.min.daoImpl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.min.dao.IMemberDao;
import com.min.vo.CareerVo;
import com.min.vo.MemberVo;
import com.min.vo.RowNumVo;


@Repository
public class MemberDaoImpl implements IMemberDao{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String NS = "com.min.daoImpl.MemberDaoImpl.";

	@Autowired
	private PasswordEncoder passwordEncoder;


	@Override
	public MemberVo loginTra(Map<String, Object> map) {
		return  sqlSession.selectOne(NS+"loginTra",map);
	}

	@Override
	public int traSignUp(Map<String, Object> map) {
		String enPassword = passwordEncoder.encode((String)map.get("pw"));
		map.put("pw", enPassword);
			
		return sqlSession.insert(NS+"traSignUp",map);
	}

	@Override
	public MemberVo loginIns(Map<String, Object> map) {
		return sqlSession.selectOne(NS+"loginIns",map);
	}

	@Override
	public int InsSignUp(Map<String, Object> map) {
		return sqlSession.insert(NS+"InsSignUp",map);
	}

	@Override
	public List<MemberVo> adminUserListRow(RowNumVo rvo) {
		return sqlSession.selectList(NS+"adminUserListRow",rvo);
	}

	@Override
	public int adminUserListTotal() {
		return sqlSession.selectOne(NS+"adminUserListTotal");
	}

	@Override
	public int adminDelTra(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.update(NS+"adminDelTra",map);
	}

	@Override
	public MemberVo findTraId(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+"findTraId",map);
	}

	@Override
	public int delTra(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.update(NS+"delTra",map);
	}

	@Override
	public int updateTra(Map<String, Object> map) {
		String enPassword = passwordEncoder.encode((String)map.get("pw"));
		map.put("pw", enPassword);
		return sqlSession.update(NS+"updateTra",map);
	}

	@Override
	public MemberVo findInsId(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+"findInsId",map);
	}

	@Override
	public int delIns(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.update(NS+"delIns",map);
	}

	@Override
	public int updateIns(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.update(NS+"updateIns",map);
	}

	@Override
	public int updateProfile(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.update(NS+"updateProfile",map);
	}
    //회원 아이디 중복
	@Override
	public int checkTraId(String id) {
		
			return sqlSession.selectOne(NS+"checkTraId",id);
	}
	//강사 아이디 중복 
	@Override
	public int checkInsId(String id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+"checkInsId",id);
	}

	@Override
	public int insertCar(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.insert(NS+"insertCar",map);
	}

	@Override
	public int insCarUpdate(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.update(NS+"insCarUpdate",map);
	}

	//강사 경력 등록 후 회원상태변경
	@Override
	public int updateCar(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.update(NS+"updateCar",map);
	}

	@Override
	public int updateCarDelflag(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.update(NS+"updateCarDelflag",map);
	}

	@Override
	public CareerVo loginCar(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+"LoginCar",map);
	}

}
