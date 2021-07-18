package com.leetcode.array.hard;

import java.util.Stack;

public class MaximalRectangle {

	public static void main(String[] args) {
		System.out.println("--------------------Test Case 1----------------------");
		char [][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}} ;
		System.out.println("Maximal Area Rectangle = "+ maximalRectangle(matrix));
		System.out.println();
		
		System.out.println("--------------------Test Case 2----------------------");
		char [][] matrix2 = {{'0'}} ;
		System.out.println("Maximal Area Rectangle = "+ maximalRectangle(matrix2));
		System.out.println();
		
		System.out.println("--------------------Test Case 3----------------------");
		char [][] matrix3 = {} ;
		System.out.println("Maximal Area Rectangle = "+ maximalRectangle(matrix3));
		System.out.println();

	}
	
	public static int maximalRectangle(char[][] matrix) {
		
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;
		
		int maxArea = 0;
		int[] dp = new int[matrix[0].length];
		int currentArea = 0;
		for (int i = 0; i < matrix.length; i++) {

			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == '1') {
					dp[j] += 1;
				} else {
					dp[j] = 0;
				}

			}
			currentArea = largestRectangleArea(dp);
			maxArea = Math.max(currentArea, maxArea);

		}

		return maxArea;

	}
	
	public static int largestRectangleArea(int[] heights) {

		if (heights == null)
			return 0;
		int maxArea = 0;
		int currentArea = 0;
		Stack<Integer> s = new Stack<Integer>();
		int i = 0;
		int len = heights.length;
		while (i < len) {

			if (s.isEmpty() || heights[s.peek()] < heights[i]) {
				s.push(i++);
			} else {
				int top = s.pop();
				if (s.isEmpty())
					currentArea = heights[top] * i;
				else
					currentArea = heights[top] * (i - s.peek() - 1);
			}
			maxArea = Math.max(currentArea, maxArea);
		}

		while (!s.isEmpty()) {
			int top = s.pop();
			if (s.isEmpty())
				currentArea = heights[top] * i;
			else
				currentArea = heights[top] * (i - s.peek() - 1);
			maxArea = Math.max(currentArea, maxArea);
		}

		return maxArea;

	}

}
