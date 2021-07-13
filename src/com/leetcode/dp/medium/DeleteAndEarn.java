package com.leetcode.dp.medium;

public class DeleteAndEarn {

	public static void main(String[] args) {
		System.out.println("-----------------Test Case 1-------------------");
		int [] nums = {2 , 2 , 3 , 3, 3 ,4};
		System.out.println("Max Score = "+deleteAndEarn(nums));
		System.out.println();
	}

	public static int deleteAndEarn(int[] nums) {
		 int[] count = new int[10001];
	        for (int x: nums) count[x]++;
	        int avoid = 0, using = 0, prev = -1;

	        for (int k = 0; k <= 10000; ++k) if (count[k] > 0) {
	            int m = Math.max(avoid, using);
	            if (k - 1 != prev) {
	                using = k * count[k] + m;
	                avoid = m;
	            } else {
	                using = k * count[k] + avoid;
	                avoid = m;
	            }
	            prev = k;
	        }
	        return Math.max(avoid, using);
	}
}
