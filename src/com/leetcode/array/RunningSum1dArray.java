package com.leetcode.array;

public class RunningSum1dArray {

	public static void main(String[] args) {
		int [] nums = {1 , 2 , 3 ,4};
		int [] arr = runningSum(nums);
		System.out.println("Print Each Element");
		
		for(int num : arr) {
			System.out.print(num+" ");
		}

	}

	public static int[] runningSum(int[] nums) {
        
		for(int i = 1 ; i < nums.length ; i++) {
			nums[i] = nums[i]+nums[i-1];
		}
		return nums;
    }
}
