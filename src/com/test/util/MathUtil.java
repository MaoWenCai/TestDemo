package com.test.util;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

/**
 * 数学计算类
 *
 * @author : Qiulingdong
 * @Filename : MathUtil.java
 * @Package : com.chyjr.has.core.util
 * @Description : 海银财富has开发框架
 * @CreateDate : 2013-5-30
 */
public class MathUtil {
	/**
	 * 默认除法运算精度 *
	 */
	private static final int DEF_DIV_SCALE = 2;

	private MathUtil() {
	}

	/**
	 * 提供精确的加法运算。
	 *
	 * @param v1 被加数
	 * @param v2 加数
	 * @return 两个参数的和
	 */
	public static double add(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.add(b2).doubleValue();
	}

	/**
	 * 提供精确的加法运算,返回BigDecimal
	 *
	 * @param v1 被加数
	 * @param v2 加数
	 * @return 两个参数的和
	 */
	public static BigDecimal add(String v1, String v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.add(b2);
	}


	/**
	 * 提供精确的加法运算,返回String
	 *
	 * @param v1 被加数
	 * @param v2 加数
	 * @return 两个参数的和
	 */
	public static String addInt2String(String v1, String v2) {
		int i = Integer.parseInt(v1);
		int j = Integer.parseInt(v2);
		int k = (i + j);
		return new Integer(k).toString();
	}

	/**
	 * 提供精确的加法运算,返回BigDecimal
	 *
	 * @param v1 被加数
	 * @param v2 加数
	 * @return 两个参数的和
	 */
	public static BigDecimal add(BigDecimal v1, BigDecimal v2) {
		return v1.add(v2);
	}

	/**
	 * 提供精确的减法运算。
	 *
	 * @param v1 被减数
	 * @param v2 减数
	 * @return 两个参数的差
	 */
	public static double sub(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.subtract(b2).doubleValue();
	}

	/**
	 * 减法运算,返回BigDecimal
	 *
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static BigDecimal sub(String v1, String v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.subtract(b2);
	}

	/**
	 * 减法运算,返回String
	 *
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static String subInt2String(String v1, String v2) {
		int i = Integer.parseInt(v1);
		int j = Integer.parseInt(v2);
		int k = (i - j);
		return new Integer(k).toString();
	}

	/**
	 * 减法运算,返回BigDecimal
	 *
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static BigDecimal sub(BigDecimal v1, BigDecimal v2) {
		return v1.subtract(v2);
	}

	public static int compareNumberStr(String v1, String v2) {
		boolean f1 = StringUtils.isEmpty(v1);
		boolean f2 = StringUtils.isEmpty(v2);
		if (f1 && f2) {
			return 0;
		} else if (f1) {
			return -1;
		} else if (f2) {
			return 1;
		}
		return new BigDecimal(v1).compareTo(new BigDecimal(v2));
	}

	/**
	 * 验证V1的值是否大于V2
	 *
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static boolean compareDataSize(BigDecimal v1, BigDecimal v2) {
		boolean flag = false;
		int v = v1.compareTo(v2);
		if (v == 1) {
			flag = true;
		}
		return flag;
	}
	public static String compareBigDecimalSize(BigDecimal v1, BigDecimal v2) {
		int v = v1.compareTo(v2);
		if (v == 0) {
			return "0";//相等
		}else if(v==1){
			return "1";//大于
		}else{
			return "-1";//小于
		}
	}

	/**
	 * 提供精确的乘法运算。
	 *
	 * @param v1 被乘数
	 * @param v2 乘数
	 * @return 两个参数的积
	 */

	public static double mul(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.multiply(b2).doubleValue();
	}

	/**
	 * 提供（相对）精确的除法运算，当发生除不尽的情况时， 精确到小数点以后scale位，以后的数字四舍五入。
	 *
	 * @param v1 被除数
	 * @param v2 除数
	 * @return 两个参数的商
	 */
	public static double div(double v1, double v2) {
		return div(v1, v2, DEF_DIV_SCALE);
	}

