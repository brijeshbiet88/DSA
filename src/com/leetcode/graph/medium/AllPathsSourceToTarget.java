package com.leetcode.graph.medium;

import java.util.*;

public class AllPathsSourceToTarget {
    public static void main(String[] args) {
        System.out.println("---------------Test Case 1-------------------");
        int [][] graph = {{1,2},{3},{3},{}};
        List<List<Integer>> result = allPathsSourceTarget(graph);
        System.out.println("Print All Paths Source To Target : ");
        result.forEach(path->{
            System.out.println();
            path.forEach(node-> System.out.print(node+" "));
        }

        );
        System.out.println();
        System.out.println("---------------Test Case 2-------------------");
        int [][] graph2 = {{4,3,1},{3,2,4},{3},{4},{}};
        List<List<Integer>> result2 = allPathsSourceTarget(graph2);
        System.out.println("Print All Paths Source To Target : ");
        result2.forEach(path->{
                    System.out.println();
                    path.forEach(node-> System.out.print(node+" "));
                }

        );
    }


    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        int startIndex = 0;
        int endIndex = graph.length - 1;
        Queue<List<Integer>> queue = new LinkedList<>();

        queue.add(Arrays.asList(startIndex));

        while (!queue.isEmpty()) {
            int size = queue.size();
            int i = 0;
            while(i++ < size) {
                List<Integer> frontList = queue.poll();

                if (frontList.get(frontList.size() - 1) == endIndex) {
                    result.add(frontList);
                }
                
                int lastNode = frontList.get(frontList.size() - 1);
                for (int connection : graph[lastNode]) {
                    List<Integer> copyList = new ArrayList<>(frontList);
                    copyList.add(connection);
                    queue.add(copyList);
                }
            }
        }

        return result;
    }
}
