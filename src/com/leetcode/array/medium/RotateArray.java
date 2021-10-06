package com.leetcode.array.medium;

public class RotateArray {
    public static void main(String[] args) {
        System.out.println("----------------Test Case 1-----------------");
        int [] nums = {1,2,3,4,5,6,7};
        int k = 3;
        printArray(nums);
        System.out.println();

        System.out.println("----------------Test Case 2-----------------");
        int [] nums2 = {-1,-100,3,99};
        k = 2;
        printArray(nums2);
        System.out.println();


    }

    private static void printArray(int[] nums) {
        System.out.println("print Array After Rotation ");
        for (int num : nums)
            System.out.print(num+" ");
        System.out.println();
    }

    public static void rotate(int[] nums, int k) {
        int len = nums.length ;
        k = k % len;
        if(k == 0 || len == 1 ) return;
        reverse(nums , 0 , len-1);
        reverse(nums , 0 , k-1);
        reverse(nums , k , len-1);

    }

    public static void reverse(int[] nums, int start, int end){
        while(start < end)
        {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
}
