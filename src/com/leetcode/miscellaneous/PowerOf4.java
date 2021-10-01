package com.leetcode.miscellaneous;

public class PowerOf4 {
    public static void main(String[] args) {
        System.out.println("-----------------Test Case 1-------------------");
        int num = 64;
        System.out.println("Is Num "+num+" Power of 4 ? "+isPowerOfFour(num));
        System.out.println();

        System.out.println("-----------------Test Case 2-------------------");
        num = 12;
        System.out.println("Is Num "+num+" Power of 4 ? "+isPowerOfFour(num));
        System.out.println();

        System.out.println("-----------------Test Case 3-------------------");
        num = 1;
        System.out.println("Is Num "+num+" Power of 4 ? "+isPowerOfFour(num));
        System.out.println();
    }

    public static boolean isPowerOfFour(int num) {
        return (num-1) %3 == 0 && ((num & num -1) == 0);
    }
}
