package com.leetcode.array.hard;

public class StockBuySellKtransaction {

	public static void main(String[] args) {
		int [] prices = {3,3,5,0,0,3,1,4};
		System.out.println("Max Profit = "+ maxProfit(prices));

	}

	public static int maxProfit(int[] prices) {
		int k = 2;
		int n = prices.length;
		int[][] dp = new int[k + 1][n];

		for (int i = 1; i < dp.length; i++) {
			for(int j = 1 ; j < dp[0].length ; j++) {
				int maxValue = 0;
				for(int m = 0 ; m < j ; m++) {
					maxValue = Math.max(maxValue, prices[j] - prices[m] + dp [i-1] [m]);
				}
				
				dp[i][j] = Math.max(dp[i][j-1], maxValue);
			}
		}

		return dp[k][n - 1];

	}

}
