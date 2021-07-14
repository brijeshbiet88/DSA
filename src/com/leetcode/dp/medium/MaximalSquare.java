package com.leetcode.dp.medium;

public class MaximalSquare {

	public static void main(String[] args) {
		char [][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
		System.out.println(" Maximal Square = "+maximalSquare(matrix));
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
}
