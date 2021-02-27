package com.ziling.goodlife.leetcode.test;

import com.ziling.goodlife.leetcode.simple.SumItem;

public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int preMax = Integer.MIN_VALUE;
        int max = nums[0];
        for (int num : nums) {
            preMax = Math.max(preMax + num, num);
            max = Math.max(max, preMax);
        }
        return max;
    }

    public static SumItem get(int[] nums, int l, int r) {
        if (l == r) return new SumItem(nums[l], nums[l], nums[l], nums[l]);
        int mid = (l + r) >> 1;
        SumItem leftSum = get(nums, 0, mid);
        SumItem rightSum = get(nums, mid + 1, r);
        return pushUp(leftSum, rightSum);
    }

    public static SumItem pushUp(SumItem l, SumItem r) {
        int lSum = Math.max(l.getlSum(), l.gettSum() + r.getlSum());
        int rSum = Math.max(r.getrSum(), l.getrSum() + r.gettSum());
        int mSum = Math.max(Math.max(l.getmSum(), r.getmSum()), l.getrSum() + r.getlSum());
        int tSum = l.gettSum() + r.gettSum();
        return new SumItem(lSum, rSum, mSum, tSum);
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3, 4,-1, 5,-1,-5, -4};
        SumItem item = get(nums, 0, nums.length - 1);
        Math.max(Math.max(item.getlSum(), item.getrSum()), Math.max(item.gettSum(), item.getmSum()));
        System.out.println(Math.max(Math.max(item.getlSum(), item.getrSum()), Math.max(item.gettSum(), item.getmSum())));
    }

}
