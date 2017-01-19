package com.test.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;

import java.text.*;
import java.util.*;

public class DateUtils {

    /**
     * 日期格式(yyyy)
     */
    public static final String DATE_PATTERN_YYYY = "yyyy";

    /**
     * 日期格式(MM)
     */
    public static final String DATE_PATTERN_MM = "MM";

    /**
     * 日期格式(dd)
     */
    public static final String DATE_PATTERN_DD = "dd";

    /**
     * 日期格式(yyyyMM)
     */
    public static final String DATE_PATTERN_YYYYMM = "yyyyMM";

    /**
     * 日期格式(yyyyMMdd)
     */
    public static final String DATE_PATTERN_YYYYMMDD = "yyyyMMdd";

    /**
     * 日期格式(yyyyMMddHHmm)
     */
    public static final String DATE_PATTERN_YYYYMMDDHHmm = "yyyyMMddHHmm";

    /**
     * 日期格式(yyyyMMddHHmmss)
     */
    public static final String DATE_PATTERN_YYYYMMDDHHmmss = "yyyyMMddHHmmss";

    public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";

    @Deprecated
    public static final String DEFAULT_TIME_FORMAT_TWO = "HHmmss";

    public static final String DATE_PATTERN_HHmmss = "HHmmss";

    /**
     * 日期格式(yyyy-MM)
     */
    public static final String DATE_PATTERN_YYYYMM_2 = "yyyy-MM";

    /**
     * 日期格式(yyyy-MM-dd)
     */
    public static final String DATE_PATTERN_YYYYMMDD_2 = "yyyy-MM-dd";

    /**
     * 日期格式(yyyy-MM-dd HH:mm)
     */
    public static final String DATE_PATTERN_YYYYMMDDHHmm_2 = "yyyy-MM-dd HH:mm";

    /**
     * 日期格式(yyyy-MM-dd HH:mm:ss)
     */
    public static final String DATE_PATTERN_YYYYMMDDHHmmss_2 = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期格式(yyyy年MM月)
     */
    public static final String DATE_PATTERN_YYYYMM_3 = "yyyy年MM月";

    /**
     * 日期格式(yyyy年MM月dd日)
     */
    public static final String DATE_PATTERN_YYYYMMDD_3 = "yyyy年MM月dd日";

    /**
     * 日期格式(yyyy年MM月dd日 HH时mm分)
     */
    public static final String DATE_PATTERN_YYYYMMDDHHmm_3 = "yyyy年MM月dd日 HH时mm分";

    /**
     * 日期格式(yyyy年MM月dd日 HH时mm分ss秒)
     */
    public static final String DATE_PATTERN_YYYYMMDDHHmmss_3 = "yyyy年MM月dd日 HH时mm分ss秒";

    /**
     * 中文星期转换为英文缩写的Map
     */
    public static final Map<String, String> weekDayCNToSENMap = new HashMap<String, String>();

    public static final Map<String, String> weekDaySENToCNMap = new HashMap<String, String>();

    static {
        initialize();
    }

    /**
     * 将时间字串从原来的格式转成新的格式
     *
     * @param dateStr   时间字符串
     * @param oldFormat 原始格式
     * @param newFormat 新格式
     * @return 转换后的时间字符串
     */
    public static String dateStrToNewFormat(String dateStr, String oldFormat,
                                            String newFormat) {
        if (StringUtils.isEmpty(dateStr))
            return dateStr;
        SimpleDateFormat fromFormat = new SimpleDateFormat(oldFormat);
        try {
            return formatDate(fromFormat.parse(dateStr), newFormat);
        } catch (ParseException e) {
            throw new RuntimeException("转换错误！", e);
        }
    }

    /**
     * 将格式化的时间字符串转换成时间对象。
     *
     * @param dateStr 格式化的时间字符串
     * @param format  时间字符串格式
     * @return 时间对象
     */
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

    /**
     * 指定时间格式，格式化指定时间，取得格式化字符串。
     *
     * @param date   日期
     * @param format 格式
     * @return 日期
     */
    public static String formatDate(Date date, String format) {
        if (null == date) {
            return null;
        }
        SimpleDateFormat sdFromat = new SimpleDateFormat(format);
        return sdFromat.format(date);
    }

    /**
     * 得到当前是当年的第几周；格式：yyyyWW
     *
     * @return
     */
    public static String getCurrentWeekOfYear() {
//        Calendar c = Calendar.getInstance();
//        int week = c.get(Calendar.WEEK_OF_YEAR);// 获取是本月的第几周
//        
//        if(c.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY) {
//        	week--;
//        }
//        
//        String strWeek = week < 10 ? "0" + week : "" + week;
//
//        return formatCurrentDate(DATE_PATTERN_YYYY) + strWeek;
        return getCurrentWeekOfYear(formatCurrentDate(DATE_PATTERN_YYYYMMDD));
    }

    /**
     * 得到当前是当年的第几周；格式：yyyyWW
     *
     * @return
     */
    public static String getCurrentWeekOfYear(String date) {
        Calendar c = Calendar.getInstance();
        c.setTime(dateStrToDate(date, DATE_PATTERN_YYYYMMDD));

        int week = c.get(Calendar.WEEK_OF_YEAR);// 获取是本月的第几周

        //如果是周日,应该周数-1
        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            week--;
        }

