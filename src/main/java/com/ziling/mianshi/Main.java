package com.ziling.mianshi;

/**
 * @Author: yipeng
 * @Date: 2021/7/7 18:32
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {7,8,9,10,1,2,3};
        int k = 10;

        System.out.println(findK(nums, 0, nums.length - 1, k));
    }

    private static int findK (int[] nums, int left, int right, int x) {
        if (nums == null || nums.length == 0) {
            throw new RuntimeException("invalid");
        }
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (nums[mid] == x) {
            return mid;
        }
        if (nums[mid] <= nums[right]) {
            if (x > nums[mid] && x <= nums[right]) {
                return findK(nums, mid + 1, right, x);
            } else {
                return findK(nums, left, mid - 1, x);
            }
        } else {
            if (x >= nums[left] && x < nums[mid]) {
                return findK(nums, left, mid - 1, x);
            } else {
                return findK(nums, mid + 1, right, x);
            }

        }
    }




}
