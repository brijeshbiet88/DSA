package com.leetcode.dp.medium;

public class MinimumPathSum {
    public static void main(String[] args) {
        System.out.println("--------------Test Case 1-----------------");
        int [][] grid1 = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println("Min Path Sum = "+minPathSum(grid1));
        System.out.println();

        System.out.println("--------------Test Case 2-----------------");
        int [][] grid2 = {{1,2,3},{4,5,6}};
        System.out.println("Min Path Sum = "+minPathSum(grid2));
        System.out.println();
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int [][] dp = new int[m][n];

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                dp[i][j] += grid[i][j];
                if(i > 0 && j > 0){
                    dp[i][j] += Math.min(dp[i-1][j],dp[i][j-1]);
                }else if(i > 0){
                    dp[i][j] += dp[i-1][j];
                }else if(j > 0){
                    dp[i][j] += dp[i][j-1];
                }
            }
        }

        return dp[m-1][n-1];
    }
}
