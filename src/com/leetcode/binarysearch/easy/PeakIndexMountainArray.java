package com.leetcode.binarysearch.easy;

public class PeakIndexMountainArray {
    public static void main(String[] args) {
        System.out.println("---------------Test Case 1---------------------");
        int [] arr = {24,69,100,99,79,78,67,36,26,19};
        System.out.println("Peak Array In Mountain Array = "+peakIndexInMountainArray(arr));
        System.out.println();

        System.out.println("---------------Test Case 2---------------------");
        int [] arr2 = {18,29,38,59,98,100,99,98,90};
        System.out.println("Peak Array In Mountain Array = "+peakIndexInMountainArray(arr2));
        System.out.println();

        System.out.println("---------------Test Case 3---------------------");
        int [] arr3 = {3,5,3,2,0};
        System.out.println("Peak Array In Mountain Array = "+peakIndexInMountainArray(arr3));
        System.out.println();

    }
    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0 , end = arr.length -1;
        int mid = 0;

        while (start <= end){

            mid = start + (end - start) / 2;
            if(mid > 0 && arr[mid] > arr[mid-1] && mid < arr.length -1 && arr[mid] > arr[mid+1]){
                return mid;
            }
            else if(mid > 0 && arr[mid] > arr[mid-1]){
                start = mid ;
            }
            else {
                end = mid ;
            }

        }
        return mid;
    }

}
