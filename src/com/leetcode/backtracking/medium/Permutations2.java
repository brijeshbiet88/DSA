package com.leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations2 {
    public static void main(String[] args) {
        System.out.println("---------------Test Case 1-----------------");
        int [] nums = {1,2,2};
        List<List<Integer>> permutations = permuteUnique(nums);
        printResult(permutations);
        System.out.println();
    }

    private static void printResult(List<List<Integer>> permutations) {
        permutations.forEach(list->{
            System.out.print(list+" ");
            System.out.println();
        });
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        backTrack(result , nums , 0 , nums.length -1);
        return new ArrayList<>(result);
    }

    private static void backTrack(Set<List<Integer>> result, int[] nums, int start , int end) {

        if(start >= nums.length)
            return;
        if(start == end){
            ArrayList<Integer> list = new ArrayList<>();
            for(int num : nums)
                list.add(num);
            result.add(list);
            return;
        }

        for(int i = start ; i < nums.length ; i++){
            swap(nums , i , start);
            backTrack(result, nums, start+1 ,end);
            swap(nums , i , start);
        }

    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
