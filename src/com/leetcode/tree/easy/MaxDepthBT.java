package com.leetcode.tree.easy;

import com.leetcode.tree.TreeNode;
import com.leetcode.tree.TreeUtil;

public class MaxDepthBT {

	public static void main(String[] args) {
		TreeNode root = TreeUtil.getTree2();
		System.out.println("Print Tree ");
		TreeUtil.traverseLevelByLevel(root);
		System.out.println("Max Depth of BT "+maxDepth(root));

	}

	public static int maxDepth(TreeNode root) {
        
		if(root == null) return 0;
		
		int lh = maxDepth(root.left);
		int rh = maxDepth(root.right);
		
		return 1+ Math.max(lh, rh);
    }
}
