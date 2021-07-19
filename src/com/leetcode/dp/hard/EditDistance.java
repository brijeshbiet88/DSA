package com.leetcode.dp.hard;

public class EditDistance {

	public static void main(String[] args) {
		System.out.println("---------------Test Case 1------------------");
		String word1 = "intention";
		String word2 = "execution";
		System.out.println("Min Edits To Convert "+word1+" to "+word2+" is = "+minDistance(word1, word2));
		
		System.out.println();
		
		
		System.out.println("---------------Test Case 2------------------");
		word1 = "horse";
		word2 = "ros";
		System.out.println("Min Edits To Convert "+word1+" to "+word2+" is = "+minDistance(word1, word2));
		
		System.out.println();

	}
	
	public static int minDistance(String word1, String word2) {
		int len1 = word1.length(), len2 = word2.length();
		int[][] dp = new int[len1 + 1][len2 + 1];

		for (int i = 1; i <= len1; i++)
			dp[i][0] = i;
		for (int i = 1; i <= len2; i++)
			dp[0][i] = i;

		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				if (word1.charAt(i - 1) != word2.charAt(j - 1))
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
				else {
					dp[i][j] =dp[i-1][j-1];
				}
			}
		}

		return dp[len1][len2];
	}

}
