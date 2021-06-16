package com.leetcode.recanddp;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		
		int[] candidates = { 2, 3, 6, 7 };
		int target = 7;

		List<List<Integer>> combinations = combinationSum(candidates, target);

		for (int i = 0; i < combinations.size(); i++) {
			List<Integer> combination = combinations.get(i);
			combination.forEach((s) -> System.out.print(s + " "));
			System.out.println();
		}
		;

	}

	
	 public static List<List<Integer>> combinationSum(int[] candidates, int target) {
	 
		 List<Integer> list = new ArrayList<Integer>();
		 List<List<Integer>> combinations = new ArrayList<List<Integer>>();
		 backtrack(candidates , 0 ,target , list , combinations);
		 
		 return combinations;
		 
	 }


	private static void backtrack(int[] candidates, int start, int target,
			List<Integer> list, List<List<Integer>> combinations ) {
		
		if(target < 0) {
			return ;
		}
		
		else if(target == 0) {
			combinations.add(new ArrayList<Integer>(list)); 
		}
		
		for(int i = start ; i < candidates.length ; i++) {
			list.add(candidates[i]);
			backtrack(candidates , i , target - candidates[i] , list , combinations);
			list.remove(list.size()-1);
			
		}
		
		
	}
}
