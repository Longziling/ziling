package com.ziling.goodlife.scriptengine;

public class MyFunction {

    public static String fun1(String name) {
        System.out.format("Hi there from Java, %s", name);
        return "greetings from java";
    }

    public static String fun2(int a, int b) {
        return a + b + "";
    }
}
