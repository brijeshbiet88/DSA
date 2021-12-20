package com.leetcode.miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDiff {
    public static void main(String[] args) {
        MinimumAbsoluteDiff minimumAbsoluteDiff = new MinimumAbsoluteDiff();
        System.out.println("------------------Test Case 1-------------------");
        int [] arr1 = {4 , 3 , 1 , 2};
        List<List<Integer>> result1 = minimumAbsoluteDiff.minimumAbsDifference(arr1);
        result1.forEach(pair-> System.out.println(pair.get(0)+" , "+pair.get(1)));
        System.out.println();

        System.out.println("------------------Test Case 2-------------------");
        int [] arr2 = {6 , 3 , 1 , 10 , 15};
        List<List<Integer>> result2 = minimumAbsoluteDiff.minimumAbsDifference(arr2);
        result2.forEach(pair-> System.out.println(pair.get(0)+" , "+pair.get(1)));
        System.out.println();
    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList();

        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for(int i = 0 ; i < arr.length -1 ; i++){
            minDiff = Math.min(minDiff , arr[i+1] - arr[i]);
        }

        for(int i = 0 ; i < arr.length -1 ; i++){
            if(arr[i+1] - arr[i] == minDiff){
                List<Integer> pair = new ArrayList();
                pair.add(arr[i]);
                pair.add(arr[i+1]);
                result.add(pair);
            }
        }

        return result;
    }
}
