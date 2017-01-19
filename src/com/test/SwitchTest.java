package com.test;

import org.junit.Test;

public class SwitchTest {
	@Test
	public void test(){
		String s = "1";  
		switch (s) {  
		    case "1":  
		    	String reValue=funct();
		    	if("8".equals(reValue)){
		    		System.out.println(reValue);
		    	}
		        System.out.println("In case 1");  
		        break;  
		    case "2":  
		        System.out.println("In case 2");  
		        break;  
		    default:  
		        System.out.println("In default");  
		        break;  
		    case "3":  
		        System.out.println("In case 3");  
		        break;  
		}  

	}

	private String funct() {
		String s="8";
		return s;
	}
}
