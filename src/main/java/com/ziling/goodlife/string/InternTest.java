package com.ziling.goodlife.string;

public class InternTest {

    public static void test1() {
        String s = new String("1");
        System.out.println(s == s.intern());
        String s2 = "1";
        System.out.println(s == s2);
        System.out.println(s.intern() == s2);

        String s3 = new String("1") + new String("1");
        System.out.println(s3 == s3.intern());
        String s4 = "11";
        System.out.println(s3 == s4);
    }

    public static void test2() {
        String s = new String("1");
        String s2 = "1";
        System.out.println(s == s.intern());
        System.out.println(s == s2);
        System.out.println(s.intern() == s2);

        String s3 = new String("1") + new String("1");
        String s4 = "11";
        System.out.println(s3 == s3.intern());
        System.out.println(s3 == s4);
        System.out.println(s3.intern() == s4);

    }


    public static void main(String[] args) {
        test1();
        test2();
    }


}
