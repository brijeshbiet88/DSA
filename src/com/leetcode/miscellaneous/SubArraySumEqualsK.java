package com.leetcode.miscellaneous;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {
    public static void main(String[] args) {
        System.out.println("---------------Test Case 1-------------------");
        int [] nums1 = {10,5,7 , 1 , 2 , 5, 3};
        int k = 15;
        System.out.println("Result = "+subarraySum(nums1,k));
        System.out.println();

        System.out.println("---------------Test Case 2-------------------");
        int [] nums2 = {1 , 1,1};
        k = 2;
        System.out.println("Result = "+subarraySum(nums2,k));
        System.out.println();

        System.out.println("---------------Test Case 3-------------------");
        int [] nums3 = {1,2, 3};
        k = 3;
        System.out.println("Result = "+subarraySum(nums3,k));
        System.out.println();
    }

    public static int subarraySum(int[] nums, int k) {
        int n = nums.length ;
        int sum = 0 , count = 0;
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        map.put(0,1);

        for(int i = 0 ; i <n ; i++ ){
            sum += nums[i];
            if(map.containsKey(sum-k)){
                count += map.get(sum-k);
            }
            map.put(sum , map.getOrDefault(sum , 0) +1);
        }

        return count;
    }
}
