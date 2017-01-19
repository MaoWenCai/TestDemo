package com.test;
import org.junit.Test;
public class SplitTest {
	@Test
	public void test(){
		String scopeDate="2016-07-30到2016-08-30";
		String startDate=scopeDate.split("到")[0];
		String endDate=scopeDate.split("到")[1];
		System.out.println(startDate+"=="+endDate);
	}
}
