package com.leetcode.math.medium;

public class IntegerBreak {
    public static void main(String[] args) {
        System.out.println("----------------Test Case 1-----------------");
        int n = 10;
        System.out.println("Max Product = "+integerBreak(n));
        System.out.println();

        System.out.println("----------------Test Case 2-----------------");
        n = 11;
        System.out.println("Max Product = "+integerBreak(n));
        System.out.println();

        System.out.println("----------------Test Case 3-----------------");
        n = 12;
        System.out.println("Max Product = "+integerBreak(n));
        System.out.println();

        System.out.println("----------------Test Case 4-----------------");
        n = 13;
        System.out.println("Max Product = "+integerBreak2(n));
        System.out.println();

        System.out.println("----------------Test Case 5-----------------");
        n = 10;
        System.out.println("Max Product = "+integerBreak2(n));
        System.out.println();
    }

    public static int integerBreak(int n) {
        int ans = -1;
        if(n == 2) return 1;
        if(n == 3) return 2;

        if(n > 3) {
            int m = n / 3;
            int rem = n % 3;
            if(rem == 0){
                ans = (int)Math.pow(3,m);
            }
            if(rem == 1){
                ans = (int)Math.pow(3,(m-1)) * 4;
            }
            if(rem == 2){
                ans = 2 * (int)Math.pow(3,m);
            }


        }
        return ans;
    }

    public static int integerBreak2(int n) {
        int[] dp = new int[n+1];

        dp[0]=0;
        dp[1]=0;
        dp[2]=1;
        if (n>2) {
            dp[3]=2;
        }

        for (int i = 4; i <= n; i++) {
            int greatestMax = -1;
            for (int j = 2; j <= i / 2; j++) {
                int n1 = j;
                int n2 = i - j;

                // for each number, get the max product n1 and n2 broken up
                int maxProduct1 = dp[n1] > n1? dp[n1]:n1;
                int maxProduct2 = dp[n2] > n2? dp[n2]:n2;
                int max = maxProduct1 * maxProduct2;
                if (max > greatestMax) {
                    greatestMax = max;
                }
            }
            dp[i] = greatestMax;
        }
        return dp[n];
    }
}
