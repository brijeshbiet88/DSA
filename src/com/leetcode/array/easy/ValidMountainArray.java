package com.leetcode.array.easy;

public class ValidMountainArray {
    public static void main(String[] args) {
        System.out.println("--------------Test case 1------------------");
        int [] arr1 = {2,1};
        System.out.println("Is Valid Mountain Array ? "+validMountainArray(arr1));
        System.out.println();

        System.out.println("--------------Test case 2------------------");
        int [] arr2 = {3,5,5};
        System.out.println("Is Valid Mountain Array ? "+validMountainArray(arr2));
        System.out.println();

        System.out.println("--------------Test case 3------------------");
        int [] arr3 = {0,3,2,1};
        System.out.println("Is Valid Mountain Array ? "+validMountainArray(arr3));
        System.out.println();

        System.out.println("--------------Test case 4------------------");
        int [] arr4 = {0,3,2,1,4};
        System.out.println("Is Valid Mountain Array ? "+validMountainArray(arr4));
        System.out.println();

        System.out.println("--------------Test case 5------------------");
        int [] arr5 = {0,3,3,2,1};
        System.out.println("Is Valid Mountain Array ? "+validMountainArray(arr5));
        System.out.println();
    }

    public static boolean validMountainArray(int[] arr) {
        if(arr.length < 3) {
            return false;
        }

        int i = 0 , len = arr.length;
        while(i < len -1 && arr[i] < arr[i+1] ){
            i++;
        }

        if(i == 0 || i == len -1)
            return false;

        while(i < len -1 && arr[i] > arr[i+1] ){
            i++;
        }

        return i == len-1;

    }
}
