package com.test.collection.sort;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.springframework.util.Assert;

public class DateTest {
	public static void main(String[] args) {
		String s1="2010-06-08";
		String s2="2015-06-08";
		String s3="2018-06-08";
		int i=1;
		if(i!=-1||i!=1){
			System.out.println("aa");
		}
		if(i!=-1&&i!=1){
			System.out.println("abb");
		}
	}
	 /**
     * 获取日期间隔（天）
     * 
     * @param start
     * @param end
     * @return
     * @throws ParseException
     */
	 public static int getBetweenDays(String start, String end) throws ParseException {
	        return getBetweenDays(start, end, "yyyy-MM-dd");
	    }
	    
	    /**
	     * 获取日期间隔（天）
	     * 
	     * @param start
	     * @param end
	     * @param pattern
	     * @return
	     * @throws ParseException
	     */
	    public static int getBetweenDays(String start, String end, String pattern) throws ParseException {
	        DateFormat format = new SimpleDateFormat(pattern);
	        Date startDate = format.parse(start);
	        Date endDate = format.parse(end);
	        return getBetweenDays(startDate, endDate);
	    }
	    /**
	     * 得到两个日期的间隔天数
	     * 
	     * @param start
	     * @param end
	     * @param date
	     * @return -1说明开始日期大于结束日期
	     */
	    public static int getBetweenDays(Date start, Date end) {
	        if (start.after(end)) {
	            return -1;
	        }
	        Calendar startC = Calendar.getInstance();
	        startC.setTime(start);
	        Calendar endC = Calendar.getInstance();
	        endC.setTime(end);
	        endC.add(Calendar.DAY_OF_YEAR, 1);
	        int days = 0;
	        do {
	            days++;
	            startC.add(Calendar.DAY_OF_YEAR, 1);
	        } while (startC.before(endC));
	        return days - 1;
	    }
	@Test
	public void test() throws ParseException{
		String s1="2015-06-08 12:12:11";
		String s2="2015-06-30 12:12:11";
		String s3="2018-06-08 12:12:11";
		s1=s1.substring(0, 7);
		System.out.println(s1);
		s2=s2.substring(0, 7);
		System.out.println(s2);
		
		if(s1.equals(s2)){
			System.out.println(111);
		}
	}
	@Test
	public void test2(){
//		String s1="2015-06-30 12:12:12";
//		String s2="2015-06-30 12:12:11";
//		if(s1.compareTo(s2)>0){
//			System.out.println("11");
//		}else{
//			System.out.println("22");
//		}
		
		String s1="2015-07-13";
		String s2="2015-06-30";
		if(s1.compareTo(s2)>0){
			System.out.println("11");
		}else{
			System.out.println("22");
		}
	}
	/**
     * 将格式化的时间字符串转换成时间对象。
     *
     * @param dateStr 格式化的时间字符串
     * @param format  时间字符串格式
     * @return 时间对象
     */
    public Date dateStrToDate(String dateStr, String format) {
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        Assert.notNull(format, "时间格式不能为空！");
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException("转换错误！", e);
        }
    }
    @Test
    public void test5(){
    	String s1="2015-07-13 12:12:12";
		String s2="2015-10-30 12:12:12";
		Date d=dateStrToDate(s2,"yyyy-M-dd HH:mm:ss");
		int m=d.getMonth();
		System.out.println(m+1);
    }
}
