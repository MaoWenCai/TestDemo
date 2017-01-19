package com.test.return1;

import org.junit.Test;

public class TestReturn {
	@Test
	public void test(){
		for(int i=0;i<5;i++){
			if(i==3){
				return;
			}
			System.out.println(i);//0 1 2
		}
	}
	@Test
	public void test2(){
		for(int i=0;i<5;i++){
			if(i==3){
				break;
			}
			System.out.println(i);//0 1 2
		}
	}
	@Test
	public void test3(){
		for(int i=0;i<5;i++){
			if(i==3){
				continue;
			}
			System.out.println(i);//0 1 2 4
		}
	}
}
