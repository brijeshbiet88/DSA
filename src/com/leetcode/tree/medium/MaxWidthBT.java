package com.leetcode.tree.medium;

import com.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MaxWidthBT {
    static int maxWidth = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);


        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        root.left.left.left = new TreeNode(6);
        root.right.right.right = new TreeNode(7);

        root.left.left.left.left = new TreeNode(8);
        System.out.println("Max Width of Binary Tree "+widthOfBinaryTree( root));

    }

    public static int widthOfBinaryTree(TreeNode root) {
        List<Integer> leftMostNodes = new ArrayList<Integer>();
        return dfs(root , 1 , 0 , leftMostNodes);
    }

    private static int dfs(TreeNode root, int id, int level, List<Integer> leftMostNodes) {
        if(root == null) return 0;
        if(level == leftMostNodes.size()){
            leftMostNodes.add(id);
        }
        return Math.max(id + 1 - leftMostNodes.get(level) ,
                Math.max(dfs(root.left, id * 2, level + 1, leftMostNodes) ,
                        dfs(root.right, id * 2 + 1, level + 1, leftMostNodes))
        );
    }


}
