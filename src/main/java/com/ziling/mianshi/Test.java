//package com.ziling.mianshi;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Stack;
//import java.util.stream.Collectors;
//
//import lombok.Data;
//
///**
// * @Author: yipeng
// * @Date: 2021/6/24 20:36
// */
//public class Test {
//
//    public static void main(String[] args) {
//        Node node1 = new Node();
//        Node node2 = new Node();
//        Node node3 = new Node();
//        Node node4 = new Node();
//        Node node5 = new Node();
//        Node node6 = new Node();
//        Node node7 = new Node();
//        Node node8 = new Node();
//        node1.setVal(5);
//        node2.setVal(4);
//        node3.setVal(8);
//        node4.setVal(1);
//        node5.setVal(11);
//        node6.setVal(9);
//        node7.setVal(2);
//        node8.setVal(7);
//
//        node1.setLeftNode(node2);
//        node1.setRightNode(node3);
//        node2.setLeftNode(node4);
//        node2.setRightNode(node5);
//        node3.setRightNode(node6);
//        node5.setLeftNode(node7);
//        node5.setRightNode(node8);
//        List<List<Integer>> result = getAllType(node1, 22);
//
//        System.out.println("Hello World!");
//    }
//
//    public static List<List<Integer>> getAllType(Node root, Integer sum) {
//        if (root == null) {
//            throw new RuntimeException("invaild value");
//        }
//        Stack<Node> stack = new Stack();
//        List<List<Integer>> result = new ArrayList<>();
//        stack.push(root);
//        Integer currentValue = 0;
//        while(!stack.isEmpty()){
//            Node currentNode = stack.pop();
//            currentValue = currentValue + currentNode.getVal();
//            if (currentNode.getLeftNode() == null && currentNode.getRightNode() == null) {
//                if (currentValue == sum) {
//                    // 将栈信息放到list中，再加上当前的叶子节点
////                    result.add(list);
//                }
//                currentValue = currentValue - currentNode.getVal();
//            }
//            if (currentNode.getLeftNode() != null) {
//                if (currentValue < sum) {
//                    stack.push(currentNode.getLeftNode());
//                }
//
//            }
//            if (currentNode.getRightNode() != null) {
//                if (currentValue < sum) {
//                    stack.push(currentNode.getRightNode());
//                }
//            }
//        }
//        return result;
//    }
//}
//
//@Data
//class Node {
//    private Integer val;
//    private Node leftNode;
//    private Node rightNode;
//}