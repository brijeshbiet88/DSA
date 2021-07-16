package com.leetcode.dp.medium;

public class MaxLenRepeatedSubArray {

	public static void main(String[] args) {
		System.out.println("---------------Test Case 1---------------------");
		int [] nums1 = {1,2,3,2,1}, nums2 = {3,2,1,4,7} ;
		System.out.println("Len of Max Sub Array = "+ findLength(nums1, nums2));
		System.out.println();
		
		System.out.println("---------------Test Case 2---------------------");
		int [] nums3 = {0,1,1,1,1} , nums4 = {1,0,1,0,1};
		System.out.println("Len of Max Sub Array = "+ findLength(nums3, nums4));
		System.out.println();
	}
	
	public static int findLength(int[] nums1, int[] nums2) {
        int len1 = nums1.length , len2 = nums2.length;
		int [][] dp = new int [len1 +1 ][len2 + 1];
        int result = 0;
        for(int i = 0; i < len1 ; i++ ) {
        	for(int j = 0 ; j < len2 ; j++) {
        		
        		if(nums1[i] == nums2[j]) {
        			dp[i+1][j+1] = dp[i][j] + 1;
        		}
        		result = Math.max(result, dp[i+1][j+1]);
        		
        	}
        }
        
        return result;
    }

}
