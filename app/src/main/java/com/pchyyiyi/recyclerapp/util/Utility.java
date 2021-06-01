package com.pchyyiyi.recyclerapp.util;


import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName Utility
 * @Description TODO
 * @Author fayXxxx
 * @Date 2021/6/1 上午10:30
 * @Version 1.0
 */
public class Utility {

    /**
     * 将时间字符串解析为日期
     * @param dateString
     * @return
     */
    public static Date stringToDate(String dateString) {
        ParsePosition position = new ParsePosition(0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        Date dateValue = simpleDateFormat.parse(dateString, position);
        return dateValue;
    }
    /**
     * 格式化时间字符串
     *
     * @param dateString
     * @return
     */
    public static String formatStringDate(String dateString) {
        if (dateString == null || dateString.length() < 1) {
            return "";
        }
        String year = dateString.substring(0, 4); // 年份
        String mouth = dateString.substring(4, 6); // 月份
        String day = dateString.substring(6, 8); // 日期
        String hour = dateString.substring(8, 10); // 时
        String minute = dateString.substring(10, 12); // 分

        return year + "-" + mouth + "-" + day + " " + hour + ":" + minute;
    }

    /**
     * 格式化时间字符串
     *
     * @param dateString
     * @return
     */
    public static String formatStringDate2(String dateString) {
        if (dateString == null || dateString.length() < 1) {
            return "";
        }
        String year = dateString.substring(0, 4); // 年份
        String mouth = dateString.substring(4, 6); // 月份
        String day = dateString.substring(6, 8); // 日期

        return year + "年" + mouth + "月" + day + "日";
    }

    /**
     * 将长时间格式时间转换为字符串 yyyy-MM-dd HH:mm:ss
     *
     * @param dateDate
     * @return
     */
    public static String formatDateToString(Date dateDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateString = formatter.format(dateDate);
        return dateString;
    }

    /**
     * 获取现在时间
     *
     * @return返回字符串格式 yyyy-MM-dd HH:mm:ss
     */
    public static String getStringDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * 获取现在时间
     *
     * @return返回字符串格式 yyyy-MM-dd HH:mm:ss
     */
    public static String getStringDateByDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);
        return dateString;
    }

    public static String getStringDateByDate2(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(date);
        return dateString;
    }

    public static String getStringDateByDate3(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("MM月dd日");
        String dateString = formatter.format(date);
        return dateString;
    }

    public static String getNextDateByDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(date.getTime() + 24 * 60 * 60 * 1000);
        return dateString;
    }

    public static String getLastDateByDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(date.getTime() - 24 * 60 * 60 * 1000);
        return dateString;
    }

    //设置时间的格式
    //                      yyyy-MM-dd 1969-12-31
    //                      yyyy-MM-dd 1970-01-01
    //                yyyy-MM-dd HH:mm 1969-12-31 16:00
    //                yyyy-MM-dd HH:mm 1970-01-01 00:00
    //               yyyy-MM-dd HH:mmZ 1969-12-31 16:00-0800
    //               yyyy-MM-dd HH:mmZ 1970-01-01 00:00+0000
    //        yyyy-MM-dd HH:mm:ss.SSSZ 1969-12-31 16:00:00.000-0800
    //        yyyy-MM-dd HH:mm:ss.SSSZ 1970-01-01 00:00:00.000+0000
    //      yyyy-MM-dd'T'HH:mm:ss.SSSZ 1969-12-31T16:00:00.000-0800
    //      yyyy-MM-dd'T'HH:mm:ss.SSSZ 1970-01-01T00:00:00.000+0000
    //注：HH显示的是24小时制，hh显示的是12小时制

}
