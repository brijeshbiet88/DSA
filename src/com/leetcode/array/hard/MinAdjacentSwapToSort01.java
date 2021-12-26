package com.leetcode.array.hard;

public class MinAdjacentSwapToSort01 {
    public static void main(String[] args) {
        MinAdjacentSwapToSort01 o = new MinAdjacentSwapToSort01();
        System.out.println("----------------Test Case 1-----------------");
        int [] arr1 = {0, 0, 1, 0, 1, 0, 1, 1};
        System.out.println("Min Adjacent Swaps To Sort Array = "+o.findMinSwaps(arr1,arr1.length));
        System.out.println();
    }

    private int findMinSwaps(int arr[], int n) {
        // Array to store count of zeroes
        int noOfZeroes[] = new int[n];
        int i, count = 0;

        // Count number of zeroes
        // on right side of every one.
        noOfZeroes[n - 1] = 1 - arr[n - 1];
        for (i = n - 2; i >= 0; i--)
        {
            noOfZeroes[i] = noOfZeroes[i + 1];
            if (arr[i] == 0)
                noOfZeroes[i]++;
        }

        // Count total number of swaps by adding number
        // of zeroes on right side of every one.
        for (i = 0; i < n; i++)
        {
            if (arr[i] == 1)
                count += noOfZeroes[i];
        }
        return count;
    }
}
