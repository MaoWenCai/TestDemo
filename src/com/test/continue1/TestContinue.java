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
}
