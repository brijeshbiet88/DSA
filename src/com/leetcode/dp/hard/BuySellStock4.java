package com.leetcode.dp.hard;

public class BuySellStock4 {

	public static void main(String[] args) {
		System.out.println("--------------Test Case 1-------------------");
		int [] prices = {3,2,6,5,0,3};
		int k = 2;
		System.out.println("Max Profit = "+maxProfit(k, prices));
		System.out.println();
		
		System.out.println("--------------Test Case 2-------------------");
		System.out.println("Max Profit = "+maxProfitRec(k, prices));
		System.out.println();
		
		System.out.println("--------------Test Case 3-------------------");
		int [] prices2 = {3,3,5,0,0,3,1,4};
		System.out.println("Max Profit = "+maxProfitRec(k, prices2));
		System.out.println();
		
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
	 
	 static Integer [][][] dp ;
	 public static int maxProfitRec(int k, int[] prices) {
	      if(prices == null || prices.length <= 1)
	      return 0;
	     
	      dp = new Integer [prices.length+1][k+1][2];
	      int buy = 1; 
	      int tx = 0 , index = 0;
	      
	      return maxProfitRecHelper(prices , k , buy , tx  , index);
	      
	    }

	 
	private static int maxProfitRecHelper(int[] prices, int k, int buy, int tx , int i) {
		
		if(k <= tx || i == prices.length) {
			return 0;
		}
		
		if(dp[i][tx][buy] != null)
			return dp[i][tx][buy];
		
		if(buy == 1) {
			return dp[i][tx][buy] = Math.max(-prices[i] + maxProfitRecHelper(prices, k, 0,  tx , i+1), maxProfitRecHelper(prices, k, buy, tx , i+1));
		}else {
			return dp[i][tx][buy] = Math.max(prices[i] + maxProfitRecHelper(prices, k, 1,  tx+1 , i+1), maxProfitRecHelper(prices, k, 0, tx, i+1));
		}
	
	}
}
