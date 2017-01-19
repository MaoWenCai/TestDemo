package com.test.BigDecimal;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.junit.Test;
public class BigDecimalTest {
	@Test
	public void test(){
		BigDecimal b=new BigDecimal("19460000.00");
		//BigDecimal d=b.divide(new BigDecimal("100000000"),4);//0.19
		BigDecimal d=b.divide(new BigDecimal("10000"));//1946.00
		//BigDecimal d=b.divide(new BigDecimal("100000000"));//0.1946
		System.out.println(d);
		
		System.out.println(com.test.util.MathUtil.div(d,10000,4));
		
		
		DecimalFormat df = new DecimalFormat("0.00"); // 保留几位小数
		BigDecimal bde=new BigDecimal("2.3");
		String str = df.format(bde);
		System.out.println("-->"+str ) ; // 结果为 str = 2.30

	}
	@Test
	public void test2(){
		BigDecimal b=new BigDecimal("19,460,000.00");
		System.out.println(b);

	}
	@Test 
	public void test3(){
		BigDecimal b=new BigDecimal("1");
		BigDecimal b2=new BigDecimal("15");
		BigDecimal c=b.divide(b2, 2, BigDecimal.ROUND_HALF_UP);
		System.out.println(c);//0.07

	}
	
	@Test 
	public void test4(){
		//BigDecimal c=new BigDecimal(3.154215);//3.1542
		//BigDecimal c=new BigDecimal(3.154255);//3.1543
		//BigDecimal c=new BigDecimal(3.154285);//3.1543
		BigDecimal c=new BigDecimal(3.154235);//3.1542
		
		DecimalFormat df = new DecimalFormat("0.0000"); // 保留几位小数
		String str = df.format(c);   
		
		System.out.println(str);
	}
	  
}
