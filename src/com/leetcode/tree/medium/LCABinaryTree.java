package com.leetcode.tree.medium;

import com.leetcode.tree.TreeNode;
import com.leetcode.tree.TreeUtil;

public class LCABinaryTree {

	public static void main(String[] args) {
		
		TreeNode root = TreeUtil.getTree2();
		System.out.println("Print Tree ");
		TreeUtil.traverseLevelByLevel(root);
		System.out.println();
		TreeNode p = root;
		TreeNode q = root.left;
		System.out.println("LCA of "+p.val +" and "+q.val+" = "+lowestCommonAncestor(root, p, q).val);
		
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		
		if(root == null) return null;
		
		if(root == p || root == q) {
			return root;
		}
		
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		
		if(left != null && right != null)
			return root;
		
		return right != null ? right : left;
	}
}
