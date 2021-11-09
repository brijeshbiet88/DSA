package com.leetcode.tree.medium;

import com.leetcode.tree.TreeNode;
import com.leetcode.tree.TreeUtil;

public class CountCompleteTreeNodes {
    public static void main(String[] args) {
        TreeNode root = TreeUtil.getTree2();
        int count = countNodes(root);
        System.out.println("Complete Tree Nodes = "+count);
    }

    public static int countNodes(TreeNode root) {
        if(root == null) return 0;
        int height = 1;
        TreeNode left = root.left , right = root.right;
        while(left != null && right != null){
            left = left.left;
            right = right.right;
            height++;
        }

        if(left == null && right == null){
            return (int) Math.pow(2, height) - 1;
        }else{
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

}
