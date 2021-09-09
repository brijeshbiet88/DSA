package com.leetcode.slidingwindow.misc;

public class MaxConsecutive1s2 {
    public static void main(String[] args) {
        System.out.println("----------------Test Case 1--------------------");
        int [] arr = {1 , 1, 0 , 1 , 1, 0 , 0 , 1 , 1 , 1 , 0 , 1 , 1, 0};
        System.out.println("Max Consecutive 1s  After Flipping a zero "+ findMaxConsecutive1s(arr));
        System.out.println();

        System.out.println("----------------Test Case 2--------------------");
        int [] arr2 = {1 , 1, 0 , 1 , 1, 0 , 0 , 1 , 1 , 0 , 0 , 1 , 1, 0};
        System.out.println("Max Consecutive 1s  After Flipping a zero "+ findMaxConsecutive1s(arr2));
        System.out.println();

        System.out.println("----------------Test Case 3--------------------");
        int [] arr3 = {1 , 1, 1 , 0 , 0 , 1 };
        System.out.println("Max Consecutive 1s  After Flipping a zero "+ findMaxConsecutive1s(arr3));
        System.out.println();
    }

    public static int findMaxConsecutive1s(int [] arr){
        int max = 0;
        int j = -1;
        int count = 0;
        for (int i = 0 ; i < arr.length ; i++){
            if(arr[i] == 0){
                count++;
            }
            while (count > 1){
                j++;
                if(arr[j] == 0){
                    count--;
                }
            }
         max = Math.max(max , i - j);
        }
        return max;
    }
}
