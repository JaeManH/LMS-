package com.min.dao;

import java.util.List;
import java.util.Map;

import com.min.vo.TagVo;

public interface ITagDao {

	public List<TagVo> selectTagClassAndSubject();
	public String selectTagAll();
	public int updateTag(Map<String, Object> map);
	public int insertTagNew(String tag);
	public String selectSubjectTag(String sub_num);
	public String selectTagJson(String name);

	public String selectTagSubjectCode(String code);

	public List<String> selectTagClassSubject(String cla_num);
	
}
