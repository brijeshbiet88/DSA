package com.leetcode.array.medium;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		System.out.println("-----------------Test Case 1-----------------");
		int[] height = { 1,8,6,2,5,4,8,3,7 };
		System.out.println("Max Area : "+maxArea(height));
		System.out.println();
		
		System.out.println("-----------------Test Case 2-----------------");
		int[] height2 = { 1,2,1 };
		System.out.println("Max Area : "+maxArea(height2));
		System.out.println();

	}
	
	public static int maxArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}

		int i = 0, j = height.length - 1;

		int maxArea = 0;

		while (i < j) {
			maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
			if (height[i] < height[j]) {

				i++;
			} else {

				j--;
			}

		}
		return maxArea;

	}

	public static int maxArea2(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}

		int len = height.length;

		int maxArea = 0;
		int j = 1;
		for (int i = 0; i < len - 1; i++) {
			j = i + 1;

			while (j < len) {
				maxArea = Math.max(Math.min(height[i], height[j]) * (j - i), maxArea);
				j++;
			}
		}

		return maxArea;

	}

}
