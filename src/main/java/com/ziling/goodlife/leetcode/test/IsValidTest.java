package com.ziling.goodlife.leetcode.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class IsValidTest {

    public boolean isValid(String s) {
        if (s == null) {
            throw new RuntimeException("s is invaild");
        }
        if (s.length() % 2 == 1) {
            return false;
        }
        Map<Character, Character> map = new HashMap<Character, Character>(){
            {
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }
        };
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            if (map.containsKey(item)) {
                if (stack.isEmpty() || stack.pop() != map.get(item)) {
                    return false;
                }
            } else {
                stack.push(item);
            }
        }
        return stack.isEmpty();
    }

}
