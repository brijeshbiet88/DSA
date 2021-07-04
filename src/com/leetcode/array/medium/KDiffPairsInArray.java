package com.leetcode.array.medium;

import java.util.HashMap;
import java.util.Map;

public class KDiffPairsInArray {

	public static void main(String[] args) {
		System.out.println("-----------------Test Case 1--------------------");
		int [] nums = {3,1,4,1,5};
		System.out.println("No of K Diff Pairs "+findPairs(nums, 2));
		System.out.println();

	}

	public static int findPairs(int[] nums, int k) {
		int result = 0;

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int num : nums) {
			map.put(num , map.getOrDefault(num, 0) + 1);
		}
		
		for(int num : map.keySet()) {
			if(k > 0 && map.containsKey(num+k) || k == 0 && map.get(num) > 1)
				result++;
		}

		return result;

	}
}
