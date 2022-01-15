package com.leetcode.bfs.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule2 {
    public static void main(String[] args) {
        System.out.println("------------------Test Case 3-------------------");
        int [][] pre1 = {{0,1},{2,1}};
        int numCourses = 3;
        int [] order = findOrder(numCourses , pre1);
        System.out.println("Order of Courses : ");
        for (int o : order)
            System.out.print(o+"->");
        System.out.println();

        System.out.println("------------------Test Case 2-------------------");
        int [][] pre2 = {{1,0},{2,0},{3,1},{3,2}};
        numCourses = 4;
        int [] order2 = findOrder(numCourses , pre2);
        System.out.println("Order of Courses : ");
        for (int o : order2)
            System.out.print(o+"->");
        System.out.println();
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList();

        int[] outDegree = new int[numCourses];
        for (int[] p : prerequisites) {
            graph[p[1]].add(p[0]);
            outDegree[p[0]]++;
        }

        int[] order = new int[numCourses];
        int index = 0;
        
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < numCourses; i++) {
            if (outDegree[i] == 0) {
                queue.add(i);
                order[index++] = i;
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int c : graph[current]) {
                outDegree[c]--;
                if (outDegree[c] == 0) {
                    queue.add(c);
                    order[index++] = c;
                }
            }
        }

        return index == numCourses ? order : new int[0];
    }
}
