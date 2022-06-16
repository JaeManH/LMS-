//package com.min;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.min.service.IStatisticsService;
//import com.min.service.ITagService;
//import com.min.vo.ClassVo;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.min.dao.IStatisticsDao;
//import com.min.dao.ITagDao;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@EnableWebSecurity
//@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/*.xml"})
//public class Statistics_Test {
//
//    @Autowired
//    private ITagDao tDao;
//    @Autowired
//    private IStatisticsDao sDao;
//    @Autowired
//    private ITagService tagService;
//    @Autowired
//    private IStatisticsService statisticsService;


//    @Test
//    public void selectTagTest() throws ParseException {
//        //새로운 태그 추가하는 곳
//        logger.info("selectTagTest 실행");
//        List<TagVo> lists = tDao.selectTagClassAndSubject();
//        String temp;
//
//        Pattern p = Pattern.compile("#([a-zA-Z0-9가-힣]*)");
//        JSONParser parser = new JSONParser();
//        JSONArray tags = new JSONArray();
//        JSONArray arr = new JSONArray();
//        List<String> addTags = new ArrayList<String>();
//        List<String> insertTags = new ArrayList<String>();
//        for (TagVo vo : lists) {
//            if (vo.getTag() != null) {
//                arr = (JSONArray) parser.parse(vo.getTag().toString());
//            }else{
//                continue;
//            }
//            //TODO 태그 추가하기
//            for (int i = 0; i < arr.size(); i++) {
//                Matcher m = p.matcher(arr.get(i).toString());
//                while (m.find()) {
//                    temp = m.group().replace(" ", "_").replace("#", "").toString().toLowerCase();
//                    //만약에 기존 태그중에 없으면 새로운 태그 추가
//                    if (!tags.contains(temp) && !addTags.contains(temp)) {
//                        addTags.add(temp);
//                    }
//                }
//            }
//        }
//        int result = tagService.insertTagNew(addTags);
//        System.out.println(result);
//        logger.info(addTags.toString());
//    }

//    @Test
//    public void likeTest() throws ParseException {
//        int result = statisticsService.updateLike("ghkdwoaks1234","CLA001");
//        System.out.println(result);
//    }
//    @Test
//    public  void likeListTest(){
//        List<String> lists = new ArrayList<String>();
//        lists.add("CLA001");
//        lists.add("CLA002");
//        lists.add("CLA004");
//        lists.add("CLA007");
//        lists.add("CLA008");
//        List<ClassVo> voList = sDao.selectClassList(lists);
//        System.out.println(voList.toString());
//
//    }
//
//}
