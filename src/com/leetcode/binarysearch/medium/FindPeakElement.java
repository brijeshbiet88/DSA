package com.leetcode.binarysearch.medium;

public class FindPeakElement {
    public static void main(String[] args) {
        int [] nums = {2 , 6 , 8, 1 , 0};
        System.out.println("Peak Element = "+findPeakElement(nums));

    }

    public static int findPeakElement(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    public static int search(int[] nums, int low, int high) {
        if (low == high)
            return low;
        int mid = (low + high) / 2;
        if (nums[mid] > nums[mid + 1])
            return search(nums, low, mid);
        return search(nums, mid + 1, high);
    }
}
