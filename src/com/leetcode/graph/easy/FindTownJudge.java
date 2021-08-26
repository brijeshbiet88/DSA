package com.leetcode.graph.easy;

public class FindTownJudge {
    public static void main(String[] args) {
        System.out.println("----------------Test Case 1---------------------");
        int n = 4;
        int [][]  trust = { {1,3},
                            {1,4},
                            {2,3},
                            {2,4},
                            {4,3}
                          };
        System.out.println("Town Judge = "+findJudge(n , trust));
        System.out.println();
    }

    public static int findJudge(int n, int[][] trust) {

        int [] persons = new int [n];
        for(int [] t : trust) {
            persons[t[0]-1]--;
            persons[t[1]-1]++;
        }

        for(int i = 0 ; i < n ; i++) {

            if(persons[i] == n-1) return i+1;
        }

        return -1;
    }
}
