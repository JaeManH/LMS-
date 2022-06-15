package com.min.serviceImpl;

import com.min.dao.ITagDao;
import com.min.service.ITagService;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ITagServiceImpl implements ITagService {

    private final Logger logger = LoggerFactory.getLogger(ITagServiceImpl.class);

    @Autowired
    private ITagDao dao;

    @Transactional
    @Override
    public int insertTagNew(List<String> addTags) {
        int cnt = 0;
        for (int i = 0; i < addTags.size(); i++) {
            dao.insertTagNew(addTags.get(i));
            cnt++;
        }
        return cnt;
    }

    @Transactional
    @Override
    public List<String> insertClassTag(List<String> sub_num) throws ParseException {
        List<String> list = new ArrayList<String>();
        JSONParser parser = new JSONParser();
        Map<String, Object> map = new HashMap<String,Object>();
        for (int i = 0; i < sub_num.size(); i++) {
            String tags = dao.selectSubjectTag(sub_num.get(i));
            JSONArray arr = (JSONArray) parser.parse(tags);
                map.put("id", sub_num.get(i));
            for (int j = 0; j < arr.size(); j++) {
                map.put("name",arr.get(j));
                dao.updateTag(map);
            }


        }
        return null;
    }

    @Override
    public String selectTagJson(String name) {
        return dao.selectTagJson(name);
    }

    @Override
    public String selectTagAll() {
        return dao.selectTagAll();
    }
    @Override
    public int updateTag(Map<String, Object> map) {

        return dao.updateTag(map);
    }

    @Override
    public String selectSubjectTag(String id) {
        return dao.selectSubjectTag(id);
    }

    @Override
    public String selectTagSubjectCode(String code) {
        return dao.selectTagSubjectCode(code);
    }

    @Override
    public List<String> selectTagClassSubject(String cla_num) {
        return dao.selectTagClassSubject(cla_num);
    }
}
