package com.test.collection.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class TestConlection1 {
	public static void main(String[] args) {  

		List<Integer> list = new ArrayList<Integer>();  
		list.add(5);  
		list.add(2);  
		list.add(1);  
		list.add(9);  
		list.add(0);  

		System.out.println("排序前:");  
		for (Integer integer : list) {  
			System.out.print(integer+" ");  
		}  
		System.out.println();  

		/*排序*/  
		Collections.sort(list);  

		System.out.println("排序后");  
		for (Integer integer : list) {  
			System.out.print(integer+" ");  
		}  
	}  
	
	//倒置  倒过来输出
	@Test
	public void test(){
		List<Integer> list = new ArrayList<Integer>();  
		list.add(5);  
		list.add(2);  
		list.add(1);  
		list.add(9);  
		list.add(0); 
		
		System.out.println("倒置前:");  
		for (Integer integer : list) {  
			System.out.print(integer+" ");  
		}  
		System.out.println();  

		/*排序*/  
		Collections.reverse(list);  

		System.out.println("倒置后");  
		for (Integer integer : list) {  
			System.out.print(integer+" ");  
		}  
	}
}
