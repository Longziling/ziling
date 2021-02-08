package com.ziling.goodlife.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 三数之和
 *
 * 难度：中等
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * https://leetcode-cn.com/problems/3sum/
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(nums));
    }


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList();
        int len = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < len; i++){
            if(nums[i] > 0) break;
            if(i >0 && nums[i] == nums[i-1]) continue;
            int target = 0 - nums[i];
            int l = i + 1, r = len - 1;
            while(l < r){
                List<Integer> list= new ArrayList();
                if(nums[l] + nums[r] == target) {
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    res.add(list);
                    while(r > l && nums[l+1] == nums[l]) l++;
                    while(r > l && nums[r] == nums[r-1]) r--;
                    l++;
                    r--;
                } else if (nums[l] + nums[r] > target) r--;
                else l++;
            }
        }
        return res;
    }




    public List<List<Integer>> threeSum1(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            resultSet.addAll(twoSum(nums, i + 1, 0 - nums[i]));
        }

        return new ArrayList<>(resultSet);
    }


    public List<List<Integer>> twoSum(int[] nums, int j, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = j; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                List<Integer> item = new ArrayList<Integer>();
                int a = -target;
                int b = nums[map.get(nums[i])];
                int c = nums[i];

                if (a > b) {
                    int temp = b;
                    b = a;
                    a = temp;
                }
                if (a > c) {
                    int temp = c;
                    c = a;
                    a = temp;
                }
                if (b > c) {
                    int temp = c;
                    c = b;
                    b = temp;
                }
                item.add(a);
                item.add(b);
                item.add(c);
                resultList.add(item);
            }
            map.put(target - nums[i], i);
        }
        return resultList;
    }
}
