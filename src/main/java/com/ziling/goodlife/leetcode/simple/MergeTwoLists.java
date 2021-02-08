package com.ziling.goodlife.leetcode.simple;

/**
 * 合并两个有序链表
 *
 * 难度：简单
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode headNode = new ListNode(0);
        ListNode currentNode = headNode;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                currentNode.next = l1;
                l1 = l1.next;
            } else {
                currentNode.next = l2;
                l2 = l2.next;
            }
            currentNode = currentNode.next;
        }
        currentNode.next = l1 != null ? l1 : l2;
        return headNode.next;
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }

    }


    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode headNode = new ListNode(0);
        ListNode currentNode = headNode;
        mergeTwoLists(l1, l2, currentNode);
        return headNode.next;
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2, ListNode currentNode) {
        if (l1 == null) {
            currentNode.next = l2;
            return null;
        }
        if (l2 == null) {
            currentNode.next = l1;
            return null;
        }
        if (l1.val < l2.val) {
            currentNode.next = l1;
            currentNode = currentNode.next;
            return mergeTwoLists(l1.next, l2, currentNode);
        }
        currentNode.next = l2;
        currentNode = currentNode.next;
        return mergeTwoLists(l1, l2.next, currentNode);
    }
}