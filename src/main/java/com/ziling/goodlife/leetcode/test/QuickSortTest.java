package com.ziling.goodlife.leetcode.test;

public class QuickSortTest {

    public void quickSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        quickSort(nums, 0, nums.length - 1);
    }

    public void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int temp = nums[l];
            int i = l;
            int j = r;
            while (i < j) {
                while (i < j && nums[j] > temp) {
                    j--;
                }
                if (i < j) {
                    nums[i++] = nums[j];
                }
                while (i < j && nums[i] < temp) {
                    i++;
                }
                if (i < j) {
                    nums[j--] = nums[i];
                }
            }
            nums[i] = temp;
            quickSort(nums, l, i -1);
            quickSort(nums, i + 1, r);
        }

    }


}
