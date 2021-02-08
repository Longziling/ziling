package com.ziling.goodlife.datastructure.tree;

public class RBTree<T extends Comparable<T>> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private TreeNode<T> root;

    /**
     * 内部节点
     */
    static class TreeNode<T extends Comparable<T>>  {
        T data;
        boolean color;
        boolean isDelete;
        TreeNode<T> parent;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data, boolean color) {
            this.data = data;
            this.color = color;
        }

        TreeNode(T data) {
            this.data = data;
            this.color = RED;
        }

    }

    /**
     * 插入一个新的节点，插入完毕后符合红黑树性质
     *
     * @param data  需要插入的数据
     */
    public void insertNode(T data) {
        TreeNode<T> curr;
        TreeNode<T> parent = toTargetParent(data);
        if (parent == null) {
            curr = root = new TreeNode<T>(data);
        } else {
            if (data.compareTo(parent.data) < 0) {
                curr = parent.left = new TreeNode<T>(data);
            } else {
                curr = parent.right = new TreeNode<T>(data);
            }
            curr.parent = parent;
        }
        fixupTree(curr);
    }

    /**
     *  调到data存放位置的父节点处
     * @param data  用于对比的数据
     * @return  data可存放处的父节点
     */
    private TreeNode<T> toTargetParent(T data) {
        TreeNode<T> curr = root;
        TreeNode<T> parent = root;
        while (curr != null) {
            parent = curr;
            if (data.compareTo(parent.data) < 0) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return parent;
    }

    /**
     * 修复红黑树的不平衡状态
     *
     * @param node  新增节点
     */
    private void fixupTree(TreeNode<T> node) {
        TreeNode<T> parent = null;
        TreeNode<T> grandParent = null;
        boolean parentColor = BLACK;
        boolean uncleColor = BLACK;
        if (node != root) {
            parent = node.parent;
            if (parent != null) {
                grandParent = parent.parent;
                parentColor = parent.color;
                uncleColor = getUncleColor(node);
            }
        }

        if (parent == null && node.color == RED) {
            node.color = BLACK;
        } else if (parentColor == RED && uncleColor == RED) {
            changeColor(grandParent);
            fixupTree(grandParent);
        } else if (parentColor == RED && uncleColor == BLACK) {
            dispatchRotation(grandParent, parent, node);
        }
    }

    /**
     * 返回叔叔节点的颜色
     *
     * @param node 一个节点
     * @return 其叔叔节点的颜色
     */
    private boolean getUncleColor(TreeNode<T> node) {
        TreeNode<T> parent = node.parent;
        return getBrotherColor(parent.parent == null ? node : parent);
    }

    /**
     * 返回兄弟节点的颜色
     *
     * @param child 传入节点
     * @return 返回兄弟节点的颜色
     */
    private boolean getBrotherColor(TreeNode<T> child) {
        TreeNode<T> parent = child.parent;
        if (parent.left == child && parent.right != null) {
            return parent.right.color;
        } else if (parent.right == child && parent.left != null) {
            return parent.left.color;
        } else {
            return BLACK;
        }
    }

    /**
     *  改变祖父节点以及两个子节点的颜色
     *
     * @param grandParent   传入新增节点的祖父
     */
    private void changeColor(TreeNode<T> grandParent) {
        grandParent.color = RED;
        if (grandParent.left != null) {
            grandParent.left.color = BLACK;
        }
        if (grandParent.right != null) {
            grandParent.right.color = BLACK;
        }
    }

    /**
     * 判断属于哪种四种情况，LL、LR、RR、RL，使用正确的旋转
     *
     * @param grandParent   祖父节点
     * @param parent    父节点
     * @param child     新增节点
     */
    private void dispatchRotation(TreeNode<T> grandParent, TreeNode<T> parent, TreeNode<T> child) {
        if (grandParent.left == parent) {
            if (parent.left == child) {
                parent.color = BLACK;
                grandParent.color = RED;
                rightRotation(grandParent);
            } else {
                leftRotation(parent);
                child.color = BLACK;
                grandParent.color = RED;
                rightRotation(grandParent);
            }
        } else {
            if (parent.left == child) {
                rightRotation(parent);
                child.color = BLACK;
                grandParent.color = RED;
                leftRotation(grandParent);
            } else {
                parent.color = BLACK;
                grandParent.color = RED;
                leftRotation(grandParent);
            }
        }
    }

    /**
     *  将传入的节点的右子节点提升为新的父节点，传入节点降为其右子节点
     *  注意颜色、父节点需要处理，务必要清除传入节点的右子节点，因为其已经被提升了父节点了。
     * @param curr  一个节点
     */
    private void leftRotation(TreeNode<T> curr) {
        TreeNode<T> tparent = curr.right;
        tparent.parent = curr.parent;
        curr.right = tparent.left;
        if (tparent.left != null) {
            tparent.left.parent = curr;
        }
        curr.parent = tparent;
        tparent.left = curr;
        setChild(curr, tparent);
    }

    /**
     *  将传入的节点的左子节点提升为新的父节点，传入节点降为其右子节点
     *  注意颜色、父节点需要处理，务必要清除传入节点的左子节点，因为其已经被提升了父节点了。
     * @param curr  一个节点
     */
    private void rightRotation(TreeNode<T> curr) {
        TreeNode<T> tparent = curr.left;
        tparent.parent = curr.parent;
        curr.left = tparent.right;
        if (tparent.right != null) {
            tparent.right.parent = curr;
        }
        curr.parent = tparent;
        tparent.right = curr;
        setChild(curr, tparent);
    }




//    /**
//     *  将传入的节点的右子节点提升为新的父节点，传入节点降为其右子节点
//     *  注意颜色、父节点需要处理，务必要清除传入节点的右子节点，因为其已经被提升了父节点了。
//     * @param curr  一个节点
//     */
//    private void leftRotation(TreeNode<T> curr) {
//        TreeNode<T> tparent = curr.right;
//        tparent.color = BLACK;
//        curr.color = RED;
//        tparent.parent = curr.parent;
//        curr.right = tparent.left;
//        if (tparent.left != null) {
//            tparent.left.parent = curr;
//        }
//        curr.parent = tparent;
//        tparent.left = curr;
//        setChild(curr, tparent);
//    }
//
//    /**
//     *  将传入的节点的左子节点提升为新的父节点，传入节点降为其右子节点
//     *  注意颜色、父节点需要处理，务必要清除传入节点的左子节点，因为其已经被提升了父节点了。
//     * @param curr  一个节点
//     */
//    private void rightRotation(TreeNode<T> curr) {
//        TreeNode<T> tparent = curr.left;
//        tparent.color = BLACK;
//        curr.color = RED;
//        tparent.parent = curr.parent;
//        curr.left = tparent.right;
//        if (tparent.right != null) {
//            tparent.right.parent = curr;
//        }
//        curr.parent = tparent;
//        tparent.right = curr;
//        setChild(curr, tparent);
//    }


    /**
     * 使旋转在树中生效
     *
     * @param roNode    被旋转的节点
     * @param newParent 被旋转之后的父节点
     */
    private void setChild(TreeNode<T> roNode, TreeNode<T> newParent) {
        TreeNode<T> roNodeParent = newParent.parent;
        if (roNodeParent == null) {
            root = newParent;
        } else if (roNodeParent.left == roNode) {
            roNodeParent.left = newParent;
        } else {
            roNodeParent.right = newParent;
        }
    }




    public static void main(String[] args) {

        int[] testNum = new int[]{15, 1, 3, 6, 8, 20, 22, 43, 67};
//        int[] testNum = new int[]{2, 3, 1};
        RBTree<Integer> fuck = new RBTree<Integer>();
        for (int i = 0; i < testNum.length; i++) {
            fuck.insertNode(testNum[i]);
        }
        System.out.println(fuck.root.data);


//        RBTree<Character> fuck = new RBTree<Character>();
//        fuck.insertNode('F');
//        fuck.insertNode('G');
//        fuck.insertNode('D');
//        fuck.insertNode('B');
//        fuck.insertNode('C');
//        System.out.println(fuck.root.data);
    }

}
