package com.test;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
public class IndexOfTest {
	@Test
	public void test(){
		String s="1,18,9";
		String s2="123456";
		//System.out.println("1".indexOf(s));//-1
		//System.out.println("18".indexOf(s));//-1
		//		System.out.println("1".indexOf(s2));//-1
		//		System.out.println("18".indexOf(s2));//-1
		//		System.out.println(s.indexOf("1"));//0
		//		System.out.println(s2.indexOf("1"));//0
		//		System.out.println(s.indexOf("18"));//2
		//		System.out.println(s2.indexOf("18"));//-1

		System.out.println(s.indexOf(""));//0

		String s3="1";
		String s4="5,16,9";
		System.out.println(s4.indexOf("1"));//2
		System.out.println(s4.indexOf("9"));//5

	}
	@Test
	public void test2(){
		String s="6,18,9";
		String[] arr = s.split(",");
		List<String> tempList = Arrays.asList(arr);
		if(tempList.contains("9"))
		{
			System.out.println("111");
		} else {
			System.out.println("222");
		}
	}
}
