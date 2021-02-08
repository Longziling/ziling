package com.ziling.goodlife.leetcode.medium;

/**
 * 删除链表的倒数第N个节点
 *
 * 难度：中等
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 *
 * 示例 :
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.

 * 注意：给定的 n 保证是有效的。
 * 尝试使用一趟扫描实现
 *
 *
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) {
            return head;
        }
        ListNode current = head;
        ListNode fast = head;
        while (n > 0) {
            if (fast.next == null) {
                return head.next;
            }
            fast = fast.next;
            n--;
        }
        while (fast.next != null) {
            current = current.next;
            fast = fast.next;
        }
        current.next = current.next.next;
        return head;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode current = head;
        ListNode fast = head;
        while (fast != null) {
            if (n < 0) {
                current = current.next;
            }
            fast = fast.next;
            n--;
        }
        if (n == 0) {
            return head.next;
        }
        current.next = current.next.next;
        return head;
    }

}
