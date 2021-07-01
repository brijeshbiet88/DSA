package com.leetcode.array.medium;

public class JumpGame {

	public static void main(String[] args) {
		System.out.println("--------------Test Case 1----------------");
		int[] nums = { 2, 3, 1, 1, 4 };
		System.out.println("Is Reachable ? " + canJump(nums));
		System.out.println();
		System.out.println("--------------Test Case 2----------------");
		int[] nums2 = { 3 , 2 , 1 , 0 , 4 };
		System.out.println("Is Reachable ? " + canJump(nums2));
		System.out.println();
		System.out.println("--------------Test Case 3----------------");
		int[] nums3 = { 3 , 0 , 8 , 2 , 0 , 0 , 1 };
		System.out.println("Is Reachable ? " + canJump(nums3));

	}

	public static boolean canJump(int[] nums) {
		int length = nums.length;
		if (length == 1) {
			return true;
		}
		int maxJump = 0, curIndex = 0;
		for (curIndex = 0; curIndex < length; curIndex++) {
			maxJump = Math.max(maxJump, curIndex + nums[curIndex]);
			if (curIndex >= maxJump) {
				return false;
			}
			if (maxJump >= length - 1) {
				return true;
			}
		}
		if (maxJump >= length - 1) {
			return true;
		} else {
			return false;
		}

	}
	
	public static boolean canJump2(int[] nums) {
		int length = nums.length;
		if (length == 1) {
			return true;
		}
		int lastGoodIndex = length -1;
		
		for(int i = length -1 ; i >= 0 ; i--) {
			
			if(nums[i] + i >= lastGoodIndex) {
				lastGoodIndex = i;
			}
			
		}
		
		return lastGoodIndex == 0;

	}

}
