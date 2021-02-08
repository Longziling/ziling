package com.ziling.goodlife.leetcode.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * 难度：简单
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * https://leetcode-cn.com/problems/two-sum/
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.twoSum(nums, 13);
        System.out.println(result[0] + " " + result[1]);
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


}
