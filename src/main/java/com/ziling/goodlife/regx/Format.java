package com.ziling.goodlife.regx;

public class Format {

    public static void main(String[] args) {

        String pattern = "[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼]{1}";
        String s = "里E12345";

        s = s.replaceAll(pattern, "");
        System.out.println(s);


    }
}
