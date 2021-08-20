package com.leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public static void main(String[] args) {
        System.out.println("---------------Test Case 1-----------------");
        int k = 3 , n = 9;
        List<List<Integer>> combinations = combinationSum3(k , n);
        printResult(combinations);
        System.out.println();

        System.out.println("---------------Test Case 2-----------------");
        k = 3 ;
        n = 7;
        List<List<Integer>> combinations2 = combinationSum3(k , n);
        printResult(combinations2);
        System.out.println();

        System.out.println("---------------Test Case 3-----------------");
        k = 3 ;
        n = 5;
        List<List<Integer>> combinations3 = combinationSum3(k , n);
        printResult(combinations3);
        System.out.println();

        System.out.println("---------------Test Case 4-----------------");
        k = 9 ;
        n = 45;
        List<List<Integer>> combinations4 = combinationSum3(k , n);
        printResult(combinations4);
        System.out.println();

        System.out.println("---------------Test Case 5-----------------");
        k = 2;
        n = 18;
        List<List<Integer>> combinations5 = combinationSum3(k , n);
        printResult(combinations5);
        System.out.println();
    }

    private static void printResult(List<List<Integer>> combinations) {
        System.out.println();
        combinations.forEach(list->{
            System.out.print(list+ " ");
        });
        System.out.println();
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> comb = new ArrayList<Integer>();
        if(k > n){
            return result;
        }
        backTrack(result , comb , n , k , 1);
        return result;
    }

    private static void backTrack(List<List<Integer>> result, List<Integer> comb, int target, int k , int start) {
        if(k < 0 || target < 0)
            return;

        if(k == 0 && target == 0){
            result.add(new ArrayList<>(comb));
            return;
        }

        for(int i = start ; i <= 9 ; i++){
            comb.add(i);
            backTrack(result , comb , target - i, k - 1 , i + 1);
            comb.remove(comb.size()-1);
        }

    }
}
