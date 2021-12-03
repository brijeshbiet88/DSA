package com.leetcode.stack.medium;

import java.util.Stack;

public class BasicCaliculator {

    public static void main(String[] args) {
        System.out.println("----------Test Case 1---------------");
        String s = "2 + 3 + 6 - 4";
        System.out.println("Result = "+calculate(s));
        System.out.println();

        System.out.println("----------Test Case 2---------------");
        s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println("Result = "+calculate(s));
        System.out.println();

        System.out.println("----------Test Case 3---------------");
        s = "(1+(4-6)-3)+(6+8)";
        System.out.println("Result = "+calculate(s));
        System.out.println();

        System.out.println("----------Test Case 4---------------");
        s = "-2 + 8 + 4";
        System.out.println("Result = "+calculate(s));
        System.out.println();

        System.out.println("----------Test Case 5---------------");
        s = "-2-(-4-6)";
        System.out.println("Result = "+calculate(s));
        System.out.println();

    }

    public static int calculate(String s) {
        int len = s.length();
        int sign = 1;
        int result = 0;
        int currNo = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                currNo = s.charAt(i) - '0';
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    currNo = currNo * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                currNo = currNo * sign;
                result += currNo;
                currNo = 0;
                sign = 1;
            } else if (s.charAt(i) == '+')
                sign = 1;
            else if (s.charAt(i) == '-')
                sign = -1;
            else if (s.charAt(i) == '(') {
                stack.push(result); // store the result calculated so far
                stack.push(sign); // store the upcoming sign
                result = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                int prevSign = stack.pop();
                result = prevSign* result ;
                int prevAns = stack.pop();
                result = result + prevAns;
            }

        }
        return result;
    }
}
