package com.leetcode.tree.easy;

import com.leetcode.tree.TreeNode;
import com.leetcode.tree.TreeUtil;

public class LCABST {

	public static void main(String[] args) {
		TreeNode root = TreeUtil.getBST();

		TreeNode p = root.left;
		TreeNode q = root.right;
		System.out.println("Is Same Tree ? " + lowestCommonAncestor(root, p, q).val);

	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        
		if (root == null) return null;
		
		if(p.val > root.val && q.val > root.val) {
			return lowestCommonAncestor(root.right, p, q);
		}
		else if(p.val < root.val && q.val < root.val) {
			return lowestCommonAncestor(root.left, p, q);
		}else {
			return  root;
		}
	
	}
}
