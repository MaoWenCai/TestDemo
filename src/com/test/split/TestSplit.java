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
	
	@Test
	public void test4(){
		String avoid="1,,4,8,";
		String[] arr = avoid.split(",");
		System.out.println(arr.length);//4
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
/**
 4
1

4
8
		
 */
	}
	@Test
	public void test41(){
		String avoid="1,,4,8, ";
		String[] arr = avoid.split(",");
		System.out.println(arr.length);//5
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
/*
 5
1

4
8
 
		
 */
	}
	
	@Test
	public void test42(){
		String avoid=",1,,4,8";
		String[] arr = avoid.split(",");
		System.out.println(arr.length);//5
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		
		/**
5

1

4
8 
*/
	}
	
	@Test
	public void test43(){
		String avoid=",,1,,4,8";
		String[] arr = avoid.split(",");
		System.out.println(arr.length);//6
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		
		/**
5

1

4
8 
*/
	}
}
