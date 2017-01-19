package com.test.collection.sort;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestNew {
	@Test
	public void test(){
		User u=new User();
		if(u==null){
			System.out.println("11");
		}else{
			System.out.println("22");
		}
	}
	@Test
	public void test2(){
		List list=new ArrayList();
		if(list.size()>0){//new之后大于0
			System.out.println("11");
		}else{
			System.out.println("22");
		}
	}
}
