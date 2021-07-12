package com.leetcode.array.hard;

import java.util.Stack;

public class LargestRectangleHistogram {

	public static void main(String[] args) {
		int [] heights = {2,1,5,6,2,3};
		System.out.println("Largest Rectangle = "+largestRectangleArea(heights));
	}

	public static int largestRectangleArea(int[] heights) {
        
		if(heights == null) return 0;
		int maxArea = 0;
		int currentArea = 0;
		Stack<Integer> s = new Stack<Integer>();
		int i = 0;
		int len = heights.length ;
		while (i < len) {

			if (s.isEmpty() || heights[s.peek()] < heights[i]) {
				s.push(i++);
			} else {
				int top = s.pop();
				if(s.isEmpty())
				currentArea = heights[top] * i;
				else
				currentArea = heights[top] * (i - s.peek() - 1);
			}
			maxArea = Math.max(currentArea, maxArea);
		}
		
		while(!s.isEmpty()) {
			int top = s.pop();
			if(s.isEmpty())
				currentArea = heights[top] * i;
				else
				currentArea = heights[top] * (i - s.peek() - 1);
			maxArea = Math.max(currentArea, maxArea);
		}
		
		
		return maxArea;
	
    }

}
