package com.ziling.goodlife.alibaba;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.python.google.common.collect.Lists;

/**
 * @Author: yipeng
 * @Date: 2021/6/17 23:35
 *
 * 题目
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 示例
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层序遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        List<List<Integer>> result = Lists.newArrayList();
        deep(treeNode, 0, result);
        return result;
    }

    private void deep(TreeNode treeNode, Integer deep, List<List<Integer>> result) {
        if (deep == result.size()) {
            result.add(Lists.newArrayList());
        }
        result.get(deep).add(treeNode.val);
        if (treeNode.left != null) {
            deep(treeNode.left, deep + 1, result);
        }
        if (treeNode.right != null) {
            deep(treeNode.right, deep + 1, result);
        }
    }


    public List<List<Integer>> levelOrder1(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        List<List<Integer>> result = Lists.newArrayList();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            int sum = queue.size();
            List<Integer> resultItem = Lists.newArrayList();
            while (sum != 0) {
                TreeNode treeNodeItem = queue.poll();
                resultItem.add(treeNodeItem.val);
                if (treeNodeItem.left != null) {
                    queue.add(treeNodeItem.left);
                }
                if (treeNodeItem.right != null) {
                    queue.add(treeNodeItem.right);
                }
                sum--;
            }
            result.add(resultItem);
        }
        return result;
    }


    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode();
        TreeNode treeNode2 = new TreeNode();
        TreeNode treeNode3 = new TreeNode();
        TreeNode treeNode4 = new TreeNode();
        TreeNode treeNode5 = new TreeNode();
        treeNode1.val = 3;
        treeNode2.val = 9;
        treeNode3.val = 20;
        treeNode4.val = 15;
        treeNode5.val = 7;
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        LevelOrder levelOrder = new LevelOrder();
        List<List<Integer>> list = levelOrder.levelOrder1(treeNode1);
        System.out.println(list);
    }

}

class TreeNode {
    TreeNode left;
    TreeNode right;
    Integer val;
}