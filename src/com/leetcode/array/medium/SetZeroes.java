package com.leetcode.array.medium;

public class SetZeroes {

    public static void main(String[] args) {
        int [][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);
        System.out.println("Print Matrix After Setting 0's");
        System.out.println();

        for (int [] row : matrix){
            for (int num : row){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
    public static void setZeroes(int[][] matrix) {

        boolean firstRow = false;
        boolean firstCol = false;

        int m = matrix.length;
        int n = matrix[0].length;

        for(int i = 0 ; i < n ; i++){
            if(matrix[0][i] == 0){
                firstRow = true;
                break;
            }
        }

        for(int i = 0 ; i < m ; i++){
            if(matrix[i][0] == 0){
                firstCol = true;
                break;
            }
        }

        for(int i = 1 ; i < m ; i++){
            for(int j = 1 ; j < n ; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i = 1 ; i < m ; i++){
            for(int j = 1 ; j < n ; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(firstRow){
            for(int j = 0 ; j < n ; j++){
                matrix[0][j] = 0;
            }
        }

        if(firstCol){
            for(int i = 0 ; i < m ; i++){
                matrix[i][0] = 0;
            }
        }

    }
}
