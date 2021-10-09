package com.leetcode.miscellaneous;

public class MissingNumber {
    public static void main(String[] args) {
        System.out.println("--------------Test Case 1-----------------");
        int [] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println("Missing Number = "+missingNumber(nums));
        System.out.println();

        System.out.println("--------------Test Case 2-----------------");
        int [] nums2 = {3 , 0 , 2};
        System.out.println("Missing Number = "+missingNumber(nums2));
        System.out.println();

        System.out.println("--------------Test Case 3-----------------");
        int [] nums3 = {0 , 1};
        System.out.println("Missing Number = "+missingNumber(nums3));
        System.out.println();
    }

    public static int missingNumber(int[] nums) {

        int n = nums.length;
        int xor = 0;
        int i =0;
        while(i < n){
            xor ^= i;
            xor ^= nums[i];
            i++;
        }

        xor ^= n;

        return xor;

    }
}
