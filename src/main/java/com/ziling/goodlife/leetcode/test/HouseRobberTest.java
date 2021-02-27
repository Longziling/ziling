package com.ziling.goodlife.leetcode.test;

public class HouseRobberTest {

    public int rob1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return rob(nums, nums.length - 1);
    }

    public int rob(int[] nums, int n) {
        if (n == 0) {
            return nums[0];
        }
        if (n == 1) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(rob(nums, n - 1), rob(nums, n - 2) + nums[n]);
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int a = nums[0];
        int b = Math.max(nums[0], nums[1]);
        int temp = a;
        for (int i = 2; i < nums.length; i++) {
            temp = a;
            a = b;
            b = Math.max(temp + nums[i], b);
        }
        return b;
    }

}
