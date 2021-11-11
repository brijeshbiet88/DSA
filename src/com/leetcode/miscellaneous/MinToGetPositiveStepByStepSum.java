package com.leetcode.miscellaneous;

public class MinToGetPositiveStepByStepSum {
    public static void main(String[] args) {
        System.out.println("--------------Test Case 1---------------");
        int [] a1 = {-3,2,-3,4,2};
        System.out.println("Min Value To Get Positive Step By Step Sum = "+minStartValue(a1));
        System.out.println();

        System.out.println("--------------Test Case 2---------------");
        int [] a2 = {1,2};
        System.out.println("Min Value To Get Positive Step By Step Sum = "+minStartValue(a2));
        System.out.println();

        System.out.println("--------------Test Case 3---------------");
        int [] a3 = {1,-2,-3};
        System.out.println("Min Value To Get Positive Step By Step Sum = "+minStartValue(a3));
        System.out.println();
    }

    public static int minStartValue(int[] nums) {
        int min = 0;
        int sum = 0;
        for(int i = 0; i < nums.length ; i++){
            sum += nums[i];
            min = Math.min(min , sum);
        }
        return -min + 1;
    }
}
