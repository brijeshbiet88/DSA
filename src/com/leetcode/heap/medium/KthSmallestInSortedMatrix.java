package com.leetcode.heap.medium;

public class KthSmallestInSortedMatrix {
    public static void main(String[] args) {
        System.out.println("-----------------Test Case 1----------------------");
        int [][] matrix = {{1,5,9} , {10,11,13} , {12,13,15}};
        int k = 8;
        System.out.println("Kth Smallest Element = "+kthSmallest(matrix , k));
        System.out.println();
    }

    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        int mid = 0;
        while (low < high){
            mid = low + (high - low)/2;
            int count = lessEqual(matrix , mid);
            if(count < k) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    public static int lessEqual(int [][] matrix , int target){
        int cnt = 0 , N = matrix.length , i = N -1 , j = 0;
        while (i >= 0 && j < N){
            if(matrix[i][j] > target){
                i--;
            }else {
                cnt = cnt + i + 1;
                j++;
            }
        }
        return cnt;
    }
}
