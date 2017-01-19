package com.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class TestMobile {
	
	@Test
	public void test(){
		//boolean b=isPhoneNumberValid("18817319415");//true
		//boolean b=isPhoneNumberValid("13764488413");//true
		//boolean b=isPhoneNumberValid("0710-4788502");//false

		boolean b=isPhoneNumberValid2("18817319415");//true
		//boolean b=isPhoneNumberValid2("13764488413");//true
		//boolean b=isPhoneNumberValid2("0710-4788502");//true
		//boolean b=isPhoneNumberValid2("027-4788502");//true
		//boolean b=isPhoneNumberValid2("0710-4744502");//true
		System.out.println(b);
	}
	
	
	//@Title: isPhoneNumberValid
	//@Description: 验证号码 手机号 固话均可
	//@author qinyl
	//@date 2014年6月20日 下午3:16:03
	//@param @param phoneNumber
	//@param @return 设定文件
	//@return boolean 返回类型
	//@throws
	public static boolean isPhoneNumberValid2(String phoneNumber) {
		boolean isValid = false;
		//-------------手机号码，以1开始，13,15,18,19,为合法，后根9位数字------
		String regEx="[1]{1}[3,5,8,6]{1}[0-9]{9}"; //表示a或f
		boolean p = Pattern.compile(regEx).matcher(phoneNumber).find();
		//-------------电话号码,以0开始,不含括号----------------------------------------------
		String tregEx="[0]{1}[0-9]{2,3}-[0-9]{7,8}"; //表示a或f 0832-80691990
		boolean tp = Pattern.compile(tregEx).matcher(phoneNumber).find();
		System.out.println("p="+p);
		System.out.println("tp="+tp);
		
		if(p||tp){
			isValid=true; 
		}
		return isValid;
		
	}
	public static boolean isPhoneNumberValid(String phoneNumber) {
		boolean isValid = false;
		String expression = "((^(13|15|18)[0-9]{9}$)|(^0[1,2]{1}d{1}-?d{8}$)|"
				+ "(^0[3-9] {1}d{2}-?d{7,8}$)|"
								+ "(^0[1,2]{1}d{1}-?d{8}-(d{1,4})$)|"
				+ "(^0[3-9]{1}d{2}-? d{7,8}-(d{1,4})$))";
		CharSequence inputStr = phoneNumber;
		Pattern pattern = Pattern.compile(expression);
		Matcher matcher = pattern.matcher(inputStr);
		if (matcher.matches()) {
			isValid = true;
		}
		return isValid;
	}
}
