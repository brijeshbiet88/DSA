package com.leetcode.dp.easy;

public class ClimbingStairs {

	public static void main(String[] args) {
		System.out.println("Total Ways to Climb 2 Stairs " + climbStairs(2));
		System.out.println("Total Ways to Climb 5 Stairs " + climbStairs(5));
		System.out.println("Total Ways to Climb 10 Stairs " + climbStairs(10));
	}

	public static int climbStairs(int n) {

		if (n == 0 || n == 1)
			return 1;

		int[] stairs = new int[n + 1];
		stairs[0] = 1;
		stairs[1] = 1;
		for (int i = 2; i <= n; i++) {
			stairs[i] = stairs[i - 1] + stairs[i - 2];
		}
		return stairs[n];
	}

}
