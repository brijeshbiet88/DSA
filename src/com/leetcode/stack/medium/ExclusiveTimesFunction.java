package com.leetcode.stack.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ExclusiveTimesFunction {
    public static void main(String[] args) {
        System.out.println("----------------Test Case 1-------------------");
        int n = 2;
        List<String> logs = new ArrayList<>();
        logs.addAll(Arrays.asList("0:start:0","1:start:2","1:end:5","0:end:6"));
        int [] res = exclusiveTime(n , logs);
        System.out.println("Print Result : ");
        for (int f : res)
            System.out.print(f+" ");
        System.out.println();

        System.out.println("----------------Test Case 2-------------------");
        n = 1;
        List<String> logs2 = new ArrayList<>();
        logs2.addAll(Arrays.asList("0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"));
        int [] res2 = exclusiveTime(n , logs2);
        System.out.println("Print Result : ");
        for (int f : res2)
            System.out.print(f+" ");
        System.out.println();

        System.out.println("----------------Test Case 3-------------------");
        n = 2;
        List<String> logs3 = new ArrayList<>();
        logs3.addAll(Arrays.asList("0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7"));
        int [] res3 = exclusiveTime(n , logs3);
        System.out.println("Print Result : ");
        for (int f : res3)
            System.out.print(f+" ");
        System.out.println();
    }

    public static int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> jobs = new Stack<Integer>();
        Stack<Integer> times = new Stack<Integer>();
        for (String log:logs) {
            String[] tokens = log.split(":");
            int id = Integer.parseInt(tokens[0]);
            String op = tokens[1];
            int timestamp = Integer.parseInt(tokens[2]);
            if (op.equals("start")) {
                if (!jobs.isEmpty()) {
                    int spent = timestamp - times.peek();
                    res[jobs.peek()] += spent;
                }
                jobs.push(id);
                times.push(timestamp);
            }
            else {
                int spent = timestamp - times.peek() + 1;
                res[id] += spent;
                jobs.pop();
                times.pop();
                if (!times.isEmpty()) {
                    times.pop();
                    times.push(timestamp + 1);
                }
            }
        }
        return res;
    }
}
