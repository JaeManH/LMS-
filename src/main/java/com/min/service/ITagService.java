package com.min.service;

import org.json.simple.parser.ParseException;

import java.util.List;
import java.util.Map;

public interface ITagService {
    public int insertTagNew(List<String> addTags);
    public List<String> insertClassTag(List<String> sub_num) throws ParseException;

    public String selectTagJson(String name);

    public String selectTagAll();
    public int updateTag(Map<String, Object> map);

    public String selectSubjectTag(String id);

    public String selectTagSubjectCode(String code);

}
