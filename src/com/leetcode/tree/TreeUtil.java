package com.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtil {
	
	public static TreeNode getTree() {

		TreeNode root = new TreeNode(1);

		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);

		root.left = node2;
		root.right = node3;

		node2.left = node4;
		node2.right = node5;

		node3.left = node6;
		node3.right = node7;

		return root;

	}
	
	public static TreeNode getBST() {

		TreeNode root = new TreeNode(10);

		TreeNode node2 = new TreeNode(5);
		TreeNode node3 = new TreeNode(15);
		TreeNode node4 = new TreeNode(3);
		TreeNode node5 = new TreeNode(7);
		TreeNode node7 = new TreeNode(18);

		root.left = node2;
		root.right = node3;

		node2.left = node4;
		node2.right = node5;

		node3.right = node7;

		return root;

	}
	
	
	public static TreeNode getTree2() {

		TreeNode root = new TreeNode(1);

		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);

		root.left = node2;
		root.right = node3;

		node2.left = node4;
		node2.right = node5;

		node3.left = node6;
		node3.right = node7;
		
		node4.left = new TreeNode(8);
		node4.left.left = new TreeNode(9);
		
		node4.right = new TreeNode(10);
		node4.right.left = new TreeNode(11);
		node4.right.left.right = new TreeNode(12);

		return root;

	}
	
	
	public static void traverseLevelOrder(TreeNode root) {
		if(root == null) return;
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		
		q.add(root);
		TreeNode temp = null;
		while(!q.isEmpty()) {
			
			temp = q.poll();
			System.out.print(temp.val+" ");
			if(temp.left != null)
				q.add(temp.left);
			if(temp.right != null)
				q.add(temp.right);
		}
	}
	
	public static void traverseLevelByLevel(TreeNode root) {
		if (root == null)
			return;

		Queue<TreeNode> q = new LinkedList<TreeNode>();

		q.add(root);
		TreeNode temp = null;
		int size = 0;
		while (!q.isEmpty()) {

			size = q.size();

			for (int i = 0; i < size; i++) {
				temp = q.poll();
				System.out.print(temp.val + " ");
				if (temp.left != null)
					q.add(temp.left);
				if (temp.right != null)
					q.add(temp.right);
			}
			System.out.println();

		}
	}

}
