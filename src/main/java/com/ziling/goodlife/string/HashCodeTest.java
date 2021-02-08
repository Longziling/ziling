package com.ziling.goodlife.string;

public class HashCodeTest {

    public static void main(String[] args) {
        String str1 = "通话";
        String str2 = "重地";
        System.out.println(String.format("str1：%d | str2：%d",  str1.hashCode(),str2.hashCode()));
        System.out.println(str1.equals(str2));



        // StringBuffer reverse
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("abcdefg");
        System.out.println(stringBuffer.reverse()); // gfedcba
        // StringBuilder reverse
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("abcdefg");
        System.out.println(stringBuilder.reverse()); // gfedcba

    }

}
