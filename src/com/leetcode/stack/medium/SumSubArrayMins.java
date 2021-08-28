package com.leetcode.stack.medium;

import java.util.Stack;

public class SumSubArrayMins {
    public static void main(String[] args) {
        System.out.println("-----------------Test Case 1-----------------------");
        int [] arr = {11,81,94,43,3};
        System.out.println("Sum of Sub Array Minimum Elements = "+sumSubarrayMins(arr));
        System.out.println();


        System.out.println("-----------------Test Case 2-----------------------");
        int [] arr2 = {3 , 1 , 2 , 4};
        System.out.println("Sum of Sub Array Minimum Elements = "+sumSubarrayMins(arr2));
        System.out.println();
    }

    public static int sumSubarrayMins(int[] arr) {
        int sum = 0;
        int mod = 1000000007;
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        int n = arr.length;

        int [] nextSmaller = new int[n];
        int [] preSmaller = new int[n];

        for (int i = 0 ; i < n ; i++){
            nextSmaller[i] = n - i -1;
            preSmaller[i] = i;
        }

        for (int i = 0 ; i < n ; i++) {
            while (!s1.isEmpty()  && arr[s1.peek()] > arr[i]){
                nextSmaller[s1.peek()] = i - s1.peek() - 1 ;
                s1.pop();
            }
            s1.push(i);
        }

        for (int i = n-1 ; i >= 0 ; i--) {
            while (!s2.isEmpty()  && arr[s2.peek()] >= arr[i]){
                preSmaller[s2.peek()] = s2.peek() - i - 1 ;
                s2.pop();
            }
            s2.push(i);
        }

        for (int i = 0 ; i < n ; i++){
            Long prod = (long)arr[i] * ((nextSmaller[i] + 1) * (preSmaller[i] + 1) );
            sum = (int)(sum +  prod % mod);
            sum %= mod;
        }
        return sum;
    }
}

