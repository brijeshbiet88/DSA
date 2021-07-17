package com.leetcode.dp.medium;

import java.util.HashMap;

public class LongestArithmeticSubsequence {

	public static void main(String[] args) {
		System.out.println("--------------Test Case 1------------------");
		int [] nums = {20,1,15,3,10,5,8};
		System.out.println("Longest Arithmetic Subsequence "+ longestArithSeqLength(nums));
		System.out.println();
		
		System.out.println("--------------Test Case 2------------------");
		int [] nums2 = {20,1,15,3,10,5};
		System.out.println("Longest Arithmetic Subsequence "+ longestArithSeqLength2(nums2));
		System.out.println();

	}

	public static int longestArithSeqLength(int[] nums) {
		int n = nums.length, max = 0;
		int[][] dp = new int[n][1002];
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				int diff = nums[i] - nums[j];
				dp[i][diff + 500] = 1 + dp[j][diff + 500];
				max = Math.max(max, dp[i][diff + 500]);
			}
		}
		return max + 1;
	}
	
	public static int longestArithSeqLength2(int[] nums) {
		HashMap<Integer, Integer>[] dp = new HashMap [nums.length];
		int max = 0;
		for (int i = 0; i < dp.length; i++) {
			dp[i] = new HashMap<>();
			for (int j = 0; j < i; j++) {
				int diff = nums[i] - nums[j];
				int vl = dp[j].getOrDefault(diff, 0);
				max = Math.max(max, vl + 1);
				dp[i].put(diff, vl + 1);
			}
		}

		return max + 1;
	}
}
