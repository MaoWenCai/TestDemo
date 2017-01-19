package com.test.jsonConfig;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsDateJsonBeanProcessor;
import net.sf.json.util.CycleDetectionStrategy;

public class JsonConfigTest {
	//registerJsonBeanProcessor 当value类型是从java的一个bean转化过来的时候，可以提供自定义处理器
	@Test
	public void testMap() {  
	    Map map = new HashMap();  
	    map.put("name", "json");  
	    map.put("class", "ddd");  
	    map.put("date", new Date());  
	    JsonConfig config = new JsonConfig();  
	    config.setIgnoreDefaultExcludes(false);  
	    config.registerJsonBeanProcessor(Date.class,  
	            new JsDateJsonBeanProcessor()); // 当输出时间格式时，采用和JS兼容的格式输出  
	    JSONObject jsonObject = JSONObject.fromObject(map, config);  
	    System.out.println(jsonObject);  
	} 
	/** setCycleDetectionStrategy 防止自包含
	    * 这里测试如果含有自包含的时候需要CycleDetectionStrategy 
	    */ 
	@Test
	   public void testCycleObject() {  
	       CycleObject object = new CycleObject();  
	       object.setMemberId("yajuntest");  
	       object.setSex("male");  
	       JsonConfig jsonConfig = new JsonConfig();  
	       jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);  
	  
	       JSONObject json = JSONObject.fromObject(object, jsonConfig);  
	       System.out.println(json);  
	   }  
}
