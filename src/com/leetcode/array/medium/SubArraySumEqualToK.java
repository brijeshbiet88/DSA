package com.leetcode.array.medium;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualToK {

	public static void main(String[] args) {
		System.out.println("----------------Test Case 1------------------------");
		int [] nums = {1,2,3};
		int k = 3;
		System.out.println("Sub Array Sum Count "+subarraySum(nums, k));
		System.out.println();
		
		System.out.println("----------------Test Case 2------------------------");
		int [] nums2 = {1,2,3 , -1 , 1 , -2 , 2};
		k = 3;
		System.out.println("Sub Array Sum Count "+subarraySum2(nums2, k));
		System.out.println();

	}
	
	public static  int subarraySum(int[] nums, int k) {
		  int count = 0;
	        for (int start = 0; start < nums.length; start++) {
	            int sum=0;
	            for (int end = start; end < nums.length; end++) {
	                sum+=nums[end];
	                if (sum == k)
	                    count++;
	            }
	        }
	        return count;
    }

	public static  int subarraySum2(int[] nums, int k) {
		int count = 0, sum = 0;
        Map <Integer, Integer> map = new HashMap <> ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
  }
}
