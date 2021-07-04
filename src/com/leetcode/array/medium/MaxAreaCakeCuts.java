package com.leetcode.array.medium;

import java.util.Arrays;

public class MaxAreaCakeCuts {

	public static void main(String[] args) {
		System.out.println("-------------------Test Case 1-------------------");
		
		int h = 5, w = 4;
		int [] horizontalCuts = {1,2,4}, verticalCuts = {1,3};
		System.out.println("Piece of Cake With Max Area = "+maxArea(h, w, horizontalCuts, verticalCuts));
		System.out.println();
		
		System.out.println("-------------------Test Case 2-------------------");
		
		h = 5;
		w = 4;
		int [] horizontalCuts2 = {3 ,1}, verticalCuts2 = {1};
		System.out.println("Piece of Cake With Max Area = "+maxArea(h, w, horizontalCuts2, verticalCuts2));
		System.out.println();

	}

	public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
		Arrays.parallelSort(horizontalCuts);
		Arrays.parallelSort(verticalCuts);
		long maxH = horizontalCuts[0];
		for(int i = 1 ; i < horizontalCuts.length ; i++) {
			maxH = Math.max(maxH, horizontalCuts[i] - horizontalCuts[i-1]);
		}
		maxH = Math.max(maxH, h - horizontalCuts[horizontalCuts.length -1]);
		
		long maxV = verticalCuts[0];
		for(int i = 1 ; i < verticalCuts.length ; i++) {
			maxV = Math.max(maxV, verticalCuts[i] - verticalCuts[i-1]);
		}
		maxV = Math.max(maxV, w - verticalCuts[verticalCuts.length -1]);
		
		return (int) ((maxH * maxV) % 1000000007);

	}
	
}
