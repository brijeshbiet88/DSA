package com.leetcode.array;

public class SquaresOfSortedArray {

	public static void main(String[] args) {
		System.out.println("------------------Test Case 1 --------------------");
		int [] nums = {-4,-1,0,3,10};
		int [] arr = sortedSquares(nums);
		System.out.println("Print Each Element");
		
		for(int num : arr) {
			System.out.print(num+" ");
		}
		
		System.out.println();

		System.out.println("------------------Test Case 2 --------------------");
		int [] nums2 = {-7,-3,2,3,11};
		int [] arr2 = sortedSquares(nums2);
		System.out.println("Print Each Element");
		
		for(int num : arr2) {
			System.out.print(num+" ");
		}
		
		System.out.println();
		
	}

	
	public static int[] sortedSquares(int[] nums) {

		int start = 0, last = nums.length - 1;

		int[] result = new int[nums.length];

		int index = last;
		while (start <= last) {

			if (nums[start] * nums[start] < nums[last] * nums[last]) {

				result[index--] = nums[last] * nums[last];
				last--;

			} else {
				result[index--] = nums[start] * nums[start];
				start++;
			}

		}
		return result;

	}
}
