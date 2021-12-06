package com.leetcode.dp.medium;

public class TargetSum {
    public static void main(String[] args) {
        TargetSum targetSum = new TargetSum();
        System.out.println("-----------------Test Case 1-------------------");
        int [] nums1 = {100};
        int target = -200;
        System.out.println("No of Ways To Achieve Target "+target+" with +/- Combinations ? "+targetSum.findTargetSumWays(nums1 , target));
        System.out.println();

        System.out.println("-----------------Test Case 2-------------------");
        int [] nums2 = {1,1,1,1,1};
        target = 3;
        System.out.println("No of Ways To Achieve Target "+target+" with +/- Combinations ? "+targetSum.findTargetSumWays(nums2 , target));
        System.out.println();

        System.out.println("-----------------Test Case 3-------------------");
        int [] nums3 = {1,1,1,1,1};
        target = -1;
        System.out.println("No of Ways To Achieve Target "+target+" with +/- Combinations ? "+targetSum.findTargetSumWays(nums3 , target));
        System.out.println();
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num : nums)
            sum += num;
        target = Math.abs(target);
        return (sum < target || (sum + target) % 2 == 1) ? 0 : subsetSum(nums, (sum + target)/2);
    }

    private int subsetSum(int [] nums , int target){
        int [] dp = new int [target + 1];
        dp[0] = 1;
        for (int n : nums) {
            for (int i = target; i >= n; --i) {
                dp[i] += dp[i-n];
            }
        }

        return dp[target];
    }
}
