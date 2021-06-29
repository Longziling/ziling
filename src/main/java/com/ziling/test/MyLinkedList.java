package com.ziling.test;


/**
 * 用java代码实现LinkedList的add()和remove()方法。要求自行设计LinkedList数据结构，不要外部类库和辅助函数来处理
 */
public class MyLinkedList<E> {
    private Node head;
    private int size;
    private class Node {
        E data;
        Node next;
        Node prev;
        public Node(E e) {
            data = e;
        }
    }

    /**
     * 追加元素方法
     */
    public boolean add(E e) {
        if (head == null) {
            head = new Node(e);
            head.next = head;
            head.prev = head;
            size++;
            return true;
        } else {
            Node last = head.prev;
            Node node =new Node(e);
            head.prev = node;
            last.next = node;
            node.prev = last;
            node.next = head;
            size++;
            return true;
        }
    }

    /**
     * 插入元素
     */
    public boolean add(int index, E e) {
        Node node = findNode(index);
        Node last = node.prev;
        Node next = node;
        Node newNode = new Node(e);
        last.next = newNode;
        newNode.prev = last;
        newNode.next = next;
        next.prev = newNode;
        size++;
        return true;
    }

    /**
     * 删除元素
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = findNode(index);
        E e = node.data;
        node.prev.next = node.next;
        node.next.prev = node.prev;
        if (index == 0) {
            head = node.next;
        }
        node.next = null;
        node.prev = null;
        size--;
        return e;
    }


    public Node findNode(int index) {
        Node node;
        // 查找位置
        if (index > size >> 1) {
            node = head.prev;
            for (int i = size -1; i > index; i--) {
                node = node.prev;
            }
        } else {
            node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        }
        return node;
    }
}
