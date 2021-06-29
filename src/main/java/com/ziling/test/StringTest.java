package com.ziling.test;

public class StringTest {

    public static String doDepress(String str) {
        //字符串为空直接返回
        if ("".equals(str)) return str;
        StringBuilder buffer = new StringBuilder();
        //用第n个字符去和第n+1个字符对比
        char c = str.charAt(0);
        //记录字符出现次数，默认为1
        int repeat = 1;
        for (int i = 1; i < str.length(); i++) {
            if (c == str.charAt(i)) {
                //如果第n个字符和第n+1个字符相等，则出现次数+1
                repeat++;
            } else {
                //如果第n个字符和第n+1个字符不相等，则拼接在字符串后面
                buffer.append(c).append(repeat);
                //拼接完后重置当前字符串
                c = str.charAt(i);
                //重置字符出现次数
                repeat = 1;
            }
        }
        //最后一组在for循环里是没有拼接的
        return buffer.append(c).append(repeat).toString();
    }

    public static void main(String[] args) {
        String a = "CABAACBBA";
        System.out.println(doDepress(a));
    }
}
