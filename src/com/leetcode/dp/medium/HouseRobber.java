package com.leetcode.dp.medium;

public class HouseRobber {

	public static void main(String[] args) {
		System.out.println("-------------Test Case 1-----------------");
		int [] nums = {2,7,9,3,1};
		System.out.println(" Maximum Robbed Money = "+ rob(nums));
		System.out.println();

	}
	
    public static int rob(int[] nums) {
        int n = nums.length;
        		
    	int [] dp = new int [n];
    	
    	dp[0] = nums[0];
    	if(n > 1) {
    		dp[1] = Math.max(nums[0], nums[1]);
    	}
    	
    	for(int i = 2 ; i < n ; i++) {
    		dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
    	}
    	
    	return dp[n-1];
    	
    }

}
