package com.test;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import com.lowagie.tools.encrypt_pdf;
import com.test.collection.sort.User;
public class TestTryCatch {
	 /**
     * 获取异常的Root Cause
     * 
     * @param ex
     * @return
     */
    public static Throwable getRootCause(Throwable ex) {
        Throwable cause;
        while ((cause = ex.getCause()) != null) {
            ex = cause;
        }
        return ex;
    }
    
    /**
     * 获取异常的Root Message
     * 
     * @param ex
     * @return
     */
    public static String getRootMessage(Throwable ex, String defaults) {
        Throwable t = getRootCause(ex);
        if (t == null) {
            return defaults;
        }
        String m = t.getLocalizedMessage();
        return StringUtils.isEmpty(m) ? defaults : m ;
    }
    
	@Test
	public void test(){
		int a=50;
		try {
			a=1/0;
		} catch (ArithmeticException e) {
			a=100;
		}
		System.out.println(a);
	}
	@Test
	public void test3(){
		try {
			te2();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void te(){
		int a=50;
		try {
			a=1/0;
		} catch (ArithmeticException e) {
			System.out.println("aaaaa");
		}
	}
	public void te2() throws Exception{
		int a=1/0;
	}
	@Test
	public void test2(){
		int a=1/0;
	}
	@Test
	public void test4(){
		try {
			//excepTion();
			excepTion2();
		} catch (Exception ex) {
			String error=getRootMessage(ex, ex.getMessage());
			System.out.println(error);
		}
	}
	public void excepTion() throws Exception{
		int a=1;
		if(a==1){
			throw new Exception("任务定位失败"+a);
		}
	}
	public void excepTion2() throws Exception{
		User u=null;
		if(u.getAddress()=="aa"){
			System.out.println("aaa");
		}
	}
	@Test
	public void test6(){
		try {
			int a=1/0;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println("aaaaa");
	}
	@Test
	public void test7(){
		try {
			int a=1/0;
		} catch (Exception ex) {
			throw new RuntimeException("gg");
		}
		System.out.println("aaaaa");
	}
	@Test
	public void test8(){
		try {
			int a=1/0;
		} catch (Exception ex) {
			System.out.println("12222");
		}
		System.out.println("aaaaa");
	}
	
	
	@Test
	public void test9(){
		try {
			for(int i=0;i<5;i++){
				encap(i);
				System.out.println(i);
			}
		} catch (Exception ex) {
			System.out.println("test9");
		}
		System.out.println("test9");
	}

	private void encap(int i) {
		try {
			int a=1/i;
		} catch (Exception e) {
			System.out.println("出现异常。。");
		}
	}
	
}
