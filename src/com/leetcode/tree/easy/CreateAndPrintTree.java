package com.leetcode.tree.easy;

import com.leetcode.tree.TreeNode;
import com.leetcode.tree.TreeUtil;

public class CreateAndPrintTree {

	public static void main(String[] args) {
		TreeNode root = TreeUtil.getTree();
		System.out.println("Print Tree Each Level :");
		TreeUtil.traverseLevelByLevel(root);
		System.out.println();
		System.out.println("Level Order Traversal of Tree ");
		TreeUtil.traverseLevelOrder(root);

	}

}
