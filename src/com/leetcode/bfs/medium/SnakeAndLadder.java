package com.leetcode.bfs.medium;

import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadder {
    public static void main(String[] args) {
        int [][] board = {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1}
                            , {-1,35,-1,-1,13,-1} ,{-1,-1,-1,-1,-1,-1} ,{-1,15,-1,-1,-1,-1}};
        System.out.println("Min Steps = "+snakesAndLadders(board));
    }

    public static int snakesAndLadders(int[][] board) {
        int n = board.length;
        int steps = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        boolean [][] visited = new boolean [n][n];
        visited[n-1][0] = true;
        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0 ; i < size ; i++){
                int x = q.poll();
                if(x == n*n) return steps;

                for(int k = 1; k <=6 ; k++){
                    if(k +x > n*n) break;
                    int [] pos = findCoordinates(k+x , n);
                    int r = pos[0];
                    int c = pos[1];
                    if(visited[r][c] == true) continue;
                    visited[r][c] = true;
                    if(board[r][c] == -1){
                        q.add(x+k);
                    }else{
                        q.add(board[r][c]);
                    }
                }


            }
            steps++;
        }
        return -1;
    }

    public static int [] findCoordinates(int num , int n){

        int r = n - (num -1) / n -1;
        int c = (num-1) % n;



        int [] pos = new int [2];

        if(r%2 == n %2){
            pos[0] = r;
            pos[1] = n -1 -c;
        }else{
            pos[0] = r;
            pos[1] = c;
        }

        return pos;
    }
}
