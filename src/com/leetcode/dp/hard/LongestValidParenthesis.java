package com.leetcode.dp.hard;

import java.util.Stack;

public class LongestValidParenthesis {

	public static void main(String[] args) {
		System.out.println("--------------Test Case 1------------------");
		String s = ")()())";
		System.out.println("Longest Valid Parenthesis in "+s+" is = "+longestValidParentheses(s));
		System.out.println();
		
		System.out.println("--------------Test Case 2------------------");
		s = ")()())()";
		System.out.println("Longest Valid Parenthesis in "+s+" is = "+longestValidParentheses(s));
		System.out.println();
		
		System.out.println("--------------Test Case 3------------------");
		s = ")))(())()";
		System.out.println("Longest Valid Parenthesis in "+s+" is = "+longestValidParentheses2(s));
		System.out.println();

	}
	
	 public static int longestValidParentheses(String s) {
		 int left = 0, right = 0, maxlength = 0;
	        for (int i = 0; i < s.length(); i++) {
	            if (s.charAt(i) == '(') {
	                left++;
	            } else {
	                right++;
	            }
	            if (left == right) {
	                maxlength = Math.max(maxlength, 2 * left);
	            } else if (right >= left) {
	                left = right = 0;
	            }
	        }
	        left = right = 0;
	        for (int i = s.length() - 1; i >= 0; i--) {
	            if (s.charAt(i) == '(') {
	                left++;
	            } else {
	                right++;
	            }
	            if (left == right) {
	                maxlength = Math.max(maxlength, 2 * right);
	            } else if (left >= right) {
	                left = right = 0;
	            }
	        }
	        return maxlength;
	        
	  }
	 
	 
	 public static int longestValidParentheses2(String s) {
		        int maxans = 0;
		        Stack<Integer> stack = new Stack<>();
		        stack.push(-1);
		        for (int i = 0; i < s.length(); i++) {
		            if (s.charAt(i) == '(') {
		                stack.push(i);
		            } else {
		                stack.pop();
		                if (stack.empty()) {
		                    stack.push(i);
		                } else {
		                    maxans = Math.max(maxans, i - stack.peek());
		                }
		            }
		        }
		        return maxans;
		    }
	        

}
