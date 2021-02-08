package com.ziling.goodlife.data;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class DataTest {

    public static void main() {
        LocalDate date = LocalDate.now();
        System.out.println("当前日期=" + date);
    }

    public static void main1() {
        LocalDate date = LocalDate.of(2000, 1, 1);
        System.out.println("千禧年=" + date);
    }

    public static void main2() {
        LocalDate date = LocalDate.now();
        System.out.printf("年=%d, 月=%d, 日=%d", date.getYear(), date.getMonthValue(), date.getDayOfMonth());
    }

    public static void main3() {
        LocalDate now = LocalDate.now();
        LocalDate date = LocalDate.of(2019, 9, 28);
        System.out.println("日期是否相等=" + now.equals(date));
    }

    public static void main(String[] args) throws Exception{
        String dateStr = "2019-10-12 00:2:2";
        String format = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        System.out.println(sdf.parse(dateStr));
    }
}