	/**
	 * 提供（相对）精确的除法运算。 当发生除不尽的情况时，由scale参数指定精度，以后的数字四舍五入。
	 *
	 * @param v1    被除数
	 * @param v2    除数
	 * @param scale 表示表示需要精确到小数点以后几位。
	 * @return 两个参数的商
	 */
	public static double div(double v1, double v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 2个BigDecimal相除
	 *
	 * @param o1
	 * @param o2
	 * @param scale
	 * @return
	 */
	public static BigDecimal div(Object o1, Object o2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(String.valueOf(o1));
		BigDecimal b2 = new BigDecimal(String.valueOf(o2));
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 提供精确的小数位四舍五入处理。
	 *
	 * @param v     需要四舍五入的数字
	 * @param scale 小数点后保留几位
	 * @return 四舍五入后的结果
	 */
	public static double round(double v, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b = new BigDecimal(Double.toString(v));
		BigDecimal one = new BigDecimal("1");
		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 把null 转换成0L
	 *
	 * @param resource
	 * @return 转化后的Long值
	 */
	public static Long nullToZero(Long resource) {
		return resource == null ? 0L : resource;
	}

	/**
	 * 把null 转换成0.0d
	 *
	 * @param resource
	 * @return 转化后的Double值
	 */
	public static Double nullToZero(Double resource) {
		return resource == null ? 0.0 : resource;
	}

	/**
	 * 将数字转为指定格式
	 *
	 * @param pattern
	 * @param bd
	 * @return
	 */
	public static String parseMoney(String pattern, BigDecimal bd) {
		if (bd.compareTo(BigDecimal.ZERO) == 0) {
			return "0.00";
		}
		DecimalFormat df = new DecimalFormat(pattern);
		return df.format(bd);
	}

	/**
	 * 将数字转为指定格式 ###,###.00
	 *
	 * @param bd
	 * @return
	 */
	public static String parseMoney(BigDecimal bd) {
		DecimalFormat df = new DecimalFormat("###,###.00");
		return df.format(bd);
	}

	/**
	 * 字符串金额/100，并转换为BigDecimal类型
	 *
	 * @param value
	 * @return
	 */
	public static BigDecimal strToBd(String value) {
		return StringUtils.isNotEmpty(value) ? new BigDecimal(value).divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP) : null;
	}

	/**
	 * BigDecimal类型金额*100,并转换为字符串类型
	 *
	 * @param value
	 * @return
	 */
	public static String bdToStr(BigDecimal value) {
		if (value == null) {
			return null;
		}
		if (value.compareTo(BigDecimal.ZERO) == 0) {
			return "0";
		}
		value = value.multiply(new BigDecimal(100));
		return parseMoney("#", value);
	}

	/**
	 * 除以一万
	 * @param value
	 * @return
	 */
	public static String divTenThousand(String value) {
		if (StringUtils.isNotBlank(value)) {
			BigDecimal bd = new BigDecimal(value);
			return bd.divide(new BigDecimal(10000), 4, BigDecimal.ROUND_HALF_UP).toString();
		}
		return null;
	}
	/**
	 * 除以一万 保留0位
	 * @param value
	 * @return
	 */
	public static BigDecimal divTenThousandNotReserve(Object value) {
		if (value!=null&&!"".equals(value)) {
			BigDecimal bd = new BigDecimal(value.toString());
			return bd.divide(new BigDecimal(10000),0, BigDecimal.ROUND_HALF_UP);
		}
		return null;
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
	/**
	 * 合计一组对象中的某个属性<br>
	 * 如果参数dbFlag为true，那么如果是字符串，默认会除以100
	 *
	 * @param list
	 * @param property
	 * @param dbFlag
	 * @return
	 */
	public static <T> BigDecimal sumProperty(List<T> list, String property, boolean dbFlag) {
		BigDecimal sum = new BigDecimal("0");
		if (CollectionUtils.isEmpty(list))
			return sum;

		T t = list.get(0);
		if (t == null)
			return sum;

		try {
			Method m = t.getClass().getMethod(("get" + StringUtil.toUpperCaseFirstOne(property)));
			if (m == null)
				return sum;

			Object v;
			BigDecimal bd;
			for (T bean : list) {
				v = m.invoke(bean);

				if (v == null || !(NumberUtils.isNumber(v.toString())))
					continue;

				if (m.getReturnType() == BigDecimal.class) {
					sum = sum.add((BigDecimal) v);
					continue;
				}
				bd = dbFlag ? MathUtil.strToBd(v.toString()) : new BigDecimal(v.toString());
				if (bd != null)
					sum = sum.add(bd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sum;
	}

	/**
	 * 合计一组对象中的某个属性
	 *
	 * @param list
	 * @param property
	 * @return
	 */
	public static <T> BigDecimal sumProperty(List<T> list, String property) {
		return sumProperty(list, property, true);
	}

	/**
	 * 格式化数字为千分位显示；
	 *
	 * @param 要格式化的数字 ；
	 * @return
	 */
	public static String fmtMicrometer(String text) {
		DecimalFormat df = null;
		if (text.indexOf(".") > 0) {
			if (text.length() - text.indexOf(".") - 1 == 0) {
				df = new DecimalFormat("###,##0.");
			} else if (text.length() - text.indexOf(".") - 1 == 1) {
				df = new DecimalFormat("###,##0.0");
			} else {
				df = new DecimalFormat("###,##0.00");
			}
		} else {
			df = new DecimalFormat("###,##0");
		}
		double number = 0.0;
		try {
			number = Double.parseDouble(text);
		} catch (Exception e) {
			number = 0.0;
		}
		return df.format(number);
	}

	public static boolean isEmpty(BigDecimal num) {
		if (null == num || num.doubleValue() == 0) {
			return true;
		}
		return false;
	}

	public static boolean isNotEmpty(BigDecimal num) {
		return !isEmpty(num);
	}

	/**
	 * 判断是否为偶数
	 *
	 * @param num
	 * @return
	 */
	public static boolean isEvenNum(int num) {
		if (num % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}
}
