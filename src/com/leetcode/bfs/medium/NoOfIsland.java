package com.leetcode.bfs.medium;

public class NoOfIsland {
    public static void main(String[] args) {
        char [][] grid = {{'1','1','0','0','0'},
                          {'1','1','0','0','0'},
                          {'0','0','1','0','0'} ,
                          {'0','0','0','1','1'}
        };
        System.out.println("No Of Island = "+numIslands(grid));
    }

    public static int numIslands(char[][] grid) {

        int noOfIsland = 0;
        if(grid.length == 0) return 0;
        int r = grid.length , c = grid[0].length;
        boolean [][] visited = new boolean[r][c];
        for(int i = 0 ; i < r ; i++) {
            for(int j = 0 ; j < c ; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    noOfIsland++;
                    //visited[i][j] = true;
                    dfs(grid , i , j , visited);

                }

            }
        }
        return noOfIsland;



    }

    private static void dfs(char[][] grid, int r, int c, boolean[][] visited) {

        //int [] row = {-1, -1 , -1, 0 , 1 , 1 ,  1,   0 };
        //int [] col = {-1,  0 ,  1, 1 , 1 , 0 , -1 , -1 };

        int [] row = {-1 ,0 , 1 , 0 };
        int [] col = { 0 ,1 , 0 ,-1 };

        visited[r][c] = true;

        for (int i = 0 ; i < 4 ; i++) {
            if(isValid(grid ,visited , r+row[i] ,c+col[i] )){
                dfs(grid, r+row[i], c+col[i], visited);
            }
        }

    }

    private static boolean isValid(char [][] grid ,boolean[][] visited, int r, int c) {
        if(r < 0 || r >= visited.length  ) {
            return false;
        }

        if(c < 0 || c >= visited[0].length  ) {
            return false;
        }

        if(visited[r][c]) {
            return false;
        }

        if(grid[r][c] == '0') {
            return false;
        }
        return true;
    }
}
