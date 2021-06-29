package com.ziling.goodlife.alibaba;

import java.util.Random;

/**
 * @Author: yipeng
 * @Date: 2021/6/18 11:25
 */
public class Reverse {

    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 9, 11, 15, 18, 19, 20, 21, 22, 25, 45, 48, 49, 52, 54, 56, 58, 67, 69};
        Random r = new Random();
        int n = r.nextInt(nums.length);
        System.out.println(n);
        print(nums);
        rotate(nums, n);
        print(nums);
    }

    public static void print(int[] nums) {
        for (int a : nums) {
            System.out.print(a + " ");
        }
        System.out.println();
    }


    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int prev = nums[start];
            int current = start;
            do {
                int next = (current + k) % nums.length;
                int tmp = nums[next];
                nums[next] = prev;
                prev =tmp;
                current = next;
                count++;
            } while (start != current);
        }
    }

}

