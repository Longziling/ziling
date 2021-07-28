package com.ziling.goodlife.alibaba;

/**
 * @Author: yipeng
 * @Date: 2021/6/18 1:55
 *
 * 升序排列的整数数组 nums 在预先未知的某个点上进行了旋转（例如， [0,1,2,4,5,6,7] 经旋转后可能变为 [4,5,6,7,0,1,2]）。
 * 找出某个值的下标
 */
public class FindN {

    public static void main(String[] args) {
        Solution so = new Solution();
//        int[] nums = {1, 2, 5, 9, 11, 15, 18, 19, 20, 21, 22, 25, 45, 48, 49, 52, 54, 56, 58, 67, 69};
        int[] nums = {7,8,9,10,1,2,3};
        System.out.println(so.search(nums, 9));
    }

}


class Solution {
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    public int search(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        if (target == nums[mid]) {
            return mid;
        }
        // 右侧有序
        if (nums[mid] < nums[right]) {
            if (target > nums[mid] && target < nums[right]) {
                return search(nums, mid + 1, right, target);
            } else {
                return search(nums, left, mid - 1, target);
            }
        } else {
            if (target < nums[mid] && target > nums[left]) {
                return search(nums, left, mid - 1, target);
            } else {
                return search(nums, mid + 1, right, target);
            }
        }
    }
}