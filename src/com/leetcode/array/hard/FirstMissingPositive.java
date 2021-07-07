package com.leetcode.array.hard;

public class FirstMissingPositive {

	public static void main(String[] args) {
		System.out.println("--------------Test Case 1----------------");
		int [] nums = {7,8,9,11,12};
		System.out.println(" First Missing Positive "+ firstMissingPositive(nums));
		System.out.println();
		
		System.out.println("--------------Test Case 2----------------");
		int [] nums2 = {1 , 2 , 0};
		System.out.println(" First Missing Positive "+ firstMissingPositive(nums2));
		System.out.println();
		
		System.out.println("--------------Test Case 3----------------");
		int [] nums3 = {3 , 4 , -1 , 1};
		System.out.println(" First Missing Positive "+ firstMissingPositive(nums3));
		System.out.println();
		
		System.out.println("--------------Test Case 4----------------");
		int [] nums4 = {1};
		System.out.println(" First Missing Positive "+ firstMissingPositive(nums4));
		System.out.println();

	
	}

	public static int firstMissingPositive(int[] nums) {
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			if (nums[i] <= 0 || nums[i] > n) {
				nums[i] = n + 1;
			}
		}
		
		for (int i = 0; i < n; i++) {
			int num = Math.abs(nums[i]);
			if (num <= n) {
				num--;
				if (nums[num] > 0)
					nums[num] = 0 - nums[num];
			}

		}

		for (int i = 0; i < n; i++) {
			if (nums[i] > 0) {
				return i + 1;
			}
		}

		return n + 1;
	}

}
