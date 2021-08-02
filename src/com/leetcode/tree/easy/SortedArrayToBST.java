package com.leetcode.tree.easy;

import com.leetcode.tree.TreeNode;
import com.leetcode.tree.TreeUtil;

public class SortedArrayToBST {

	public static void main(String[] args) {
		int [] nums = {-10,-3,0,5,9};
		TreeNode root = sortedArrayToBST(nums);
		System.out.println("Print BST");
		TreeUtil.traverseLevelByLevel(root);

	}
	
	 public static TreeNode sortedArrayToBST(int[] nums) {
		 if(nums.length == 0) return null;
		 return constructBSTFromArray(nums , 0 , nums.length-1);
	 }

	private static TreeNode constructBSTFromArray(int[] nums, int left, int right) {
		if(left > right)return null;
		int mid = left + (right - left)/2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = constructBSTFromArray(nums, left, mid-1);
		node.right = constructBSTFromArray(nums, mid+1, right);
		return node;
	}

}
