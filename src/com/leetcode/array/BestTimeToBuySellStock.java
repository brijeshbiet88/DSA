package com.leetcode.array;

public class BestTimeToBuySellStock {

	public static void main(String[] args) {
		System.out.println("--------------Test Case 1 -----------------");
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		int maxProfit = maxProfit(prices);
		System.out.println("Max Profit : " + maxProfit);
		System.out.println();

		System.out.println("--------------Test Case 2 -----------------");
		int[] prices2 = { 2, 1, 2, 1, 0, 1, 2 };
		maxProfit = maxProfit(prices2);
		System.out.println("Max Profit : " + maxProfit);
		System.out.println();

		System.out.println("--------------Test Case 3 -----------------");
		int[] prices3 = { 7, 6, 4, 3, 2 };
		maxProfit = maxProfit(prices3);
		System.out.println("Max Profit : " + maxProfit);
		System.out.println();

	}

	public static int maxProfit(int[] prices) {

        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
	}

}
