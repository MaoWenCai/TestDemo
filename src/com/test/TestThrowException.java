package com.test;

import org.junit.Test;

import com.test.collection.sort.User2;

public class TestThrowException {
	@Test
	public void test(){
		if(true){
			throw new RuntimeException("运行出错");
		}
		System.out.println("1111111");
	}
	
	@Test
	public void test2(){
		try {
			TestException();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("1111111");
	}
	
	public void TestException() throws Exception{
		User2 user=new User2();
		user.setName("张三2");
		int i=1/0;
	}
}	
