package com.leetcode.tree.easy;

import com.leetcode.tree.TreeNode;
import com.leetcode.tree.TreeUtil;

public class RangeSumBST {

	public static void main(String[] args) {
		TreeNode root = TreeUtil.getBST();
		System.out.println("print BST");
		TreeUtil.traverseLevelByLevel(root);
		int low = 7 , high = 15;
		System.out.println("Range Sum "+rangeSumBST(root, low, high));
	}

	
	public static int rangeSumBST(TreeNode root, int low, int high) {

		if (root == null)
			return 0;

		if (root.val < low) {
			return rangeSumBST(root.right, low, high);
		}

		else if (root.val > high) {
			return rangeSumBST(root.left, low, high);
		} else {
			return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
		}

	}
}
