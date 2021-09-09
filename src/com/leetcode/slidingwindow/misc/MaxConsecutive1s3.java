package com.leetcode.slidingwindow.misc;

public class MaxConsecutive1s3 {
    public static void main(String[] args) {
        System.out.println("-----------------Test Case 1--------------------");
        int [] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;
        System.out.println("Max Consecutive 1s After K 0 Flip "+longestOnes(nums,k));
        System.out.println();

        System.out.println("-----------------Test Case 2--------------------");
        int [] nums2 = {1,1,1,0,0,0,1,1,1,1,0};
        k = 2;
        System.out.println("Max Consecutive 1s After K 0 Flip "+longestOnes(nums2,k));
        System.out.println();

    }

    public static int longestOnes(int[] nums, int k) {
        int max = 0;
        int j = -1;
        int count = 0;
        for (int i = 0 ; i < nums.length ; i++){
            if(nums[i] == 0){
                count++;
            }
            while (count > k){
                j++;
                if(nums[j] == 0){
                    count--;
                }
            }
            max = Math.max(max , i - j);
        }
        return max;
    }
}
