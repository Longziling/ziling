package com.ziling.goodlife.random;

import java.math.BigDecimal;
import java.util.Random;

public class RandomTest {

    public static void main(String[] args) {
//        String s = "";
//        String ss = s.replace("【", "");
//        System.out.println(ss);

//        long s = 1L;
//        s = 24 * 3600 * 100000000000000L;
//        System.out.println(s);
//        float f = 11.1f;
//        BigDecimal bd = new BigDecimal((double) f);
//        System.out.println(bd.intValue());
//        BigDecimal bd1 = BigDecimal.valueOf((double) f);
//        System.out.println(bd.hashCode());
//        System.out.println(bd1.hashCode());
//        if (bd.equals(bd1)) {
//            System.out.println(1111);
//        }


//        try {
//            System.out.println("1111");
//            int i = 1 / 0;
//            System.out.println("2222");
//        } catch (Exception e) {
//            System.out.println("3333");
//            int j = 1 / 0;
//            System.out.println("4444");
//        } finally {
//            System.out.println("5555");
//        }
//        System.out.println("6666");

//        System.out.println(test());


        long a = 0L;
        a =  ((long) 1000000000 * 200);
        System.out.println(a);
        a = 1000000000 * 200L;
        System.out.println(a);
        a = 1000000000 * 200;
        System.out.println(a);
        a =  (long) (1000000000 * 200);
        System.out.println(a);

    }

    public static String test() {
        String s = null;
        try {
            s = "1111";
            int i = 1 / 0;
        } catch (Exception e) {
            s = "3333";
            int j = 1 / 0;
        } finally {
            return s;
        }
    }
}