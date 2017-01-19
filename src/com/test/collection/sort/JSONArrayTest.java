package com.test.collection.sort;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JSONArrayTest {
	@Test
	public void test(){
		String s="[{'type': '1', 'productId': '1005', 'dailySales': 1000000, 'sumSales': 5000000},"
				+ "{'type': '1', 'productId': '1006', 'dailySales': 2000000, 'sumSales': 6000000},"
				+ "{'type': '2', 'dailySales': 3000000},{'type': '3', 'dailySales': 7000000}]";
		JSONArray j=JSONArray.fromObject(s);
		for(int i=0;i<j.size();i++){
			JSONObject jb=j.getJSONObject(i);
			System.out.println(jb.get("type"));
			System.out.println(jb.get("productId"));
/**
 * 输出 
 * 1
1005
1
1006
2
null
3
null
			 */
		}
	}
	
	@Test
	public void test1(){
		List list=new ArrayList();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		merge(list);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
	private void merge(List list) {
		for(int i=0;i<list.size();i++){
			if(i==1){
				list.add("dd");
			}
		}
	}
	
	@Test
	public void test3(){
		String s="[{'createDate':'2016-05-12 15:16:32','deadline':'3.47','endDate':'2016-08-25','interestType':'5','principal':'1000.00','productName':'0011605120101','productType':'短期赚','scalingFactor':'1.00','sellerId':'002197','sellerName':'邬剑','startDate':'2016-05-13','transCode':'701242'},{'createDate':'2016-05-12 16:03:08','deadline':'0.17','endDate':'2016-05-16','interestType':'5','principal':'1001.83','productName':'ZCZR16051252109','productType':'灵活转','scalingFactor':'1.00','sellerId':'000020','sellerName':'董青青','startDate':'2016-05-11','transCode':'701249'},{'createDate':'2016-05-12 16:45:03','deadline':'3.33','endDate':'2016-08-25','interestType':'5','principal':'1000.00','productName':'0011605120105','productType':'短期赚','scalingFactor':'1.00','sellerId':'002197','sellerName':'邬剑','startDate':'2016-05-17','transCode':'701251'},{'createDate':'2016-05-12 16:45:03','deadline':'3.33','endDate':'2016-08-25','interestType':'5','principal':'10000.00','productName':'0011605120105','productType':'短期赚','scalingFactor':'1.00','sellerId':'000356','sellerName':'王伟','startDate':'2016-05-17','transCode':'701252'},{'createDate':'2016-05-12 16:46:09','deadline':'3.33','endDate':'2016-08-25','interestType':'5','principal':'3000.00','productName':'0011605120105','productType':'短期赚','scalingFactor':'1.00','sellerId':'002197','sellerName':'邬剑','startDate':'2016-05-17','transCode':'701253'},{'createDate':'2016-05-12 16:46:49','deadline':'3.33','endDate':'2016-08-25','interestType':'5','principal':'10000.00','productName':'0011605120105','productType':'短期赚','scalingFactor':'1.00','sellerId':'000356','sellerName':'王伟','startDate':'2016-05-17','transCode':'701254'},{'createDate':'2016-05-12 16:46:52','deadline':'3.33','endDate':'2016-08-25','interestType':'5','principal':'5000.00','productName':'0011605120105','productType':'短期赚','scalingFactor':'1.00','sellerId':'002197','sellerName':'邬剑','startDate':'2016-05-17','transCode':'701255'},{'createDate':'2016-05-12 17:26:41','deadline':'3.33','endDate':'2016-08-25','interestType':'5','principal':'1000.00','productName':'0011605120105','productType':'短期赚','scalingFactor':'1.00','sellerId':'002390','sellerName':'刘浩荣','startDate':'2016-05-17','transCode':'701260'},{'createDate':'2016-05-12 17:27:07','deadline':'3.33','endDate':'2016-08-25','interestType':'5','principal':'4000.00','productName':'0011605120105','productType':'短期赚','scalingFactor':'1.00','sellerId':'002390','sellerName':'刘浩荣','startDate':'2016-05-17','transCode':'701261'},{'createDate':'2016-05-12 17:27:53','deadline':'3.33','endDate':'2016-08-25','interestType':'5','principal':'5000.00','productName':'0011605120105','productType':'短期赚','scalingFactor':'1.00','sellerId':'002390','sellerName':'刘浩荣','startDate':'2016-05-17','transCode':'701262'}]";
		JSONArray j=JSONArray.fromObject(s);
		BigDecimal b1=new BigDecimal("0");
		for(int i=0;i<j.size();i++){
			JSONObject jb=j.getJSONObject(i);
			BigDecimal b=new BigDecimal(jb.get("principal").toString());
			b1=b1.add(b);
		}
		//41001.83
		System.out.println(b1);
	}
	
	@Test
	public void test5(){
		String s="[{'type': '1', 'productId': '1005', 'dailySales': 1000000, 'sumSales': 5000000},"
				+ "{'type': '1', 'productId': '1006', 'dailySales': 2000000, 'sumSales': 6000000},"
				+ "{'type': '2', 'dailySales': 3000000},{'type': '3', 'dailySales': 7000000}]";
		JSONArray j=JSONArray.fromObject(s);
		for(int i=0;i<j.size();i++){
			JSONObject jb=j.getJSONObject(i);
			System.out.println(jb.get("type"));
			System.out.println(jb.get("aa"));
//			System.out.println(jb.get("productId").toString());//null的toString 报错
		}
	}
	
	
}
