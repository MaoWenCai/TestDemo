package com.test.time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.springframework.util.Assert;

public class TimeChange {
	@Test
	public void test(){
		Date date = new Date();
		Long time = date.getTime();
		System.out.println(time);

		Date d = new Date(time);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(d));
	}
	//日期转换成秒
	@Test
	public void test2() throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String start="2999-12-31 12:12:12";
		//String end ="2011-10-20 6:30:00";
		//得到毫秒数
		long timeStart=sdf.parse(start).getTime();
		System.out.println(timeStart);//32503608732000
	}
	//秒转换成日期
	@Test
	public void test3(){
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		//long now =32503608732000l;
		//long now =4086589681000l;
		//long now =1468544832995L;
		//long now =1425773107000L;
		//long now =1448945940000L;
		String s= "1448945940000";
		Long now=Long.parseLong(s);
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(now);
		//32503608732000 = 2999-12-31 12:12:12
		//System.out.println(now + " = " + formatter.format(calendar.getTime()));
		//4086589681000 = 2099-07-01 07:48:01
		//System.out.println(now + " = " + formatter.format(calendar.getTime()));
		//1468544832995 = 2016-07-15 09:07:12
		//System.out.println(now + " = " + formatter.format(calendar.getTime()));
		//1425773107000 = 2015-03-08 08:05:07
		//System.out.println(now + " = " + formatter.format(calendar.getTime()));
		//1448945940000 = 2015-12-01 12:59:00
		//System.out.println(now + " = " + formatter.format(calendar.getTime()));
		//1448945940000 = 2015-12-01 12:59:00
		System.out.println(now + " = " + formatter.format(calendar.getTime()));
	}
	@Test
	public void test4() throws ParseException{
		System.out.println(getDateByString("2099-12-12 12:12:12","yyyy-MM-dd HH:mm:ss"));
	}
	public Date getDateByString(String str, String pattern) throws ParseException {
        SimpleDateFormat df3 = new SimpleDateFormat();
        df3.applyPattern(pattern);
        return df3.parse(str);
    }
	public static Date dateStrToDate(String dateStr, String format) {
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
	public void test5() throws ParseException{
		Date d=new Date("1448945940000");
		System.out.println(d);
		//System.out.println(dateStrToDate("2099-12-12 12:12:12","yyyy-MM-dd HH:mm:ss"));
	}
}
