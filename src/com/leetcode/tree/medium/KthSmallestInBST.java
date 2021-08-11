package com.leetcode.tree.medium;

import com.leetcode.tree.TreeNode;
import com.leetcode.tree.TreeUtil;

import java.util.Stack;

public class KthSmallestInBST {

    public static void main(String [] args) {
        TreeNode root = TreeUtil.getBST();
        System.out.println("Print Tree ");
        TreeUtil.traverseLevelByLevel(root);
        int k = 3;
        System.out.println("Kth Smallest Element = "+kthSmallest(root , k));
    }

    public static int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }
}
