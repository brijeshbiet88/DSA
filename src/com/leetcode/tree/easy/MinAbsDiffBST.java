package com.leetcode.tree.easy;

import com.leetcode.tree.TreeNode;
import com.leetcode.tree.TreeUtil;

public class MinAbsDiffBST {

	public static void main(String[] args) {
		TreeNode root = TreeUtil.getBST();
		System.out.println("Print Tree ");
		TreeUtil.traverseLevelByLevel(root);
		System.out.println("Min Absolute Difference in BST = " + getMinimumDifference(root));
	}
	static int res ;
	static int prev ;
	
	public static void recurse(TreeNode node) {
	        if (node == null)
	            return;
	        
	        recurse(node.left);
	        
	        if (prev != -1)
	            res = Math.min(res, Math.abs(prev - node.val));
	        prev = node.val;
	        
	        recurse(node.right);
	    }
	    
	    public static int getMinimumDifference(TreeNode root) {
	        res = Integer.MAX_VALUE;
	        prev = -1;
	        recurse(root);
	        return res;
	    }

}