        //如果当年的1/1是周日,则周数+1
        c.setTime(dateStrToDate(date.substring(0, 4) + "0101", DATE_PATTERN_YYYYMMDD));
        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            week++;
        }

        String strWeek = week < 10 ? "0" + week : "" + week;

        return formatCurrentDate(DATE_PATTERN_YYYY) + strWeek;
    }

    /**
     * 得到当前月份是当年的第几季度；格式：yyyyQQ
     *
     * @return
     */
    public static String getCurrentQuarterOfYear() {
        Calendar c = Calendar.getInstance();
        int month = c.get(Calendar.MONTH) + 1;// 获取当前月,注意这里要加1,计算机第一个月从0开始

        String strQuarter = "";
        if (month <= 3)
            strQuarter = "01";
        if (month >= 4 && month <= 6)
            strQuarter = "02";
        if (month >= 7 && month <= 9)
            strQuarter = "03";
        if (month >= 10)
            strQuarter = "04";

        return formatCurrentDate(DATE_PATTERN_YYYY) + strQuarter;
    }

    /**
     * 指定时间格式，格式化当前时间，取得格式化字符串。
     *
     * @param format 时间格式
     * @return String
     */
    public static String formatCurrentDate(String format) {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        return formatDate(date, format);
    }

    /**
     * 获得当前时间
     *
     * @return
     */
    public static Date getCurrentDate() {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        return date;
    }

    public static String getCurrentTimeOfDb() {
        return formatCurrentDate(DATE_PATTERN_YYYYMMDDHHmmss);
    }

    public static String getCurrentDateOfDb() {
        return formatCurrentDate(DATE_PATTERN_YYYYMMDD_2);
    }

    /**
     * 取得指定年份中某月的天数
     *
     * @param year
     * @param month
     * @return 指定年份中某月的天数
     */
    public static int getDaysOfMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 傅相奎添加
     *
     * @param X
     * @return Date 获得X分钟后的时间
     */
    public static Date getXminLate(int X) {
        Long now = new Date().getTime();
        Long xmin = Long.valueOf(X * 60 * 1000);
        return new Date(now + xmin);

    }

    /**
     * 傅相奎添加
     *
     * @param dateId 字符串数字 20090324
     * @return 20090301
     */
    public static String getFirstDay(Long dateId) {
        String date = "" + dateId;
        return date.substring(0, date.length() - 2) + "01";
    }

    /**
     * 傅相奎添加
     *
     * @param date
     * @return 获得当前月的第一天
     * 这个只支持YYMMDD的啊
     */
    public static String getFirstDayOfMonth(String date) {
        if (null == date || "".equals(date)) {

            String d = getCurrentDateOfDb();
            return d.substring(0, d.length() - 2) + "01";

        } else {

            return date.substring(0, date.length() - 2) + "01";
        }

    }

    /**
     * @param date 格式YYMMDD
     * @return 获得当某天的所在月最后一天
     */
    public static String getLastDayOfMonth(String date) {
        String d = date;
        if (null == date || "".equals(date)) {
            d = getCurrentDateOfDb();
        }
        d = d.substring(0, d.length() - 2) + "01";
        Date first = DateUtils.stringToDateYYYYMMDD2(d);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(first);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DATE, -1);
        return formatDate(calendar.getTime(), DATE_PATTERN_YYYYMMDD_2);
    }

    /**
     * 取指定的日期加天数,若天数为负值，则向前推算，若为正
     * <p/>
     * 数，则向后推算。
     *
     * @param days 天数
     * @return 日期
     */
    public static String addDays(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, days);
        return formatDate(calendar.getTime(), DATE_PATTERN_YYYYMMDD);
    }

    /* 在指定的日期字符串上添加，减少指定的天数 jackey */
    public static String calcDays(String dateStr, int days) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                DATE_PATTERN_YYYYMMDD);
        Date dt = null;
        try {
            dt = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dt);
        calendar.add(Calendar.DATE, days);
        return formatDate(calendar.getTime(), DATE_PATTERN_YYYYMMDD);
    }
    /**
     * 指定日期前后的日期
     * @param dateStr
     * @param days
     * @return 
     */
    public static String calcAroundDays(String dateStr, int days) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
        		DATE_PATTERN_YYYYMMDD_2);
        Date dt = null;
        try {
            dt = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dt);
        calendar.add(Calendar.DATE, days);
        return formatDate(calendar.getTime(), DATE_PATTERN_YYYYMMDD_2);
    }

    /**
     * 给指定时间添加或减少天数。返回修改后的时间字符串。
     *
     * @param date   时间。
     * @param days   添加或减少的天数。
     * @param format 格式化字符串。
     * @return 修改后的时间字符串。
     * @author aijs
     */
    public static String addDays(Date date, int days, String format) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(calendar.getTime());
    }

    /**
     * 给指定时间添加或减少天数。返回修改后的时间字符串。
     * 返回的时间应该属于工作日(如果是加天数的话，则向前推；如果是减去天数的话，则向后推)
     *
     * @param date：当前日期
     * @param days：要加的天数或要减少的天数
     * @param returnFormat：返回日期字符串的格式
     * @return 日期字符串
     */
    public static String addWorkDays(Date date, int days, String returnFormat) {
        if (0 == days) {
            return formatDate(date, returnFormat);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        int num = days > 0 ? 1 : -1;
        while (isWeekend(calendar.getTime())) {
            calendar.add(Calendar.DATE, num);
        }
        return formatDate(calendar.getTime(), returnFormat);
    }

    /**
     * 给指定时间添加或减少天数。返回修改后的时间字符串。
     * 返回的时间应该属于工作日(如果是加天数的话，则向前推；如果是减去天数的话，则向后推)
     *
     * @param dateStr
     * @param days
     * @param paramFormat
     * @param returnFormat
     * @return
     */
    public static String addWorkDays(String dateStr, int days, String paramFormat, String returnFormat) {
        Date date = dateStrToDate(dateStr, paramFormat);
        return addWorkDays(date, days, returnFormat);
    }

    /**
     * 给指定时间添加或减少分钟。返回修改后的时间字符串。
     *
     * @param date    时间。
     * @param minutes 添加或减少的分钟。
     * @param format  格式化字符串。
     * @return 修改后的时间字符串。
     * @author aijs
     */
    public static String addMinutes(Date date, int minutes, String format) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minutes);
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                format);
        return dateFormat.format(calendar.getTime());
    }

    /**
     * 给指定时间添加或减少秒。返回修改后的时间字符串。
     *
     * @param date    时间。
     * @param minutes 添加或减少的秒。
     * @param format  格式化字符串。
     * @return 修改后的时间字符串。
     * @author chenfy
     */
    public static String addSecond(Date date, int seconds, String format) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, seconds);
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                format);
        return dateFormat.format(calendar.getTime());
    }

    /* 在指定的日期字符串上添加，减少指定的秒数 jackey */
    public static String calcSecond(String dateStr, int second) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                DATE_PATTERN_YYYYMMDDHHmmss);
        Date dt = null;
        try {
            dt = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dt);
        calendar.add(Calendar.SECOND, second);
        return formatDate(calendar.getTime(), DATE_PATTERN_YYYYMMDDHHmmss);
    }

    /* 比较两个日期字符串的值 前大于后值为 1 ；后大于前值为-1 ；两者相等值为 0 */
    public static int compareDate(String startDate, String endDate, String paramDateFormat) {
        paramDateFormat = StringUtils.isBlank(paramDateFormat) ? DATE_PATTERN_YYYYMMDD : paramDateFormat;
        SimpleDateFormat dateFormat = new SimpleDateFormat(paramDateFormat);
        Date sDate = null;
        Date eDate = null;
        try {
            sDate = dateFormat.parse(startDate);
            eDate = dateFormat.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sDate.compareTo(eDate);
    }

    /* 比较两个日期字符串的值 前大于后值为 1 ；后大于前值为-1 ；两者相等值为 0 */
    public static int compareDateTime(String startDateTime, String endDateTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                DATE_PATTERN_YYYYMMDDHHmmss);
        Date sDateTime = null;
        Date eDateTime = null;
        try {
            sDateTime = dateFormat.parse(startDateTime);
            eDateTime = dateFormat.parse(endDateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sDateTime.compareTo(eDateTime);
    }

    public static int compareTime(String startTime, String endTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                DEFAULT_TIME_FORMAT_TWO);
        Date sTime = null;
        Date eTime = null;
        try {
            sTime = dateFormat.parse(startTime);
            eTime = dateFormat.parse(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sTime.compareTo(eTime);
    }

    public static Date stringToDateYYYYMMDD2(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                DATE_PATTERN_YYYYMMDD_2);
        Date dt = null;
        try {
            dt = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dt;
    }

    public static Date StringToDate(String dateStr, String dtFormat) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                dtFormat);
        Date dt = null;
        try {
            dt = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dt;
    }

    public static Date StringToDateYYYYMMDDHHmmss(String dateTimeStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                DATE_PATTERN_YYYYMMDDHHmmss);
        Date dt = null;
        try {
            dt = dateFormat.parse(dateTimeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dt;
    }

    /**
     * @param mss 要转换的毫秒数
     * @return 该毫秒数转换为 * hours * minutes * seconds 后的格式
     * @author jackeyQing
     */
    public static String LongTohms(long mss) {
        if (mss < 1000) {
            return mss + "";
        }
        long days = mss / (1000 * 60 * 60 * 24);
        long hours = (mss % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
        long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60);
        long seconds = (mss % (1000 * 60)) / 1000;
        // 返回格式
        // 00:00:00
        return hours + ":" + minutes + ":" + seconds;
    }

    /**
     * @param mss 要转换的毫秒数
     * @return 该毫秒数转换为 * hours * minutes * seconds 后的格式
     * @author jackeyQing
     */
    public static String LongToHMString(long mss) {
        if (mss < 1000) {
            String str = formatDigit(Long.toString(mss), 6);
            str = str.replaceAll(",", "");
            return str;
        }
        long days = mss / (1000 * 60 * 60 * 24);
        long hours = (mss % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
        long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60);
        long seconds = (mss % (1000 * 60)) / 1000;
        // 返回格式
        // 000000前两位为小时，中间两位为分钟，后两位为秒
        return formatDigit(Long.toString(hours), 2)
                + formatDigit(Long.toString(minutes), 2)
                + formatDigit(Long.toString(seconds), 2);
    }

    /**
     * @param mss 要转换的毫秒数
     * @return 该毫秒数转换为 * hours * minutes * seconds 后的格式
     * @author jackeyQing
     */
    public static String LongToDHMSString(long mss) {
//        if (mss < 1000) {
//            String str = formatDigit(Long.toString(mss), 6);
//            str = str.replaceAll(",", "");
//            return str;
//        }
        long days = mss / (1000 * 60 * 60 * 24);
        long hours = (mss % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
        long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60);
        long seconds = (mss % (1000 * 60)) / 1000;
        long ms = mss % 1000;

        // 返回格式
        // 000000前两位为小时，中间两位为分钟，后两位为秒
        return days
                + "D " + formatDigit(Long.toString(hours), 2)
                + ":" + formatDigit(Long.toString(minutes), 2)
                + ":" + formatDigit(Long.toString(seconds), 2)
                + "." + formatDigit(Long.toString(ms), 3);
    }

    /*
      * jackey 2010.09.16
      * 
      * 格式化数字字符串的位数
      * 
      * param :numberStr数字字符串
      * 
      * param :digit格式化后的位数
      */
    public static String formatDigit(String numberStr, int digit) {
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMinimumIntegerDigits(digit);
        return formatter.format(Integer.parseInt(numberStr));
    }

    /*
      * 取得日期字符串的毫秒数
      * 
      * param :dateStr日期字符串
      * 
      * param :format格式化
      */
    public static long StringToLong(String dateStr, String format) {
        Date dt = dateStrToDate(dateStr, format);
        if (dt == null) {
            return 0;
        }
        return dt.getTime();
    }

    /**
     * 获得昨天的日期
     *
     * @return
     */
    public static Date getYesterday() {
        return new Date(new Date().getTime() - 24 * 3600 * 1000);
    }

    /**
     * 获得上个月昨天的日期
     *
     * @return
     */
    public static Date getLastMonthYesterday(String date) {

        if (null == date || "" == date) {
            GregorianCalendar aGregorianCalendar = new GregorianCalendar();

            aGregorianCalendar.set(Calendar.MONTH, aGregorianCalendar
                    .get(Calendar.MONTH) - 1);

            return new Date(
                    aGregorianCalendar.getTime().getTime() - 24 * 3600 * 1000);

        } else {

            return getMonthTongqi(date);

        }

    }

    /**
     * 得到上月同期的时间
     *
     * @param datetime
     * @return
     */
    public static Date getMonthTongqi(String datetime) {
        Calendar rightNow = Calendar.getInstance();
        Date date = new Date();

        // 由传入的时间计算上月天数
        date = stringToDateYYYYMMDD2(datetime);
        rightNow.setTime(date);
        rightNow.add(Calendar.MONTH, -1);
        rightNow.set(Calendar.DATE, 1);
        rightNow.roll(Calendar.DATE, -1);
        String str = formatDate(rightNow.getTime(), DATE_PATTERN_YYYYMMDD_2);
        int d = Integer.parseInt(str.substring(8, 10));

        // 重新读入时间，知道回滚多少天
        rightNow.setTime(date);
        rightNow.add(Calendar.MONTH, -1);
        rightNow.roll(Calendar.DATE, -d);// 得到上月同期日期。
        return new Date(rightNow.getTime().getTime());

    }

    /**
     * 获得去年的昨天这个时间
     *
     * @return
     */
    public static Date getLastYearYesterday(String date) {

        if (null == date || "" == date) {
            GregorianCalendar aGregorianCalendar = new GregorianCalendar();
            aGregorianCalendar.set(Calendar.YEAR, aGregorianCalendar
                    .get(Calendar.YEAR) - 1);
            return new Date(
                    aGregorianCalendar.getTime().getTime() - 24 * 3600 * 1000);

        } else {

            return getYearTongqi(date);

        }
    }

    /**
     * 获得三个月前的当天
     *
     * @param d
     * @return
     */
    public static String getThreeMonthsAgo(Date d) {

        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(Calendar.MONTH, -3);
        d = c.getTime();
        return formatDate(d, DATE_PATTERN_YYYYMMDD);

    }

    /**
     * 得到去年同期的一天
     *
     * @param datetime
     * @return
     */
    public static Date getYearTongqi(String datetime) {

        Calendar rightNow = Calendar.getInstance();
        Date date = new Date();

        // 由传入的时间计算上年天数
        date = stringToDateYYYYMMDD2(datetime);
        rightNow.setTime(date);
        rightNow.add(Calendar.YEAR, -1);
        rightNow.set(Calendar.DATE, 1);
        rightNow.roll(Calendar.DATE, -1);
        String str = formatDate(rightNow.getTime(), DATE_PATTERN_YYYYMMDD_2);
        int d = Integer.parseInt(str.substring(8, 10));

        // 重新读入时间，知道回滚多少天
        rightNow.setTime(date);
        rightNow.add(Calendar.YEAR, -1);
        rightNow.roll(Calendar.DATE, -d);// 得到去年同期日期。
        return new Date(rightNow.getTime().getTime());

    }

    public static String getYear(Date date) {

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return "" + c.get(Calendar.YEAR);

    }

    public static String getMonth(Date date) {

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return "" + (c.get(Calendar.MONTH) + 1);

    }

    /**
     * 获取指定日期的月份
     *
     * @param dateStr
     * @return
     * @author zhouj
     */
    public static String getMonth(String dateStr) {
        Date date = DateUtils.dateStrToDate(dateStr, DateUtils.DATE_PATTERN_YYYYMMDD);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return "" + (c.get(Calendar.MONTH) + 1);

    }

    public static String getDay(Date date) {

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return "" + c.get(Calendar.DAY_OF_MONTH);

    }

    /**
     * 获取指定日期的日
     *
     * @param dateStr
     * @return
     * @author zhouj
     */
    public static String getDay(String dateStr) {
        Date date = DateUtils.dateStrToDate(dateStr, DateUtils.DATE_PATTERN_YYYYMMDD);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return "" + c.get(Calendar.DAY_OF_MONTH);

    }

    public static String getHour(Date date) {

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return "" + c.get(Calendar.HOUR_OF_DAY);

    }

    public static String getMinute(Date date) {

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return "" + c.get(Calendar.MINUTE);

    }

    public static String getSecond(Date date) {

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return "" + c.get(Calendar.SECOND);

    }

    public static String getYear() {
        Calendar ca = Calendar.getInstance();
        ca.setTime(new Date());
        String year = "" + ca.get(Calendar.YEAR);
        return year;
    }

    public static String getMonthqianqi(String startDate) {
        Date d = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dateStrToDate(startDate, DATE_PATTERN_YYYYMMDD));
        c.add(Calendar.MONTH, -2);
        d = c.getTime();
        return formatDate(d, DATE_PATTERN_YYYYMMDD);

    }

    /**
     * 给指定时间添加或减少天数。返回修改后的时间字符串。
     *
     * @param date   时间。
     * @param days   添加或减少的天数。
     * @param format 格式化字符串。
     * @return 修改后的时间字符串。
     * @author aijs
     */
    public static Date addMonths(Date date, int months) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, months);

        return calendar.getTime();
    }

    public static String addMonth(String dataStr, int months) {
        Date date = dateStrToDate(dataStr, DATE_PATTERN_YYYYMMDD_2);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, months);

        return formatDate(calendar.getTime(), DATE_PATTERN_YYYYMMDD_2);
    }


    public static String getEndDayOfMonth(String startDate) {

        Date d = dateStrToDate(startDate, DATE_PATTERN_YYYYMMDD_2);

        Date d2 = addMonths(d, 1);

        Date d3 = dateStrToDate(getFirstDayOfMonth(formatDate(d2, DATE_PATTERN_YYYYMMDD_2)), DATE_PATTERN_YYYYMMDD_2);

        return addDays(d3, -1, DATE_PATTERN_YYYYMMDD_2);
    }

    /**
     * 取得date所在周的周一
     *
     * @param date
     * @return
     */
    public static String getMondayOfWeek(String date) {
        return formatDate(
                getMondayOfWeek(dateStrToDate(date, DATE_PATTERN_YYYYMMDD))
                , DATE_PATTERN_YYYYMMDD);
    }

    /**
     * 取得date所在周的周一
     *
     * @param date
     * @return
     */
    public static Date getMondayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == Calendar.SUNDAY) {
            calendar.add(Calendar.DATE, -6);
        } else {
            calendar.add(Calendar.DATE, -(dayOfWeek - 2));
        }
        return calendar.getTime();
    }

    /**
     * 取得date所在周的周日
     *
     * @param date
     * @return
     */
    public static String getSundayOfWeek(String date) {
        return formatDate(
                getSundayOfWeek(dateStrToDate(date, DATE_PATTERN_YYYYMMDD))
                , DATE_PATTERN_YYYYMMDD);
    }

    public static Date getSundayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == Calendar.SUNDAY) {

        } else {
            calendar.add(Calendar.DATE, 7 - (dayOfWeek - 1));
        }
        return calendar.getTime();
    }

    /**
     * 取得指定日期的昨天(前一天)
     *
     * @param dateStr
     * @return
     * @author zhouj
     */
    public static String getYesterday(String dateStr) {
        Date date = dateStrToDate(dateStr, DATE_PATTERN_YYYYMMDD);
        return formatDate(
                new Date(date.getTime() - 24 * 3600 * 1000)
                , DATE_PATTERN_YYYYMMDD);
    }

    public static Date getYesterday(Date date) {
        Date date2 = new Date(date.getTime() - 24 * 3600 * 1000);
        return date2;
    }

    /**
     * 获得某月的最后一天
     *
     * @param year
     * @param month
     * @return
     * @author zhouj
     */
    public static String getLastDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DATE));
        return new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
    }

    /**
     * 获得某月的第一天
     *
     * @param year
     * @param month
     * @return
     * @author zhouj
     */
    public static String getFirstDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, cal.getMinimum(Calendar.DATE));
        return new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
    }

    /**
     * 返回去年的同期日期
     *
     * @param date
     * @return
     */
    public static Date getDayOfLastYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.add(Calendar.YEAR, -1);
        return calendar.getTime();
    }

    /**
     * 返回去年的同期日期
     *
     * @param date
     * @return
     */
    public static String getDayOfLastYear(String date) {

        return formatDate(
                getDayOfLastYear(dateStrToDate(date, DATE_PATTERN_YYYYMMDD))
                , DATE_PATTERN_YYYYMMDD);
    }

    /**
     * 返回同比日期
     *
     * @param date
     * @return
     */
    public static Date getCompDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        calendar.add(Calendar.YEAR, -1);
        int compDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek > compDayOfWeek) {
            calendar.add(Calendar.DATE, dayOfWeek - compDayOfWeek);
        } else {
            calendar.add(Calendar.DATE, dayOfWeek - compDayOfWeek + 7);
        }
        return calendar.getTime();
    }

    public static String getCompDate(String date) {
        return formatDate(
                getCompDate(dateStrToDate(date, DATE_PATTERN_YYYYMMDD))
                , DATE_PATTERN_YYYYMMDD);
    }

    /**
     * 返回环比日期
     *
     * @param date
     * @return
     */
    public static Date getCpriorDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -7);

        return calendar.getTime();
    }

    public static String getCpriorDate(String date) {
        return formatDate(
                getCpriorDate(dateStrToDate(date, DATE_PATTERN_YYYYMMDD))
                , DATE_PATTERN_YYYYMMDD);
    }

    public static Date[] getCompWeek(Date date) {
        Date compDate = getCompDate(date);
        Date monday = DateUtils.getMondayOfWeek(compDate);
        return new Date[]{monday, compDate};
    }

    public static String[] getCompWeek(String date) {
        Date[] compWeek = getCompWeek(dateStrToDate(date, DATE_PATTERN_YYYYMMDD));
        return new String[]{formatDate(compWeek[0], DATE_PATTERN_YYYYMMDD)
                , formatDate(compWeek[1], DATE_PATTERN_YYYYMMDD)};
    }

    public static Date[] getCpriorWeek(Date date) {
        Date compDate = getCpriorDate(date);
        Date monday = DateUtils.getMondayOfWeek(compDate);
        return new Date[]{monday, compDate};
    }

    public static String[] getCpriorWeek(String date) {
        Date[] compWeek = getCpriorWeek(dateStrToDate(date, DATE_PATTERN_YYYYMMDD));
        return new String[]{formatDate(compWeek[0], DATE_PATTERN_YYYYMMDD)
                , formatDate(compWeek[1], DATE_PATTERN_YYYYMMDD)};
    }

    public static Date[] getCompMonth(Date date) {
        String[] compMonth = getCompMonth(formatDate(date, DATE_PATTERN_YYYYMMDD));

        return new Date[]{dateStrToDate(compMonth[0], DATE_PATTERN_YYYYMMDD)
                , dateStrToDate(compMonth[1], DATE_PATTERN_YYYYMMDD)};
    }

    public static Date[] getCompYear(Date date) {
        String[] compYear = getCompYear(formatDate(date, DATE_PATTERN_YYYYMMDD));

        return new Date[]{dateStrToDate(compYear[0], DATE_PATTERN_YYYYMMDD)
                , dateStrToDate(compYear[1], DATE_PATTERN_YYYYMMDD)};
    }


    public static String[] getCompMonth(String date) {
        String dayOfLastYear = getDayOfLastYear(date);

        return new String[]{
                dayOfLastYear.subSequence(0, 6) + "01"
                , dayOfLastYear
        };
    }

    public static String[] getCompYear(String date) {
        String dayOfLastYear = getDayOfLastYear(date);

        return new String[]{
                dayOfLastYear.subSequence(0, 4) + "0101"
                , dayOfLastYear
        };
    }

    /**
     * 取得2个日期间的间隔天数，即d1+?=d2
     *
     * @param d1
     * @param d2
     * @return
     */
    public static long getDaysDiff(Date d1, Date d2) {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(d1);
        Calendar c2 = Calendar.getInstance();
        c2.setTime(d2);

        return getDaysDiff(c1, c2);
    }

    /**
     * 取得2个日期间的间隔天数，即d1+?=d2
     *
     * @param d1
     * @param d2
     * @return
     */
    public static long getDaysDiff(Calendar d1, Calendar d2) {
        if (d1.after(d2)) {
            Calendar swap = d1;
            d1 = d2;
            d2 = swap;
        }
        long days = d2.get(Calendar.DAY_OF_YEAR)
                - d1.get(Calendar.DAY_OF_YEAR);
        long y2 = d2.get(Calendar.YEAR);
        if (d1.get(Calendar.YEAR) != y2) {
            d1 = (Calendar) d1.clone();
            do {
                days += d1.getActualMaximum(Calendar.DAY_OF_YEAR);
                d1.add(Calendar.YEAR, 1);
            } while (d1.get(Calendar.YEAR) != y2);
        }
        return days;
    }

    /**
     * 获得指定日期是星期几（中文）
     * 参数格式需为：YYYYMMDD
     *
     * @return 星期（中文）
     * @author zhouj
     */
    public static String getWeekOfDate(String date) {
        Date dt = dateStrToDate(date, DateUtils.DATE_PATTERN_YYYYMMDD);
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);

        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;

        return weekDays[w];
    }

    /**
     * 判断给定的日期是否是周末
     *
     * @param date
     * @return
     */
    public static boolean isWeekend(Date date) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        if ("星期日".equals(weekDays[w]) || "星期六".equals(weekDays[w])) {
            return true;
        }
        return false;
    }

    /**
     * 判断给定的日期字符是否为周末
     *
     * @param dateStr:日期字符串
     * @param dateStrFormat：日期字符串格式
     * @return
     */
    public static boolean isWeekend(String dateStr, String dateStrFormat) {
        Date dt = dateStrToDate(dateStr, dateStrFormat);
        return isWeekend(dt);
    }

    /**
     * 获得当前天是星期几（中文）
     *
     * @return 星期（中文）
     */
    public static String getCurrentWeekDayCN() {
        Date d = new Date();
        DateFormat df = new SimpleDateFormat("E", Locale.CHINESE);
        String s = df.format(d);
        return s;
    }

    /**
     * 获得当前天是星期几（英文缩写）
     *
     * @return 星期（英文缩写）
     */
    public static String getCurrentWeekDaySEN() {
        return weekDayCNToSENMap.get(getCurrentWeekDayCN());
    }

    public static String getCNWeekDayBySEN(String enAbbreviate) {
        return weekDaySENToCNMap.get(enAbbreviate);
    }

    /**
     * 初始化
     */
    private static void initialize() {
        if (weekDayCNToSENMap.size() == 0) {
            weekDayCNToSENMap.put("星期一", "MON");
            weekDayCNToSENMap.put("星期二", "TUE");
            weekDayCNToSENMap.put("星期三", "WED");
            weekDayCNToSENMap.put("星期四", "THU");
            weekDayCNToSENMap.put("星期五", "FRI");
            weekDayCNToSENMap.put("星期六", "SAT");
            weekDayCNToSENMap.put("星期日", "SUN");

            weekDayCNToSENMap.put("Monday", "MON");
            weekDayCNToSENMap.put("Tuesday", "TUE");
            weekDayCNToSENMap.put("Wednesday", "WED");
            weekDayCNToSENMap.put("Thursday", "THU");
            weekDayCNToSENMap.put("Friday", "FRI");
            weekDayCNToSENMap.put("Saturday", "SAT");
            weekDayCNToSENMap.put("Sunday", "SUN");
        }
        if (weekDaySENToCNMap.size() == 0) {
            weekDaySENToCNMap.put("MON", "星期一");
            weekDaySENToCNMap.put("TUE", "星期二");
            weekDaySENToCNMap.put("WED", "星期三");
            weekDaySENToCNMap.put("THU", "星期四");
            weekDaySENToCNMap.put("FRI", "星期五");
            weekDaySENToCNMap.put("SAT", "星期六");
            weekDaySENToCNMap.put("SUN", "星期日");
        }
    }

    /**
     * 获得时间的默认格式：HH:mm:ss
     *
     * @param dateStr 事件字符串
     * @return 带格式的事件字符串
     */
    public static String getDefaultTimeFormatStr(String dateStr) {
        return DateUtils.formatDate(DateUtils.dateStrToDate(dateStr, DateUtils.DATE_PATTERN_HHmmss), DateUtils.DEFAULT_TIME_FORMAT);
    }

    /**
     * 获得当前时分秒的字符串 如：103000表示10点30分0秒
     *
     * @return 时间字符串
     */
    public static String getCurrentTimeStr() {
        return DateUtils.formatDate(new Date(), DateUtils.DATE_PATTERN_HHmmss);
    }

    /**
     * 将日期字符串转换为带格式的字符串
     * 如：20110708102500 转换为2011-07-08 10:25:00
     *
     * @param dateStr 要转换的日期字符串
     * @return 转换后的字符串
     */
    public static String getDefaultDateTimeFormatStr(String dateStr) {
        return DateUtils.formatDate(DateUtils.dateStrToDate(dateStr, DateUtils.DATE_PATTERN_YYYYMMDDHHmmss), DateUtils.DATE_PATTERN_YYYYMMDDHHmmss_2);
    }

    /**
     * 获得两个格式为YYYYMMDD的日期的相差天数。endDate-startDate的差
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static Long getDiffDays(String startDate, String endDate) {

        Date sDate = DateUtils.StringToDate(startDate, DATE_PATTERN_YYYYMMDD_2);
        Date eDate = DateUtils.StringToDate(endDate, DATE_PATTERN_YYYYMMDD_2);
        return (eDate.getTime() - sDate.getTime()) / (1000 * 60 * 60 * 24);

    }

    /**
     * 获得两个格式为YYYYMMDD的日期的相差天数。endDate-startDate的差
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static Long getDiffMinutes(String startTime, String endTime) {

        Date sDate = DateUtils.StringToDateYYYYMMDDHHmmss(startTime);
        Date eDate = DateUtils.StringToDateYYYYMMDDHHmmss(endTime);
        return (eDate.getTime() - sDate.getTime()) / (1000 * 60);
    }

    /**
     * 将日期字符串转换为带格式的字符串
     * 如：20110708102500 转换为2011年07月08日 10时25分00秒
     *
     * @param dateStr 要转换的日期字符串
     * @return 转换后的字符串
     */
    public static String getDateTimeFormatStr3(String dateStr) {
        return DateUtils.formatDate(DateUtils.dateStrToDate(dateStr, DateUtils.DATE_PATTERN_YYYYMMDDHHmmss), DateUtils.DATE_PATTERN_YYYYMMDDHHmm_3);
    }

    public static String getPartTime(String time) {
        if (time.startsWith("0")) {
            time = time.replaceFirst("0", "");
        }
        Integer timeInt = new Integer(time);
        if (timeInt.compareTo(new Integer("00000")) >= 0
                && timeInt.compareTo(new Integer("03000")) <= 0) {
            return "00:00-00:30";
        }
        if (timeInt.compareTo(new Integer("03000")) > 0
                && timeInt.compareTo(new Integer("10000")) <= 0) {
            return "00:30-01:00";
        }
        if (timeInt.compareTo(new Integer("10000")) > 0
                && timeInt.compareTo(new Integer("13000")) <= 0) {
            return "01:00-01:30";
        }
        if (timeInt.compareTo(new Integer("13000")) > 0
                && timeInt.compareTo(new Integer("20000")) <= 0) {
            return "01:30-02:00";
        }
        if (timeInt.compareTo(new Integer("20000")) > 0
                && timeInt.compareTo(new Integer("23000")) <= 0) {
            return "02:00-02:30";
        }
        if (timeInt.compareTo(new Integer("23000")) > 0
                && timeInt.compareTo(new Integer("30000")) <= 0) {
            return "02:30-03:00";
        }
        if (timeInt.compareTo(new Integer("30000")) > 0
                && timeInt.compareTo(new Integer("33000")) <= 0) {
            return "03:00-03:30";
        }
        if (timeInt.compareTo(new Integer("33000")) > 0
                && timeInt.compareTo(new Integer("40000")) <= 0) {
            return "03:30-04:00";
        }
        if (timeInt.compareTo(new Integer("40000")) > 0
                && timeInt.compareTo(new Integer("43000")) <= 0) {
            return "04:00-04:30";
        }
        if (timeInt.compareTo(new Integer("43000")) > 0
                && timeInt.compareTo(new Integer("50000")) <= 0) {
            return "04:30-05:00";
        }
        if (timeInt.compareTo(new Integer("50000")) > 0
                && timeInt.compareTo(new Integer("53000")) <= 0) {
            return "05:00-05:30";
        }
        if (timeInt.compareTo(new Integer("53000")) > 0
                && timeInt.compareTo(new Integer("60000")) <= 0) {
            return "05:30-06:00";
        }
        if (timeInt.compareTo(new Integer("60000")) > 0
                && timeInt.compareTo(new Integer("63000")) <= 0) {
            return "06:00-06:30";
        }
        if (timeInt.compareTo(new Integer("63000")) > 0
                && timeInt.compareTo(new Integer("70000")) <= 0) {
            return "06:30-07:00";
        }
        if (timeInt.compareTo(new Integer("70000")) > 0
                && timeInt.compareTo(new Integer("73000")) <= 0) {
            return "07:00-07:30";
        }
        if (timeInt.compareTo(new Integer("73000")) > 0
                && timeInt.compareTo(new Integer("80000")) <= 0) {
            return "07:30-08:00";
        }
        if (timeInt.compareTo(new Integer("80000")) > 0
                && timeInt.compareTo(new Integer("83000")) <= 0) {
            return "08:00-08:30";
        }
        if (timeInt.compareTo(new Integer("83000")) > 0
                && timeInt.compareTo(new Integer("90000")) <= 0) {
            return "08:30-09:00";
        }
        if (timeInt.compareTo(new Integer("90000")) > 0
                && timeInt.compareTo(new Integer("93000")) <= 0) {
            return "09:00-09:30";
        }
        if (timeInt.compareTo(new Integer("93000")) > 0
                && timeInt.compareTo(new Integer("100000")) <= 0) {
            return "09:30-10:00";
        }
        if (timeInt.compareTo(new Integer("100000")) > 0
                && timeInt.compareTo(new Integer("103000")) <= 0) {
            return "10:00-10:30";
        }
        if (timeInt.compareTo(new Integer("103000")) > 0
                && timeInt.compareTo(new Integer("110000")) <= 0) {
            return "10:30-11:00";
        }
        if (timeInt.compareTo(new Integer("110000")) > 0
                && timeInt.compareTo(new Integer("113000")) <= 0) {
            return "11:00-11:30";
        }
        if (timeInt.compareTo(new Integer("113000")) > 0
                && timeInt.compareTo(new Integer("120000")) <= 0) {
            return "11:30-12:00";
        }
        if (timeInt.compareTo(new Integer("120000")) > 0
                && timeInt.compareTo(new Integer("123000")) <= 0) {
            return "12:00-12:30";
        }
        if (timeInt.compareTo(new Integer("123000")) > 0
                && timeInt.compareTo(new Integer("130000")) <= 0) {
            return "12:30-13:00";
        }
        if (timeInt.compareTo(new Integer("130000")) > 0
                && timeInt.compareTo(new Integer("133000")) <= 0) {
            return "13:00-13:30";
        }
        if (timeInt.compareTo(new Integer("133000")) > 0
                && timeInt.compareTo(new Integer("140000")) <= 0) {
            return "13:30-14:00";
        }
        if (timeInt.compareTo(new Integer("140000")) > 0
                && timeInt.compareTo(new Integer("143000")) <= 0) {
            return "14:00-14:30";
        }
        if (timeInt.compareTo(new Integer("143000")) > 0
                && timeInt.compareTo(new Integer("150000")) <= 0) {
            return "14:30-15:00";
        }
        if (timeInt.compareTo(new Integer("150000")) > 0
                && timeInt.compareTo(new Integer("153000")) <= 0) {
            return "15:00-15:30";
        }
        if (timeInt.compareTo(new Integer("153000")) > 0
                && timeInt.compareTo(new Integer("160000")) <= 0) {
            return "15:30-16:00";
        }
        if (timeInt.compareTo(new Integer("160000")) > 0
                && timeInt.compareTo(new Integer("163000")) <= 0) {
            return "16:00-16:30";
        }
        if (timeInt.compareTo(new Integer("163000")) > 0
                && timeInt.compareTo(new Integer("170000")) <= 0) {
            return "16:30-17:00";
        }
        if (timeInt.compareTo(new Integer("170000")) > 0
                && timeInt.compareTo(new Integer("173000")) <= 0) {
            return "17:00-17:30";
        }
        if (timeInt.compareTo(new Integer("173000")) > 0
                && timeInt.compareTo(new Integer("180000")) <= 0) {
            return "17:30-18:00";
        }
        if (timeInt.compareTo(new Integer("180000")) > 0
                && timeInt.compareTo(new Integer("183000")) <= 0) {
            return "18:00-18:30";
        }
        if (timeInt.compareTo(new Integer("183000")) > 0
                && timeInt.compareTo(new Integer("190000")) <= 0) {
            return "18:30-19:00";
        }
        if (timeInt.compareTo(new Integer("190000")) > 0
                && timeInt.compareTo(new Integer("193000")) <= 0) {
            return "19:00-19:30";
        }
        if (timeInt.compareTo(new Integer("193000")) > 0
                && timeInt.compareTo(new Integer("200000")) <= 0) {
            return "19:30-20:00";
        }
        if (timeInt.compareTo(new Integer("200000")) > 0
                && timeInt.compareTo(new Integer("203000")) <= 0) {
            return "20:00-20:30";
        }
        if (timeInt.compareTo(new Integer("203000")) > 0
                && timeInt.compareTo(new Integer("210000")) <= 0) {
            return "20:30-21:00";
        }
        if (timeInt.compareTo(new Integer("210000")) > 0
                && timeInt.compareTo(new Integer("213000")) <= 0) {
            return "21:00-21:30";
        }
        if (timeInt.compareTo(new Integer("213000")) > 0
                && timeInt.compareTo(new Integer("220000")) <= 0) {
            return "21:30-22:00";
        }
        if (timeInt.compareTo(new Integer("220000")) > 0
                && timeInt.compareTo(new Integer("223000")) <= 0) {
            return "22:00-22:30";
        }
        if (timeInt.compareTo(new Integer("223000")) > 0
                && timeInt.compareTo(new Integer("230000")) <= 0) {
            return "22:30-23:00";
        }
        if (timeInt.compareTo(new Integer("230000")) > 0
                && timeInt.compareTo(new Integer("233000")) <= 0) {
            return "23:00-23:30";
        }
        if (timeInt.compareTo(new Integer("233000")) > 0
                && timeInt.compareTo(new Integer("235959")) <= 0) {
            return "23:30-00:00";
        }
        return "";
    }

    /**
     * 获取某个时间段中为星期几的日期列表
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @param week      星期
     * @return
     */
    public static List getSplitTimeSectionDate(String startDate, String endDate,
                                               String week) {
        Calendar c_begin = new GregorianCalendar();
        Calendar c_end = new GregorianCalendar();
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] weeks = dfs.getWeekdays();
        c_begin.set(Integer.parseInt(startDate.substring(0, 4)), Integer
                .parseInt(startDate.substring(4, 6)) - 1, Integer
                .parseInt(startDate.substring(6, 8))); // Calendar的月从0-11，所以4月是3.
        c_end.set(Integer.parseInt(endDate.substring(0, 4)), Integer
                .parseInt(endDate.substring(4, 6)) - 1, Integer
                .parseInt(endDate.substring(6, 8))); // Calendar的月从0-11，所以5月是4.
        c_end.add(Calendar.DAY_OF_YEAR, 1); // 结束日期下滚一天是为了包含最后一天
        List list = new ArrayList();
        while (c_begin.before(c_end)) {
            String date = dateStrToNewFormat(new java.sql.Date(c_begin
                            .getTime().getTime()).toString(),
                    DateUtils.DATE_PATTERN_YYYYMMDD_2,
                    DateUtils.DATE_PATTERN_YYYYMMDD);
            if ("0".equals(week) || "全部".equals(week)) {
                list.add(date);
            } else {
                int dayOfWeek = c_begin.get(Calendar.DAY_OF_WEEK);
                if (weeks[dayOfWeek].equals(week) || week.equals(dayOfWeek + "".toString())) {
                    list.add(date);
                }
            }
            c_begin.add(Calendar.DAY_OF_YEAR, 1);
        }
        return list;
    }

    public static long getDaysFrom1900(String date) {
        return DateUtils.getDaysDiff(DateUtils.dateStrToDate("19000101", DateUtils.DATE_PATTERN_YYYYMMDD)
                , DateUtils.dateStrToDate(date, DateUtils.DATE_PATTERN_YYYYMMDD)) + 1;
    }

    /**
     * 取得指定日期所在周的周几的日期
     */
    public static String getSpecifiedDaysWeekDate(String date, int day) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(DateUtils.dateStrToDate(date, DateUtils.DATE_PATTERN_YYYYMMDD));
        calendar.set(calendar.DAY_OF_WEEK, day);
        return DateUtils.formatDate(calendar.getTime(), DateUtils.DATE_PATTERN_YYYYMMDD);
    }

    // 取得某年某月第几周第几天是多少号
    public static String weekdatetodata(int year, int month, int weekOfMonth,
                                        int dayOfWeek) {
        Calendar c = Calendar.getInstance();
        // 计算出 x年 y月 1号 是星期几
        c.set(year, month - 1, 1);
        // 如果i_week_day =1 的话 实际上是周日
        int i_week_day = c.get(Calendar.DAY_OF_WEEK);
        int sumDay = 0;
        // dayOfWeek+1 就是星期几（星期日 为 1）
        if (i_week_day == 1) {
            sumDay = (weekOfMonth - 1) * 7 + dayOfWeek + 1;
        } else {
            sumDay = 7 - i_week_day + 1 + (weekOfMonth - 1) * 7 + dayOfWeek + 1;
        }
        // 在1号的基础上加上相应的天数
        c.set(Calendar.DATE, sumDay);
        SimpleDateFormat sf2 = new SimpleDateFormat("yyyyMMdd");
        return sf2.format(c.getTime());
    }

    /**
     * 根据月的间隔获得两个日期之间的期数
     *
     * @param startDateStr：开始日期
     * @param endDateStr：结束日期
     * @param months：间隔的月数
     * @param paramFormat：传入日期字符串的格式(默认格式:yyyy-MM-dd)
     * @param returnFormat：返回期数里面的日期格式(默认格式:yyyy-MM-dd)
     * @return: json数组, eg: [{"date":"2014-12-01","period":"1"}]
     */
    public static JSONArray monthPeriodBetweenDate(String startDateStr, String endDateStr, int months, String paramFormat, String returnFormat) throws Exception {
        if (StringUtils.isBlank(startDateStr) || StringUtils.isBlank(endDateStr)) {
            return null;
        }
        paramFormat = StringUtils.isBlank(paramFormat) ? DATE_PATTERN_YYYYMMDD_2 : paramFormat;
        returnFormat = StringUtils.isBlank(returnFormat) ? DATE_PATTERN_YYYYMMDD_2 : returnFormat;
        try {
            SimpleDateFormat paramDateFormat = new SimpleDateFormat(paramFormat);
            Date startDate = paramDateFormat.parse(startDateStr);
            SimpleDateFormat returnDateFormat = new SimpleDateFormat(returnFormat);
            Date endDate = returnDateFormat.parse(endDateStr);
            //sDate.compareTo(eDate);
            if (startDate.compareTo(endDate) >= 0) {
                return null;
            }
            JSONArray jsonArray = new JSONArray();
            startDate = addMonths(startDate, months);
            int period = 1;
            while (startDate.compareTo(endDate) < 0) {
                JSONObject json = new JSONObject();
                json.put("date", formatDate(startDate, returnFormat));
                json.put("period", String.valueOf(period));
                jsonArray.add(json);
                startDate = addMonths(startDate, months);
                period++;
            }
            JSONObject json = new JSONObject();
            json.put("date", formatDate(endDate, returnFormat));
            json.put("period", String.valueOf(period));
            jsonArray.add(json);
            return jsonArray;
        } catch (ParseException e) {
            throw e;
        }
    }

}
