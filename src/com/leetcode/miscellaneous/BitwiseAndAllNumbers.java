package com.leetcode.miscellaneous;

public class BitwiseAndAllNumbers {
    public static void main(String[] args) {
        System.out.println("----------------Test Case 1-----------------");
        int left = 5;
        int right = 7;
        System.out.println("Result = "+rangeBitwiseAnd(left , right));
        System.out.println();
    }

    public static int rangeBitwiseAnd(int left, int right) {
        int shifts = 0;
        while(left != right){

            left = left >> 1;
            right = right >> 1;
            shifts++;

        }

        return left << shifts;

    }
}
