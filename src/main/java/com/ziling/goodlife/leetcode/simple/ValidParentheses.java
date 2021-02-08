package com.ziling.goodlife.leetcode.simple;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * 有效的括号
 *
 * 难度：简单
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class ValidParentheses {

    public static void main(String[] args) {
        String s1 = "{[(8 + 4) * 8 + 5] * 7}";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "([)]";
        String s5 = "{[]}";
        String s6 = "{{[]}";
        String s7 =  "{";
        System.out.println(isValid(s1));
        System.out.println(isValid(s2));
        System.out.println(isValid(s3));
        System.out.println(isValid(s4));
        System.out.println(isValid(s5));
        System.out.println(isValid(s6));
        System.out.println(isValid(s7));

    }

    public static boolean isValid(String s) {
        if (s == null) {
            return true;
        }
        Map<Character, Character> parenthesesMap = new HashMap<>(3);
        parenthesesMap.put(')', '(');
        parenthesesMap.put(']', '[');
        parenthesesMap.put('}', '{');
        Set<Character> parenthesesLift = new HashSet<>(3);
        parenthesesLift.add('(');
        parenthesesLift.add('[');
        parenthesesLift.add('{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (parenthesesLift.contains(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if (parenthesesMap.containsKey(s.charAt(i))) {
                if (stack.isEmpty()) {
                    return false;
                }
                while (!stack.isEmpty()) {
                    if (parenthesesMap.get(s.charAt(i)).equals(stack.peek())) {
                        stack.pop();
                        break;
                    }
                    if (parenthesesLift.contains(stack.peek())) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid1(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}