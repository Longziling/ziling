package com.ziling.goodlife.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: yipeng
 * @Date: 2021/7/11 19:30
 */
public class LongestString {

    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            throw new RuntimeException("invaild value");
        }
        int longestValue = 0;
        if (s.isEmpty()) {
            return longestValue;
        }
        Set<Character> noRepeatSet = new HashSet<>();
        int k = -1;
        for (int i = 0; i < s.length() && k + 1 < s.length(); i++) {
            if (i != 0) {
                noRepeatSet.remove(s.charAt(i - 1));
            }
            while (k + 1 < s.length() && !noRepeatSet.contains(s.charAt(k + 1))) {
                noRepeatSet.add(s.charAt(++k));
            }
            longestValue = Math.max(noRepeatSet.size(), longestValue);
        }
        return longestValue;
    }

    public static void main(String[] args) {
        LongestString longestString = new LongestString();
        System.out.println(longestString.lengthOfLongestSubstring("abcabcbbjklior"));
    }

}
