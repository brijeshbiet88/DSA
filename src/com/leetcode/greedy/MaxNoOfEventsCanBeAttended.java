package com.leetcode.greedy;

import java.util.*;

public class MaxNoOfEventsCanBeAttended {
    public static void main(String[] args) {
        System.out.println("------------------Test Case 1---------------------");
        int [][] events = {{1,2},{2,3},{3,4}};
        System.out.println("Max Events That Can be Attended = "+maxEvents(events));
        System.out.println();

        System.out.println("------------------Test Case 2---------------------");
        int [][] events2 = {{1,2},{2,3},{3,4},{1,2}};
        System.out.println("Max Events That Can be Attended = "+maxEvents(events2));
        System.out.println();

        System.out.println("------------------Test Case 3---------------------");
        int [][] events3 = {{1,1},{1,1},{4,4},{2,2},{3,4},{1,4}};
        System.out.println("Max Events That Can be Attended = "+maxEvents(events3));
        System.out.println();

        System.out.println("------------------Test Case 4---------------------");
        int [][] events4 = {{1,100000}};
        System.out.println("Max Events That Can be Attended = "+maxEvents(events4));
        System.out.println();

        System.out.println("------------------Test Case 5---------------------");
        int [][] events5 = {{1,1},{1,2},{1,3},{1,4},{1,5},{1,6},{1,7}};
        System.out.println("Max Events That Can be Attended = "+maxEvents(events5));
        System.out.println();

    }

    public static int maxEvents(int[][] events) {
        Arrays.sort(events, (a,b) ->  {
            if(a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int j = 0;
        int attended = 0;

        // by fefault, from small to big
        // PriorityQueue contains last day
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 1; i <= 100000 ; i++) {
            //  remove from pq everything < currect day
            while(!pq.isEmpty() && pq.peek() < i)
                pq.poll();

            //  for all events started on day d, add the last day to queue
            while(j < events.length && events[j][0] == i) {
                pq.offer(events[j][1]);
                j++;
            }

            if(!pq.isEmpty()) {
                pq.poll();
                attended++;
            }
        }

        return attended;
    }

}
