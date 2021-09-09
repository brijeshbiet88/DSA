package com.leetcode.slidingwindow.misc;

public class MaxConsecutive1s {
    public static void main(String[] args) {
        System.out.println("----------------Test Case 1-----------------------");
        int [] nums = {1,1,0,1,1,1};
        System.out.println("Max Consecutive 1s = "+findMaxConsecutiveOnes(nums));
        System.out.println();
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;

        for (int i = 0 ; i < nums.length ; i++){
            if(nums[i] == 1){
                count++;
            }else {
                max = Math.max(count , max);
                count = 0;
            }

        }
        max = Math.max(count , max);
        return max;
    }
}
