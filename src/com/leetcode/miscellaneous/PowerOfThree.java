package com.leetcode.miscellaneous;

public class PowerOfThree {
    public static void main(String[] args) {
        System.out.println("----------------Test Case 1---------------------");
        int n = 27;
        System.out.println("Result = "+isPowerOfThree(n));
        System.out.println();

        System.out.println("----------------Test Case 2---------------------");
        n = -27;
        System.out.println("Result = "+isPowerOfThree(n));
        System.out.println();

        System.out.println("----------------Test Case 3---------------------");
        n = 0;
        System.out.println("Result = "+isPowerOfThree(n));

        System.out.println("----------------Test Case 4---------------------");
        n = 1;
        System.out.println("Result = "+isPowerOfThree(n));
        System.out.println();

        System.out.println("----------------Test Case 5---------------------");
        n = 63;
        System.out.println("Result = "+isPowerOfThree(n));
        System.out.println();


    }

    public static boolean isPowerOfThree(int n) {
        int num = n;
        if(num <= 0) return false;
        while(num != 1){
            int rem = num %3 ;
            if(rem != 0) return false;
            num = num/3;
        }

        return true;
    }
}
