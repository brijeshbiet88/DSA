package com.leetcode.stack.easy;

import java.util.Stack;

public class RemoveAdjacentDupsFromStack {
    public static void main(String[] args) {
        System.out.println("------------------Test Case 1------------------------");
        String s = "azxxzy";
        System.out.println("Removing Adjacent Duplicate Chars From String "+s +" = "+removeDuplicates(s));
        System.out.println();

        System.out.println("------------------Test Case 2------------------------");
        s = "abbaca";
        System.out.println("Removing Adjacent Duplicate Chars From String "+s +" = "+removeDuplicates(s));
        System.out.println();

    }

    public static String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<Character>();
        stack.push(S.charAt(0));
        int i = 1;
        int n = S.length();
        while (i < n) {

            if(!stack.isEmpty() && stack.peek() == S.charAt(i)) {
                stack.pop();
                i++;
            }else{
                stack.push(S.charAt(i++));
            }

        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
