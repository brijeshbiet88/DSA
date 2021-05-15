package com.leetcode.array;

public class SearchInsertPosition {

	public static void main(String[] args) {
		int [] nums = {1,3,5,6};
		int target = 5;
		System.out.println("Insert Position : "+searchInsert(nums, target));

	}

	public static int searchInsert(int[] nums, int target) {
		int l = 0 , r = nums.length -1;
		
		while(l <= r) {
			int mid = l + (r-l)/2;
			if(nums[mid] == target) {
				return mid;
			}
			else if(nums[mid] > target) {
				r--;
			}else {
				l++;
			}
			
		}
		
		return l;
		
	}

}
