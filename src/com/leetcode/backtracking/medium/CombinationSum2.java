package com.leetcode.backtracking.medium;

import java.util.*;

public class CombinationSum2 {
    public static void main(String[] args) {
        System.out.println("--------------Test Case 1-------------------");
        int [] candidates = {10 , 1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> combinations = combinationSum(candidates , target);
        printResult(combinations);
        System.out.println();

        System.out.println("--------------Test Case 2-------------------");
        int [] candidates2 = {2,5,2,1,2};
        target = 5;
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
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        List<Integer> currentList = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(result , candidates , target , 0, currentList);
        return new ArrayList<>(result);
    }

    private static void backTrack(Set<List<Integer>> result, int[] candidates, int target, int start,
                                  List<Integer> currentList) {
        if(target < 0){
            return;
        }

        if(target == 0){
            result.add(new ArrayList<>(currentList));
            return;
        }

        int prev = -1;
        for (int i = start ; i < candidates.length ; i++){
            if(candidates[i] == prev)
                continue;
            currentList.add(candidates[i]);
            backTrack(result , candidates , target - candidates[i] , i + 1 ,currentList);
            currentList.remove(currentList.size()-1);
            prev = candidates[i];
        }


    }
}
