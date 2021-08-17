package com.leetcode.binarysearch.medium;

public class MinLimitsOfBallsInBag {
    public static void main(String[] args) {
        System.out.println("------------------Test Case 1-------------------");
        int [] nums = {9};
        int maxOpeartion = 2;
        System.out.println("Minimum Penalty = "+minimumSize(nums , maxOpeartion));
        System.out.println();

        System.out.println("------------------Test Case 2-------------------");
        int [] nums2 = {2,4,8,2};
        maxOpeartion = 4;
        System.out.println("Minimum Penalty = "+minimumSize(nums2 , maxOpeartion));
        System.out.println();

        System.out.println("------------------Test Case 2-------------------");
        int [] nums3 = {7,17};
        maxOpeartion = 2;
        System.out.println("Minimum Penalty = "+minimumSize(nums3 , maxOpeartion));
        System.out.println();
    }

    public static int minimumSize(int[] nums, int maxOperations) {
        int min = 1 ;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
           max = Math.max(max, nums[i]);
        }

        while (min < max)
        {
            int mid = (min + max) / 2 ;
            int count = 0;
            for (int num : nums)
            count += (num - 1) / mid;
            if (count > maxOperations) min = mid + 1;
            else max = mid;
        }
        return min;
    }

}

