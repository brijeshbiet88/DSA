package com.leetcode.tree.easy;

import com.leetcode.tree.TreeNode;
import com.leetcode.tree.TreeUtil;

public class InvertBT {

	public static void main(String[] args) {
		TreeNode root = TreeUtil.getTree();
		System.out.println("Level Order ");
		TreeUtil.traverseLevelByLevel(root);
		root = invertTree(root);
		System.out.println();
		System.out.println("Level Order After Inverting BT ");
		TreeUtil.traverseLevelByLevel(root);
	}

	public static TreeNode invertTree(TreeNode root) {
		
		if(root == null) return root;
		
		TreeNode temp;
		
		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);
		
		temp = left ;
		
		root.left = right;
		root.right = temp;
		return root;
	}

}
