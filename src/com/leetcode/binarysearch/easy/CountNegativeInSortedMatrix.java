package com.leetcode.binarysearch.easy;

public class CountNegativeInSortedMatrix {
    public static void main(String[] args) {
        int [][] grid = {{4, 3 , 2, -1 , - 2},
                         {3, 2, 1,  -1 , - 3},
                         {1, -1, -1, -2 , - 4},
                         {-1,-1,-2, -3  , -5}};
        System.out.println("Negative Numbers in Matrix Sorted Row and Column Wise "+countNegatives(grid));
    }

    public static int countNegatives(int[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        int row = 0;
        int col = n -1;

        while (row < m){
            while (col >= 0 && grid[row][col] < 0) col--;
            count += n - col -1 ;
            row++;
        }

        return count;
    }

}
