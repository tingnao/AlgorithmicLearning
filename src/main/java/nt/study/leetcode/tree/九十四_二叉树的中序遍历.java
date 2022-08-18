package nt.study.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class 九十四_二叉树的中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        backtrack(list, root);
        return list;
    }
    public void backtrack(List<Integer> list, TreeNode root){
        backtrack(list, root.left);
        list.add(root.val);
        backtrack(list, root.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
