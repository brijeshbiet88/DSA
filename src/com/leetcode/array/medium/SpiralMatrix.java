package com.leetcode.array.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        System.out.println("--------------Test Case 1-------------------");
        int [][] mat1 = {{1 , 2 , 3}, {4 , 5 , 6 }, {7 , 8 , 9}};
        List<Integer> result = spiralOrder(mat1);
        System.out.println("Print Matrix In Spiral Order : ");
        result.forEach(num -> System.out.print(num+" "));
        System.out.println();

        System.out.println("--------------Test Case 2-------------------");
        int [][] mat2 = {{10 , 11 , 12 , 13}, {14 , 15 , 16 , 17 }, {18 , 19 , 20 , 21}};
        List<Integer> result2 = spiralOrder(mat2);
        System.out.println("Print Matrix In Spiral Order : ");
        result2.forEach(num -> System.out.print(num+" "));
        System.out.println();

    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        int m = matrix.length;
        int n = matrix[0].length ;
        int up = 0 ;
        int down = m - 1;
        int left = 0;
        int right = n - 1;

        int count = 0;

        while(true){

            for(int i = left ; i <= right ; i++){
                result.add(matrix[up][i]);
                count++;
            }
            up++;

            if(count == m*n){
                break;
            }

            for(int i = up ; i <= down ; i++){
                result.add(matrix[i][right]);
                count++;
            }
            right--;

            if(count == m*n){
                break;
            }

            for(int i = right ; i >= left ; i--){
                result.add(matrix[down][i]);
                count++;
            }
            down--;

            if(count == m*n){
                break;
            }

            for(int i = down ; i >= up ; i--){
                result.add(matrix[i][left]);
                count++;
            }
            left++;
            if(count == m*n){
                break;
            }


        }
        return result;

    }
}
