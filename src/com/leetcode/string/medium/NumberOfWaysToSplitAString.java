package com.leetcode.string.medium;

public class NumberOfWaysToSplitAString {
    public static void main(String[] args) {
        System.out.println("----------------Test Case 1-------------------");
        String s = "0000";
        System.out.println("No of Ways To Split s = "+s+" In 3 String With Equal 1's "+numWays(s));
        System.out.println();

        System.out.println("----------------Test Case 2-------------------");
        s = "100100010100110";
        System.out.println("No of Ways To Split s = "+s+" In 3 String With Equal 1's "+numWays(s));
        System.out.println();

        System.out.println("----------------Test Case 3-------------------");
        s = "10010";
        System.out.println("No of Ways To Split s = "+s+" In 3 String With Equal 1's "+numWays(s));
        System.out.println();

        System.out.println("----------------Test Case 4-------------------");
        s = "111111";
        System.out.println("No of Ways To Split s = "+s+" In 3 String With Equal 1's "+numWays(s));
        System.out.println();

    }

    public static int numWays(String s) {
        long ones = 0;
        long n = s.length();
        final long MOD = 1000000007;
        for (char c : s.toCharArray())
            ones += c - '0';
        if (ones == 0)
            return (int) ((((n - 1) * (n - 2)) / 2) % MOD);
        if (ones % 3 != 0)
            return 0;
        long oneThird = ones / 3;
        ones = 0;
        long ways1 = 0;
        long ways2 = 0;
        for (char c : s.toCharArray()) {
            ones += c - '0';
            if (ones == oneThird) ways1++;
            if (ones == 2 * oneThird) ways2++;
        }
        return (int) ((ways1 * ways2) % MOD);
    }
}
