package com.leetcode.backtracking.hard;

public class UniquePath3 {
    public static void main(String[] args) {
        System.out.println("----------------Test Case 1---------------------");
        int [][] grid = {{1 , 0 , 0 , 0}, {0 , 0 , 0 , 0} , {0 , 0 , 2 , -1}};
        System.out.println("Total Paths = "+uniquePathsIII(grid));
        System.out.println();
    }

    public static int uniquePathsIII(int[][] grid) {
        int zeroCount = 0 , startX = 0 , startY = 0;
        for (int i = 0 ; i < grid.length ; i++){
            for (int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 0) zeroCount++;
                else if(grid[i][j] == 1){
                    startX = i;
                    startY = j;
                }
            }
        }
        return dfs(grid , startX , startY , zeroCount);
    }

    private static int dfs(int[][] grid, int x, int y, int zeroCount) {
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == -1)
            return 0;
        if(grid[x][y] == 2)
            return zeroCount == -1 ? 1 : 0;

        grid[x][y] = -1;
        zeroCount--;

        int totalPaths = dfs(grid, x + 1, y, zeroCount) +
                         dfs(grid, x, y + 1, zeroCount) +
                         dfs(grid, x - 1, y, zeroCount) +
                         dfs(grid, x, y - 1, zeroCount) ;

        grid[x][y] = 0;
        zeroCount++;
        return totalPaths;
    }
}
