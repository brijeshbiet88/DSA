package com.leetcode.miscellaneous;

public class ReverseBits {
    public static void main(String[] args) {
        System.out.println("----------------Test Case 1---------------");
        int n = 1;
        int result = reverseBits(n);
        System.out.println("Result = "+result);
        System.out.println();
    }

    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i ++) {
            int lsb = n & 1;
            int reverseLsb = lsb << (31 - i);
            result = result | reverseLsb;
            n = n >> 1;
        }
        return result;
    }
}
