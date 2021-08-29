package com.leetcode.graph.medium;

import java.util.*;

public class NetworkDelayTime {
    public static void main(String[] args) {
        System.out.println("-----------------Test Case 1-------------------");
        int [][] times = {{2,1,1} , {2,3,1} , {3,4,3} , {1,4,2}};
        int n = 4;
        int k = 2;

        System.out.println("Network Delay = "+networkDelayTime(times , n , k));
        System.out.println();

        System.out.println("-----------------Test Case 2-------------------");
        int [][] times2 = {{2,1,1} , {2,3,1} , {3,4,5} , {1,4,3}};

        System.out.println("Network Delay = "+networkDelayTime(times2 , n , k));
        System.out.println();
    }

    static Map<Integer, Integer> dist;
    public static int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap();
        for (int[] edge: times) {
            if (!graph.containsKey(edge[0]))
                graph.put(edge[0], new ArrayList<int[]>());
            graph.get(edge[0]).add(new int[]{edge[2], edge[1]});
        }
        for (int node: graph.keySet()) {
            Collections.sort(graph.get(node), (a, b) -> a[0] - b[0]);
        }
        dist = new HashMap();
        for (int node = 1; node <= N; ++node)
            dist.put(node, Integer.MAX_VALUE);

        dfs(graph, K, 0);
        int ans = 0;
        for (int cand: dist.values()) {
            if (cand == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, cand);
        }
        return ans;
    }

    public static void dfs(Map<Integer, List<int[]>> graph, int node, int elapsed) {
        if (elapsed >= dist.get(node)) return;
        dist.put(node, elapsed);
        if (graph.containsKey(node))
            for (int[] info: graph.get(node))
                dfs(graph, info[1], elapsed + info[0]);
    }

    private static Map<Integer, List<Node>> constructGraph(int[][] times , int n) {
        Map<Integer , List<Node>> graph = new HashMap<>();
        for (int i = 0 ; i < times.length ; i++){
            int source = times[i][0];
            graph.putIfAbsent(source , new ArrayList<>());
            graph.get(source).add(new Node(times[i][1] , times[i][2]));
        }

        return graph;
    }

    static class Node {
        Integer key;
        Integer value;

        public Node(Integer key , Integer value){
            this.key = key;
            this.value = value;
        }
    }



    static Map<Integer, Integer> dist2;
    public static int networkDelayTime2(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap();
        for (int[] edge: times) {
            if (!graph.containsKey(edge[0]))
                graph.put(edge[0], new ArrayList<int[]>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        dist2 = new HashMap();
        for (int node = 1; node <= N; ++node)
            dist2.put(node, Integer.MAX_VALUE);

        dist2.put(K, 0);
        boolean[] seen = new boolean[N+1];

        while (true) {
            int candNode = -1;
            int candDist = Integer.MAX_VALUE;
            for (int i = 1; i <= N; ++i) {
                if (!seen[i] && dist2.get(i) < candDist) {
                    candDist = dist2.get(i);
                    candNode = i;
                }
            }

            if (candNode < 0) break;
            seen[candNode] = true;
            if (graph.containsKey(candNode))
                for (int[] info: graph.get(candNode))
                    dist2.put(info[0],
                            Math.min(dist2.get(info[0]), dist2.get(candNode) + info[1]));
        }

        int ans = 0;
        for (int cand: dist2.values()) {
            if (cand == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, cand);
        }
        return ans;
    }
}
