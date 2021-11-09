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

        int left = getLeftHeight(root);
        int right = getRightHeight(root);

        if(left == right){
            return (int) Math.pow(2, left) - 1;
        }else{
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    public static int getLeftHeight(TreeNode root){
        int count = 1;
        while(root.left != null){
            count++;
            root = root.left;
        }
        return count ;
    }

    public static int getRightHeight(TreeNode root){
        int count = 1;
        while(root.right != null){
            count++;
            root = root.right;
        }
        return count ;
    }

}
