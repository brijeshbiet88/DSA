package com.leetcode.tree.easy;

import com.leetcode.tree.TreeNode;
import com.leetcode.tree.TreeUtil;

public class DiameterBT {
	static int ans = 0;
	public static void main(String[] args) {
		TreeNode root = TreeUtil.getTree2();
		System.out.println("Level Order ");
		TreeUtil.traverseLevelByLevel(root);
		
		System.out.println("Diameter of BT = "+diameterOfBinaryTree(root));

	}
	
	 public static int diameterOfBinaryTree(TreeNode root) {
		 getDiameter(root);
		 return ans == 0 ? 0 : ans -1;
	 }

	private static int getDiameter(TreeNode root) {

		if (root == null)
			return 0;

		int left = getDiameter(root.left);
		int right = getDiameter(root.right);

		ans = Math.max(ans, left + right + 1);

		return Math.max(left, right) + 1;

	}

}
