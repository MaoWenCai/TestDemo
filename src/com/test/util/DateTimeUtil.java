package com.test.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang.StringUtils;


/**
 * 日期工具类
 * 
 * @Filename : DateTimeUtil.java
 * @Package : com.chyjr.has.core.util
 * @Description : 海银财富has开发框架
 * @author : Qiulingdong
 * @CreateDate : 2013-4-11
 */
public class DateTimeUtil {
    
    /**
     * 获取某个日期多少个月之前
     * 
     * @param current
     * @param month
     * @return
     */
    public static Date getLastDate(Date current, int month) {
        Calendar c = GregorianCalendar.getInstance();
        c.setTime(current);
        c.add(Calendar.MONTH, -month);
        return c.getTime();
    }

    /**
     * 获取多少个月之前
     * 
     * @param month
     * @return
     */
    public static Date getLastDate(int month) {
        Date current = getCurrentTime();
        return getLastDate(current, month);
    }
    
    /**
     * 工作日往前推
     * 
     * @param date
     * @param day
     * @return
     */
    public static String subWorkDay(String date, int day) {
        WorkDayService workDayService = (WorkDayService) WebContextUtil.getBean("workDayServiceImpl");
        return workDayService.getWorkingDay(date, -day);
    }
    
    /**
     * 工作日往后推几天
     * 
     * @param date
     * @param day
     * @return
     */
    public static String addWorkDay(String date, int day) {
        WorkDayService workDayService = (WorkDayService) WebContextUtil.getBean("workDayServiceImpl");
        return workDayService.getWorkingDay(date, day);
    }
    
    /**
     * 获得当前的系统时间
     * 
     * @return 当前的系统日期
     */
    public static Date getCurrentTime() {
        return new Date();
    }

    /**
     * 获得当前的系统日期，不带有时分秒
     * 
     * @return 当前的系统日期
     */
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

    /**
     * 根据字符串格式日期，返回Date
     * 
     * @param d
     *            Date
     * @return 当前的系统日期
     */
    public static Date getDate(String d) {
        Timestamp ts = Timestamp.valueOf(d);
        return ts;
    }

    /**
     * 得到当前系统日期,格式："yyyy-MM-dd"
     * 
     * @return String
     */
    public static String getCurDate() {
        return getFormatDate(getCurrentDate());
    }

    /**
     * 输出字符串类型的格式化日期 "yyyy-MM-dd"
     * 
     * @param dt
     *            Date
     * @return sDate
     */
    public static String getFormatDate(Date dt) {
        return getFormatDate(dt, FormatConstant.DATE_PATTERN);
    }

    /**
     * 输出字符串类型的格式化时间 yyyy-MM-dd HH:mm:ss
     * 
     * @param dt
     *            Date
     * @return sDate
     */
    public static String getFormatTime(Date dt) {
        return getFormatDate(dt, FormatConstant.TIME_PATTERN);
    }

    /**
     * 输出字符串类型的格式化日期
     * 
     * @param dt
     *            Date
     * @param pattern
     *            时间格式
     * @return sDate
     */
    public static String getFormatDate(Date dt, String pattern) {
        String sDate;
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        sDate = formatter.format(dt);
        return sDate;
    }

