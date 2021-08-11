package com.leetcode.tree.medium;

import com.leetcode.tree.TreeNode;
import com.leetcode.tree.TreeUtil;

public class ConstructTreeFromPrePost {

	public static void main(String[] args) {
		int[] preorder = { 1, 2, 3, 4 };
		int[] postorder = { 3, 4, 2, 1 };
		TreeNode root = constructFromPrePost(preorder, postorder);
		System.out.println("Print Tree ");
		TreeUtil.traverseLevelByLevel(root);
	}

	public static TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
		return dfs(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
	}

	private static TreeNode dfs(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
		if (preStart > preEnd)
			return null;
		TreeNode root = new TreeNode(preorder[preStart]);
		if (preStart == preEnd)
			return root;

		int postIndex = postStart;
		while (postorder[postIndex] != preorder[preStart + 1]) {
			postIndex++;
		}

		int len = postIndex - postStart + 1;
		root.left = dfs(preorder, preStart + 1, preStart + len, postorder, postStart, postIndex);
		root.right = dfs(preorder, preStart + len + 1, preEnd, postorder, postIndex + 1, postEnd - 1);

		return root;
	}
}
