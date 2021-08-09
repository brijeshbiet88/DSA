package com.leetcode.tree.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


import com.leetcode.tree.TreeNode;
import com.leetcode.tree.TreeUtil;

public class ZigzagLevelTraversal {

	public static void main(String[] args) {
		TreeNode root = TreeUtil.getTree();
		List<List<Integer>> zigzagList = zigzagLevelOrder(root);
		System.out.println("Print Zigzag Traversal :");
		zigzagList.forEach( list ->{
			list.forEach(num -> System.out.print(num+" "));
			System.out.println();
		});
		
	}

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null) return result;

		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		List<Integer> levelList = new ArrayList<Integer>();
		s1.push(root);
		boolean ltoR = true;
		while (!s1.isEmpty()) {
			TreeNode temp = s1.pop();
			levelList.add(temp.val);
			if (ltoR) {

				if (temp.left != null) {
					s2.push(temp.left);
				}
				if (temp.right != null) {
					s2.push(temp.right);
				}

			} else {
				if (temp.right != null) {
					s2.push(temp.right);
				}
				if (temp.left != null) {
					s2.push(temp.left);
				}
			}
			
			if(s1.isEmpty()) {
				Stack<TreeNode> tmp = s1;
				s1 = s2;
				s2 = tmp;
				result.add(levelList);
				ltoR = !ltoR;
				levelList = new ArrayList<Integer>();
			}

		}

		return result;
	}
}
