package com.leetcode.binarysearch.medium;

public class Divide2Integers {
    public static void main(String[] args) {
        System.out.println("--------------Test Case 1--------------------");
        int dividend = 102;
        int divisor = 5;
        int result = divide(dividend , divisor);
        System.out.println("Result = "+result);
        System.out.println();

        System.out.println("--------------Test Case 2--------------------");
        dividend = 7;
        divisor = -3;
        result = divide(dividend , divisor);
        System.out.println("Result = "+result);
        System.out.println();

        System.out.println("--------------Test Case 3--------------------");
        dividend = 0;
        divisor = 1;
        result = divide(dividend , divisor);
        System.out.println("Result = "+result);
        System.out.println();

        System.out.println("--------------Test Case 4--------------------");
        dividend = 1;
        divisor = 1;
        result = divide(dividend , divisor);
        System.out.println("Result = "+result);
        System.out.println();
    }

    public static int divide(int dividend, int divisor) {
        if(dividend == 1 << 31 && divisor == -1) return Integer.MAX_VALUE;

        boolean sign = (dividend >= 0) == ( divisor > 0) ? true : false;

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int result = 0;

        while(dividend - divisor >= 0 ){
            int count = 0;

            while(dividend  - (divisor <<1 << count) >= 0 ){
                count++;
            }

           result += 1 << count;

            dividend -= divisor << count ;
        }

        return sign ? result : -result ;
    }
}
