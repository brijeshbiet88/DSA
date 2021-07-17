package com.leetcode.dp.medium;

public class SquareSubMatricesAll1s {

	public static void main(String[] args) {
		int [][] matrix = { {0,1,1,1},
				  {1,1,1,1},
				  {0,1,1,1}
				};
		
		System.out.println(" No of Sub Square Matrices "+countSquares(matrix) );
	}

	public static int countSquares(int[][] matrix) {
		int count = 0;
		int r = matrix.length, c = matrix[0].length;
		int[][] dp = new int[r + 1][c + 1];
		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <= c; j++) {

				if (matrix[i - 1][j - 1] == 1) {
					dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
					count += dp[i][j];
				}

			}
		}
		return count;

	}

}
