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
	
	//测试test3
	@Test
	public void test3(){
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				if(j==2){
					break;
				}
				//删除值
				System.out.println(i +"*"+j+"="+ i*j);
			}
		}
	}
}
