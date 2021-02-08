package com.ziling.goodlife.leetcode.simple;

public class FindUnsortedSubarray {
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        int min = 0;
        int max = nums.length - 1;
        int i = 0;
        int j = nums.length - 1;
        boolean minFlag = false;
        boolean maxFlag = false;
        while (i < j) {
            if (nums[i] > nums[j]) {
                return j - i + 1;
            }
            for (int k = i + 1; (k < j) && (!minFlag || !maxFlag); k++) {
                if (nums[i] > nums[k] && !minFlag) {
                    minFlag = true;
                    min = i;
                }
                if (nums[j] < nums[k] && !maxFlag) {
                    maxFlag = true;
                    max = j;
                }
            }
            if (minFlag && maxFlag) {
                return max - min + 1;
            }
            if (!minFlag) {
                i++;
            }
            if (!maxFlag) {
                j--;
            }
        }
        if (i >= j) {
            return 0;
        }
        return max - min;
    }

    public static void main(String[] args) {
        FindUnsortedSubarray findUnsortedSubarray = new FindUnsortedSubarray();
        int[] nums = {1,2,3,4};
        System.out.println(findUnsortedSubarray.findUnsortedSubarray(nums));
    }

}
