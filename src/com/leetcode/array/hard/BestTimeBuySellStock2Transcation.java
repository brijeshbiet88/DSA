package com.leetcode.array.hard;

public class BestTimeBuySellStock2Transcation {
    public static void main(String[] args) {
        System.out.println("---------------Test Case 1----------------");
        int [] prices = {3,3,5,0,0,3,1,4};
        System.out.println("Max Profit With At Most 2 Transactions = "+maxProfit(prices));
        System.out.println();
    }
    public static int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;

        int s1 = -prices[0] , s2 = 0, s3 = Integer.MIN_VALUE , s4 = 0;

        for(int i = 1 ; i < prices.length ; i++){
            s1 = Math.max(s1 , 0  - prices[i]);
            s2 = Math.max(s2 , s1 + prices[i]);
            s3 = Math.max(s3 , s2 - prices[i]);
            s4 = Math.max(s4 , s3 + prices[i]);
        }
        return s4;
    }
}
