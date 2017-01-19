package com.test.collection.sort;
import org.junit.Test;
public class ForTtest {
	@Test
	public void test(){
		for(int i=0;i<5;i++){
			for(int j=0;j<6;j++){
				if(i==j){
					System.out.println(i+"==="+j);
					break;
				}else{
					System.out.println("aa");
				}
			}
		}
	}
}
