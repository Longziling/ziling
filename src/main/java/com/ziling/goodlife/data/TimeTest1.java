package com.ziling.goodlife.data;

import java.sql.Time;

public class TimeTest1 {

    public static void main(String[] args) {
        String startTimeStr = "2019-12-20 10:2:02";
        String endTimeStr = "12:20:20";
        Time startTime = Time.valueOf(startTimeStr);
        Time endtTime = Time.valueOf(endTimeStr);
        System.out.println(startTime);
        System.out.println(endtTime);
        System.out.println(startTime.compareTo(endtTime));
    }
}
