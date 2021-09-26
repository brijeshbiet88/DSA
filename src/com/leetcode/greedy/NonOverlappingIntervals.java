package com.leetcode.greedy;

import java.util.Arrays;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        System.out.println("-----------------Test Case 1---------------------");
        int [][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println("Result = "+eraseOverlapIntervals(intervals));
        System.out.println();
    }

    public static int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);

        int result = 0;
        int prevEnd = Integer.MIN_VALUE;

        for (int[] interval : intervals) {
            if (prevEnd > interval[0]) result++;
            else prevEnd = interval[1];
        }

        return result;
    }
}
