package com.leetcode.binarysearch.medium;

public class SingleNumberInSortedArray {
    public static void main(String[] args) {
        System.out.println("-------------Test Case 1---------------");
        int[] nums1= {1};
        System.out.println("Single Number In Sorted Array = "+singleNonDuplicate(nums1));
        System.out.println();

        System.out.println("-------------Test Case 2---------------");
        int[] nums2= {1 , 2 , 2};
        System.out.println("Single Number In Sorted Array = "+singleNonDuplicate(nums2));
        System.out.println();

        System.out.println("-------------Test Case 3---------------");
        int[] nums3= {1 , 1 , 3};
        System.out.println("Single Number In Sorted Array = "+singleNonDuplicate(nums3));
        System.out.println();

        System.out.println("-------------Test Case 4---------------");
        int[] nums4 = {1,1,2,3,3,4,4,8,8};
        System.out.println("Single Number In Sorted Array = "+singleNonDuplicate(nums4));
        System.out.println();

        System.out.println("-------------Test Case 5---------------");
        int[] nums5 = {3,3,7,7,10,11,11};
        System.out.println("Single Number In Sorted Array = "+singleNonDuplicate(nums5));
        System.out.println();
    }

    public static int singleNonDuplicate(int[] nums) {

        if (nums == null) {
            return -1;
        }

        int l = 0, h = nums.length - 1;

        while (l != h) {
            int mid = (h + l) / 2;

            if (mid % 2 != 0) {

                if (nums[mid] == nums[mid - 1]) {
                    l = mid + 1;
                } else {
                    h = mid - 1;
                }
            }

            else {

                if (nums[mid] == nums[mid + 1]) {
                    l = mid + 2;
                } else {
                    h = mid;
                }
            }

        }
        return nums[h];

    }
}
