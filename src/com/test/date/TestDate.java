package com.test.date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.junit.Test;
import com.test.util.DateUtils;
public class TestDate {
	@Test
	public void test(){
		//以当天为准
		//String day=DateUtils.addDays(2);//20160521
		String day=DateUtils.addDays(-2);//20160517
		System.out.println(day);
	}
	@Test
	public void test2(){
		//以指定日期为准  向前向后推
		String day=DateUtils.calcDays("20160512",2);//20160514
		System.out.println(day);
	}
	@Test
	public void test3(){
		//以指定日期为准  向前向后推
		String day=DateUtils.calcAroundDays("2016-05-12",2);//2016-05-14
		System.out.println(day);
	}
	 /**
     * 判断给定时间在否在给定两个时间之前
     * @throws Exception 
     */
    public boolean compareCurrentDateBetw(String star,String end) throws Exception{
        SimpleDateFormat localTime=new SimpleDateFormat("yyyy-MM-dd");
        try{
            Date sdate = localTime.parse(star);
            Date edate=localTime.parse(end);
            long time = System.currentTimeMillis();
            System.out.println(time+"##"+sdate.getTime()+"##"+edate.getTime());
            if(time>=sdate.getTime()&& time<=edate.getTime()){
                return true;
            }else{
            	return false;
            }
        }catch(Exception e){
        	throw e;
        }
    }
    @Test
	public void test4() throws Exception{
		//以指定日期为准  向前向后推
		String day=DateUtils.calcAroundDays("2016-05-12",2);//2016-05-14
		String s="2016-06-16";
		String e="2016-06-17";
		
		System.out.println(compareCurrentDateBetw(s,e));
	}
    @Test
    public void test5() throws ParseException{
    	String startTime ="2016-07-21 13:12:12";
    	String startTime2 ="2016-07-21 13:12:12";
    	String startTime3 ="2015-07-21 13:12:12";
    	Date s=getDateByString(startTime, "yyyy-MM-dd HH:mm:ss");
    	Date s2=getDateByString(startTime2, "yyyy-MM-dd HH:mm:ss");
    	Date s3=getDateByString(startTime3, "yyyy-MM-dd HH:mm:ss");
		//比较开始时间和系统当前的时间
		Date currentDate=getCurrentTime();
		System.out.println("比较:"+s.compareTo(currentDate));//-1
		System.out.println("比较:"+s.compareTo(s2));//0
		System.out.println("比较:"+s.compareTo(s3));//1
		
		if(s.compareTo(currentDate)<=0){
			s=currentDate;
		}
    }
    public static Date getCurrentTime() {
        return new Date();
    }
    @Test
    public void test6() throws ParseException{
		//比较开始时间和系统当前的时间
    	String startTime ="2016-07-21 12:12:12";
    	Date s=getDateByString(startTime, "yyyy-MM-dd HH:mm:ss");
		Date currentDate=getCurrentTime();
		System.out.println(currentDate+""+s);
    }
    public static Date getDateByString(String str, String pattern) throws ParseException {
        SimpleDateFormat df3 = new SimpleDateFormat();
        df3.applyPattern(pattern);
        return df3.parse(str);
    }
    @Test
    public void test7() throws ParseException{
		//比较开始时间和系统当前的时间
    	String startTime ="2016-07-21";
    	String startTime2 ="2016-07-01";
    	
		System.out.println(startTime.substring(8, 10));//21
		System.out.println(startTime2.substring(8, 10));//01
    }
    @Test
    public void test8() throws ParseException{
		//比较开始时间和系统当前的时间
    	String s1 ="2016-07-21";
    	String s2 ="2016-07-01";
    	String s3 ="2016-07-10";
		System.out.println(s1.compareTo(s2));//2
		System.out.println(s2.compareTo(s3));//-1
		System.out.println(s3.compareTo(s1));//-1
		System.out.println(s3.compareTo(s3));//0
    }
    @Test
    public void test9() throws ParseException{
		//比较开始时间和系统当前的时间
    	String s1 ="2016-07-21 12:12:12";
    	String s2 ="2016-07-01 13:13:13";
    	String s3 ="2016-07-10 14:14:14";
		System.out.println(s1.compareTo(s2));//2
		System.out.println(s2.compareTo(s3));//-1
		System.out.println(s3.compareTo(s1));//-1
		System.out.println(s3.compareTo(s3));//0
    }
    public static Date getCurrentDate() {

        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        c.clear(Calendar.HOUR);
        c.clear(Calendar.MINUTE);
        c.clear(Calendar.SECOND);
        c.clear(Calendar.MILLISECOND);

        date = c.getTime();
        return date;
    }
    @Test
    public void test10(){
    	Date d=getCurrentDate();
    	//Thu Nov 10 18:00:00 CST 2016
    	System.out.println(d);
    }
}
