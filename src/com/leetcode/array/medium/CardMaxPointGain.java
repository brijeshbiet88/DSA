package com.leetcode.array.medium;

public class CardMaxPointGain {

	public static void main(String[] args) {
		int [] cardPoints = {1,2,3,4,5,6,1};
		int k = 3;
		System.out.println("Max Score = "+maxScore(cardPoints, k));
	}
	
	public static int maxScore(int [] cardPoints  , int k) {
		int sum = 0;
		int n = cardPoints.length;
		for(int i = 0 ; i < k ; i++) {
			sum += cardPoints[i];
		}
		
		int maxSum = sum;
		
		for(int i = 0 ; i < k ; i++) {
			sum = sum - cardPoints[k - 1 - i] + cardPoints[n -1 - i];
			maxSum = Math.max(maxSum, sum);
		}
		
		return maxSum;
		
		
	}

}
