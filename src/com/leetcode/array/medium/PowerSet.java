package com.leetcode.array.medium;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
	
	static List<List<Integer>> result = new ArrayList<List<Integer>>();
	static List<List<Integer>> result2 = new ArrayList<List<Integer>>();

	public static void main(String[] args) {
		System.out.println("----------------------Test Case 1 ------------------------");
		int [] nums = {1 , 2, 3};
		subsets(nums);
		
		result.forEach((list)->{
			list.forEach((num) ->{
				System.out.print(num+" ");
			});
			System.out.println();
		});
		
		System.out.println();
		
		System.out.println("----------------------Test Case 2 ------------------------");
		int [] nums2 = {1 , 2, 3 , 4};
		List<List<Integer>> output = subsets2(nums2);
		
		output.forEach((list)->{
			list.forEach((num) ->{
				System.out.print(num+" ");
			});
			System.out.println();
		});
		
		System.out.println();
		
		System.out.println("----------------------Test Case 3 ------------------------");
		char [] str = {'a' , 'b' , 'c'};
		List<List<Character>> output2 = subsets3(str);
		
		output2.forEach((list)->{
			list.forEach((num) ->{
				System.out.print(num+" ");
			});
			System.out.println();
		});
		
		System.out.println();
		System.out.println("----------------------Test Case 4 ------------------------");
		String [] strArr = {"n1" , "n2" , "n3" , "n4"};
		List<List<String>> output3 = subsets4(strArr);
		
		output3.forEach((list)->{
			list.forEach((num) ->{
				System.out.print(num+" ");
			});
			System.out.println();
		});
		
		System.out.println();

	}

	public static List<List<Integer>> subsets(int[] nums) {
		if(nums.length == 0) return result;
		
		bt(0 , new ArrayList<Integer>() , nums);
		return result;
	}

	private static void bt(int start, ArrayList<Integer> current, int[] nums) {
		result.add(new ArrayList<Integer>(current));
		
		for(int i = start ; i < nums.length ; i++) {
			current.add(nums[i]);
			bt(i + 1, current, nums);
			current.remove(current.size()-1);
		}
		
	}
	
	public static List<List<Integer>> subsets2(int[] nums) {
		List<List<Integer>> output = new ArrayList();
		output.add(new ArrayList<Integer>());

		for (int num : nums) {
			List<List<Integer>> newSubsets = new ArrayList();
			for (List<Integer> curr : output) {
				
				List<Integer> newList = new ArrayList<Integer>(curr);
				newList.add(num);
				newSubsets.add(newList);
				
			}
			for (List<Integer> curr : newSubsets) {
				output.add(curr);
			}
		}
		return output;
	}
	
	public static List<List<Character>> subsets3(char[] nums) {
		List<List<Character>> output = new ArrayList();
		output.add(new ArrayList<Character>());

		for (char num : nums) {
			List<List<Character>> newSubsets = new ArrayList();
			for (List<Character> curr : output) {
				
				List<Character> newList = new ArrayList<Character>(curr);
				newList.add(num);
				newSubsets.add(newList);
				
			}
			for (List<Character> curr : newSubsets) {
				output.add(curr);
			}
		}
		return output;
	}
	
	public static List<List<String>> subsets4(String[] nums) {
		List<List<String>> output = new ArrayList();
		output.add(new ArrayList<String>());

		for (String num : nums) {
			List<List<String>> newSubsets = new ArrayList();
			for (List<String> curr : output) {
				
				List<String> newList = new ArrayList<String>(curr);
				newList.add(num);
				newSubsets.add(newList);
				
			}
			for (List<String> curr : newSubsets) {
				output.add(curr);
			}
		}
		return output;
	}
	
	
}
