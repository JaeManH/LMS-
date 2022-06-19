package com.min.serviceImpl;

import com.min.dao.IStatisticsDao;
import com.min.service.IStatisticsService;
import com.min.vo.ClassVo;
import com.min.vo.SubjectVo;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StatisticsServiceImpl implements IStatisticsService {

    private final Logger logger = LoggerFactory.getLogger(StatisticsServiceImpl.class);
    @Autowired
    private IStatisticsDao dao ;

    /**
     * 과목코드를 조회하는 메소드 과목 입력시 자동완성을 위해 사용됨
     * @return 과목코드 JSON_ARRAY
     */
    @Override
    public String selectSubjectCode() {
        logger.info("STAT_001_HJM StatisticsServiceImpl selectSubjectCode");
        return dao.selectSubjectCode();
    }


    /**
     * 사용자의 선호를 업데이트 하는 메소드
     * @param map "id":사용자 아이디  "prefer": 선호도 json 타입
     * @return
     */
    @Override
    public int updatePrefer(Map<String, Object> map) {
        logger.info("STAT_001_HJM StatisticsServiceImpl updatePrefer {}",map);
        return dao.updatePrefer(map);
    }

    /**
     * @param userId 유저 id
     * @param num class의 id
     * @return 좋아요가 추가될 시 1을 반환 삭제될 시 0이 반환
     * @throws ParseException
     */
    @Override
    public int updateLike(String userId, String num) throws ParseException {
        logger.info("STAT002_HJM StatisticsServiceImpl updateLike 실행");
        int result = 0;
        String myLike = dao.selectUserLike(userId);
        String classLike = dao.selectClassLike(num);
        JSONArray myArr;
        JSONArray classArr;
        JSONParser parser = new JSONParser();
        //유저의 과정 좋아요 리스트
        if(myLike!=null){
            myArr = (JSONArray) parser.parse(myLike);
        }else{
            myArr = new JSONArray();
        }

        //과정에 좋아요 누른 유저 리스트
        if(classLike!=null){
            classArr = (JSONArray)parser.parse(classLike);
        }else{
            classArr = new JSONArray();
        }

        if(myArr.contains(num)){
            myArr.remove(num);
            classArr.remove(userId);
        }else{
            myArr.add(num);
            classArr.add(userId);
            result = 1;
        }
        Map<String,Object> userMap = new HashMap<String,Object>();
        userMap.put("like",myArr.toJSONString());
        userMap.put("id",userId);

        Map<String,Object> classMap = new HashMap<String,Object>();
        classMap.put("like",classArr.toJSONString());
        classMap.put("num",num);

        dao.updateClassLike(classMap);
        dao.updateUserLike(userMap);
        return classArr.size();
    }

    /**
     * 특정 유저의 아이디를 검색해 좋아요 리스트를 JSON형식으로 가져온다.
     * @param id
     * @return
     */
    public String selectUserLike(String id){
        logger.info("STAT002_HJM StatisticsServiceImpl selectUserLike 실행");
        return dao.selectUserLike(id);
    }

    /**
     * IN절을 통해 원하는 클래스들을 조회한다.
     * @param id
     * @return
     */
    @Override
    public List<ClassVo> selectClassList(List<String> id) {
        logger.info("STAT002_HJM StatisticsServiceImpl selectClassList 실행 {]",id);
        return dao.selectClassList(id);
    }

    /**
     * IN절을 통해 과목 리스트를 조회한다.
     * @param id
     * @return
     */
    @Override
    public List<SubjectVo> selectSubjectList(List<String> id) {
        logger.info("STAT002_HJM StatisticsServiceImpl selectSubjectList 실행 {]",id);
        return dao.selectSubjectList(id);
    }

    /**
     * 과목의 평점을 조회한다.
     * @param id
     * @return
     */
    @Override
    public String selectSubjectScore(String id) {
        return dao.selectSubjectScore(id);
    }

    /**
     * 과목의 평점을 업데이트 한다.
     * @param map
     * @return
     */
    @Override
    public int updateSubjectScore(Map<String, Object> map) {
        return dao.updateSubjectScore(map);
    }

    @Override
    public String selectSubjectTitle(String id) {
        return dao.selectSubjectTitle(id);
    }

    @Override
    public void scoreCron() {

    }

    @Override
    public List<String> selectSubejctToCode(String cla_num) {
        return dao.selectSubejctToCode(cla_num);
    }

    @Override
    public List<ClassVo> selectClassIN(List<String> list) {
        return dao.selectClassIN(list);
    }
}
