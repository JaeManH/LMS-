package com.min.ctrl;

import com.min.service.IStatisticsService;
import com.min.service.ITagService;
import com.min.vo.ClassVo;
import com.min.vo.SubjectVo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Controller
public class TagController {

    private static final Logger logger = LoggerFactory.getLogger(TagController.class);

    @Autowired
    private ITagService tagService;

    @Autowired
    private IStatisticsService statisticsService;

    public static final Pattern TAG_REGEX = Pattern.compile("#([a-zA-Z0-9가-힣]*)");

    @RequestMapping(value = "*/tag.do", method = RequestMethod.GET)
    public String tagPage(String tag) {

        return "tag";
    }


    @RequestMapping(value = "*/getTags.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getTags() {
        String tags = tagService.selectTagAll();
        return tags;

        
    }

    @RequestMapping(value = "*/searchTag.do", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String searchTag(String tag, String category) throws ParseException {
        JSONParser parser = new JSONParser();
        logger.info("searchTag tag: {} category: {}", tag, category);
        String ids = tagService.selectTagJson(tag);
        logger.info("ids: {}", ids);
        JSONObject jsonObject = (JSONObject) parser.parse(ids);
        List<String> searchList = new ArrayList<String>();
        List<ClassVo> classVoList = new ArrayList<ClassVo>();
        List<SubjectVo> subjectVoList = new ArrayList<SubjectVo>();
        JSONArray temp;

        //TODO 과목 상세보기가 완료되면 주소를 매핑해주기
        //카테고리에 따라 검색 결과 나눠주기
        if (category.equals("과정")) {
            temp = (JSONArray) jsonObject.get("class");
            for (int i = 0; i < temp.size(); i++) {
                searchList.add(temp.get(i).toString());
            }
            temp.clear();
            classVoList = statisticsService.selectClassList(searchList);
            for (ClassVo vo : classVoList) {
                jsonObject = new JSONObject();
                jsonObject.put("title",vo.getCla_title());
                jsonObject.put("num",vo.getCla_num());
                jsonObject.put("price",vo.getCla_price());
                jsonObject.put("content",vo.getCla_content());
                jsonObject.put("regdate",vo.getCla_regdate());
                temp.add(jsonObject);
            }
            return temp.toJSONString();
        } else {
            temp = (JSONArray) jsonObject.get("subject");
            for (int i = 0; i < temp.size(); i++) {
                searchList.add(temp.get(i).toString());
            }
            temp.clear();
            subjectVoList = statisticsService.selectSubjectList(searchList);
            System.out.println("subjectVoList: "+subjectVoList);
            for (SubjectVo vo : subjectVoList) {
                jsonObject = new JSONObject();
                jsonObject.put("title", vo.getSub_title());
                jsonObject.put("num", vo.getSub_num());
                jsonObject.put("ins", vo.getSub_ins());
                jsonObject.put("content", vo.getSub_content());
                jsonObject.put("regdate", vo.getSub_regdate());
                temp.add(jsonObject);
            }
            return temp.toJSONString();
        }
    }

}
