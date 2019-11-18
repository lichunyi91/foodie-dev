package com.imooc.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DateUtil {

    /**
     * Base ISO 8601 Date format yyyyMMdd i.e., 20021225 for the 25th data of December 2002
     */
    public static final String ISO_DATE_FORMAT = "yyyyMMdd";

    /**
     * Expanded ISO 8601 Date format yyyy-MM-dd i.e., 2002-12-25 for the 25th data of December 2002
     */
    public static final String ISO_EXPANDED_DATE_FORMAT = "yyyy-MM-dd";


    /**
     * yyyy-MM-dd hh:mm:ss
     */
    public static String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static String DATE_PATTERN = "yyyyMMddHHmmss";

    /**
     * 则个
     */
    private static boolean LENIENT_DATE = false;


    private static Random random = new Random();

    public static Date stringToDate(String dateString) {
        return stringToDate(dateString, ISO_EXPANDED_DATE_FORMAT, LENIENT_DATE);
    }

    public static Date stringToDate(String dateString, String pattern, boolean lenientDate) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            System.out.println(dateString);
            Date date = sdf.parse(dateString);
            System.out.println(date);
            System.out.println(sdf.format(date));
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String dateToString(Date date, String pattern) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }


}
