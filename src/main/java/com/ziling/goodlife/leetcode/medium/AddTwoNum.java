package com.ziling.goodlife.leetcode.medium;

/**
 * 两数相加
 *
 * 难度：中等
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class AddTwoNum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode l = l1;
        int carry = 0;

        while(l1.next != null && l2.next != null) {
            int val = l1.val + l2.val + carry;
            if (val > 9) {
                carry = 1;
                val = val - 10;
            } else {
                carry = 0;
            }
            l1.val = val;
            l1 = l1.next;
            l2 = l2.next;
        }
        int val1 = l1.val + l2.val + carry;
        if (val1 > 9) {
            carry = 1;
            val1 = val1 - 10;
        } else {
            carry = 0;
        }
        l1.val = val1;
        if (l2.next != null) {
            l1.next = l2.next;

        }

        if (l1.next == null) {
            if (carry != 0) {
                ListNode h = new ListNode(1);
                l1.next = h;
            }
            return l;
        }
        l1 = l1.next;
        while (l1.next != null) {
            if (carry == 0) {
                return l;
            }
            int val = carry + l1.val;
            if (val > 9) {
                carry = 1;
                val = val - 10;
            } else {
                carry = 0;
            }
            l1.val = val;
            l1 = l1.next;
        }

        if (carry != 0) {
            int val = carry + l1.val;
            if (val > 9) {
                val = val - 10;
                carry = 1;
            } else {
                carry = 0;
            }
            l1.val = val;
            if (carry != 0) {
                ListNode h = new ListNode(1);
                l1.next = h;
            }
        }
        return l;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

}

