package com.leetcode.dp.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
    public static void main(String[] args) {
        System.out.println("--------------Test Case 1-------------------");
        int [] nums1 = {1,2,4,8};
        List<Integer> res = largestDivisibleSubset(nums1);
        System.out.println("Result : ");
        res.forEach(s-> System.out.println(s+" "));
        System.out.println();
    }

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int len = nums.length;
        if(len == 0) return result;
        Arrays.sort(nums);
        int [] dp = new int[len];
        Arrays.fill(dp , 1);

        int maxIndex = 0;
        for (int i = 1; i < len ; i++){
            for(int j = i - 1 ; j >= 0 ; j-- ){
                if(nums[i] % nums[j] == 0){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if(dp[i] > dp[maxIndex]){
                maxIndex = i;
            }
        }

        int temp = nums[maxIndex];
        int currentCount = dp[maxIndex];
        for(int i = maxIndex ; i >= 0 ; i--){
            if(temp % nums[i] == 0 && currentCount == dp[i]){
                result.add(nums[i]);
                temp = nums[i];
                currentCount--;
            }
        }

        return result;
    }
}
