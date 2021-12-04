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
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        
        for(int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }

        int[] inDegree = new int[numCourses];
        
        for(int[] edge: prerequisites) {
            graph[edge[0]].add(edge[1]);
            inDegree[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList();
        for(int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0)
                queue.add(i);
        }

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            for(int c : graph[curr]) {
                inDegree[c]--;
                if(inDegree[c] == 0)
                    queue.add(c);
            }
            numCourses--;
        }

        return numCourses == 0;
    }
}
