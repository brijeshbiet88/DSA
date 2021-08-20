package com.leetcode.backtracking.medium;

import java.util.*;

public class Subset2 {

    public static void main(String[] args) {
        System.out.println("----------------Test Case 1-----------------------");
        int [] nums = {1 , 2 , 2};
        List<List<Integer>> subsets = subsetsWithDup(nums);
        printResult(subsets);
        System.out.println();

        System.out.println("----------------Test Case 2-----------------------");
        int [] nums2 = {1 , 1};
        List<List<Integer>> subsets2 = subsetsWithDup2(nums2);
        printResult(subsets2);
        System.out.println();

    }

    private static void printResult(List<List<Integer>> subsets) {
        subsets.forEach(list->{
            System.out.println(list+" ");
        });
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> result = new HashSet();
        Arrays.sort(nums);
        subsets(nums , 0 , new ArrayList() , result);
        return new ArrayList<>(result);
    }

    private static void subsets(int[] nums, int start, List list, Set<List<Integer>> result) {
        if(start > nums.length) return;
        result.add(list);

        for (int i = start ; i < nums.length ; i++){
            List<Integer> newSubset = new ArrayList<>(list);
            newSubset.add(nums[i]);
            subsets(nums, i+1, newSubset, result);
        }

    }

    public static List<List<Integer>> subsetsWithDup2(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);
        subsets2(nums , 0 , new ArrayList() , result);
        return new ArrayList<>(result);
    }

    private static void subsets2(int[] nums, int start, List list, List<List<Integer>> result) {
        if(start > nums.length) return;
        result.add(list);

        for (int i = start ; i < nums.length ; i++){
            if(i > start && nums[i] == nums[i-1])
                continue;
            List<Integer> newSubset = new ArrayList<>(list);
            newSubset.add(nums[i]);
            subsets2(nums, i+1, newSubset, result);
        }

    }
}
