package com.leetcode.graph.medium;

import java.util.*;

public class MinHeightTrees {
    public static void main(String[] args) {
        MinHeightTrees mht = new MinHeightTrees();
        System.out.println("------------Test Case 1---------------");
        int n = 6;
        int [][] edges1 = {{3,0},{3,1},{3,2},{3,4},{5,4}};
        List<Integer> result1 = mht.findMinHeightTrees(n , edges1);
        System.out.println("Print Result ");
        result1.forEach(node-> System.out.print(node+" "));
        System.out.println();

        System.out.println("------------Test Case 2---------------");
        n = 4;
        int [][] edges2 = {{1,0},{1,2},{1,3}};
        List<Integer> result2 = mht.findMinHeightTrees(n , edges2);
        System.out.println("Print Result ");
        result2.forEach(node-> System.out.print(node+" "));
        System.out.println();
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        List<Integer> result = new ArrayList<>();
        if (n <= 0) return result;
        if (n == 1) {
            result.add(0);
            return result;
        }

        Map<Integer, Set<Integer>> graph = new HashMap<>();

        int[] degree = new int[n];

        for(int[] edge: edges){

            degree[edge[0]]++;
            degree[edge[1]]++;
            graph.putIfAbsent(edge[0], new HashSet<>());
            graph.get(edge[0]).add(edge[1]);
            graph.putIfAbsent(edge[1], new HashSet<>());
            graph.get(edge[1]).add(edge[0]);

        }

        Queue<Integer> leaves = new LinkedList<>();


        for(int i = 0; i < n; i++){

            if(degree[i] != 1)
                continue;
            leaves.offer(i);
        }

        int nodeCount = n;
        while(nodeCount > 2){

            int size = leaves.size();
            nodeCount = nodeCount-size;
            while(size-- > 0){
                int leaf = leaves.poll();
                for(int adjNode : graph.get(leaf)){
                    degree[adjNode]--;
                    if(degree[adjNode] == 1){
                        leaves.offer(adjNode);
                    }
                }

            }

        }
        return new ArrayList<>(leaves);
    }
}
