package com.test.split;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import net.sf.json.JSONObject;

public class TestSplit {
	@Test
	public void test(){
		String st ="24";
		String avoid ="4";
		if(st.indexOf(avoid)>=0)
		{
			System.out.println("aaaaa包含");
		}
	}
	@Test
	public void test2(){
		String avoid="1,4";
		String[] arr = avoid.split(",");
		List<String> tempList = Arrays.asList(arr);
		if(tempList.contains("4")){
			System.out.println("编号起始号不能使用规避的数字!");
		}
	}
//	@Test
//	public void test3(){
//		String st ="14";
//		String avoid ="2,4";
//		if(st.indexOf(avoid)>=0)
//		{
//			System.out.println("aaaaa包含");
//		}
//	}
	@Test
	public void test3(){
		String avoid="1,4,8";
		String[] arr = avoid.split(",");
		for(int i=0;i<arr.length;i++){
			String ind=arr[i];
			if("6".indexOf(ind)>=0)
			{ 
				System.out.println("123".indexOf(ind));
				System.out.println("aaaaa包含"+i);
			}
		}
	}
}
