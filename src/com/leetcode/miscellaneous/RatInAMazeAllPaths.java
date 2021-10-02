package com.leetcode.miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class RatInAMazeAllPaths {
    static List<String> possiblePaths = new ArrayList<>();
    static StringBuilder path = new StringBuilder("");
    public static void main(String[] args) {
        System.out.println("-----------------Test Case 1------------------");
        int [][] maze1 = {{0,1,0,1,1},
                          {0,0,0,0,0},
                          {0,0,1,0,1},
                          {1,0,0,0,0},
                          {1,0,0,1,0}
        };

        printAllPaths(maze1);
        System.out.println("Print Paths : ");
        possiblePaths.forEach(path -> System.out.print(path+" "));
        System.out.println();
    }

    private static void printAllPaths(int[][] maze1) {
        printAllPathsHelper(0 , 0 , maze1 , maze1.length);
    }

    private static void printAllPathsHelper(int x, int y, int[][] maze1, int n) {

        if(x == n-1 && y == n -1){
            possiblePaths.add(path.toString());
            return;
        }

        if(isValid(x, y, maze1, n)){
            path.append("D");
            printAllPathsHelper(x + 1, y, maze1, n);
            path.deleteCharAt(path.length()-1);
            path.append("R");
            printAllPathsHelper(x, y + 1, maze1, n);
            path.deleteCharAt(path.length()-1);
        }
    }

    private static boolean isValid(int row , int col , int [][] maze , int n ){
        if(row < 0 || row > n-1 || col < 0 || col > n -1 || maze[row][col] == 1)
        return false;
        return true;
    }
}
