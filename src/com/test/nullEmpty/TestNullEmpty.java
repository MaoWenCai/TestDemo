package com.test.nullEmpty;

import org.junit.Test;

public class TestNullEmpty {
	@Test
	public void test(){
		String s1=null;
		String s2="";
		String s3=" ";//1个空格
		String s4="  ";//2个空格
		
		//System.out.println(s1.length());//NullPointerException
		System.out.println(s2.length());//0
		System.out.println(s3.length());//1
		System.out.println(s4.length());//2
		
	}
	
}	
