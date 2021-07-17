package com.leetcode.dp.medium;

public class LongestArithmeticSubsequence {

	public static void main(String[] args) {
	int [] nums = {20,1,15,3,10,5,8};
	System.out.println("Longest Arithmetic Subsequence "+ longestArithSeqLength(nums));

	}

	public static int longestArithSeqLength(int[] nums) {
		 int n = nums.length,max = 0;
	        int[][] dp = new int[n][1002];
	        for(int i = 0;i<n;i++){
	            for(int j = 0;j<i;j++){
	                dp[i][nums[i]-nums[j]+500] = 1+dp[j][nums[i]-nums[j]+500];
	                max = Math.max(max,dp[i][nums[i]-nums[j]+500]);
	            }
	        }
	        return max+1;
    }
}
