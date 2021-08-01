package com.leetcode.tree.easy;

import java.util.LinkedList;
import java.util.Queue;

import com.leetcode.tree.TreeNode;
import com.leetcode.tree.TreeUtil;

public class InvertBT {

	public static void main(String[] args) {
		TreeNode root = TreeUtil.getTree();
		System.out.println("Level Order ");
		TreeUtil.traverseLevelByLevel(root);
		root = invertTree(root);
		System.out.println();
		System.out.println("Level Order After Inverting BT ");
		TreeUtil.traverseLevelByLevel(root);
		root = invertTree2(root);
		System.out.println("Level Order After Inverting BT Again ");
		TreeUtil.traverseLevelByLevel(root);
	}

	public static TreeNode invertTree(TreeNode root) {
		
		if(root == null) return root;
		
		TreeNode temp;
		
		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);
		
		temp = left ;
		
		root.left = right;
		root.right = temp;
		return root;
	}
	
	public static TreeNode invertTree2(TreeNode root) {
	    if (root == null) return null;
	    Queue<TreeNode> queue = new LinkedList<TreeNode>();
	    queue.add(root);
	    while (!queue.isEmpty()) {
	        TreeNode current = queue.poll();
	        TreeNode temp = current.left;
	        current.left = current.right;
	        current.right = temp;
	        if (current.left != null) queue.add(current.left);
	        if (current.right != null) queue.add(current.right);
	    }
	    return root;
	}

}
