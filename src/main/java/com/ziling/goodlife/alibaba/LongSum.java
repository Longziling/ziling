package com.ziling.goodlife.alibaba;

/**
 * @Author: yipeng
 * @Date: 2021/5/11 20:14
 */
public class LongSum {
    private static ListNode stringToNode(String num) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        for (int i = num.length() - 1; i >= 0; i--) {
            ListNode list = new ListNode(num.charAt(i) - '0');
            current.next = list;
            current = list;

        }
        return head.next;
    }
    private static String nodeToString(ListNode l) throws Exception {
        if (l == null) {
            throw new Exception("invaild l");
        }
        ListNode current = l;
        StringBuilder sb = new StringBuilder();
        Integer n = current.val;
        sb.append(n);
        while (current.next != null) {
            current = current.next;
            sb.append(current.val);
        }
        return sb.reverse().toString();
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry != 0) {
            current.next = new ListNode(carry);
        }
        return head.next;
    }
    public static String addTwoNumber(String num1, String num2) throws Exception {
        if (num1== null || num2 == null) {
            throw new Exception("invaild");
        }
        ListNode l1 = stringToNode(num1);
        ListNode l2 = stringToNode(num2);
        ListNode result = addTwoNumbers(l1, l2);
        return nodeToString(result);
    }
    public static void main(String[] args) {
        try {
            System.out.println(addTwoNumber("787878899", "1213797979"));
            System.out.println(1213797979 + 787878899);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class ListNode {

    Integer val;
    ListNode next;

    public ListNode(Integer value) {
        this.val = value;
    }
}
