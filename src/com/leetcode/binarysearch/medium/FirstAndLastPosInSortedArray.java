package com.leetcode.binarysearch.medium;

public class FirstAndLastPosInSortedArray {
    public static void main(String[] args) {
        System.out.println("---------------Test Case 1---------------");
        int [] nums = {5,7,7,8,8,10};
        int target = 8;
        int pos [] = new int [2];
        pos = searchRange(nums , target);
        System.out.println("First and Last Position of "+target+" is "+pos[0]+" , "+pos[1]);
        System.out.println();

        System.out.println("---------------Test Case 2---------------");
        int [] nums2 = {5,7,7,8,8,10};
        target = 6;
        int pos2 [] = new int [2];
        pos2 = searchRange(nums2 , target);
        System.out.println("First and Last Position of "+target+" is "+pos2[0]+" , "+pos2[1]);
        System.out.println();

        System.out.println("---------------Test Case 3---------------");
        int [] nums3 = {};
        target = 0;
        int pos3 [] = new int [2];
        pos3 = searchRange(nums3 , target);
        System.out.println("First and Last Position of "+target+" is "+pos3[0]+" , "+pos3[1]);
        System.out.println();
    }

    public static int[] searchRange(int[] nums, int target) {
        int [] pos = new int [2];
        pos[0] = findFirstOccurcnce(nums , target , 0 , nums.length -1);
        pos[1] = findLastOccurcnce(nums , target , 0 , nums.length -1);
        
        return pos;
    }

    private static int findFirstOccurcnce(int[] nums, int target, int low, int high) {
        if(low > high)
            return -1;
        int mid = low + (high - low)/2;

        if(nums[mid] == target && mid > 0 && nums[mid -1] < target){
            return mid;
        }else if(nums[mid] == target && mid == 0 ){
            return mid;
        }
        else if(nums[mid] == target && mid > 0 && nums[mid-1] == target){
            return findFirstOccurcnce(nums, target, low, mid-1);
        }

        else if(nums[mid] > target ){
            return findFirstOccurcnce(nums, target, low, mid-1);
        }else if(nums[mid] < target){
            return findFirstOccurcnce(nums, target, mid+1, high);
        }
        return -1;
    }

    private static int findLastOccurcnce(int[] nums, int target, int low, int high) {
        if(low > high)
            return -1;
        int mid = low + (high - low)/2;

        if(nums[mid] == target && mid < nums.length -1 && nums[mid +1] > target){
            return mid;
        }else if(nums[mid] == target && mid == nums.length -1 ){
            return mid;
        }
        else if(nums[mid] == target && mid < nums.length -1 && nums[mid+1] == target){
            return findLastOccurcnce(nums, target, mid +1 , high);
        }

        else if(nums[mid] > target ){
            return findLastOccurcnce(nums, target, low, mid-1);
        }else if(nums[mid] < target){
            return findLastOccurcnce(nums, target, mid+1, high);
        }
        return -1;
    }



}
