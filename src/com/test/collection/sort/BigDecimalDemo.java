package com.test.collection.sort;

import java.math.BigDecimal;
import java.text.NumberFormat;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
public class BigDecimalDemo {

	public String divTenThousand(String value) {
		if (StringUtils.isNotBlank(value)) {
			BigDecimal bd = new BigDecimal(value);
			return bd.divide(new BigDecimal(10000),4,BigDecimal.ROUND_HALF_UP).toString();
		}
		return null;
	}
	public String divTenThousand2(String value) {
		if (StringUtils.isNotBlank(value)) {
			BigDecimal bd = new BigDecimal(value);
			return bd.divide(new BigDecimal(10000),0,BigDecimal.ROUND_HALF_UP).toString();
		}
		return null;
	}
	@Test
	public void test22(){
		String b="278311111111.00";
		System.out.println(divTenThousand2(b));
	}

	public static double round(double v, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b = new BigDecimal(Double.toString(v));
		BigDecimal one = new BigDecimal("10000");
		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public static double round2(double v, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b = new BigDecimal(Double.toString(v));
		BigDecimal one = new BigDecimal("1");
		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	//	public static BigDecimal div(Object o1, Object o2, int scale) {
	//        if (scale < 0) {
	//            throw new IllegalArgumentException("The scale must be a positive integer or zero");
	//        }
	//        BigDecimal b1 = new BigDecimal(String.valueOf(o1));
	//        BigDecimal b2 = new BigDecimal(String.valueOf(o2));
	//        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP);
	//    }

	//	public static void main(String[] args) {
	//		System.out.println(divTenThousand("333333.30000000005"));
	//		System.out.println(round(333333.30000000005,2));
	//		System.out.println(round2(333333.32000000005,2));
	//	}

	@Test
	public void test(){
		BigDecimal bd=new BigDecimal("15.3");
		BigDecimal bd2=new BigDecimal("15");
		System.out.println(bd.add(bd2));
	}
	@Test
	public void test2(){
		BigDecimal bd=new BigDecimal("15.3");
		BigDecimal bd2=new BigDecimal(0);
		for(int i=0;i<5;i++){
			bd2=bd2.add(bd);
		}
		System.out.println(bd2);
	}
	@Test
	public void test3(){
		NumberFormat num = NumberFormat.getPercentInstance(); 
		num.setMaximumIntegerDigits(3); 
		num.setMaximumFractionDigits(2); 
		//double csdn = 0.201; //转换成百分比
		BigDecimal bd=new BigDecimal("0.201");
		System.out.println(num.format(bd));
	}
	/**
	 * 小数转换成百分比
	 * @param value
	 * @return
	 */
	public static String decimalConvertPercentate(String value) {
		if (value!=null&&!"".equals(value)) {
			BigDecimal bd=new BigDecimal(value);
			NumberFormat num = NumberFormat.getPercentInstance(); 
			num.setMaximumIntegerDigits(3); 
			num.setMaximumFractionDigits(2); 
			return num.format(bd);
		}
		return null;
	}

	@Test
	public void test33(){
		String value="0.201";
		
		System.out.println(decimalConvertPercentate(value));
	}
	/**
	 * 验证V1的值是否大于V2
	 *
	 * @param v1
	 * @param v2
	 * @return
	 */
	public boolean compareDataSize(BigDecimal v1, BigDecimal v2) {
		boolean flag = false;
		int v = v1.compareTo(v2);
		if (v == 1) {
			flag = true;
		}
		return flag;
	}
	@Test
	public void test4(){
		//		BigDecimal bd=new BigDecimal("15.3");
		//		BigDecimal bd2=new BigDecimal("15.3");
		//		int v = bd.compareTo(bd2);//相等0
		//		System.out.println(v);

		//		BigDecimal bd=new BigDecimal("15.3");
		//		BigDecimal bd2=new BigDecimal("15.6");
		//		int v = bd.compareTo(bd2);//小于返回-1
		//		System.out.println(v);

		BigDecimal bd=new BigDecimal("15.9");
		BigDecimal bd2=new BigDecimal("15.6");
		int v = "12".compareTo("15.6");//大于返回  1
		System.out.println(v);
	}

	public String compareBigDecimalSize(BigDecimal v1, BigDecimal v2) {       
		int v = v1.compareTo(v2);
		if (v == 0) {
			return "0";//相等
		}else if(v==1){
			return "1";//大于
		}else{
			return "-1";//小于
		}
	}
	@Test
	public void test5(){
		BigDecimal bd=new BigDecimal("0.00");
		BigDecimal bd2=new BigDecimal("0");
		int v = bd.compareTo(bd2);
		System.out.println(v);
		String s=compareBigDecimalSize(bd,bd2);
		if(bd2.equals(bd)){
			System.out.println("0");
		}else{
			System.out.println("1");
		}
	}
	  /**
     * 2个BigDecimal相除
     *
     * @param o1
     * @param o2
     * @param scale
     * @return
     */
    public BigDecimal div(Object o1, Object o2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(String.valueOf(o1));
        BigDecimal b2 = new BigDecimal(String.valueOf(o2));
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP);
    }
	@Test
	public void test6(){
		BigDecimal bd=new BigDecimal("781232.00");
		BigDecimal bd2=new BigDecimal("6000.00");
		int v = bd.compareTo(bd2);
		BigDecimal s=div(bd,bd2,2);
		System.out.println(s);
		
		System.out.println(bd.divide(new BigDecimal(10000)));
	}
	 /**
     * 除以一万 保留0位
     * @param value
     * @return
     */
    public String divTenThousandNotReserve(Object value) {
        if (value!=null&&!"".equals(value)) {
            BigDecimal bd = new BigDecimal(value.toString());
            return bd.divide(new BigDecimal(10000),0, BigDecimal.ROUND_HALF_UP).toString();
        }
        return null;
    }
    @Test
	public void test7(){
		BigDecimal bd=new BigDecimal("781232.00");
		BigDecimal bd2=new BigDecimal("6000.00");
		
		System.out.println(divTenThousandNotReserve(781232.00));
	}
}
