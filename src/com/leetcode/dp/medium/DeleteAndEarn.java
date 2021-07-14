package com.leetcode.dp.medium;

public class DeleteAndEarn {

	public static void main(String[] args) {
		System.out.println("-----------------Test Case 1-------------------");
		int [] nums = {2 , 2 , 3 , 3, 3 ,4};
		System.out.println("Max Score = "+deleteAndEarn2(nums));
		System.out.println();
	}

	public static int deleteAndEarn(int[] nums) {
		 int[] count = new int[10001];
	        for (int x: nums) count[x]++;
	        int avoid = 0, using = 0, prev = -1;

	        for (int k = 0; k <= 10000; ++k) if (count[k] > 0) {
	            int m = Math.max(avoid, using);
	            if (k - 1 != prev) {
	                using = k * count[k] + m;
	                avoid = m;
	            } else {
	                using = k * count[k] + avoid;
	                avoid = m;
	            }
	            prev = k;
	        }
	        return Math.max(avoid, using);
	}
	
	public static int deleteAndEarn2(int[] nums) {
			if(nums.length == 0) return 0;
			
			if(nums.length == 1) return nums[0];
			
			int [] count = new int[10001];
	        int [] sum = new int [10001];
	        
	        int maxValue = 0;
	        for(int num : nums) {
	        	count[num]++;
	        	if(num > maxValue)
	        		maxValue = num;
	        }
	        
	        sum[0] = count[0];
	        sum[1] = count[1];
	        
	        for(int i = 2 ; i <= maxValue ; i++) {
	        	sum[i] = Math.max(sum[i-2] + count[i]*i, sum[i-1]);
	        }
	        
			return sum[maxValue];
	}
}
