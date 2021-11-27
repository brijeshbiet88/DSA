package com.leetcode.array.medium;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        System.out.println("----------------Test Case 1-------------------");
        int [] nums = {1,2,3,4,5};
        int [] res = productExceptSelf(nums);
        System.out.println("Print Result : ");
        for (int num : res)
            System.out.print(num+" ");
        System.out.println();
    }

    public static int[] productExceptSelf(int[] nums) {

        int len = nums.length;
        int [] prod = new int [len];
        int i = 0 ,temp = 1;
        for(i = 0; i < len ; i++) {
            prod[i] = 1;
        }

        // left Array Formation

        for(i = 0 ; i < len ; i++) {
            prod[i] = temp*prod[i];
            temp *= nums[i];
        }

        //right array Formation
        temp = 1;
        for(i = len-1 ; i >= 0 ; i--) {
            prod[i] = temp*prod[i];
            temp *= nums[i];
        }

        return prod;

    }
}
