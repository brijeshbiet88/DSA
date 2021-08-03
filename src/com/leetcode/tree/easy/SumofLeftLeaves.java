package com.leetcode.tree.easy;

import com.leetcode.tree.TreeNode;
import com.leetcode.tree.TreeUtil;

public class SumofLeftLeaves {

	public static void main(String[] args) {
		TreeNode root = TreeUtil.getTree();
		System.out.println("Print Tree ");
		TreeUtil.traverseLevelByLevel(root);
		System.out.println("Sum of Left Leaves = " + sumOfLeftLeaves(root));

	}

	public static int sumOfLeftLeaves(TreeNode root) {
		if(root == null) return 0;
		TreeNode leftNode = root.left;
		if(leftNode != null && leftNode.left == null && leftNode.right == null) {
			return leftNode.val + sumOfLeftLeaves(root.right);
		}else {
			return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
		}
		
	}
}
