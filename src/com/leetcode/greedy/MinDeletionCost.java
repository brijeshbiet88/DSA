package com.leetcode.greedy;

public class MinDeletionCost {
    public static void main(String[] args) {
        System.out.println("-------------------Test Case 1---------------------");
        String s = "abaac";
        int [] cost = {1,2,3,4,5};
        System.out.println("Result = "+minCost(s,cost));
        System.out.println();
    }

    public static int minCost(String s, int[] cost) {
        int len = s.length(), groupSum = 0, groupMax = 0, result = 0;
        for (int i = 0; i < len; i++) {
            if (i > 0 && s.charAt(i) != s.charAt(i - 1)) {
                result += groupSum - groupMax;
                groupSum = 0;
                groupMax = 0;
            }
            groupSum += cost[i];
            groupMax = Math.max(groupMax, cost[i]);
        }

        result += groupSum - groupMax;
        return result;
    }
}
