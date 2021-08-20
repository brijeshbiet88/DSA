package com.leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations1 {
    public static void main(String[] args) {
        System.out.println("---------------Test Case 1-----------------");
        int [] nums = {1,2,3};
        List<List<Integer>> permutations = permute(nums);
        printResult(permutations);
        System.out.println();
    }

    private static void printResult(List<List<Integer>> permutations) {
        permutations.forEach(list->{
            System.out.print(list+" ");
            System.out.println();
        });
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backTrack(result , nums , 0 , nums.length -1);
        return result;
    }

    private static void backTrack(List<List<Integer>> result, int[] nums, int start , int end) {

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
