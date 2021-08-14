package com.leetcode.tree.medium;

import com.leetcode.tree.TreeNode;
import com.leetcode.tree.TreeUtil;

public class RecoverBST {

	static TreeNode prev = null, first = null, second = null;

	public static void main(String[] args) {
		TreeNode root = TreeUtil.getBST();
		System.out.println();

		int temp = root.val;
		root.val = root.left.right.val;
		root.left.right.val = temp;
		System.out.println("Print BST ");
		TreeUtil.traverseLevelByLevel(root);
		System.out.println();
		recoverTree(root);
		System.out.println("Print Recovered BST ");
		TreeUtil.traverseLevelByLevel(root);

	}

	public static void recoverTree(TreeNode root) {
		if (root == null) {
			return;
		}

		inorder(root);
		int temp = first.val;
		first.val = second.val;
		second.val = temp;
	}

	public static void inorder(TreeNode root) {
		if(first != null && second != null){
			return;
		}
		if (root == null) {
			return;
		}
		inorder(root.left);
		if (prev != null && root.val < prev.val) {
			if (first == null) {
				first = prev;
			}
			second = root;
		}
		prev = root;
		inorder(root.right);
	}
}
