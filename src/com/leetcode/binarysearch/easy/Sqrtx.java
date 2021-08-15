package com.leetcode.binarysearch.easy;

public class Sqrtx {
    public static void main(String[] args) {
        System.out.println("--------------Test Case 1------------------");
        int num = 16;
        System.out.println("Square Root of "+num+" is = "+mySqrt(num));
        System.out.println();

        System.out.println("--------------Test Case 2------------------");
        num = 4;
        System.out.println("Square Root of "+num+" is = "+mySqrt(num));
        System.out.println();

        System.out.println("--------------Test Case 3------------------");
        num = 8;
        System.out.println("Square Root of "+num+" is = "+mySqrt(num));
        System.out.println();

        System.out.println("--------------Test Case 4------------------");
        num = 10;
        System.out.println("Square Root of "+num+" is = "+mySqrt(num));
        System.out.println();

        System.out.println("--------------Test Case 5------------------");
        num = 1;
        System.out.println("Square Root of "+num+" is = "+mySqrt(num));
        System.out.println();
    }

    public static int mySqrt(int x) {
        int start = 0 , end = x;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if(mid * mid == x){
                return mid;
            }else if(mid * mid > x){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return start-1;
    }
}
