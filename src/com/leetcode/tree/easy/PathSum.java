package com.leetcode.tree.easy;

import com.leetcode.tree.TreeNode;
import com.leetcode.tree.TreeUtil;

public class PathSum {

	public static void main(String[] args) {
		TreeNode root = TreeUtil.getBST();
		System.out.println("Print Tree ");
		TreeUtil.traverseLevelByLevel(root);
		int targetSum = 22;
		System.out.println("Is TargetSum Available in Root To Leaf Path Sum ? "+hasPathSum(root, targetSum) );

	}

	public static boolean hasPathSum(TreeNode root, int targetSum) {
		 if(root == null) return false;      
	        return (root.left == null && root.right == null && root.val == targetSum) ||
					hasPathSum(root.left,targetSum - root.val) ||
					hasPathSum(root.right,targetSum - root.val);
	}

}
