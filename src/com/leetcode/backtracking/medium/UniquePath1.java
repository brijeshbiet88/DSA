package com.leetcode.backtracking.medium;

import java.util.Arrays;

public class UniquePath1 {
    public static void main(String[] args) {
        System.out.println("---------------Test Case 1--------------------");
        int m = 3 , n = 7;
        System.out.println("Unique Paths = "+uniquePaths(m,n));
        System.out.println();
    }

    public static int uniquePaths(int m, int n) {
        int [][] dp = new int[m][n];
        for(int i = 0 ; i < m ; i++)
            dp[i][0] = 1;
        for(int i = 0 ; i < n ; i++)
            dp[0][i] = 1;

        for(int i = 1 ; i < m ; i++){
            for (int j = 1 ; j < n ; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
}
