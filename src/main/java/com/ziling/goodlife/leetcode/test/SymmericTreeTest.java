package com.ziling.goodlife.leetcode.test;

import java.util.LinkedList;
import java.util.Queue;

public class SymmericTreeTest {

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null &&  right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    public boolean isSymmetric(TreeNode root) {
        TreeNode root1 = root;
        TreeNode root2 = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root1);
        queue.add(root2);
        while (!queue.isEmpty() && queue.size() % 2 == 0) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null & node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null) {
                return false;
            }
            if (node1.val != node2.val) {
                return false;
            }
            queue.add(node1.left);
            queue.add(node2.right);
            queue.add(node1.right);
            queue.add(node2.left);
        }
        return queue.isEmpty();
    }


}
