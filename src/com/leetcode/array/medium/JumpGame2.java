package com.leetcode.array.medium;

public class JumpGame2 {

	public static void main(String[] args) {
		System.out.println("--------------Test Case 1----------------");
		int[] nums = { 2, 3, 1, 1, 4 };
		System.out.println("Minimum Jumps To Reach End ? " + jump(nums));
		System.out.println();
		System.out.println("--------------Test Case 2----------------");
		int[] nums2 = { 3, 2, 1, 2, 4 };
		System.out.println("Minimum Jumps To Reach End ? " + jump(nums2));
		System.out.println();
		System.out.println("--------------Test Case 3----------------");
		int[] nums3 = { 3, 0, 1, 2, 1, 1, 1 , 1 };
		System.out.println("Minimum Jumps To Reach End ? " + jump(nums3));

	}

	public static int jump(int[] nums) {

		int n = nums.length;
		
		int jumps = 1;
		
		if(n ==1 || nums[0] == 0) {
			return 0;
		}
		
		int farthest = nums[0];
		int current = nums[0];
		
		for (int i = 1; i < n; i++) {
			if (i == n - 1)
				return jumps;

			farthest = Math.max(farthest, i + nums[i]);
			if (i == current) {
				jumps++;
				current = farthest;
			}

		}
		
		
		return jumps;

	}
}
