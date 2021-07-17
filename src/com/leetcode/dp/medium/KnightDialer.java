package com.leetcode.dp.medium;

import java.util.Arrays;

public class KnightDialer {

	public static void main(String[] args) {
		int n = 4;
		System.out.println("Distinct Numbers "+ knightDialerDP(n));

	}
	
	private static int knightDialerDP(int n) {
        long[][] dp = new long[n][10];
        Arrays.fill(dp[0],1);
        int mod = 1000000007;
        
        for(int i = 1; i < n; i++) {
            dp[i][0] = (dp[i-1][4] + dp[i-1][6]) % mod;
            dp[i][1] = (dp[i-1][6] + dp[i-1][8]) % mod;
            dp[i][2] = (dp[i-1][7] + dp[i-1][9]) % mod;
            dp[i][3] = (dp[i-1][4] + dp[i-1][8]) % mod;
            dp[i][4] = (dp[i-1][0] + dp[i-1][3] + dp[i-1][9]) % mod;
            dp[i][6] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][7]) % mod;
            dp[i][7] = (dp[i-1][2] + dp[i-1][6]) % mod;
            dp[i][8] = (dp[i-1][1] + dp[i-1][3]) % mod;
            dp[i][9] = (dp[i-1][2] + dp[i-1][4]) % mod;
        }
        long sum = 0;
        for(long val : dp[n-1])
        sum = (sum + val) % mod;
        return (int)sum;
    }

}
