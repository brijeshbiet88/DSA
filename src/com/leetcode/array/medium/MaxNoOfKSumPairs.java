package com.leetcode.array.medium;

import java.util.HashMap;
import java.util.Map;

public class MaxNoOfKSumPairs {

    public static void main(String[] args) {
        int [] a = {3,1,3,4,3};
        System.out.println("Result = "+maxOperations(a, 6));
    }

    public static int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (int i : nums) {
            if (map.containsKey(k-i)) {
                if (i == (k-i)) {
                    res += map.get(i)/2;
                    map.remove(i);
                }
                else {
                    res += Math.min(map.get(i), map.get(k-i));
                    map.remove(i);
                    map.remove(k-i);
                }
            }
        }
        return res;
    }
}
