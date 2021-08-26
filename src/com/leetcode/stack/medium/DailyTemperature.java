package com.leetcode.stack.medium;

import java.util.Stack;

public class DailyTemperature {
    public static void main(String[] args) {
        System.out.println("-------------------Test Case 1---------------------");
        int [] temperatures = {73,74,75,71,69,72,76,73};
        int [] result = dailyTemperatures(temperatures);
        System.out.println("Print Result ");
        for(int days : result)
            System.out.print(days+" ");
        System.out.println();

        System.out.println("-------------------Test Case 2---------------------");
        int [] temperatures2 = {30,40,50,50 ,60};
        int [] result2 = dailyTemperatures(temperatures2);
        System.out.println("Print Result ");
        for(int days : result2)
            System.out.print(days+" ");
        System.out.println();

        System.out.println("-------------------Test Case 3---------------------");
        int [] temperatures3 = {30,29,28,27,26,35};
        int [] result3 = dailyTemperatures(temperatures3);
        System.out.println("Print Result ");
        for(int days : result3)
            System.out.print(days+" ");
        System.out.println();
        
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] result = new int[len];

        Stack<Integer> stack = new Stack<>();// Store Index of each day

        for(int i = 0; i < len; i++) {

            while(!stack.isEmpty() &&
                    temperatures[stack.peek()] < temperatures[i] ) {

                result[stack.peek()] = i - stack.pop();
            }

            stack.push(i);
        }

        return result;
    }
}
