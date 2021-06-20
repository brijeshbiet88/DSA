package com.leetcode.array;

public class DuplicateRemovalSortedArray {

	public static void main(String[] args) {
	  int [] nums = {1 , 2 , 3 , 3 , 3 , 4 , 4 , 5 , 6 , 6 , 7 , 8 ,9 , 9};
	  int index = removeDuplicates(nums);		  
	  System.out.println("Array Elements After Duplicates Removal");
	  for(int i = 0 ; i < index ; i++) {
		  System.out.print(nums[i]+" ");
	  }
	  
	  
	}
	public static int removeDuplicates(int[] nums) {
	    if (nums.length == 0) return 0;
	    int i = 0;
	    for (int j = 1; j < nums.length; j++) {
	        if (nums[j] != nums[i]) {
	            i++;
	            nums[i] = nums[j];
	        }
	    }
	    return i + 1;
	}

}
