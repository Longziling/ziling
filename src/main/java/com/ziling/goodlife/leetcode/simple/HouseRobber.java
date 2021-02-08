package com.ziling.goodlife.leetcode.simple;

/**
 * 打家劫舍
 *
 * 难度：简单
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * 示例 1：
 *
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 *
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 * https://leetcode-cn.com/problems/house-robber
 */
public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {1, 9, 8, 2};
        HouseRobber houseRobber = new HouseRobber();
        System.out.println(houseRobber.rob(nums));
    }

    public int rob1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return rob(nums, nums.length -1);
    }

    public int rob(int[] nums, int n) {
        if (n == 0) {
            return nums[0];
        }
        if (n == 1) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(rob(nums, n -2) + nums[n], rob(nums, n - 1));
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int a = nums[0];
        int b = Math.max(nums[0], nums[1]);
        int max = b;
        for (int i = 2; i < nums.length; i++) {
            max = Math.max(a + nums[i], b);
            a = b;
            b = max;
        }
        return max;
    }




}
