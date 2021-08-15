package com.leetcode.bfs.medium;

import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    public static void main(String[] args) {
        int [][] graph = {{1,3}, {0,2}, {1,3}, {0,2}};
        System.out.println("Is Graph Bipartite ? "+isBipartite(graph));
    }

    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int [] colors = new int [n];

        for (int i = 0 ; i < n ; i++){
            if(colors[i] == 1 || colors[i] == -1) continue;
            Queue<Integer> q = new LinkedList();
            q.add(i);
            colors[i] = 1;
            while (!q.isEmpty()){
                int current = q.poll();
                for(int next : graph[current]){
                    if(colors[next] == 0){
                        colors[next] = -colors[current];
                        q.add(next);
                    }

                    if(colors[next] == colors[current]) return false;
                }
            }

        }

        return true;
    }
}
