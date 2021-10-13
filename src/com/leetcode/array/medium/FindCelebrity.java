package com.leetcode.array.medium;

public class FindCelebrity {
    public static void main(String[] args) {
        System.out.println("---------------Test case 1-----------------");
        int [][] mat1 = {{0,0,1,0},
                         {0,0,1,0},
                         {0,0,0,0},
                         {0,0,1,0}};
        System.out.println("Celebrity is "+findCelebrity(mat1));
        System.out.println();

    }

    public static int findCelebrity(int [][] mat){
        int m = mat.length , n = mat[0].length;
        int x = 0 , y = n - 1;
        while (x < y){
            if(mat[x][y] == 1){
                x++;
            }else {
                y--;
            }
        }
        int celebrity = x;
        for (int j = 0 ; j < n ; j++){
            if(mat[x][j] == 1){
                celebrity = -1;
                break;
            }
        }

        return celebrity+1;
    }
}
