package com.leetcode.array.medium;

public class FindDuplicateNumber {
    public static void main(String[] args) {
        System.out.println("--------------Test Case 1---------------");
        int [] nums = {1 , 2 , 3 , 4 , 3};
        System.out.println("Result = "+findDuplicate(nums));
        System.out.println();

        System.out.println("--------------Test Case 2---------------");
        int [] nums2 = {2 , 2 , 2 , 2 , 2};
        System.out.println("Result = "+findDuplicate(nums2));
        System.out.println();
    }

    public static int findDuplicate(int[] nums) {
        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            int num = Math.abs(nums[i]);
            nums[num] = - nums[num];
            if(nums[num] > 0)
                return num;
        }

        return -1;
    }
}
