package com.ziling.goodlife.leetcode.test;

public class MajorityElementTest {

    public int majorityElement1(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new RuntimeException("nums is invalid");
        }
        int count = 0;
        int cadition = 0;
        for (int num : nums) {
            if (count == 0) {
                cadition = num;
            }
            count += cadition == num ? 1 : -1;
        }
        return cadition;
    }

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new RuntimeException("nums is invalid");
        }
        return majorityElement(nums, 0, nums.length - 1);
    }

    public int majorityElement(int[] nums, int low, int high) {
        if (low == high) {
            return nums[low];
        }
        int mid = (low + high) >> 1;
        int leftMax = majorityElement(nums, low, mid);
        int rightMax = majorityElement(nums, mid + 1, high);
        return push(nums, leftMax, rightMax, low, high);
    }

    public int push(int[] nums, int leftMax, int rightMax, int low, int high) {
        if (leftMax == rightMax) {
            return leftMax;
        }
        int leftCount = getCount(nums, leftMax, low, high);
        int rightCount = getCount(nums, rightMax, low, high);
        return leftCount > rightCount ? leftMax : rightMax;
    }

    public int getCount(int[] nums, int max, int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (nums[i] == max) {
                count++;
            }
        }
        return count;
    }
}
