package com.leetcode.array.easy;

public class PowerOf2 {
    public static void main(String[] args) {
        for (int i = 1 ; i <= 16 ; i++){
            System.out.println("Is Number = "+i+" Power of two ? "+isPowerOfTwo(i));
        }


    }

    public static boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        if(n == 1) return true;
        if(n %2 == 1) return false;
        return isPowerOfTwo(n/2);

    }
}
