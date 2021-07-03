package com.leetcode.array.medium;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInArray {

	public static void main(String[] args) {
		System.out.println("------------Test Case 1 ----------------");
		int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
		List <Integer> duplicates = findDuplicates(nums);
		System.out.println("Print All Duplicates : ");
		duplicates.forEach((n)->{
			System.out.print(n+" ");
		});
		
		System.out.println();
		
		System.out.println("------------Test Case 2-----------------");
		int[] nums2 = { 1 , 1 , 2 };
		List <Integer> duplicates2 = findDuplicates(nums2);
		System.out.println("Print All Duplicates : ");
		duplicates2.forEach((n)->{
			System.out.print(n+" ");
		});
		
		System.out.println();

	}

	public static List<Integer> findDuplicates(int[] nums) {
		List<Integer> dupliactes = new ArrayList<Integer>();

		int n = nums.length;

		for (int i = 0; i < n; i++) {
			nums[i] = nums[i] - 1;
		}
		int pos = 0;
		for (int i = 0; i < n; i++) {
			pos = nums[i] % n;
			nums[pos] = nums[pos] + n;
		}

		for (int i = 0; i < n; i++) {
			nums[i] = nums[i] / n;
		}

		for (int i = 0; i < n; i++) {
			if (nums[i] > 1)
				dupliactes.add(i + 1);
		}

		return dupliactes;
	}
	
	public List<Integer> findDuplicates2(int[] nums) {
	      
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0 ; i < nums.length ; i++) {
			int num = Math.abs(nums[i]);
			if(nums[num-1] < 0) {
				list.add(Math.abs(nums[i]));
			}else {
				nums[num-1] = 0 - nums[num-1];
			}
		}
		return list;
        
    
    }

}
