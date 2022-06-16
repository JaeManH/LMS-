package com.min.daoImpl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.dao.ITagDao;
import com.min.vo.TagVo;

@Repository
public class TagDaoImpl implements ITagDao {

	@Autowired 
	private SqlSessionTemplate session; 
	private final String NS = "com.min.daoImpl.TagDaoImpl.";
	
	@Override
	public List<TagVo> selectTagClassAndSubject() {
		return session.selectList(NS+"selectTagClassAndSubject");
	}

	@Override
	public String selectTagAll() {
		return session.selectOne(NS+"selectTagAll");
	}

	@Override
	public int updateTag(Map<String, Object> map) {
		return session.update(NS+"updateTag",map);
	}

	@Override
	public int insertTagNew(String tag) {
		return session.insert(NS+"insertTagNew",tag);
	}

	@Override
	public String selectSubjectTag(String sub_num) {
		return session.selectOne(NS+"selectSubjectTag",sub_num);
	}

	@Override
	public String selectTagJson(String name) {
		return session.selectOne(NS+"selectTagJson",name);
	}

	@Override
	public String selectTagSubjectCode(String code) {
		return session.selectOne(NS+"selectTagSubjectCode",code);
	}

	@Override
	public List<String> selectTagClassSubject(String cla_num) {
		return session.selectList(NS+"selectTagClassSubject",cla_num);
	}
}
