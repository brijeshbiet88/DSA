package com.leetcode.array.medium;

public class SpiralMatrix2 {
    public static void main(String[] args) {
        System.out.println("-------------Test Case 1----------------");
        int n = 3;
        int [][] result = generateMatrix(n);
        printMatrix(result , n);
        System.out.println();

        System.out.println("-------------Test Case 2----------------");
        n = 1;
        int [][] result2 = generateMatrix(n);
        printMatrix(result2 , n);
        System.out.println();

        System.out.println("-------------Test Case 3----------------");
        n = 4;
        int [][] result3 = generateMatrix(n);
        printMatrix(result3 , n);
        System.out.println();

    }

    private static void printMatrix(int [][] matrix , int n){
        for (int i = 0 ; i < n ; i++)
            for (int j = 0 ; j < n ; j++){
                System.out.print(matrix[i][j]+" ");
            }
        System.out.println();
    }

    public static int[][] generateMatrix(int n) {
        int [][] matrix = new int [n][n];
        int num = 1;

        int up = 0;
        int down = n-1;
        int left = 0;
        int right = n-1;

        while(num <= n*n ){


            for(int i = left ; i <= right ; i++  ){
                matrix[up][i] = num++;
            }
            up++;

            for(int i = up ; i <= down ; i++  ){
                matrix[i][right] = num++;
            }
            right--;

            for(int i = right ; i >= left ; i--  ){
                matrix[down][i] = num++;
            }
            down--;

            for(int i = down ; i >= up ; i--  ){
                matrix[i][left] = num++;
            }
            left++;

            if(num > n*n){
                break;
            }

        }


        return matrix;
    }
}
