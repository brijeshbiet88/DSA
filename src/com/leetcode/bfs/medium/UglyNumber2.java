package com.leetcode.bfs.medium;

import java.util.ArrayList;
import java.util.Map;

public class UglyNumber2 {
    public static void main(String[] args) {
        System.out.println("---------------Test Case 1-------------------");
        int n = 10;
        System.out.println(n+"th Ugly Number = "+nthUglyNumber(n));
        System.out.println();
    }

    public static int nthUglyNumber(int n) {
        int[] dp = new int[n];
        int[] primes = { 2, 3, 5 };
        int[] frequency = new int[primes.length];
        dp[0] = 1;

        for (int i = 2; i <= n; i++) {
            int minUgly = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                int nextUgly = primes[j] * (dp[frequency[j]]);
                if (nextUgly > dp[i - 2]) {
                    minUgly = Math.min(minUgly, nextUgly);
                }

            }
            dp[i - 1] = minUgly;

            for (int j = 0; j < primes.length; j++) {
                if (minUgly == primes[j] * (dp[frequency[j]])) {
                    frequency[j]++;
                }
            }

        }

        return dp[n - 1];
    }
}
