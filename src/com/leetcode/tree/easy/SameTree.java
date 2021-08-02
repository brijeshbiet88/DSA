package com.leetcode.tree.easy;

import com.leetcode.tree.TreeNode;
import com.leetcode.tree.TreeUtil;

public class SameTree {

	public static void main(String[] args) {
		TreeNode p = TreeUtil.getBST();
		TreeNode q = TreeUtil.getBST();
		System.out.println("Is Same Tree ? "+isSameTree(p, q));

	}

	public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        
        return (p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }
}
