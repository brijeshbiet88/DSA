package com.leetcode.array.medium;

public class MaxAreaofIsland {

	 static int count = 1;
	public static void main(String[] args) {
		System.out.println("--------------Test Case 1-----------------");
		int[][] grid = { 
					{ 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, 
					{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
					{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, 
					{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
					{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
					{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
					{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
					{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };
		
		System.out.println("Max Area of Island = "+maxAreaOfIsland(grid));
		System.out.println();
		
		
	}

	public static int maxAreaOfIsland(int[][] grid) {
		int maxArea = 0;
		int m = grid.length, n = grid[0].length;
		boolean[][] visited = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && grid[i][j] == 1) {
					count = 1;
					maxArea = Math.max(maxArea, dfs(grid, visited, i, j));
				}
			}
		}

		return maxArea;

	}
	
	

	private static int dfs(int[][] grid, boolean[][] visited, int r, int c) {

		int[] row = { 1, 0, -1, 0 };
		int[] col = { 0, 1, 0, -1 };

		visited[r][c] = true;
		for (int i = 0; i < row.length; i++) {
			if (isSafe(visited, r + row[i], c + col[i]) && grid[r + row[i]][c + col[i]] == 1) {
				visited[r + row[i]][c + col[i]] = true;
				dfs(grid, visited, r + row[i], c + col[i]);
				count++;
			}

		}
		return count;

	}

	private static boolean isSafe(boolean[][] visited, int i, int j) {

		
		int m = visited.length;
		int n = visited[0].length;
		if (i < 0 || j < 0 || i >= m || j >= n)
			return false;
		if (visited[i][j])
			return false;
		return true;
	}
}
