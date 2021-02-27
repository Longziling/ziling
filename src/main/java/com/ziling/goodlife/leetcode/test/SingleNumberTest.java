package com.ziling.goodlife.leetcode.test;

public class SingleNumberTest {

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new RuntimeException("invaild");
        }
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

}
