package com.ziling.goodlife.alibaba;

/**
 * @Author: yipeng
 * @Date: 2021/6/18 17:53
 */
public class QuickSort {

    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;
            int x = nums[i];
            while (i < j) {
                while (i < j && nums[j] > x) {
                    j--;
                }
                if (i < j) {
                   nums[i++] = nums[j];
                }
                while (i < j && nums[i] < x) {
                    i++;
                }
                if (i < j) {
                    nums[j--] = nums[i];
                }
            }
            nums[i] = x;
            quickSort(nums, left, i - 1);
            quickSort(nums,i + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,5,8,7,2,15,48,32,84,6,5,4,21,6,12,97,5345,1,23,46,56};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(nums, 0, nums.length - 1);
        System.out.println(nums);
    }

}
