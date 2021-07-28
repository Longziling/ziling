package com.ziling.mianshi;

import java.util.ArrayList;

import lombok.Data;

/**
 * 二叉树根节点到叶子节点和为指定值的路径
 * 给定一个二叉树和一个值sum，请找出所有的根节点到叶子节点的节点值之和等于sum 的路径，
 * 例如：给出如下的二叉树，sum=22，
 *           5
 *        /    \
 *       4      8
 *      / \      \
 *     1   11      9
 *        / \
 *       2   7
 *
 * 返回[[5,4,11,2],[5,8,9]]
 * 示例1
 * 输入{1,2},1
 * 输出[]
 * 示例2
 * 输入{1,2},3
 * 输出[[1,2]]
 *
 */
public class SpecifiedPathTree {

    public ArrayList<ArrayList<Integer>> pathSum (TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        process(root, 0, sum, new ArrayList<Integer>(), res);
        return res;
    }

    private void process(TreeNode root, int currentSum, int sum, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res) {
        path.add(root.getVal());
        currentSum += root.getVal();
        if (root.getLeft() == null && root.getRight() == null) {
            if (currentSum == sum){
                res.add(new ArrayList<>(path));
            }
        } else if (currentSum < sum) {
            if (root.getLeft() != null) {
                process(root.getLeft(), currentSum, sum, path, res);
            }
            if (root.getRight() != null) {
                process(root.getRight(), currentSum, sum, path, res);
            }
        }
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode();
        TreeNode node2 = new TreeNode();
        TreeNode node3 = new TreeNode();
        TreeNode node4 = new TreeNode();
        TreeNode node5 = new TreeNode();
        TreeNode node6 = new TreeNode();
        TreeNode node7 = new TreeNode();
        TreeNode node8 = new TreeNode();
        node1.setVal(5);
        node2.setVal(4);
        node3.setVal(8);
        node4.setVal(1);
        node5.setVal(11);
        node6.setVal(9);
        node7.setVal(2);
        node8.setVal(7);
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setRight(node6);
        node5.setLeft(node7);
        node5.setRight(node8);
        SpecifiedPathTree specifiedPathTree = new SpecifiedPathTree();
        ArrayList<ArrayList<Integer>> result = specifiedPathTree.pathSum(node1, 10);
        System.out.println(result);
    }

}

@Data
class TreeNode {
    private int val = 0;
    private TreeNode left = null;
    private TreeNode right = null;
}

