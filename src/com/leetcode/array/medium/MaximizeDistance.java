package com.leetcode.array.medium;

public class MaximizeDistance {
    public static void main(String[] args) {
        System.out.println("----------------Test Case 1------------------");
        int [] seats1 = {0, 0, 0, 1 , 0 , 0};
        System.out.println("Max Distance = "+maxDistToClosest(seats1));
        System.out.println();

        System.out.println("----------------Test Case 2------------------");
        int [] seats2 = {0, 1 , 0 , 0,0 , 0};
        System.out.println("Max Distance = "+maxDistToClosest(seats2));
        System.out.println();

        System.out.println("----------------Test Case 3------------------");
        int [] seats3 = {1,0,0,0,1,0,1};
        System.out.println("Max Distance = "+maxDistToClosest(seats3));
        System.out.println();
    }

    public static int maxDistToClosest(int[] seats) {

        int n = seats.length ;
        int result = 0;
        int k = 0;
        for(int i = 0 ; i < n ; i++){
            if(seats[i] == 1){
                k = 0;
            }else{
                k++;
                result = Math.max(result , (k+1)/2);
            }
        }


        for(int i = 0 ; i < n ; i++){
            if(seats[i] == 1){
                break;
            }
            result = Math.max(result , i + 1);
        }



        for(int i = n-1 ; i >= 0 ; i--){
            if(seats[i] == 1){
                break;
            }
            result = Math.max(result , n -i);
        }
        return result;
    }
}
