package com.leetcode.array.medium;

public class RotateImage {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println("Rotate 90 Degree ");
		rotate(matrix);
		System.out.println("Print Matrix After Rotating 90 Degree ");
		for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
               System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
		
	}

	
	 public static void rotate(int[][] matrix) {
	        
	        for(int i = 0 ; i < matrix.length ; i++){
	            for(int j = i+1 ; j < matrix[0].length ; j++){
	                int temp = matrix[i][j];
	                matrix[i][j] = matrix[j][i];
	                matrix[j][i] = temp;
	            }
	        }
	        
	        for(int i = 0 ; i < matrix.length ; i++){
	            int a = 0 , b = matrix.length  -1 ;
	            while(a < b){
	                int tmp = matrix[i][a];
	                matrix[i][a] = matrix[i][b];
	                matrix[i][b] = tmp;
	                a++;
	                b--;
	            }
	        }
	        
	    }
}
