package com.leetcode.array.medium;

import java.util.Arrays;

public class ThreeSumClosest {

	public static void main(String[] args) {
		int [] nums = {-1,2,1,-4} ;
		int target = 1;
		System.out.println("Closest Sum : "+threeSumClosest(nums, target));

	}
	
	 public static int threeSumClosest(int[] nums, int target) {
		    
			Arrays.sort(nums);
			int min = Integer.MAX_VALUE;
			int sum = 0;

			for (int i = 0; i < nums.length - 1; i++) {
				for (int j = i + 1, k = nums.length - 1; j < k;) {
					int tripletSum = nums[i] + nums[j] + nums[k];
					if (tripletSum == target) {
						return tripletSum;
					}
					if (target > 0 && Math.abs(min) > Math.abs(target - tripletSum)) {
						min = target - tripletSum;
						sum = tripletSum;
					}
					
					else if (target <= 0 && Math.abs(min) > Math.abs(tripletSum - target)) {
						min = tripletSum - target;
						sum = tripletSum;
					}

					if (tripletSum < target)
						j++;
					else
						k--;
				}
			}

			return sum;
		
	    }

}
