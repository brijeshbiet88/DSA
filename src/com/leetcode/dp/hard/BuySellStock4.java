package com.leetcode.dp.hard;

public class BuySellStock4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public static int maxProfit(int k, int[] prices) {
	      if(prices == null || prices.length <= 1)
	      return 0;
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
