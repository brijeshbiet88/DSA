package com.leetcode.array.medium;

public class MinINRotatedSorted {
    public static void main(String[] args) {
        System.out.println("----------------Test Case 1------------------");
        int [] nums1 = {5 , 4};
        System.out.println("Min = "+findMin(nums1));
        System.out.println();

        System.out.println("----------------Test Case 2------------------");
        int [] nums5 = {4,5,6,7,0,1,2};
        System.out.println("Min = "+findMin(nums5));
        System.out.println();

        System.out.println("----------------Test Case 3------------------");
        int [] nums2 = {3,4,5,1,2};
        System.out.println("Min = "+findMin(nums2));
        System.out.println();

        System.out.println("----------------Test Case 4------------------");
        int [] nums3 = {4 , 5 , 6};
        System.out.println("Min = "+findMin(nums3));
        System.out.println();

        System.out.println("----------------Test Case 5------------------");
        int [] nums4 = {4,5,6,7,0,1,2};
        System.out.println("Min = "+findMin(nums4));
        System.out.println();
    }

    public static int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        int low = 0 ,  high = nums.length -1;
        if(nums[low] < nums[high]) return nums[low];

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(mid > 0 && nums[mid] < nums[mid -1])
                return nums[mid];
            if(mid < nums.length -1 && nums[mid] > nums[mid + 1])
                return nums[mid + 1];


            if(nums[low] < nums[mid]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return -1;
    }
}
