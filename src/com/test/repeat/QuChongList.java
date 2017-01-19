package com.test.repeat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class QuChongList {
	@Test
	public void test() {
		List<String> listA = new ArrayList<>();
		listA.add("1");
		listA.add("2");
		listA.add("3");
		List<String> listB = new ArrayList<>();
		listB.add("1");
		listB.add("3");
		listB.add("5");
		// listB.add("1");
		for (String s : listA) {
			System.out.println(s);
		}
		for (String s : listB) {
			System.out.println(s);
		}
		System.out.println("=========结束=========");

		for (int i = 0; i < listA.size(); i++) {
			String tmpA = listA.get(i);
			for (int j = 0; j < listB.size(); j++) {
				String tmpB = listB.get(j);
				if (tmpA == tmpB) {
					listB.remove(j);// 移除
					listA.remove(i);
				}
			}
		}
		for (String s : listA) {
			System.out.println(s);
		}
		for (String s : listB) {
			System.out.println(s);
		}
		System.out.println("=========结束=========");

	}

	@Test
	public void test2(){
		List<String> list = new ArrayList<String>();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		list.add("dd");
		list.add("bb");
		list.add("ee");
		list.add("dd");
		list.add("ff");

		String temp = "";
		for (int i = 0; i < list.size() - 1; i++)
		{
			temp = list.get(i);
			for (int j = i + 1; j < list.size(); j++)
			{
				if (temp.equals(list.get(j)))
				{
					System.out.println("第" + (i + 1) + "个跟第" + (j + 1) + "个重复，值是：" + temp);
				}
			}
		}


	}
}
