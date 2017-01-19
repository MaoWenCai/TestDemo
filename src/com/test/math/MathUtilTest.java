package com.test.math;
import java.math.BigDecimal;

import org.junit.Test;

import com.test.util.MathUtil;
public class MathUtilTest {
	@Test
	public void test(){
		BigDecimal b1=new BigDecimal("2589452");
		BigDecimal b2=new BigDecimal("2589");
		//BigDecimal d=MathUtil.div(b2,b1,3);//0.001
		BigDecimal d=MathUtil.div(b2,b1, 4);//0.0010
		System.out.println(d);
	}
}
