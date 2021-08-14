package com.leetcode.bfs.medium;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public static void main(String[] args) {
        int [][] grid = {{2 , 1, 1},
                        {1 , 1 , 0},
                        {0 , 1 , 1}};
        System.out.println("Min Time To Rot All Oranges "+orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {

        int[][] direction = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        Queue<Node> q = new LinkedList<>();
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int freshCount = 0;
        int maxTime = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                } else if (grid[i][j] == 2) {
                    visited[i][j] = true;
                    q.add(new Node(i, j, 0));
                }
            }

        while (!q.isEmpty()) {

            Node temp = q.poll();
            maxTime = Math.max(maxTime, temp.time);
            for (int i = 0; i < 4; i++) {
                if (isValid(grid, i, temp, visited, direction)) {
                    q.add(new Node(temp.x + direction[i][0], temp.y + direction[i][1], temp.time + 1));
                    freshCount--;
                    visited[temp.x + direction[i][0]][temp.y + direction[i][1]] = true;
                }
            }

        }

        return 	freshCount == 0 ? maxTime : -1;


    }

    private static boolean isValid(int[][] grid, int i, Node temp, boolean[][] visted, int[][] direction) {
        if((temp.x + direction[i][0]) < 0 || (temp.x + direction[i][0]) >= grid.length) {
            return false;
        }

        if((temp.y + direction[i][1]) < 0 || (temp.y + direction[i][1]) >= grid[0].length) {
            return false;
        }

        if(visted[temp.x + direction[i][0]][temp.y + direction[i][1]] == true) {
            return false;
        }

        if(grid[temp.x + direction[i][0]][temp.y + direction[i][1]] != 1) {
            return false;
        }

        return true;
    }

    public static class Node {
        private int x ;
        private int y;
        private int time ;
        public Node(int x, int y, int time) {
            super();
            this.x = x;
            this.y = y;
            this.time = time;
        }
        public int getX() {
            return x;
        }
        public void setX(int x) {
            this.x = x;
        }
        public int getY() {
            return y;
        }
        public void setY(int y) {
            this.y = y;
        }
        public int getTime() {
            return time;
        }
        public void setTime(int time) {
            this.time = time;
        }
        @Override
        public String toString() {
            return "Node [x=" + x + ", y=" + y + ", time=" + time + "]";
        }



    }
}
