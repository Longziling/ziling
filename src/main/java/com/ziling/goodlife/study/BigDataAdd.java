package com.ziling.goodlife.study;

/**
 * @Author: yipeng
 * @Date: 2021/6/22 20:45
 */
public class BigDataAdd {

    public static String bigDataAdd(String a, String b) {
        if (a == null || a.isEmpty()) return b;
        if (b == null || b.isEmpty()) return a;
        StringBuilder res = new StringBuilder("");
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? a.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = n1 + n2 + carry;
            carry = sum / 10;
            res.append(sum % 10);
            i--;
            j--;
        }
        if (carry == 1) {
            res.append(carry);
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "523";
        String b = "74523";
        System.out.println(bigDataAdd(a, b));
    }

}
