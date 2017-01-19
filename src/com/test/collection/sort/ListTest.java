package com.test.collection.sort;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
public class ListTest {
	@Test
	public void test(){
		List<User> userList=new ArrayList();
		User user=new User();
		user.setAddress("香港");
		user.setName("张三");
		userList.add(user);
		for(User uu:userList){
			uu.setOrder(11);
		}
		for(User us:userList){
			System.out.println(us.getOrder());
		}
	}
}
