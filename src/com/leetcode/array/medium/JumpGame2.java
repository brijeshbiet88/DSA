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
		if(nums.length == 1) return 0;


		int jumps = 0;
		int maxReach = 0;
		int currentReach = 0;
		int i = 0;

		while(i < nums.length - 1){

			maxReach = Math.max(maxReach , i + nums[i]);

			if(i == currentReach){
				jumps++;
				currentReach = maxReach;
			}
			i++;

		}

		return jumps;
	}
	}

