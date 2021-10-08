package com.leetcode.miscellaneous;

public class SingleNumber2 {
    public static void main(String[] args) {
        System.out.println("---------------Test Case 1------------------");
        int [] nums1 = {2 , 2, 3 , 2 , 1 , 3 ,3};
        System.out.println("Single Number = "+singleNumber(nums1));
        System.out.println();
        //[0,1,0,1,0,1,99

        System.out.println("---------------Test Case ------------------");
        int [] nums2 = {0 ,1 , 0 , 1 , 0 , 1 , 99};
        System.out.println("Single Number = "+singleNumber(nums2));
        System.out.println();
    }

    public static int singleNumber(int[] nums) {
        int result = 0;
        for(int i = 0; i < 32; i++) {
            int sum = 0;
            for(int j = 0; j < nums.length; j++) {
                if(((nums[j] >> i) & 1) == 1)
                    sum++;
            }
            sum = sum % 3;

            if(sum != 0) {
                result |= sum << i; // to set bits
            }
        }
        return result;
    }
}
