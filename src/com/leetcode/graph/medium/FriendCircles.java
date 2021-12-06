package com.leetcode.graph.medium;

import java.util.LinkedList;
import java.util.Queue;

public class FriendCircles {
    public static void main(String[] args) {
        System.out.println("----------------Test Case 1-----------------");
        FriendCircles friendCircles = new FriendCircles();
        int [][] isConnected1 = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println("Number of Friend Circles = "+friendCircles.findCircleNum(isConnected1));
        System.out.println();

        System.out.println("----------------Test Case 1-----------------");
        FriendCircles friendCircles2 = new FriendCircles();
        int [][] isConnected2 = {{1,0,0},{0,1,0},{0,0,1}};
        System.out.println("Number of Friend Circles = "+friendCircles2.findCircleNum(isConnected2));
        System.out.println();

    }

    public int findCircleNum(int[][] isConnected) {
        int result = bfs(0 , isConnected);
        return result;
    }

    public int bfs(int result , int [][] mat){
        int len = mat.length ;
        boolean [] visited = new boolean[len];
        for(int i = 0 ; i < len ; i++){
            if(!visited[i]){
                result++;
                bfsHelper(mat , i , visited);
            }
        }

        return result;
    }

    public void bfsHelper(int [][] mat , int city , boolean [] visited){
        Queue<Integer> q = new LinkedList<>();
        q.add(city);
        visited[city] = true;
        int len = mat.length;
        while(!q.isEmpty()) {
            int front = q.poll();
            for(int i = 0; i < len; i++) {
                if(mat[front][i] == 1 && visited[i] == false) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }

    }
}
