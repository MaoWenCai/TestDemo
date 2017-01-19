package com.test.collection.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class CollectionSort {
	@Test
	public void test1() {
        User user1 = new User();
        user1.setName("a");
        user1.setOrder(1);
        User user2 = new User();
        user2.setName("b");
        user2.setOrder(2);
        List<User> list = new ArrayList<User>();
        //此处add user2再add user1
        list.add(user2);
        list.add(user1);
        Collections.sort(list);
        for(User u : list){
            System.out.println(u.getName());
        }
    }
	@Test
	public void test2(){
		User2 user1 = new User2();
        user1.setName("a");
        user1.setOrder(1);
        User2 user2 = new User2();
        user2.setName("b");
        user2.setOrder(2);
        List<User2> list = new ArrayList<User2>();
        list.add(user2);
        list.add(user1);
//        Collections.sort(list, new Comparator<User2>() {
//        	public int compare(User2 arg0,User2 arg1) {
//        		return arg0.getOrder().compareTo(arg1.getOrder());
//        	};
//		});
        for(User2 u:list){
        	System.out.println(u.getName()+"=="+u.getOrder());//b==2 a==1

        }
	}
	@Test
	public void test22(){
		User2 user1 = new User2();
        user1.setName("a");
        user1.setOrder(1);
        User2 user2 = new User2();
        user2.setName("b");
        user2.setOrder(2);
        User2 user3 = new User2();
        user3.setName("c");
        user3.setOrder(3);
        List<User2> list = new ArrayList<User2>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        Collections.sort(list, new Comparator<User2>() {
        	public int compare(User2 arg0,User2 arg1) {
        		return arg0.getOrder().compareTo(arg1.getOrder());
        	};
		});
        for(User2 u:list){
        	System.out.println(u.getName()+"=="+u.getOrder());
        	/**
        	 * a==1
b==2
c==3

        	 */

        }
	}
	@Test
	public void test23(){
		User2 user1 = new User2();
        user1.setName("a");
        user1.setOrder(1);
        User2 user2 = new User2();
        user2.setName("b");
        user2.setOrder(2);
        User2 user3 = new User2();
        user3.setName("c");
        user3.setOrder(3);
        List<User2> list = new ArrayList<User2>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        Collections.sort(list, new Comparator<User2>() {
        	public int compare(User2 arg0,User2 arg1) {
        		return arg0.getOrder()-arg1.getOrder();//升序
        	};
		});
        for(User2 u:list){
        	System.out.println(u.getName()+"=="+u.getOrder());//a==1  b==2
/**
 * a==1
b==2
c==3

 */
        }
	}
	@Test
	public void test24(){
		User2 user1 = new User2();
        user1.setName("a");
        user1.setOrder(1);
        User2 user2 = new User2();
        user2.setName("b");
        user2.setOrder(2);
        User2 user3 = new User2();
        user3.setName("c");
        user3.setOrder(3);
        List<User2> list = new ArrayList<User2>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        Collections.sort(list, new Comparator<User2>() {
        	public int compare(User2 arg0,User2 arg1) {
        		return arg1.getOrder()-arg0.getOrder();//降序
        	};
		});
        for(User2 u:list){
        	System.out.println(u.getName()+"=="+u.getOrder());
        	/**
        	 * c==3
				b==2
				a==1

        	 */

        }
	}
}
