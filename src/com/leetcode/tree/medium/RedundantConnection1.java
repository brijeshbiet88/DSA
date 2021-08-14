package com.leetcode.tree.medium;

import java.util.*;

public class RedundantConnection1 {
    static Map<Integer , List<Integer>> graph = new HashMap();
    public static void main(String[] args) {
        int [][] edges = {{1 ,2} , {2 , 3} ,{3 , 4 },{1 , 4 },{1 , 5}};
        int [] edge = findRedundantConnection(edges);
        System.out.println("Edge = "+edge[0]+" , "+edge[1]);
        System.out.println();
        int [] edge2 = findRedundantConnection2(edges);
        System.out.println("Edge = "+edge2[0]+" , "+edge2[1]);
    }

    public static int[] findRedundantConnection2(int[][] edges) {
        int [] parent  = new int[edges.length+1];
        for (int [] edge : edges ){
            int u = edge[0];
            int v = edge[1];

            int parentU = findParent(u , parent);
            int parentV = findParent(v , parent);

            if(parentU == parentV)
                return edge;

            parent[parentV] = parentU;
        }
        return new int [0];
    }

    public static int findParent(int v , int [] parent){
        if(parent[v] == 0)
            parent[v] = v;

        if(parent[v] != v)
            parent[v] = findParent(parent[v], parent);

        return  parent[v];
    }

    public static int[] findRedundantConnection(int[][] edges) {
        for (int [] edge : edges ){
            int u = edge[0];
            int v = edge[1];

            if(dfs(u ,v , new HashSet<Integer>())){
                return edge;
            }

            List<Integer> list1 = graph.getOrDefault(u , new ArrayList<>());
            list1.add(v);
            graph.put(u , list1);

            List<Integer> list2 = graph.getOrDefault(v , new ArrayList<>());
            list2.add(u);
            graph.put(v , list2);

        }
        return new int [0];
    }

    private static boolean dfs(int source, int target, HashSet<Integer> visited) {
        if(visited.contains(source)){
            return false;
        }

        if(source == target){
            return  true;
        }

        visited.add(source);

        for(int i : graph.getOrDefault(source , new ArrayList<Integer>())){
            if(dfs(i, target, visited))
                return true;
        }

        return false;
    }
}
