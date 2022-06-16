package com.min.service;

import com.min.vo.ClassVo;
import com.min.vo.SubjectVo;
import org.json.simple.parser.ParseException;

import java.util.List;
import java.util.Map;

public interface IStatisticsService {
    //자동완성을 위한 과목코드 가져오는 쿼리
    public String selectSubjectCode();

    //회원의 선호조사 또는 추천 결과를 업데이트 하는 쿼리
    public int updatePrefer(Map<String, Object> map);

   //좋아요 클릭 시 업데이트
    public int updateLike(String id , String num) throws ParseException;

    public List<ClassVo> selectClassList(List<String> id);

    public List<SubjectVo> selectSubjectList(List<String> id);

    public String selectSubjectScore(String id);

    public int updateSubjectScore(Map<String,Object> map);

    public String selectSubjectTitle(String id);

    public void scoreCron();

}
