package com.king.movieshare.utils;


import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    /**
     * 获取min分钟后的日期
     * @param nowDate
     * @param min
     * @return
     */
    public static synchronized Date addDateMin(Date nowDate, int min){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowDate);
        calendar.add(Calendar.MINUTE, min);
        return calendar.getTime();
    }

    /**
     * 获取hours小时后的日期
     * @param nowDate
     * @param hours
     * @return
     */
    public synchronized static Date addDateHour(Date nowDate, int hours){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowDate);
        calendar.add(Calendar.HOUR_OF_DAY, hours);
        return calendar.getTime();
    }
}
