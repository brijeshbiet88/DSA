package com.leetcode.array.medium;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumDivByK {

	public static void main(String[] args) {
		System.out.println("-------------Test Case 1--------------");
		int nums [] = {4,5,0,-2,-3,1};
		int k = 5;
		System.out.println(" No of Sub Arrays With Divisible By K is "+ subarraysDivByK(nums, k));
		System.out.println();

	}

	public static int subarraysDivByK(int[] nums, int k) {
		int result = 0;

		Map<Integer, Integer> map = new HashMap();
		map.put(0, 1);

		int runningSum = 0;

		for (int i = 0; i < nums.length; i++) {
			runningSum += nums[i];
			
			int rem = (runningSum % k + k ) % k;
			result += map.getOrDefault(rem, 0);
			
			map.put(rem, map.getOrDefault(rem, 0) + 1);
			
			
		}
		return result;

	}
}
