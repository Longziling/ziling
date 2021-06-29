package com.ziling.goodlife.algorithm;

public class JosephCircle {

    public int cir1(int n, int m) {
        int p = 0;
        for(int i = 2; i <= n; i++) {
            p = (p + m) % i;
        }
        return p + 1;
    }

    public int cir2(int n, int m) {
        int p = 1;
        for (int i = 2; i <= n; i++) {
            p = (p + m - 1) % i + 1;
        }
        return p;
    }

    public int cir3(int n, int m){
        return n == 1 ? n : (cir3(n - 1, m) + m - 1) % n + 1;
    }

    public static int solve(int n, int m) {
        if (m == 1 || n < 2) {
            return n;
        }
        //创建环形链表
        Node head = createLinkedList(n);
        int count = 1;
        Node cur = head;
        Node pre = null;
        while (cur.next != cur) {
            if (count == m) {
                count = 1;
                pre.next = cur.next;
                cur = pre.next;
            } else {
                count++;
                pre = cur;
                cur = cur.next;
            }
        }
        return cur.data;
    }


    public static Node createLinkedList(int n) {
        Node head = new Node(1);
        Node next = head;
        for (int i = 2; i <= n; i++) {
            Node temp = new Node(i);
            next.next = temp;
            next = next.next;
        }
        next.next = head;
        return head;
    }


    public static void main(String[] args) {
        JosephCircle circle = new JosephCircle();
        System.out.println(circle.cir1(111, 3));
        System.out.println(solve(111, 3));
    }

}


class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
    }
}


