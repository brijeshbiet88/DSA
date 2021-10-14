package com.leetcode.array.medium;

import java.util.Arrays;

public class ValidTriangle {
    public static void main(String[] args) {
        System.out.println("---------------Test Case 1-------------------");
        int [] nums = {2 , 2 , 3, 4};
        System.out.println("No of Valid Triangles "+triangleNumber(nums));
        System.out.println();

        System.out.println("---------------Test Case 2-------------------");
        int [] nums2 = {4 , 2 , 3, 4};
        System.out.println("No of Valid Triangles "+triangleNumber(nums2));
        System.out.println();
    }

    public static int triangleNumber(int[] nums) {
        int n = nums.length ;
        if(n < 3) return 0;
        Arrays.sort(nums);
        int count = 0;

        for(int i = n - 1 ; i >= 2; i--){
            int j = 0;
            int k = i -1;
            while(j < k){
                if (nums[k] + nums[j] > nums[i]){
                    count += k -j;
                    k--;
                }else {
                    j++;
                }

            }
        }

        return count;
    }
}
