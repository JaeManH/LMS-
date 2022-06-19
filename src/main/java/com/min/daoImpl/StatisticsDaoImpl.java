package com.min.daoImpl;

import com.min.vo.ClassVo;
import com.min.vo.SubjectVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.dao.IStatisticsDao;

import java.util.List;
import java.util.Map;

@Repository
public class StatisticsDaoImpl implements IStatisticsDao {

    private final String NS = "com.min.StatisticsDaoImpl.";
    @Autowired
    private SqlSessionTemplate session;

    @Override
    public String selectSubjectCode() {
        return session.selectOne(NS + "selectSubjectCode");
    }

    @Override
    public int updatePrefer(Map<String, Object> map) {
        return session.update(NS + "updatePrefer", map);
    }

    @Override
    public String selectPreferW(String id) {
        return session.selectOne(NS+"selectPreferW",id);
    }

    @Override
    public List<String> selectPreferAll() {
        return session.selectList(NS+"selectPreferAll");
    }

    @Override
    public int updateUserLike(Map<String, Object> map) {
        return session.update(NS+"updateUserLike",map);
    }

    @Override
    public int updateClassLike(Map<String, Object> map) {
        return session.update(NS+"updateClassLike",map);
    }

    @Override
    public String selectUserLike(String id) {
        return session.selectOne(NS+"selectUserLike",id);
    }

    @Override
    public String selectClassLike(String num) {
        return session.selectOne(NS+"selectClassLike",num);
    }

    @Override
    public List<ClassVo> selectClassList(List<String> id) {
        return session.selectList(NS+"selectClassList",id);
    }

    @Override
    public List<SubjectVo> selectSubjectList(List<String> id) {
        return session.selectList(NS+"selectSubjectList",id);
    }

    @Override
    public String selectSubjectScore(String id) {
        return session.selectOne(NS+"selectSubjectScore",id);
    }

    @Override
    public int updateSubjectScore(Map<String, Object> map) {
        return session.update(NS+"updateSubjectScore",map);
    }

    @Override
    public String selectSubjectTitle(String id) {
        return session.selectOne(NS+"selectSubjectTitle",id);
    }

    @Override
    public List<String> selectSubejctToCode(String cla_num) {
        return session.selectList(NS+"selectSubejctToCode",cla_num);
    }

    @Override
    public List<ClassVo> selectClassIN(List<String> list) {
        return session.selectList(NS+"selectClassIN",list);
    }
}

