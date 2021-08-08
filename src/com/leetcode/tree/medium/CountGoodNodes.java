package com.leetcode.tree.medium;

import com.leetcode.tree.TreeNode;
import com.leetcode.tree.TreeUtil;

public class CountGoodNodes {

	public static void main(String[] args) {
		TreeNode root = TreeUtil.getBST();
		System.out.println("Print Tree ");
		TreeUtil.traverseLevelByLevel(root);
		System.out.println();
		System.out.println("Good Nodes "+goodNodes(root));
	}
	
	public static int goodNodes(TreeNode root) {
        if(root == null) return 0;
        return dfs (root , root.val);
    }

	private static int dfs(TreeNode root, int max) {
		if(root == null) return 0;
		
		if(root.val >= max) {
			return 1 + dfs(root.left, root.val) + dfs(root.right, root.val);
		}else
			return dfs(root.left, max) + dfs(root.right, max);
	}

}
