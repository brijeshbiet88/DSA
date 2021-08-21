package com.leetcode.backtracking.medium;

public class UniquePath2 {
    public static void main(String[] args) {
        System.out.println("------------------Test Case 1 -----------------");
        int [][] grid = {{0,0,0}, {0,1,0}, {0,0,0}};
        System.out.println("No of Ways to Reach End "+uniquePathsWithObstacles(grid));
        System.out.println();

        System.out.println("------------------Test Case 2 -----------------");
        int [][] grid2 = {{0,0,0}, {0,0,1}, {0,1,0}};
        System.out.println("No of Ways to Reach End "+uniquePathsWithObstacles(grid2));
        System.out.println();
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

         obstacleGrid[0][0] = 1;

        for (int i = 1; i < m; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }

        for (int i = 1; i < n; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
        }

        for(int i = 1 ; i < m ; i++){
            for (int j = 1 ; j < n ; j++){
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }

        return obstacleGrid[m-1][n-1];
    }
}
