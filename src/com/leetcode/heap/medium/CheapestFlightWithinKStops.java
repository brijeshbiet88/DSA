package com.leetcode.heap.medium;

import java.util.*;

public class CheapestFlightWithinKStops {
    public static void main(String[] args) {
        System.out.println("----------------------Test Case 1---------------------------");
        int n = 3;
        int [][] flights = {{0,1,100}, {1,2,100}, {0,2,500}};
        int src = 0, dst = 2, k = 1;
        System.out.println("Result = "+findCheapestPrice(n , flights , src , dst , k));
        System.out.println();
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int[] f : flights)
        {
            map.putIfAbsent(f[0],new ArrayList<>());
            map.get(f[0]).add(new int[]{f[1],f[2]});
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        q.offer(new int[]{src,0 ,k});
        while(!q.isEmpty())
        {
            int[] c=q.poll();
            int curr=c[0];
            int cost=c[1];
            int stop=c[2];
            if(curr==dst)
                return cost;
            if(stop >= 0)
            {
                if(!map.containsKey(curr))
                    continue;

                for(int[] next:map.get(curr)) {
                    q.add(new int[]{next[0], cost+next[1], stop-1});
                }
            }
        }
        return -1;
    }
}
