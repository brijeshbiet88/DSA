package com.leetcode.array.medium;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {

	public static void main(String[] args) {
		System.out.println("-----------------Test case 1 ------------------------");
		int [][] intervals = {{1 ,3 } , {8 ,10} , {2 , 6} , {15 , 18}};
		
		int[][] mergedIntervals = merge(intervals);
		
		for (int [] a : mergedIntervals) {
			System.out.print("{ "+a[0]+" , "+a[1]+" } ");
		}
		
		
		System.out.println();

	}
	
	public static int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

}
