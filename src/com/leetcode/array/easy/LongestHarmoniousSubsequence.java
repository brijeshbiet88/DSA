package com.leetcode.array.easy;

import java.util.HashMap;

public class LongestHarmoniousSubsequence {
    public static void main(String[] args) {
        System.out.println("--------------Test Case 1----------------");
        int [] nums = {1,3,2,2,5,2,3,7};
        System.out.println("Longest Harmonious Subsequence With Max and Min Diff Exactly 1 = "+findLHS(nums));
        System.out.println();

        System.out.println("--------------Test Case 2----------------");
        int [] nums2 = {1,2,3,4};
        System.out.println("Longest Harmonious Subsequence With Max and Min Diff Exactly 1 = "+findLHS(nums2));
        System.out.println();

        System.out.println("--------------Test Case 3----------------");
        int [] nums3 = {1,1,1,1};
        System.out.println("Longest Harmonious Subsequence With Max and Min Diff Exactly 1 = "+findLHS(nums3));
        System.out.println();
    }

    public static int findLHS(int[] nums) {
        HashMap< Integer, Integer > map = new HashMap();
        int result = 0;
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.containsKey(num + 1))
                result = Math.max(result, map.get(num) + map.get(num + 1));
            if (map.containsKey(num - 1))
                result = Math.max(result, map.get(num) + map.get(num - 1));
        }
        return result;
    }
}