    /**
     * 该方法将日期格式化为标准日期格式字符串
     * 
     * @param date
     *            待转化的日期
     * @return 标准日期格式字符串
     */
    public static String getCriterionFormatDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(FormatConstant.DATE_PATTERN);
        format.setLenient(false);
        String strDate = format.format(date);
        return strDate;
    }

    /**
     * 得到指定日期的月份,格式：yyyy-mm-dd
     * 
     * @return String
     */
    public static String getDateMonth(Date date) {

        SimpleDateFormat format1 = new SimpleDateFormat("yyyy'-'MM'-'dd");
        format1.setLenient(false);
        String dateStr = format1.format(date);
        int begin = dateStr.indexOf('-') + 1;
        int end = dateStr.lastIndexOf('-');
        String month = dateStr.substring(begin, end);
        return month;
    }

    /**
     * 得到某一天的开始时间，精确到毫秒
     * 
     * @param date
     *            日期
     * @return 某一天的0时0分0秒0毫秒的那个Date
     */
    public static Date beginOfDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        date = c.getTime();
        return date;
    }

    /**
     * 得到某一天的最后时间，精确到毫秒
     * 
     * @param date
     *            日期
     * @return 某一天的下一天的0时0分0秒0毫秒的那个Date减去1毫秒所得到的Date
     */
    public static Date endOfDay(Date date) {
        date = beginOfDay(date);
        return endOfDayByBeginOfDate(date);
    }

    /**
     * 根据某一天的开始时间，得到某一天的最后时间，精确到毫秒
     * 
     * @param date
     *            日期
     * @return 某一天的下一天的0时0分0秒0毫秒的那个Date减去1毫秒所得到的Date
     */
    public static Date endOfDayByBeginOfDate(Date date) {
        date = nextDay(date);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MILLISECOND, -1);
        date = c.getTime();
        return date;
    }

    /**
     * 得到指定日期后若干天的日期 
     * 
     * @param date
     *            指定日期
     * @param days
     *            天数
     * @return 自指定日期后的若干天的日期
     */
    public static Date afterDaysSinceDate(Date date, int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, days);
        date = c.getTime();
        return date;
    }

    /**
     * 判断两个Date是否在同一天
     * 
     * @param date1
     *            date1
     * @param date2
     *            date2
     * @return 如果两个Date在同一天，则返回true，否则false
     */
    public static boolean isTwoDatesInSameDay(Date date1, Date date2) {
        Date preDate1 = preDay(date1);
        Date nextDate1 = nextDay(date1);
        if (date2.after(preDate1) && date2.before(nextDate1)) {
            return true;
        }
        return false;
    }

    /**
     * 得到指定日期的下一天的开始时间
     * 
     * @param date
     *            指定Date
     * @return 下一天的开始时间
     */
    public static Date beginOfNextDay(Date date) {
        date = nextDay(date);
        return beginOfDay(date);
    }

    /**
     * 得到指定日期的下一天
     * 
     * @param date
     *            日期
     * @return 传入日期的下一天
     */
    public static Date nextDay(Date date) {
        return addDay(date, 1);
    }
    
    /**
     * 指定日期后几天
     * 
     * @param date
     * @param d 往后推的天数
     * @return
     */
    public static Date addDay(Date date, int d) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, d);
        date = c.getTime();
        return date;
    }
    
    /**
     * 指定日期后几天
     * 
     * @param dateStr
     * @param d
     * @return
     * @throws ParseException
     */
    public static Date addDay(String dateStr, int d) throws ParseException {
        Date date = getFormatDate(dateStr);
        return addDay(date, d);
    }

    /**
     * 得到指定日期的前一天
     * 
     * @param date
     *            日期
     * @return 传入日期的前一天
     */
    public static Date preDay(Date date) {
        return subDay(date, 1);
    }

    /**
     * 得到指定日期的前一天
     * 
     * @param date
     *            日期
     * @return 传入日期的前一天
     */
    public static Date preDay(String dateStr) throws ParseException {
        return subDay(dateStr, 1);
    }
    
    /**
     * 指定日期前几天
     * 
     * @param date
     * @param d 往前推的天数
     * @return
     */
    public static Date subDay(Date date, int d) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, -d);
        date = c.getTime();
        return date;
    }

    /**
     * 指定日期前几天
     * 
     * @param dateStr
     * @param d 往前推的天数
     * @return
     */
    public static Date subDay(String dateStr, int d)  throws ParseException {
        Date date = getFormatDate(dateStr);
        return subDay(date, d);
    }

    /**
     * 得到当前月份的下一个月份
     * 
     * @return String
     */
    public static Date addMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, 1);
        date = c.getTime();
        return date;
    }
    
    /**
     * 获得指定日期后的month日期
     * @param date
     * @param month
     * @return
     */
    public static Date addMonth(Date date,int month) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, month);
        date = c.getTime();
        return date;
    }

    /**
     * 得到年份与月份,格式：yyyy-mm
     * 
     * @return String
     */
    public static String getYearMonth(Date date) {
        String yearMonthStr = getCriterionFormatDate(date);
        int index = yearMonthStr.lastIndexOf('-');
        yearMonthStr = yearMonthStr.substring(0, index);
        return yearMonthStr;
    }

    /**
     * 得到当前月的最后一天
     * 
     * @return String
     */
    public static Date getLastDayOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, 1);
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.add(Calendar.DAY_OF_MONTH, -1);
        date = c.getTime();
        return date;
    }

    /**
     * 得到当前月的第一天
     * 
     * @return String
     */
    public static Date getFirstDayOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, 1);
        date = c.getTime();
        return date;
    }

    /**
     * 判断一个日期是否在指定的时间段内
     * 
     * @return String
     */
    public static boolean inTimeSegment(Date start, Date end, Date date) {
        start = preDay(start);
        end = nextDay(end);
        if (date.after(start) && date.before(end)) {
            return true;
        }
        return false;
    }

    /**
     * 判断当前日期是否在指定的时间段内
     * 
     * @param start
     *            时间段开始时间
     * @param end
     *            时间段结束时间
     * @return 如果当前日期在指定时间段内，则为true，否则为false
     */
    public static boolean isCurrentDateInTimeSegment(Date start, Date end) {
        Date date = getCurrentDate();
        if (inTimeSegment(start, end, date)) {
            return true;
        }
        return false;
    }

    /**
     * 得到同一个月内两个日期的间隔天数 备注：可能需要提交到框架作统一处理
     * 
     * @param start
     * @param end
     * @param date
     * @return
     */
    public static int betweenDaysInOneMonth(Date start, Date end) {
        String startStr = getFormatDate(start, "yyyyMMdd");
        String endStr = getFormatDate(end, "yyyyMMdd");
        int days = Integer.parseInt(endStr) - Integer.parseInt(startStr) + 1;
        return days;
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
     * 得到指定月份的天数
     * 
     * @param date
     * @param format
     * @return
     */
    public static int daysInMonth(Date date) {
        Date start = getFirstDayOfMonth(date);
        Date end = getLastDayOfMonth(date);
        int days = betweenDaysInOneMonth(start, end);
        return days;
    }

    /**
     * 判断两个时间段是否存在重叠
     * 
     * @param start1
     *            第一个时间段的开始时间
     * @param end1
     *            第一个时间段的结束时间
     * @param start2
     *            第二个时间段的开始时间
     * @param end2
     *            第二个时间段的结束时间
     * @return 如果存在重叠返回true，否则false
     */
    public static boolean isTimeOverlap(Date start1, Date end1, Date start2, Date end2) {
        if (inTimeSegment(start1, start2, end2) || inTimeSegment(end1, start2, end2)) {
            return true;
        }
        return false;
    }
    
    /**
     * 对比两个日期字符串
     * 
     * @param date1
     * @param date2
     * @return
     * @throws ParseException 
     */
    public static int compare(String date1, String date2) throws ParseException {
        return compare(date1, date2, new SimpleDateFormat("yyyy-MM-dd"));
    }
    
    /**
     * 对比两个日期字符串
     * 
     * @param date1
     * @param date2
     * @param pattern
     * @return
     * @throws ParseException 
     */
    public static int compare(String date1, String date2, String pattern) throws ParseException {
        return compare(date1, date2, new SimpleDateFormat(pattern));
    }

    /**
     * 按天对比日期对象
     * 
     * @param date1
     * @param date2
     * @return
     * @throws ParseException 
     */
    public static int compareDay(Date date1, Date date2) throws ParseException {
        return compare(date1, date2, "yyyy-MM-dd");
    }
    
    /**
     * 对比两个日期对象
     * 
     * @param date0
     * @param date1
     * @return
     * @throws ParseException 
     */
    public static int compare(Date date1, Date date2, String pattern) throws ParseException {
        DateFormat format = new SimpleDateFormat(pattern);
        return compare(format.format(date1), format.format(date2), format);
    }

    /**
     * 对比两个日期字符串
     * 
     * @param date1
     * @param date2
     * @param format
     * @return
     * @throws ParseException 
     */
    public static int compare(String date1, String date2, DateFormat format) throws ParseException {
        Date dt1 = format.parse(date1);
        Date dt2 = format.parse(date2);
        if (dt1.getTime() > dt2.getTime()) {
            return 1;
        } else if (dt1.getTime() < dt2.getTime()) {
            return -1;
        } else {
            return 0;
        }
    }
    
    /**
     * 当前日期与参数日期进行比较，比较天
     * 
     * @param date
     * @return
     * @throws Exception
     */
    public static int compareDay(Date date) throws Exception {
        return getCurrentDate()
                .compareTo(getFormatDate(getFormatDate(date)));
    }
    
    /**
     * 当前日期与参数日期进行比较，比较天
     * 
     * @param dateStr
     * @return
     * @throws Exception
     */
    public static int compareDay(String dateStr) throws Exception {
        Date date = DateTimeUtil.getFormatDate(dateStr);
        return compareDay(date);
    }
    
    /**
     * 把传入的时间和当前的系统时间进行比较，精度控制在天。
     * 
     * @param formmartTimeString
     *            格式化的时间字符串 年月日 ********8位的字符串
     * @return comparedResult 1 传入的时间大于系统当前时间，0相等，-1是小于。
     */
    public static int compareCurrentTime(String formmartTimeString) {
        // TODO 得到当前系统的时间函数需要变更
        Calendar currentTime = Calendar.getInstance();
        Calendar comparedTime = (Calendar) currentTime.clone();
        comparedTime.set(Calendar.YEAR, Integer.parseInt(formmartTimeString.substring(0, 4)));
        comparedTime.set(Calendar.MONTH, Integer.parseInt(formmartTimeString.substring(4, 6)) - 1);
        comparedTime.set(Calendar.DAY_OF_MONTH, Integer.parseInt(formmartTimeString.substring(6, 8)));
        int comparedResult = comparedTime.compareTo(currentTime);
        return comparedResult;
    }

    public static Date getDateFromFormattingString(String dateString) {
        Calendar currentTime = Calendar.getInstance();
        currentTime.set(Calendar.YEAR, Integer.parseInt(dateString.substring(0, 4)));
        currentTime.set(Calendar.MONTH, Integer.parseInt(dateString.substring(5, 7)) - 1);
        currentTime.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateString.substring(8, 10)));
        currentTime.set(Calendar.HOUR_OF_DAY, Integer.parseInt(dateString.substring(11, 13)));
        currentTime.set(Calendar.MINUTE, Integer.parseInt(dateString.substring(14, 16)));
        currentTime.set(Calendar.SECOND, Integer.parseInt(dateString.substring(17, 19)));
        return currentTime.getTime();
    }
    
    public static Date getFormatDateStr(String str) {
        try {
            return DateTimeUtil.getFormatDate(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date getFormatDate(String str) throws ParseException {
        if (str == null || "".equals(str))
            return null;
        if (str.length() <= 10) {
            return getDateByString(str, "yyyy-MM-dd");
        } else {
            return getDateByString(str, "yyyy-MM-dd HH:mm");
        }
    }

    public static Date getDateByString(String str, String pattern) throws ParseException {
        SimpleDateFormat df3 = new SimpleDateFormat();
        df3.applyPattern(pattern);
        return df3.parse(str);
    }

    public static Date addDate(Date date, int num) {
        return new Date(date.getTime() + num * (long) 24 * 3600 * 1000);
    }
    
    /**
     * 根据String年月日，小时返回当前时间
     * 
     * @param date
     * @param hour
     * @return
     * @throws ParseException
     */
    @SuppressWarnings("deprecation")
    public static Date createDate(String date, Long hour) {
        Date result = null;
        if (StringUtils.isNotEmpty(date)) {
            String[] arrs = date.split("-");
            int year = Integer.valueOf(arrs[0]);
            int month = Integer.valueOf(arrs[1]);
            int day = Integer.valueOf(arrs[2]);
            result = new Date(year - 1900, month - 1, day);
        }
        return createDate(result, hour);
    }

    /**
     * 符合本业务的获取时间方法,通过年月日小时生成时间
     * 
     * @param date
     * @param hour
     * @return
     * @throws ParseException
     */
    @SuppressWarnings("deprecation")
    public static Date createDate(Date date, Long hour) {
        Date result = null;
        if (date != null) {
            try {
                result = new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (result != null && hour != null) {
            result.setHours(hour.intValue());
        }
        return result;
    }

    /**
     * 符合本业务的获取时间方法,通过年月日小时生成时间
     * 
     * @param date
     * @param hour
     * @return
     * @throws ParseException
     */
    @SuppressWarnings("deprecation")
    public static Date createDate(Date date, Long hour, Long minute) {
        Date result = null;
        if (date != null) {
            try {
                result = new SimpleDateFormat("yyyy-MM-dd").parse(new SimpleDateFormat("yyyy-MM-dd").format(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (result != null) {
            if (hour != null)
                result.setHours(hour.intValue());
            if (minute != null)
                result.setMinutes(minute.intValue());
        }
        return result;
    }

    /**
     * SQL语句小于时间的转换 比如小于1月1日，sql语句中其实是小于1月2日
     * 
     * @param resourceDate
     * @return
     */
    public static Date getSqlLessDate(Date resourceDate) {
        Calendar c = Calendar.getInstance();
        c.setTime(resourceDate);
        c.add(Calendar.DATE, 1);
        c.clear(Calendar.HOUR);
        c.clear(Calendar.MINUTE);
        c.clear(Calendar.SECOND);
        c.clear(Calendar.MILLISECOND);
        return c.getTime();
    }

    /**
     * 在一个日期推后 days 天 的日期，不包含星期六和星期天
     * 
     * @param date
     * @param days
     * @return
     */
    public static Date addDateIgnoreSaturdaySunday(Date date, long days) {
        if (date != null) {
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            for (int i = 0; i < days;) {
                c.add(Calendar.DATE, 1);
                if (c.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && c.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                    i++;
                }
            }
            date = c.getTime();
        }
        return date;

    }

    /**
     * 输出字符串类型的格式化日期 "yyyyMMdd"
     * 
     * @param dt
     *            Date
     * @return sDate
     */
    public static String getFormatDateStr(Date dt) {
        return getFormatDate(dt, FormatConstant.DATE_PATTERN_STR);
    }

    public static String getCurrentYear(){
        return getFormatDate(new Date(),"YYYY");
    }

}
