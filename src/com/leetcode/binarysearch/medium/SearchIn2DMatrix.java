package com.leetcode.binarysearch.medium;

public class SearchIn2DMatrix {
    public static void main(String[] args) {
        System.out.println("--------------Test Case 1---------------");
        int [][] matrix = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };

        int target = 3;
        System.out.println("Element Found ? "+searchMatrix(matrix , target));
        System.out.println();

        System.out.println("--------------Test Case 1---------------");
        int [][] matrix2 = {{1}};

        target = 0;
        System.out.println("Element Found ? "+searchMatrix(matrix2 , target));
        System.out.println();
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0 , high = m*n -1;
        int [] pos = new int [2];
        while (low <= high){
            int mid = low + (high - low)/2;
            pos = findCoordinates(mid , m , n);
            if(matrix[pos[0]][pos[1]] == target) return true;
            else if(matrix[pos[0]][pos[1]] > target){
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }
        return  false;
    }

    public static int [] findCoordinates(int index , int m , int n){
        int [] pos = new int [2];
        pos[0] = (index ) / n;
        pos[1] = (index ) % n;
        return  pos;
    }
}
