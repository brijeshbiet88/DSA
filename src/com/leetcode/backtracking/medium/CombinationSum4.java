package com.leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum4 {
    public static void main(String[] args) {
        System.out.println("-------------------Test Case 1-----------------------");
        int [] nums = {1 , 2 , 3};
        int target = 4;
        System.out.println("No of Combinations = "+combinationSum4(nums , target));
        System.out.println();

        System.out.println("-------------------Test Case 2-----------------------");
        int [] nums2 = {9};
        target = 3;
        System.out.println("No of Combinations = "+combinationSum4(nums2 , target));
        System.out.println();

        System.out.println("-------------------Test Case 3-----------------------");
        int [] nums3 = {1 , 2 , 3 , 4 , 5};
        target = 10;
        System.out.println("No of Combinations = "+combinationSum4(nums3 , target));
        System.out.println();
    }

    public static int combinationSum4(int[] nums, int target) {
        int [] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return combinationSum4(nums, target, dp);
    }


    private static int combinationSum4 (int []nums, int target, int[] dp) {
        if (target == 0) return 1;

        if (target < 0) return 0;

        if ( dp[target] == -1) {

            int count = 0;
            for (int i = 0 ; i < nums.length; i++) {
                count += combinationSum4(nums, target - nums[i],  dp);
            }

             dp[target] = count;
        }
        return  dp[target];
    }

}
