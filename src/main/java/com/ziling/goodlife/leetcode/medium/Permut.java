package com.ziling.goodlife.leetcode.medium;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 全排列
 *
 * 难度：中等
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 */
public class Permut {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        int length = nums.length;
//        function(res, list, length, 0);
        backtrack(length, nums, res, 0);
        return res;
    }

    public void function(List<List<Integer>> res, List<Integer> list, int length, int first) {
        if (length == first) {
            // 重点代码，ArrayList必须新建，否则会都一样
            res.add(new ArrayList<Integer>(list));
        }
        for (int i = first; i < length; i++) {
            Collections.swap(list, first, i);
            function(res, list, length, first + 1);
            Collections.swap(list, first, i);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Permut permut = new Permut();
        System.out.println(permut.permute(nums));
    }

    private void backtrack(int n, int[] nums, List<List<Integer>> result, int first) {
        if (first == n) {
            List<Integer> output = new ArrayList<>();
            for (int num : nums) {
                output.add(num);
            }
            result.add(output);
        }
        for (int i = first; i < n; i++) {
            swap(nums, first, i);
            backtrack(n, nums, result, first + 1);
            swap(nums, first, i);
        }
    }

    private void swap(int[] list, int i, int j) {
        int n = list.length;
        if (i >= n || j >= n) {
            return;
        }
        int x = list[i];
        list[i] = list[j];
        list[j] = x;

    }

}
