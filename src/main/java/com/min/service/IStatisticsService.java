package com.min.service;

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

}
