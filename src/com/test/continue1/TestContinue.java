package com.test.continue1;

import org.junit.Test;

public class TestContinue {
	@Test
	public void test(){
		for(int i=0;i<5;i++){
			if(i==3){
				continue;
			}
			System.out.println(i);
		}
	}
	@Test
	public void test2(){
		for(int i=0;i<5;i++){
			if(i==3){
				break;
			}
			System.out.println(i);
		}
	}
	//测试。
	//测试2
	//测试3
	//测试4
	//测试5
	//测试5.git	
	@Test
	public void test3(){
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				if(j==2){
					//当前for会结束
					break;
				}
				System.out.println("输出git=====");
				System.out.println("输出开始0=====");
				System.out.println("输出=====");
				System.out.println("输出="+i +"*"+j+"="+ i*j);
				System.out.println("输出结束11=====");
				System.out.println("输出结束12=====");
			}
		}
	}
	
	//测试continue
	@Test
	public void test4(){
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				if(j==2){
					continue;
				}
				System.out.println("输出===");
				System.out.println(i +"*"+j+"="+ i*j);
			}
		}
	}
}
