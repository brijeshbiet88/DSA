package com.leetcode.array.medium;

public class SortColors {
    public static void main(String[] args) {
        System.out.println("---------------Test Case 1---------------");
        int [] nums = {2,0,2 ,1 ,1 , 0};
        sortColors(nums);
        System.out.println("Array Elements After Sorting : ");
        for (int n : nums)
            System.out.print(n+" ");
        System.out.println();

        System.out.println("----------------Test Case 2--------------------");
        int [] nums2 = {2,0,1};
        sortColors(nums2);
        System.out.println("Array Elements After Sorting : ");
        for (int n : nums2)
            System.out.print(n+" ");
    }

    public static void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length -1;

        while (mid <= high){

            if(nums[mid] == 0){
                swap(nums , low , mid);
                low++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else if(nums[mid] == 2){
                swap(nums , mid , high);
                high--;
            }
        }


    }

    public static void swap (int [] num , int i , int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
