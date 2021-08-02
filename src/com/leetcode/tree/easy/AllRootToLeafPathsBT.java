package com.leetcode.tree.easy;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.tree.TreeNode;
import com.leetcode.tree.TreeUtil;

public class AllRootToLeafPathsBT {

	static List<String> paths;
	public static void main(String[] args) {
		TreeNode root = TreeUtil.getTree();
		System.out.println("Print Tree ");
		TreeUtil.traverseLevelByLevel(root);
		binaryTreePaths(root);
		System.out.println("Print All Paths ");
		paths.forEach(s->System.out.println(s));

	}

	

	public static List<String> binaryTreePaths(TreeNode root) {
		paths = new ArrayList<>();
		printPathRecursive(root, new StringBuilder());
		return paths;
	}

	public static void printPathRecursive(TreeNode root, StringBuilder res) {
		if (root == null)
			return;

		int len = res.length();
		res.append(root.val);
		if (root.left == null && root.right == null) {
			paths.add(res.toString());
		} else {
			res.append("->");
			if (root.left != null)
				printPathRecursive(root.left, res);
			if (root.right != null)
				printPathRecursive(root.right, res);
		}
		res.setLength(len);
	}

}
