package com.leetcode.dp.medium;

public class MaximalSquare {

	public static void main(String[] args) {
		System.out.println("----------------Test Case 1 --------------------");
		char [][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
		System.out.println(" Maximal Square = "+maximalSquare(matrix));
		System.out.println();
		
		System.out.println("----------------Test Case 2 --------------------");
		char [][] matrix2 = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','1','1','1'}};
		System.out.println(" Maximal Square = "+maximalSquare2(matrix2));
		System.out.println();
	}

	public static int maximalSquare(char[][] matrix) {
		
		int [][] result = new int [matrix.length+1][matrix[0].length+1];
		int maximalSquare = 0;
		for(int i = 0 ; i < matrix.length ; i++) {
			for(int j = 0; j < matrix[0].length ; j++) {
				
				if(matrix[i][j] == '0') {
					result[i+1][j+1] = 0;
				}
				else {
					int ch = Math.min(result[i][j], Math.min(result[i][j+1] , result[i+1][j]));
					result[i+1][j+1] =  ch + 1;
					maximalSquare = Math.max(maximalSquare, result[i+1][j+1]);
				}
				
				
			}
		}
		return maximalSquare * maximalSquare;

	}
	
	
	public static  int maximalSquare2(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[] dp = new int[cols + 1];
        int maximalSquare = 0, prev = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
                    maximalSquare = Math.max(maximalSquare, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return maximalSquare * maximalSquare;
    }
}
