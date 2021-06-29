package com.ziling.goodlife.study;

import java.util.Arrays;

/**
 * @Author: yipeng
 * @Date: 2021/6/21 00:06
 */
public class TopKmax {

    /**
     * 最小的K个数，快排解法，修改原数组, 时间复杂度O(N)
     * @param nums
     * @param k
     */
    public static int[] topKmax(int[] nums, int k) {
        if (nums == null || k <= 0 || nums.length < k) {
            throw new RuntimeException("invalid param");
        }
        int left = 0;
        int right = nums.length - 1;
        int index = partition(nums, left, right);
        while (index != k - 1) {
            if (index < k - 1) {
                index = partition(nums, index + 1, right);
            } else {
                index = partition(nums, left, index - 1);
            }
        }
        return Arrays.copyOf(nums, k);
    }


    private static int partition(int[] nums, int left, int right) {
        int x = nums[left];
        while (left < right) {
            // 由于上方判断条件为“index != k - 1”，此处必须加等号，否则会出现跳过相等情况，进而造成死循环。
            while (left < right && nums[right] <= x) {
                right--;
            }
            if (left < right) {
                nums[left++] = nums[right];
            }
            while (left < right && nums[left] > x) {
                left++;
            }
            if (left < right) {
                nums[right--] = nums[left];
            }
            nums[left] = x;
        }
        return left;
    }

    public static void print(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {34,23,6435,4234,2523,425235,234234,6345,23,54,43,23,23,43,53,2,423,6345,432,24,25,2,234,53,6546,5345,2342,63534,234,4364};
        print(nums);
        print(topKmax(nums, 10));
        // 此情况下可构建出死循环
        // topKmax.print(topKmax.topKmax(nums, 20));
    }

}
