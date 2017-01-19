package com.test.collection.sort;

import org.junit.Test;

public class TestUser {
	@Test
	public void test(){
		User2 user=new User2();
		user.setAddress("香港。。");
		System.out.println(user.getAddress()+" "+user.getName()+" "+user.getOrder());
		
		encapsulate(user,"张三",9);
		
		System.out.println(user.getAddress()+" "+user.getName()+" "+user.getOrder());
	}

	private void encapsulate(User2 user, String name, Integer order) {
		user.setName(name);
		user.setOrder(order);
	}

}	
