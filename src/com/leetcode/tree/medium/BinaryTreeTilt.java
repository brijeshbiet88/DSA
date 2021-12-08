package com.leetcode.tree.medium;

import com.leetcode.tree.TreeNode;
import com.leetcode.tree.TreeUtil;

public class BinaryTreeTilt {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);

        root.left = new TreeNode(2);
        root.right = new TreeNode(9);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(7);

        System.out.println("Level Order Traversal");
        TreeUtil.traverseLevelByLevel(root);

        int result = findTilt(root);
        System.out.println("Tilt result = "+result);


    }

    public static int findTilt(TreeNode root) {
        findTiltHelper(root);
        System.out.println("Tilted Tree");
        TreeUtil.traverseLevelByLevel(root);
        return findTiltSum(root);
    }

    public static int findTiltSum(TreeNode root) {
        if(root == null)
            return 0;

        int left = findTiltSum(root.left);
        int right = findTiltSum(root.right);

        return root.val + left + right;
    }

    private static int findTiltHelper(TreeNode root ){
        if(root == null)
            return 0;

        int left = findTiltHelper(root.left);
        int right = findTiltHelper(root.right);

        int prev = root.val;
        root.val = Math.abs(left-right);
        return prev + left + right;
    }
}
