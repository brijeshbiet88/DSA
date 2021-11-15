package com.leetcode.miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        System.out.println("----------------Test Case 1----------------");
        int [][] intervals1 = {{1,3},{2,6},{8,10},{15,18}};
        int [][] merged1 = merge(intervals1);
        System.out.println("Print Merged Intervals : ");
        for (int [] pair : merged1){
            System.out.println(pair[0]+" "+pair[1]);
        }
        System.out.println();

        System.out.println("----------------Test Case 2----------------");
        int [][] intervals2 = {{1,3}};
        int [][] merged2 = merge(intervals2);
        System.out.println("Print Merged Intervals : ");
        for (int [] pair : merged2){
            System.out.println(pair[0]+" "+pair[1]);
        }
        System.out.println();

        System.out.println("----------------Test Case 3----------------");
        int [][] intervals3 = {{2,3},{1,5}};
        int [][] merged3 = merge(intervals3);
        System.out.println("Print Merged Intervals : ");
        for (int [] pair : merged3){
            System.out.println(pair[0]+" "+pair[1]);
        }
        System.out.println();
    }
    public static int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList();
        if(intervals.length <= 1)
            return intervals;
        Arrays.sort(intervals , (a, b) -> a[0] - b[0]);
        int i = 1;
        int [] in = intervals[0];
        while (i < intervals.length){
            if(in[1] < intervals[i][0]){
                result.add(in);
                in = intervals[i];
            }else{
                in[1] = Math.max(in[1],intervals[i][1]);
            }
            i++;
        }
        result.add(in);
        return result.toArray(new int[result.size()][]);
    }
}
