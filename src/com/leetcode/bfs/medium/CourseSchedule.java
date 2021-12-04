package com.leetcode.bfs.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public static void main(String[] args) {
        System.out.println("------------------Test Case 1-------------------");
        int [][] pre = {{1,0}};
        int numCourses = 2;
        System.out.println("Can Finish ? "+canFinish(numCourses , pre));
        System.out.println();

        System.out.println("------------------Test Case 2-------------------");
        int [][] pre2 = {{1,0},{0,1}};
        numCourses = 2;
        System.out.println("Can Finish ? "+canFinish(numCourses , pre2));
        System.out.println();

        System.out.println("------------------Test Case 3-------------------");
        int [][] pre3 = {{0,1},{1,2},{2,1}};
        numCourses = 3;
        System.out.println("Can Finish ? "+canFinish(numCourses , pre3));
        System.out.println();
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        
        for(int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }

        int[] outDegree = new int[numCourses];
        
        for(int[] edge: prerequisites) {
            graph[edge[1]].add(edge[0]);
            outDegree[edge[0]]++;
        }

        Queue<Integer> queue = new LinkedList();
        for(int i = 0; i < numCourses; i++) {
            if(outDegree[i] == 0)
                queue.add(i);
        }

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            for(int c : graph[curr]) {
                outDegree[c]--;
                if(outDegree[c] == 0)
                    queue.add(c);
            }
            numCourses--;
        }

        return numCourses == 0;
    }
}
