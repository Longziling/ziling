package com.ziling.goodlife.leetcode.test;

public class RemoveNthFromEndTest {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode current = head;
        while(fast != null) {
            if (n > 0) {
                current = current.next;
            } else {
                n--;
            }
            fast = fast.next;
        }
        if (n == 0) {
            return head.next;
        }
        current.next = current.next.next;
        return head;
    }
}
