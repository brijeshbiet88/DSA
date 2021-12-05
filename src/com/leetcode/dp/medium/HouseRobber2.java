package com.leetcode.dp.medium;

public class HouseRobber2 {
    public static void main(String[] args) {
        System.out.println("---------------Test case 1---------------");
        int [] nums = {1 , 2 , 3};
        System.out.println("Max profit = "+rob(nums));
        System.out.println();

        System.out.println("---------------Test case 2---------------");
        int [] nums2 = {1 , 2 , 3, 1};
        System.out.println("Max profit = "+rob(nums2));
        System.out.println();


        System.out.println("---------------Test case 3---------------");
        int [] nums3 = {2 , 3, 2};
        System.out.println("Max profit = "+rob(nums3));
        System.out.println();

        System.out.println("---------------Test case 4---------------");
        int [] nums4 = {5};
        System.out.println("Max profit = "+rob(nums4));
        System.out.println();

        System.out.println("---------------Test case 5---------------");
        int [] nums5 = {2 , 3, 1 , 7 , 1 , 4 };
        System.out.println("Max profit = "+rob(nums5));
        System.out.println();
    }

    public static int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(rob(nums , 0 , nums.length -1) , rob(nums , 1 , nums.length));
    }

    public static int rob(int[] nums , int start , int end) {
        int firstPrev = 0 , secPrev = 0 , max = 0;

        for (int i = start ; i < end ; i++){
            max = Math.max(secPrev + nums[i] , firstPrev);
            secPrev = firstPrev;
            firstPrev = max;
        }

        return max;
    }
}
