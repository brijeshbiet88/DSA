package com.leetcode.tree.medium;

import com.leetcode.tree.TreeNode;

public class ConstructBSTFromPreOrder {
    public static void main(String[] args) {
        System.out.println("------------Test Case 1-----------------");
        int [] preorder = {8,5,1,7,10,12};
        TreeNode root = bstFromPreorder(preorder);
        System.out.println("Print InOrder Traversal BST");
        inOrder(root);
        System.out.println();

    }

    public static void inOrder(TreeNode root){
        if(root == null) {
           return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }

    public static TreeNode bstFromPreorder(int[] preorder) {
        return constructBST(preorder , 0 , preorder.length);
    }

    public static TreeNode constructBST(int[] preorder , int rootIndex , int high){
        if(rootIndex >= high) return null;
        int value = preorder[rootIndex];
        TreeNode root = new TreeNode(value);

        int i = rootIndex + 1;
        while(i <= preorder.length-1 && preorder[i] < value){
            i++;
        }

        root.left = constructBST(preorder, rootIndex + 1, i);
        root.right = constructBST(preorder,i, high);

        return root;
    }
}
