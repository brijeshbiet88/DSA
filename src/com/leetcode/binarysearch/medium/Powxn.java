package com.leetcode.binarysearch.medium;

public class Powxn {
    public static void main(String[] args) {
        System.out.println("----------------Test Case 1---------------");
        double x = 2.0;
        int n = 10;
        System.out.println("Result of "+x+" to the power "+n+" = "+myPow(x,n));
        System.out.println();

        System.out.println("----------------Test Case 2---------------");
        x = 2.0;
        n = -2;
        System.out.println("Result of "+x+" to the power "+n+" = "+myPow(x,n));
        System.out.println();

        System.out.println("----------------Test Case 3---------------");
        x = 2.0;
        n = -2147483648;
        System.out.println("Result of "+x+" to the power "+n+" = "+myPow(x,n));
        System.out.println();

    }

    public static double myPowUtil(double x, int n) {
        if(n == 0){
            return 1;
        }

        if(n == 1){
            return  x;
        }


        if(n%2 == 0) {
            double r = myPow(x, n / 2);
            return r * r;
        }
        else{
            double r = myPow(x,n/2);
            return x * r * r;
        }
    }

    public static double myPow(double x, int n) {
       boolean isNegativeMax = n == -2147483648 ? true : false;
       if(isNegativeMax){
           n = n + 1;
       }
       int absN = Math.abs(n);
       boolean isNegative = n >= 0 ? false : true;
       double result = myPowUtil(x, absN);
       if(isNegative){
           result = 1 / result;
       }if(isNegativeMax){
           result = result / x;
        }
       return  result;
    }
}
