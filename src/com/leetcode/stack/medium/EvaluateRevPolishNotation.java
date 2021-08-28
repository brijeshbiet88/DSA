package com.leetcode.stack.medium;

import java.util.Stack;

public class EvaluateRevPolishNotation {
    public static void main(String[] args) {
        System.out.println("------------- Test case 1-----------------");
        String [] tokens = {"2","1","+","3","*"};
        System.out.println("Result = "+evalRPN(tokens));
        System.out.println();

        System.out.println("------------- Test case 2-----------------");
        String [] tokens2 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println("Result = "+evalRPN(tokens2));
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
