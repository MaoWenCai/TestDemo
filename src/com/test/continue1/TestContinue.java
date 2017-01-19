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
	@Test
	public void test3(){
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				if(j==2){
					break;
				}
				System.out.println(i +"*"+j+"="+ i*j);
			}
		}
	}
	
	@Test
	public void test4(){
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				if(j==2){
					continue;
				}
				System.out.println(i +"*"+j+"="+ i*j);
			}
		}
	}
	
	@Test
	public void test5(){
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				if(j==2){
					return;
				}
				System.out.println(i +"*"+j+"="+ i*j);
			}
		}
	}
	/**return 测试
	 * 返回值
	 * 0*0=0
	   0*1=0
	 */
}
