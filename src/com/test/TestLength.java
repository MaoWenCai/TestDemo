package com.test;

import java.util.regex.Pattern;

import org.junit.Test;

public class TestLength {
//	public static void main(String[] args) {
//		String  s="预约测试起点金额";
//		System.out.println(s.length());
//	}
	@Test
	public void test(){
		String phone="021-80133840";
		Pattern pattern = Pattern
		.compile("/^((00|\\+)?(86(?:-| )))?((\\d{11})|(\\d{3}[- ]{1}\\d{4}[- ]{1}\\d{4})|((\\d{2,4}[- ]){1}(\\d{7,8}|(\\d{3,4}[- ]{1}\\d{4}))([- ]{1}\\d{1,4})?))$/");
		boolean flag=pattern.matcher(phone).matches();
		
		System.out.println(flag);
	}
}
