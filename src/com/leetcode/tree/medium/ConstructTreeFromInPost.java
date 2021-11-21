package com.leetcode.tree.medium;

import com.leetcode.tree.TreeNode;
import com.leetcode.tree.TreeUtil;

public class ConstructTreeFromInPost {
    public static void main(String[] args) {
        System.out.println("----------------Test Case 1------------------");
        int [] inorder = {9,3,15,20,7};
        int [] postorder = {9,15,7,20,3};
        TreeNode root = buildTree(inorder,postorder);
        System.out.println("Print Level Order of Constructed Tree :");
        TreeUtil.traverseLevelByLevel(root);
        System.out.println();
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        int length = postorder.length;
        return constructTreeFromInPost(inorder , postorder , 0 , length-1 , length-1 );
    }

    public static TreeNode constructTreeFromInPost(int[] in , int[] post , int start , int end , int index){
        if(start > end) return null;
        TreeNode root = new TreeNode(post[index]);
        int inorderIndex = start;
        while(post[index] != in[inorderIndex])
            inorderIndex++;

        root.left = constructTreeFromInPost(in , post , start , inorderIndex -1 , index-(end-inorderIndex) -1 );
        root.right = constructTreeFromInPost(in , post , inorderIndex +1 , end , index-1 );

        return root;
    }
}
