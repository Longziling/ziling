package com.ziling.goodlife.leetcode.test;

public class ClimbingStairsTest {
    public static int climbStairs1(int n) {
        if (n < 0) {
            throw new RuntimeException("n invalid");
        }
        if (n == 0) {
            return 0;
        }
        if (n  == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int a = 1;
        int b = 2;
        int temp = a;
        for (int i = 2; i < n; i++) {
            temp = a;
            a = b;
            b = b +temp;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs1(4));
    }
}
