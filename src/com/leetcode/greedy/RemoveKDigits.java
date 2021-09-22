package com.leetcode.greedy;

import java.util.Stack;

public class RemoveKDigits {
    public static void main(String[] args) {
        System.out.println("--------------Test Case 1--------------------");
        String num =  "1432219";
        int k = 3;
        System.out.println("Result = "+removeKdigits(num , k));
        System.out.println();

    }

    public static String removeKdigits(String num, int k) {
        int n = num.length();
        Stack<Character> s = new Stack<>();

        for (char c : num.toCharArray()){

            while (!s.empty() && k > 0 && s.peek() > c){
                s.pop();
                k--;
            }

            if(!s.isEmpty() || c != '0')
                s.push(c);

        }

        while (!s.isEmpty() && k-- > 0){
            s.pop();
        }
        if(s.isEmpty()) return "0";
        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()){
            sb.append(s.pop());
        }

        return sb.reverse().toString();
    }
}
