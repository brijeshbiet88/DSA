package com.leetcode.greedy;

import java.util.*;

public class MaxNoOfEventsCanBeAttended {
    public static void main(String[] args) {
        System.out.println("------------------Test Case 1---------------------");
        int [][] events = {};
        System.out.println("Max Events That Can be Attended = "+maxEvents(events));
        System.out.println();
    }

    public static int maxEvents(int[][] events) {
        if (events == null || events.length == 0) return 0;
        final int N = events.length;
        Arrays.sort(events, (e1, e2) -> Integer.compare(e1[0], e2[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0, day = 0, count = 0;
        while (i < N || !pq.isEmpty()) {
            if (pq.isEmpty()) {
                day = events[i][0];
            }
            while (i < N && day == events[i][0]) {
                pq.add(events[i][1]);
                i++;
            }
            pq.poll();
            count++;
            day++;
            while (!pq.isEmpty() && day > pq.peek()) {
                pq.poll();
            }
        }
        return count;
    }

}
