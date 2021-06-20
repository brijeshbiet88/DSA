package com.leetcode.array;

public class BestTimeToBuySellStocks2 {

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

		int localMinima = 0;
		int profit = 0;
		int i = 0;

		while (i < prices.length - 1) {

			while (i < prices.length - 1 && prices[i] > prices[i + 1]) {
				i++;
			}

			if (i < prices.length - 1) {
				localMinima = prices[i];
			}

			i++;

			while (i < prices.length - 1 && prices[i] < prices[i + 1]) {
				i++;
			}

			if (i < prices.length) {
				profit += prices[i] - localMinima;
			}

		}
		return profit;
	}

}
