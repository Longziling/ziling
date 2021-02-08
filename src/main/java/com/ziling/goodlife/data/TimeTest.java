package com.ziling.goodlife.data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class TimeTest {

    public static void main() {
        LocalTime time = LocalTime.now();
        System.out.println("当前时间=" + time);
    }

    public static void main1() {
        LocalTime time = LocalTime.now();
        LocalTime newTime = time.plusHours(2);
        System.out.println("newTime =" + newTime);

        LocalDate date = LocalDate.now();
        LocalDate newDate = date.plus(1, ChronoUnit.WEEKS);
        System.out.println("newDate =" + newDate);
    }

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate newDate = LocalDate.of(2000,1,1);
        if (now.isAfter(newDate)) {
            System.out.println("千禧年已经过去了");
        }
        LocalDate date2 = LocalDate.of(2020, 1, 1);
        if (now.isBefore(date2)) {
            System.out.println("2020年还没未到来");
        }
    }

}
