package com.leetcode.array;

public class TargetSumPlusMinus {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 1, 1 };
		int target = 3;

		findTargetSumWays(nums, target);

		System.out.println("Count = " + count);
		
		System.out.println(" ===========Check If Target Exists ---------------");
		
		int[] nums2 = { 1, 4, 7, 5, -1 };
		int target2 = 2;
		System.out.println(" Does Target Exists ? "+checkIfExist(nums2, 0, 0, target2));
		
	}

	static int count = 0;

	public static int findTargetSumWays(int[] nums, int target) {
		calculate(nums, 0, 0, target);
		return count;

	}

	public static void calculate(int[] nums, int i, int sum, int S) {
		if (i == nums.length) {
			if (sum == S)
				count++;
		} else {
			calculate(nums, i + 1, sum + nums[i], S);
			calculate(nums, i + 1, sum - nums[i], S);
		}
	}
	
	public static boolean checkIfExist(int[] nums, int i, int sum, int S) {
		if (i == nums.length) {
			if (sum == S)
				return true;
		}if(i > nums.length) return false;	
		return checkIfExist(nums, i + 1, sum + nums[i], S) || checkIfExist(nums, i + 1, sum - nums[i], S);
	
	}

}
