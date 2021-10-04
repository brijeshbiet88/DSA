package com.leetcode.miscellaneous;

public class IslandPerimeter {
    public static void main(String[] args) {
        System.out.println("--------------Test Case 1-----------------");
        int [][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        int perimeter = islandPerimeter(grid);
        System.out.println("Island Perimeter = "+perimeter);
        System.out.println();

        System.out.println("--------------Test Case 2-----------------");
        int [][] grid2 = {{1}};
        int perimeter2 = islandPerimeter(grid2);
        System.out.println("Island Perimeter = "+perimeter2);
        System.out.println();
    }

    public static int islandPerimeter(int[][] grid) {

        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;

        int perimeter = 0;

        for (int row = 0 ; row < m  ; row++){
            for (int col = 0 ; col < n  ; col++) {

                    if (grid[row][col] == 1) {
                        perimeter += 4;

                        if (row > 0 && grid[row - 1][col] == 1) {
                             perimeter -= 2;
                        }

                        if (col > 0 && grid[row][col - 1] == 1) {
                            perimeter -= 2;
                        }
                    }
            }
        }
        return perimeter;
    }
}
