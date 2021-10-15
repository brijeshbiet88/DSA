package com.leetcode.array.medium;

public class BuySellStocks {
    public static void main(String[] args) {
        System.out.println("---------------Test Case 1-------------------");
        int [] prices1 = {7,1,5,3,6,4};
        System.out.println("Max Profit = "+maxProfit(prices1));
        System.out.println();

        System.out.println("---------------Test Case 2-------------------");
        int [] prices2 = {1,2,3,4,5};
        System.out.println("Max Profit = "+maxProfit(prices2));
        System.out.println();

        System.out.println("---------------Test Case 3-------------------");
        int [] prices3 = {7 , 6 , 4 , 3 , 1};
        System.out.println("Max Profit = "+maxProfit(prices3));
        System.out.println();

        System.out.println("---------------Test Case 4-------------------");
        int [] prices4 = {1,2,3 , 2};
        System.out.println("Max Profit = "+maxProfit(prices4));
        System.out.println();

    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxProfit += prices[i] - prices[i - 1];
        }
        return maxProfit;
    }
}
