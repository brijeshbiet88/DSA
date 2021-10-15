package com.leetcode.miscellaneous;

public class MaxProductSubArray {
    public static void main(String[] args) {
        System.out.println("---------------Test Case 1-----------------");
        int [] nums1 = {1 , 2 , -4 , 5 , -6};
        System.out.println("Max Product Sub Array = "+maxProduct(nums1));
        System.out.println();
    }

    public static int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int prod = nums[0];

        for(int i = 1 ; i < nums.length ; i++) {

            if(nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(nums[i], nums[i] * max);
            min = Math.min(nums[i], nums[i] * min);

            if(prod < max) {
                prod = max;
            }


        }
        return prod;

    }
}
