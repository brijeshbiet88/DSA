package com.leetcode.array.medium;

public class NextPermutation {

	public static void main(String[] args) {
		System.out.println("--------------Test Case 1 ----------------------");
		int [] nums = {1 , 2 ,3};
		nextPermutation(nums);
		System.out.println("Next Permutation ");
		for(int num : nums) {
			System.out.print(num+" ");
		}
		System.out.println();

		
		System.out.println("--------------Test Case 2 ----------------------");
		int [] nums2 = {3 , 2 ,1};
		nextPermutation(nums2);
		System.out.println("Next Permutation ");
		for(int num : nums2) {
			System.out.print(num+" ");
		}
		System.out.println();

		System.out.println("--------------Test Case 3 ----------------------");
		int [] nums3 = {3 , 2 ,1 , 0};
		nextPermutation(nums3);
		System.out.println("Next Permutation ");
		for(int num : nums3) {
			System.out.print(num+" ");
		}
		System.out.println();

	}

	 public static void nextPermutation(int[] nums) {
		 int i = nums.length - 2;
	        while (i >= 0 && nums[i + 1] <= nums[i]) {
	            i--;
	        }
	        if (i >= 0) {
	            int j = nums.length - 1;
	            while (nums[j] <= nums[i]) {
	                j--;
	            }
	            swap(nums, i, j);
	        }
	        reverse(nums, i + 1);
	    }
	 
	 private static void reverse(int[] nums, int start) {
	        int i = start, j = nums.length - 1;
	        while (i < j) {
	            swap(nums, i, j);
	            i++;
	            j--;
	        }
	    }

	    private static void swap(int[] nums, int i, int j) {
	        int temp = nums[i];
	        nums[i] = nums[j];
	        nums[j] = temp;
	    }
}
