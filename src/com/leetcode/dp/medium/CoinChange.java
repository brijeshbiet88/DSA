package com.leetcode.dp.medium;

public class CoinChange {

	public static void main(String[] args) {
		int [] coins = {1 , 2 , 5};
		int amount = 11;
		System.out.println("Minimum Coins = "+coinChange(coins, amount));
		System.out.println();

	}
	
	public static int coinChange(int[] coins, int amount) {
		 int [] dp = new int [amount + 1];
		 for(int i =1 ; i <= amount ; i++) {
			 dp[i] = amount + 1;
			 
			 for(int coin : coins ) {
				 if(coin <=i)
					 dp[i] = Math.min(dp[i], dp[i- coin] + 1);
			 }
		 }
		 return dp[amount] == amount + 1 ? -1 : dp[amount];
	}

}
