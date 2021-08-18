package com.leetcode.array.medium;

import java.util.HashMap;
import java.util.Map;

public class LargestSubarrayWithEqual0and1 {
    public static void main(String[] args) {
        int nums [] = {0,1,1,0,1,1,1,0};
        System.out.println("Largest Sub Array With Equal 0 and 1 = "+findMaxLength(nums));
    }

    public static int findMaxLength(int[] nums) {
        int sum = 0;
        int largest = 0;
        Map<Integer, Integer> map = new HashMap<Integer , Integer>();
        map.put(0,0);
        for (int i = 0 ; i < nums.length ; i++){
            sum += nums[i] == 1 ? 1 : -1;
            if(map.get(sum) != null) {
                largest = Math.max(largest , i + 1 - map.get(sum));
            }else{
                map.put(sum, i+1);
            }
        }

        return largest;
    }
}
