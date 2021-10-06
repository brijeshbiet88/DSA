package com.leetcode.tree.medium;

import com.leetcode.tree.TreeNode;
import com.leetcode.tree.TreeUtil;

public class BoundaryOfBT {
    public static void main(String[] args) {
        System.out.println("-----------------Test Case 1-------------------");
        TreeNode root = TreeUtil.getTree();
        printBoundary(root);
        System.out.println();

        System.out.println("-----------------Test Case 2-------------------");
        TreeNode root2 = TreeUtil.getTree2();
        printBoundary(root2);
        System.out.println();

    }

    private static void printLeaves(TreeNode node)
    {
        if (node == null)
            return;

        printLeaves(node.left);
        if (node.left == null && node.right == null)
            System.out.print(node.val + " ");
        printLeaves(node.right);
    }

    private static void printBoundaryLeft(TreeNode node)
    {
        if (node == null)
            return;

        if (node.left != null) {
            System.out.print(node.val + " ");
            printBoundaryLeft(node.left);
        }
        else if (node.right != null) {
            System.out.print(node.val + " ");
            printBoundaryLeft(node.right);
        }

    }

    private static void printBoundaryRight(TreeNode node)
    {
        if (node == null)
            return;

        if (node.right != null) {
            printBoundaryRight(node.right);
            System.out.print(node.val + " ");
        }
        else if (node.left != null) {
            printBoundaryRight(node.left);
            System.out.print(node.val + " ");
        }
    }

    private static void printBoundary(TreeNode node)
    {
        if (node == null)
            return;

        System.out.print(node.val + " ");
        printBoundaryLeft(node.left);
        printLeaves(node.left);
        printLeaves(node.right);
        printBoundaryRight(node.right);
    }
}
