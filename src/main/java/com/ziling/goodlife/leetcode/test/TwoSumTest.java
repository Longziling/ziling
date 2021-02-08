package com.ziling.goodlife.leetcode.test;

import java.util.HashMap;

public class TwoSumTest {

    public static int[] twoSum(int[] nums, int target) {
        HashMap <Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[] {map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }



}
