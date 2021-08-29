package com.leetcode.array.medium;

public class MinSizeSubArraySum {
    public static void main(String[] args) {
        System.out.println("-----------------Test Case 1--------------------");
        int [] nums = {2,3,1,2,4,3};
        int target = 7;
        System.out.println("Min Length Subarray with Sum = "+target+" = "+minSubArrayLen(target ,nums));
        System.out.println();
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int result = Integer.MAX_VALUE ;
        int sum = 0;
        for(int i = 0 ; i < nums.length ; i++){
            sum += nums[i];
            while (sum >= target){
                result = Math.min(result , i - left + 1);
                sum -= nums[left++];
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
