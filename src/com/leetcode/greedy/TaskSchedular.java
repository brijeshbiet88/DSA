package com.leetcode.greedy;

import java.util.Arrays;

public class TaskSchedular {
    public static void main(String[] args) {
        System.out.println("-----------------Test Case 1------------------");
        char [] tasks = {'A','A','A','B','B','B'};
        int n = 2;
        System.out.println("result = "+leastInterval(tasks , n));
        System.out.println();

        System.out.println("-----------------Test Case 2------------------");
        char [] tasks2 = {'A','A','A','A','A','B','B','B','B','B','C','C','C','C','D','D','D'};
        n = 2;
        System.out.println("result = "+leastInterval(tasks2 , n));
        System.out.println();
    }

    public static int leastInterval(char[] tasks, int n) {

        int[] f = new int[26];
        for (char task : tasks)
            f[task - 'A']++;

        Arrays.sort(f);
        int chunk = f[25] - 1;
        int idleSpots = chunk * n;

        for (int i = 24; i >= 0; i--)
            idleSpots -= Math.min(chunk, f[i]);

        return idleSpots < 0 ? tasks.length : idleSpots + tasks.length;
    }
}
