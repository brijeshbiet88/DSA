package com.leetcode.dp.easy;

public class MaxSubArraySum {

	public static void main(String[] args) {
		System.out.println("---------------Test Case 1-----------------");
		int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println("Max Sum "+maxSubArray(nums));
		System.out.println();
	}

	public static int maxSubArray(int[] nums) {
		
		int maxSum = Integer.MIN_VALUE;
		int sum = 0;
		for(int i = 0 ; i < nums.length ; i++) {
			sum += nums[i];
			maxSum = Math.max(maxSum, sum);
			if(sum < 0)
				sum = 0;
		}
		
		return maxSum;
	}

}
