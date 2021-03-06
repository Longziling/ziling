package com.ziling.goodlife.leetcode.test;

public class HammingDistancTest {

    public static int hammingDistance(int x, int y) {
        int n = x ^ y;
        int distance = 0;
        while (n != 0) {
            n &= n -1;
            distance++;
        }
        return distance;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }

}
