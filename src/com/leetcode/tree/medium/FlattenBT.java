package com.leetcode.tree.medium;

import com.leetcode.tree.TreeNode;
import com.leetcode.tree.TreeUtil;

public class FlattenBT {
    public static void main(String[] args) {
        TreeNode root = TreeUtil.getBST();
        flatten(root);
        System.out.println("Print Flattened Tree");
        TreeUtil.traverseLevelByLevel(root);
    }

    public static void flatten(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return;
        if(root.left != null) {
            flatten(root.left);
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode curr = root.right;
            while(curr.right != null){
                curr = curr.right;
            }
            curr.right = temp;
        }
        if(root.right != null){
            flatten(root.right);
        }
    }
}
