package com.leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum1 {
    public static void main(String[] args) {
        System.out.println("--------------Test Case 1-------------------");
        int [] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> combinations = combinationSum(candidates , target);
        printResult(combinations);
        System.out.println();

        System.out.println("--------------Test Case 2-------------------");
        int [] candidates2 = {2,3,5};
        target = 8;
        List<List<Integer>> combinations2 = combinationSum(candidates2 , target);
        printResult(combinations2);
        System.out.println();
    }

    private static void printResult(List<List<Integer>> combinations) {
        System.out.println();
        combinations.forEach(list->{
            System.out.print(list+ " ");
        });
        System.out.println();
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> currentList = new ArrayList<>();
        backTrack(result , candidates , target , 0 , 0, currentList);
        return result;
    }

    private static void backTrack(List<List<Integer>> result, int[] candidates, int target, int sum , int start, List<Integer> currentList) {
        if(sum  > target){
            return;
        }
        if(sum == target){
            result.add(new ArrayList<>(currentList));

            return;
        }
        for (int i = start ; i < candidates.length ; i++){
            sum += candidates[i];
            currentList.add(candidates[i]);
            backTrack(result , candidates , target , sum , start , currentList);
            currentList.remove(currentList.size() - 1);
            sum -= candidates[i];
            start = start + 1;
        }
        return;
    }
}
