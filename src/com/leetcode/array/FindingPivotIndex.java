package com.leetcode.array;

public class FindingPivotIndex {

	public static void main(String[] args) {
	    System.out.println("-----------------Test Case 1------------------");
		int [] nums = {1 , 7 , 3 , 6 , 5 , 6};
		System.out.println("Pivot Index = "+ pivotIndex(nums));
		System.out.println();
		
		System.out.println("-----------------Test Case 2------------------");
		int [] nums2 = {1 , 2 , 3};
		System.out.println("Pivot Index = "+ pivotIndex(nums2));
		System.out.println();
		
		System.out.println("-----------------Test Case 3------------------");
		int [] nums3 = {2 , -1 , 1 };
		System.out.println("Pivot Index = "+ pivotIndex(nums3));
		System.out.println();
		
	}
	
	public static int pivotIndex(int[] nums) {
		int sum = 0, leftsum = 0;
		for (int x : nums)
			sum += x;
		for (int i = 0; i < nums.length; ++i) {
			if (leftsum == sum - leftsum - nums[i])
				return i;
			leftsum += nums[i];
		}
		return -1;
	}

}
