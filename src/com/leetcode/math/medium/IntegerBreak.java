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
}
