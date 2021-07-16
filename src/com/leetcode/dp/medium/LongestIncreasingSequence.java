package com.leetcode.dp.medium;

import java.util.Arrays;

public class LongestIncreasingSequence {

	public static void main(String[] args) {
		int []  nums = {10,9,2,5,3,7,101,18};
		System.out.println("Longest Increasing Subsequence "+ lengthOfLIS(nums));

	}
	
	 public static int lengthOfLIS(int[] nums) {
	        
		 int lis = 1;
		 int [] a = new int [nums.length];
		 Arrays.fill(a, 1);
		 
		 
		 for(int i = 1 ; i < nums.length ; i++) {
			 for(int j = 0 ; j < i ; j++) {
				 if(nums[i] > nums[j]) {
					a[i] = Math.max(a[i], a[j] + 1);
		    	    lis = Math.max(lis, a[i]);
                 }
			 }
		 }
		 
		 
		return lis;
	        
	 
    }

}
