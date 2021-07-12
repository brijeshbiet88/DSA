package com.leetcode.dp.easy;

public class CountBits {

	public static void main(String[] args) {
		System.out.println("-------------------Test Case 1------------------------");
		int [] bitsets = countBits(20);
		System.out.println(" Print Array Elements : ");
		for(int n : bitsets)
			System.out.print(n+" ");
		System.out.println();
	}

	public static int[] countBits(int n) {
		int [] dp = new int [n+1];
		dp[0] = 0;
		int setBits = 0;
		for(int i = 1 ; i <= n ; i++) {
			
			if(i%2 == 1) {
				setBits = dp[i/2] + 1;
			}else {
				setBits = dp[i/2] ;
			}
			dp[i] = setBits;
			
		}
		return dp;
	}

}
