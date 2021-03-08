package com.ziling.goodlife.leetcode.test;

public class MyAtoiTest {
    public int myAtoi(String str) {
        int i = 0;
        int sign = 1;
        char firstChar = str.charAt(i);
        if (firstChar == '+') {
            i++;
        }
        if (firstChar == '-') {
            sign = -1;
            i++;
        }
        int sum = 0;
        for (; i < str.length(); i++) {
            char current = str.charAt(i);
            if (current > '9' || current < '0') {
                continue;
            }
            if (sum > Integer.MAX_VALUE / 10 || (sum == Integer.MAX_VALUE / 10 && current - '0' > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (sum < Integer.MIN_VALUE / 10 || (sum == Integer.MIN_VALUE / 10 && current - '0' > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }
            sum = sum * 10 + sign * (current - '0');
        }
        return sum;
    }
}
