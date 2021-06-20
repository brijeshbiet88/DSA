package com.leetcode.array;

public class MajorityElement {

	public static void main(String[] args) {
		System.out.println("--------------------Test Case 1 ------------------"); 
		int [] nums = {2,2,1,1,1,2,2} ;
		System.out.println("Majority Element : "+ majorityElement(nums));
		System.out.println();
		
		System.out.println("--------------------Test Case 1 ------------------"); 
		int [] nums2 = {1,2,1} ;
		System.out.println("Majority Element : "+ majorityElement(nums2));
		System.out.println();

	}
	
	public static int majorityElement(int[] nums) {
		int majorityElement = nums[0];
		int occurence = 1;

		for (int i = 1; i < nums.length; i++) {

			if(nums[i] == majorityElement) {
				occurence++;
			}
			else occurence --;
			
			if(occurence == 0) {
			  majorityElement = nums[i];
			  occurence = 1;
			}
			
		}
		return majorityElement;

	}

}
