package com.leetcode.binarysearch.easy;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println("--------------test Case 1--------------");
        int [] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println("Index of "+target+" = "+search(nums , target));

        System.out.println("--------------test Case 2--------------");
        int [] nums2 = {-1,0,3,5,9,12};
        target = 2;
        System.out.println("Index of "+target+" = "+search(nums2 , target));
    }

    public static int search(int[] nums, int target) {
        int end = nums.length - 1;
        int start = 0;
        return binarySearchUtil(nums , target , start , end);
    }

    private static int binarySearchUtil(int[] nums, int target, int start, int end) {
        int mid = start + (end - start) / 2;
        if(start > end){
            return - 1;
        }
        if(nums[mid] == target){
            return mid;
        }else if(nums[mid] < target){
            return binarySearchUtil(nums , target , start +1 , end);
        }else{
            return binarySearchUtil(nums , target , start , end-1);
        }
    }
}
