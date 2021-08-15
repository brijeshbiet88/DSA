package com.leetcode.binarysearch.medium;

public class SearchInSortedRotatedArray {
    public static void main(String[] args) {
        System.out.println("-----------------Test Case 1---------------------");
        int [] nums = {4,5,6,7,0,1,2,3};
        int target = 0;
        System.out.println("Index of "+target+" in Array = "+search(nums , target));
        System.out.println();

        System.out.println("-----------------Test Case 2---------------------");
        target = 3;
        System.out.println("Index of "+target+" in Array = "+search(nums , target));
        System.out.println();

        System.out.println("-----------------Test Case 3---------------------");
        int [] nums2 = {1};
        target = 0;
        System.out.println("Index of "+target+" in Array = "+search(nums2 , target));
        System.out.println();

        System.out.println("-----------------Test Case 4---------------------");
        int [] nums3 = {3 , 1};
        target = 1;
        System.out.println("Index of "+target+" in Array = "+search(nums3 , target));
        System.out.println();
    }

    public static int search(int[] nums, int target) {
        int start = 0 , end = nums.length -1;
        return search(nums , target , start ,end );
    }

    private static int search(int[] nums, int target, int start, int end) {
        int mid = 0;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return mid;

            if(nums[start] <= nums[mid]){
                if (target >= nums[start] && target <= nums[mid]){
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }else{
                if (target >= nums[mid] && target <= nums[end]){
                    start = mid + 1;
                }else {
                    end = mid - 1;
                }
            }

        }

        return -1;
    }
}
