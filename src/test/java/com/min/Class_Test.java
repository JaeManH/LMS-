package com.min;


import static org.hamcrest.CoreMatchers.endsWith;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.min.dao.IClassBoardDao;
import com.min.dao.IClassDao;
import com.min.dao.PayDao;
import com.min.service.IClassService;
import com.min.service.IPayService;
import com.min.vo.ClassBoardVo;
import com.min.vo.ClassPeopleVo;
import com.min.vo.ClassVo;
import com.min.vo.InstructorVo;
import com.min.vo.SubjectVo;
import com.min.vo.VoteVo;

import lombok.EqualsAndHashCode.Include;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/*.xml"})
public class Class_Test {

	@Autowired
	private IClassDao dao;

	@Autowired
	private IClassBoardDao bDao;

	@Autowired
	private IClassService service;
	
	@Autowired
	private IPayService pService;
	
	@Autowired
	private PayDao pdao;
	
	@Test
	public void testService() throws ParseException {
		
		LocalDate now = LocalDate.now();
		System.out.println(now);
		
		Date format1 = new SimpleDateFormat("yyyy/MM/dd").parse("2022/06/15");
		Date format2 = java.sql.Date.valueOf(now);
		
	    long diffDays = ((format2.getTime() - format1.getTime()) / 1000) / (24*60*60);
		
	    System.out.println(diffDays);
		
		if(diffDays == 0 ) {
			add();
		}
		
	}
	public void add() {
	      Map<String, Object> map = new HashMap<String, Object>();
	      map.put("sal_cla_num", "CLA002");
	      List<String> list = pService.getIns(map);
	      for(int i = 0; i<list.size(); i++) {
	         Map<String, Object> salMap = new HashMap<String, Object>();
	         salMap.put("sal_cla_num", "CLA002");
	         salMap.put("sal_ins_id", list.get(i));
	         pService.insertSalary(salMap);
	         System.out.println(list.get(i) + " 지급완료");
	      }
	   }
}
	
	
