package com.leetcode.math.medium;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        System.out.println("-------------Test Case 1-----------------");
        int [] nums = {1,2,3,4,5,3,2};
        nextPermutation(nums);
        System.out.println("Print Next Permutation");
        for (int num : nums)
            System.out.print(num+" ");
        System.out.println();

        System.out.println("-------------Test Case 2-----------------");
        int [] nums2 = {1,3,2};
        nextPermutation(nums2);
        System.out.println("Print Next Permutation");
        for (int num : nums2)
            System.out.print(num+" ");
        System.out.println();

        System.out.println("-------------Test Case 3-----------------");
        int [] nums3 = {3,2,1};
        nextPermutation(nums3);
        System.out.println("Print Next Permutation");
        for (int num : nums3)
            System.out.print(num+" ");
        System.out.println();
    }

    public static void nextPermutation(int[] nums) {
        if(nums.length == 1) return;
        int n = nums.length ;
        int lastDigit = nums[n-1];
        int i = n - 1;
        while(i > 0 && nums[i-1] >= nums[i]){
            i--;
        }

        if(i <= 0){
            reverse(nums , 0 , n -1);
            return;
        }

        int j = n-1;
        while( j > i && nums[j] <= nums[i-1]){
            j--;
        }

        swap(nums , i-1 , j);
        reverse(nums , i , n-1);

        return;
    }

    public static void reverse(int []nums , int i , int j){

        while(i < j){
            swap(nums , i , j);
            i++;
            j--;
        }
    }

    public static void swap(int [] nums , int a , int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
