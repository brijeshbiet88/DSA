package com.leetcode.tree.easy;

import com.leetcode.tree.TreeNode;
import com.leetcode.tree.TreeUtil;

public class SymmetricTree {

	public static void main(String[] args) {
		TreeNode root = TreeUtil.getSymmetricTree();
		System.out.println("Symmetric Tree");
		TreeUtil.traverseLevelByLevel(root);
		System.out.println("is Sysmettric Tree "+isSymmetric(root));
	}

	public static boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        TreeNode left = root.left;
        TreeNode right = root.right;
        return areMirrorImage(left , right);
    }

	public static boolean areMirrorImage(TreeNode root1, TreeNode root2) {
		if(root1 == null && root2 == null) return true;
		if(root1 == null || root2 == null) return false;
		return (root1.val == root2.val && areMirrorImage(root1.left, root2.right) && areMirrorImage(root1.right, root2.left));
	}
}
