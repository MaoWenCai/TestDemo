package com.test.collection.sort;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import net.sf.json.JSONObject;

public class JsonObject {
	@Test
	public void test(){
		Map map =new HashMap<>();
		map.put("aa","111");
		map.put("bb","222");
		map.put("cc","333");
		map.put("dd","444");
		JSONObject json = JSONObject.fromObject(map);
		//System.out.println(json.get("aa"));
		//System.out.println(json.getString("ee"));
		//System.out.println(json.get("ee"));
		System.out.println("".equals(json.get("ee"))||json.get("ee")==null);
	}
	@Test
	public void test2(){
		Map map =new HashMap<>();
		map.put("aa","111");
		map.put("bb","");
		JSONObject json = JSONObject.fromObject(map);
		System.out.println("".equals(json.get("bb")));//true
		System.out.println(json.get("bb")==null);//false
	}
	@Test
	public void test3(){
		Map map =new HashMap<>();
		map.put("aa","111");
		map.put("bb","");
		JSONObject json = JSONObject.fromObject(map);
		People p=new People();
		p.setName(json.get("cc").toString());
		p.setAddress(json.get("bb").toString());
		//System.out.println(p.getAddress());
		System.out.println(p.getName());
	}
}
