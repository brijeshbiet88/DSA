package com.leetcode.dp.hard;

public class TrappingRainWater {

	public static void main(String[] args) {
		int [] height = {4,2,0,3,2,5};
		System.out.println("Water Trapped = "+ trap(height));

	}
	
	 public static int trap(int[] height) {
	       
			if(height == null || height.length == 0) {
				return 0;
			}
			int len = height.length;
			int result = 0;

			int[] rightMax = new int[len];
			int[] leftMax = new int[len];

			rightMax[len - 1] = 0;
			leftMax[0] = 0;
	        int max = 0;
			for (int i = 1; i < len; i++){
				max = Math.max(max, height[i-1]);
				leftMax[i]= max;
	         
			}

			max = 0;
			for (int i = len-2; i >= 0; i--){
				max = Math.max(max, height[i+1]);
				rightMax[i]= max;
	         
			}
			
			int minHeight = 0;
			for (int i = 1; i < len-1; i++){
				minHeight = Math.min(leftMax[i], rightMax[i]);
				if(minHeight-height[i] > 0)
				result += minHeight - height[i];
			}
			
			return result;
		
	    }

}
