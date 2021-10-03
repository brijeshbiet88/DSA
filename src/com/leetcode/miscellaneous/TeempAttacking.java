package com.leetcode.miscellaneous;

public class TeempAttacking {
    public static void main(String[] args) {
        System.out.println("---------------Test Case 1------------------");
        int [] timeSeries = {1,4};
        int duration = 2;
        System.out.println("Result = "+findPoisonedDuration(timeSeries,duration));
        System.out.println();

        System.out.println("---------------Test Case 2------------------");
        int [] timeSeries2 = {1,2};
        duration = 2;
        System.out.println("Result = "+findPoisonedDuration(timeSeries2,duration));
        System.out.println();
    }

    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries.length == 0) return 0;
        int totalDuration = 0;
        for (int i = 0 ; i < timeSeries.length -1 ; i++){
            totalDuration += Math.min(duration , timeSeries[i+1] - timeSeries[i]);
        }
        return duration + totalDuration;
    }
}
