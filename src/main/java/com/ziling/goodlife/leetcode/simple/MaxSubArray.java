package com.ziling.goodlife.leetcode.simple;

/**
 * 最大子序和
 *
 * 难度：简单
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
public class MaxSubArray {

    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int curr = 0;
            for (int j = i; j < nums.length; j++) {
                curr += nums[j];
                if (max < curr) {
                    max = curr;
                }
            }
        }
        return max;

    }

    public static int max(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }




    public static SumItem get(int[] nums, int l, int r) {
        if (l == r) return new SumItem(nums[l], nums[l], nums[l], nums[l]);
        int m = (l + r) >> 1;
        SumItem lSub = get(nums, l, m);
        SumItem rSub = get(nums, m + 1, r);
        return pushUp(lSub, rSub);
    }

    public static SumItem pushUp(SumItem l, SumItem r) {
        int tSum = l.gettSum() + r.gettSum();
        int lSum = Math.max(l.getlSum(), l.gettSum() + r.getlSum());
        int rSum = Math.max(r.getrSum(), l.getrSum() + r.gettSum());
        int mSum = Math.max(Math.max(l.getmSum(), r.getmSum()), l.getrSum() +  r.getlSum());
        return new SumItem(lSum, rSum, mSum, tSum);
    }


    public static void main(String[] args) {
        int[] nums = {-2,1,-3, -4,-1, -2,-1,-5, -4};
        SumItem item = get(nums, 0, nums.length - 1);
        Math.max(Math.max(item.getlSum(), item.getrSum()), Math.max(item.gettSum(), item.getmSum()));
        System.out.println();

    }

}
