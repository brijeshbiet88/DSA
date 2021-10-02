package com.leetcode.miscellaneous;

public class RatInMaze1 {
    public static void main(String[] args) {
        System.out.println("-----------------Test Case 1------------------");
        int [][] maze1 = {{0,1,0,1,1},
                          {0,0,0,0,0},
                          {1,0,1,0,1},
                          {0,0,1,0,0},
                          {1,0,0,1,0}
                          };

        System.out.println("Can Rat Reach to Corner in The Maze ? "+canReach(maze1));
        System.out.println();

        System.out.println("-----------------Test Case 2------------------");
        int [][] maze2 = {{0,1,0,1,1},
                          {0,0,0,0,0},
                          {1,0,1,1,1},
                          {0,0,1,0,0},
                          {1,0,0,1,0}
        };

        System.out.println("Can Rat Reach to Corner in The Maze ? "+canReach(maze2));
        System.out.println();

        System.out.println("-----------------Test Case 3------------------");
        int [][] maze3 = {{0,1,0,1,1},
                          {0,0,1,1,1},
                          {1,0,1,1,1},
                          {0,0,0,0,0},
                          {1,0,0,1,0}
        };

        System.out.println("Can Rat Reach to Corner in The Maze ? "+canReach(maze3));
        System.out.println();
    }

    private static boolean canReach(int [][] maze){
        int m = maze.length , n = maze[0].length;
        int [][] path = new int[m][n];
        return canReachHelper(maze , path , 0 , 0 , m , n);
    }

    private static boolean canReachHelper(int[][] maze, int[][] path, int x, int y , int m , int n ) {

        if (x == m-1 && y == n-1 ){
            path[x][y] = 1;
            return true;
        }

        if (isValid(maze, x, y)){
            path[x][y] = 1;

            if(canReachHelper(maze, path, x+1, y, m, n)){
                return true;
            }
            if(canReachHelper(maze, path, x, y+1, m, n)){
                return true;
            }
            path[x][y] = 0;
            return false;
        }

        return false;
    }

    private static boolean isValid(int [][] maze , int x , int y){
        if(x < maze.length && y < maze[0].length && maze[x][y] != 1){
            return true;
        }
        return false;
    }
}
