package com.ziling.test;


import java.util.LinkedList;
import java.util.Queue;

import lombok.Data;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。（即逐层地，从左到右访问所有节点）。
 */
public class TreeTest {

    public void vist(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue =  new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode item = queue.poll();
                System.out.println(item.getVal());
                if (item.getLeft() != null) queue.add(item.getLeft());
                if (item.getRight() != null) queue.add(item.getRight());
                size--;
            }

        }
    }

}

@Data
class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;
}