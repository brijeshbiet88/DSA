package com.leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.List;

public class Subset1 {
    public static void main(String[] args) {
        System.out.println("----------------Test Case 1-----------------------");
        int [] nums = {1 , 2 , 3};
        List<List<Integer>> subsets = subsets(nums);
        printResult(subsets);
        System.out.println();

    }

    private static void printResult(List<List<Integer>> subsets) {
        subsets.forEach(list->{
            System.out.println(list+" ");
        });
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        result.add(new ArrayList<Integer>());

        for(int i = 0 ; i < nums.length ; i++){
            int size = result.size();
            for(int j = 0 ; j < size ; j++){
                List<Integer> subset = new ArrayList<>(result.get(j));
                subset.add(nums[i]);
                result.add(subset);
            }

        }

        return result;
    }
}
