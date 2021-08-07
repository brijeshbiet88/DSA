package com.leetcode.tree.easy;

import com.leetcode.tree.TreeNode;
import com.leetcode.tree.TreeUtil;

public class BalancedTree {
	static boolean isBal = true;
	public static void main(String[] args) {
		TreeNode root = TreeUtil.getTree2();
		System.out.println("Print Tree ");
		TreeUtil.traverseLevelByLevel(root);
		System.out.println("Is Balanced Tree ? "+isBalanced(root));
	}

	public static boolean isBalanced(TreeNode root) {
		 if(root == null){
	            return true;
	        }
	         height(root);
	         return isBal;		
	}
	
	public static int height(TreeNode root) {
		if(root == null) return 0;
		
		int lh = height(root.left);
		int rh = height(root.right);
		
		if(Math.abs(lh-rh) > 1)
			isBal = false;
		
		return 1 + Math.max(lh, rh);
	}
}
