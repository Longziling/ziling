package com.ziling.goodlife.data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Format {

    public static void main() {

        String dateText = "20190924";
        LocalDate date = LocalDate.parse(dateText, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("格式化之后的日期=" + date);

        dateText = date.format(DateTimeFormatter.ISO_DATE);
        System.out.println("dateText=" + dateText);

    }

    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime now = LocalDateTime.now();
        String nowText = now.format(formatter);
        System.out.println("nowText=" + nowText);

        String datetimeText = "1999-12-31 23:59:59";
        LocalDateTime dateTime = LocalDateTime.parse(datetimeText, formatter);
        System.out.println(dateTime);
    }
}
