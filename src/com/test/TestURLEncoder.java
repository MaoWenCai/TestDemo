package com.test;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class TestURLEncoder {
	@Test
	public void test() throws UnsupportedEncodingException{
		String s="TEST_J_16_003";
		String name=URLEncoder.encode(s, "UTF-8");
		System.err.println(name);
	}
}
