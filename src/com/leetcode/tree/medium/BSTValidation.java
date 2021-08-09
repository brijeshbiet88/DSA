package com.leetcode.tree.medium;

import com.leetcode.tree.TreeNode;
import com.leetcode.tree.TreeUtil;

public class BSTValidation {

    public static void main(String [] args){
        TreeNode root = TreeUtil.getBST();
        System.out.println("Print Tree ");
        TreeUtil.traverseLevelByLevel(root);
        System.out.println();
        System.out.println("Is Valid BST = "+isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return isValidBSTUtil(root , Long.MIN_VALUE , Long.MAX_VALUE);
    }

    private static boolean isValidBSTUtil(TreeNode root, long minValue, long maxValue) {
        if(root == null) return true;
        boolean isValid = root.val > minValue && root.val < maxValue;
        return (isValid && isValidBSTUtil(root.left , minValue ,root.val-1) &&
                isValidBSTUtil(root.right , root.val+1,maxValue));
    }
}
