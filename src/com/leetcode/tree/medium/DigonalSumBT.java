package com.leetcode.tree.medium;

import java.util.*;

public class DigonalSumBT {
    static class TreeNode {
        int data;
        int vd;
        TreeNode left, right;
        public TreeNode(int data)
        {
            this.data = data;
            vd = Integer.MAX_VALUE;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(11);
        root.left.left.right = new TreeNode(10);
        Tree tree = new Tree(root);
        tree.diagonalSum();
    }

    static class Tree
    {
        TreeNode root;

        public Tree(TreeNode root)  {  this.root = root;  }
        public void diagonalSum()
        {
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            Map<Integer, Integer> map = new TreeMap<>();
            root.vd = 0;
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode curr = queue.poll();
                int vd = curr.vd;
                while (curr != null) {
                    int prevSum = (map.get(vd) == null)? 0: map.get(vd);
                    map.put(vd, prevSum + curr.data);
                    if (curr.left != null) {
                        curr.left.vd = vd+1;
                        queue.add(curr.left);
                    }
                    curr = curr.right;
                }
            }


            System.out.print("Diagonal sum in a binary tree is  ");
            map.forEach((k,v)-> System.out.print(v+" "));
        }
    }

}
