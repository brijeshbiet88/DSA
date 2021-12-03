package com.leetcode.dp.medium;

public class CoinChange2 {
    public static void main(String[] args) {
        System.out.println("-------------Test Case 1----------------");
        int amount = 5;
        int [] coins1 = {2 , 1 , 5};
        System.out.println("Total No of Ways To Create Amount = "+amount+" with Given Coins = "+change(amount,coins1));
        System.out.println();

        System.out.println("-------------Test Case 2----------------");
        amount = 5;
        int [] coins2 = {1 , 2 , 5};
        System.out.println("Total No of Ways To Create Amount = "+amount+" with Given Coins = "+change(amount,coins2));
        System.out.println();

        System.out.println("-------------Test Case 3----------------");
        amount = 3;
        int [] coins3 = {2};
        System.out.println("Total No of Ways To Create Amount = "+amount+" with Given Coins = "+change(amount,coins3));
        System.out.println();

        System.out.println("-------------Test Case 4----------------");
        amount = 10;
        int [] coins4 = {1,2,5};
        System.out.println("Total No of Ways To Create Amount = "+amount+" with Given Coins = "+change(amount,coins4));
        System.out.println();

        System.out.println("-------------Test Case 5----------------");
        amount = 10;
        int [] coins5 = {10};
        System.out.println("Total No of Ways To Create Amount = "+amount+" with Given Coins = "+change(amount,coins5));
        System.out.println();
    }

    public static int change(int amount, int[] coins) {
        int dp[] = new int[amount + 1];
        dp[0] = 1;

        for(int coin : coins){
            for(int i = coin ; i <= amount ; i++){
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }
}
