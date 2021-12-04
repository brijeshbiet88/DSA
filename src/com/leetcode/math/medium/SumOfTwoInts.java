package com.leetcode.math.medium;

public class SumOfTwoInts {
    public static void main(String[] args) {
        System.out.println("-------------Test Case 1-----------------");
        int a = 2;
        int b = 3;
        System.out.println("Summation of a = "+a+" and b = "+b+" = "+getSum(a,b));
        System.out.println();

        System.out.println("-------------Test Case 2-----------------");
        a = 9;
        b = 11;
        System.out.println("Summation of a = "+a+" and b = "+b+" = "+getSum(a,b));
        System.out.println();

        System.out.println("-------------Test Case 3-----------------");
        a = 16;
        b = 16;
        System.out.println("Summation of a = "+a+" and b = "+b+" = "+getSum(a,b));
        System.out.println();
    }

    public static int getSum(int a, int b) {
        while(b != 0){
            int carry = (a & b) << 1;
            a = (a ^ b);
            b = carry;
        }

        return a;
    }
}
