package com.leetcode.dp.medium;

public class PerfectSquare {
    public static void main(String[] args) {
        System.out.println("-----------------Test Case 1---------------------");
        int n = 12;
        System.out.println("Result = "+numSquares(n));
        System.out.println();

        System.out.println("-----------------Test Case 2---------------------");
        n = 13;
        System.out.println("Result = "+numSquares(n));
        System.out.println();

        System.out.println("-----------------Test Case 3---------------------");
        n = 28;
        System.out.println("Result = "+numSquares(n));
        System.out.println();
    }

    public static int numSquares(int n) {
        int [] dp = new int [n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2 ; i <= n ; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 1 ; j*j <= i ; j++){
                int rem = i - j*j;
                min = Math.min(dp[rem], min);
            }
            dp[i] = min + 1;
        }

        return dp[n];
    }
}
