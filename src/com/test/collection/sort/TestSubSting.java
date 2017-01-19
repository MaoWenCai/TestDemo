package com.test.collection.sort;

import org.junit.Test;

public class TestSubSting {
	@Test
    public void test(){
    	String s="2015-06-12 12:12:12";
    	//System.out.println(s.substring(0,10));
    	System.out.println(s.substring(11,19));
    	System.out.println(s.substring(0,4));
		
    	System.out.println(s.substring(5,7));
    }
	@Test
    public void test2(){
    	String s="3400000";
    	int maxAmount=Integer.parseInt(s);
    	System.out.println(maxAmount);
    }
}
