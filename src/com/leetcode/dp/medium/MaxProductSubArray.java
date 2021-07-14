package com.leetcode.dp.medium;

public class MaxProductSubArray {

	public static void main(String[] args) {
		System.out.println("----------------Test Case 1 -------------------");
		int [] nums = {2 , 3 , -2 , 4};
		System.out.println("Maximum Product Sub array = "+maxProduct(nums));
		System.out.println();
	}

	public static int maxProduct(int[] nums) {
		
		int max = nums[0];
		int min = nums[0];
		int prod = nums[0];
		
		for(int i = 1 ; i < nums.length ; i++) {
			
			if(nums[i] < 0) {
				int temp = max;
				max = min;
				min = temp;
			}
			
			max = Math.max(nums[i], nums[i] * max);
			min = Math.min(nums[i], nums[i] * min);
			
			if(prod < max) {
				prod = max;
			}
			
			
		}
		return prod;
	}
}
