package com.leetcode.stackqueue;

import java.util.Stack;

public class EvalateReversePolishNotation {

	public static void main(String[] args) {
		System.out.println("--------------------Test Case 1----------------------");
		String[] tokens = { "2", "1", "+", "3", "*" };
		System.out.println("Expression Evaluation = " + evalRPN(tokens));
		System.out.println();
		
		System.out.println("--------------------Test Case 2----------------------");
		String[] tokens2 = { "4","13","5","/","+" };
		System.out.println("Expression Evaluation = " + evalRPN(tokens2));
		System.out.println();
		
		System.out.println("--------------------Test Case 3----------------------");
		String[] tokens3 = { "10","6","9","3","+","-11","*","/","*","17","+","5","+" };
		System.out.println("Expression Evaluation = " + evalRPN(tokens3));
		System.out.println();
	}

	public static int evalRPN(String[] tokens) {
		Stack<String> stack = new Stack<String>();
		int result = 0;
		for (String token : tokens) {
			if ("+-*/".contains(token)) {
				int a = Integer.parseInt(stack.pop());
				int b = Integer.parseInt(stack.pop());
				stack.push(String.valueOf(evaluate(b, a, token)));
			} else {
				stack.push(token);
			}

		}

		result = Integer.parseInt(stack.pop());

		return result;

	}

	private static int evaluate(int a, int b, String operator) {

		if ("+".equals(operator)) {
			return a + b;
		}

		if ("*".equals(operator)) {
			return a * b;
		}

		if ("-".equals(operator)) {
			return a - b;
		}

		else
			return a / b;

	}
}
