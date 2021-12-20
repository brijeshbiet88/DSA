package com.leetcode.greedy;

import java.util.Arrays;

public class MinimumPlatformsNeeded {
    public static void main(String[] args) {
        System.out.println("---------------Test Case 1-----------------");
        int [] arr = {1 , 2 , 3 , 6 };
        int [] dep = {3 , 3,  4, 8 };
        System.out.println("Min Platform Needed = "+findPlatform(arr , dep , arr.length));
        System.out.println();
    }

    private static int findPlatform(int arr[], int dep[], int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int platforms = 1;
        int result = 1;
        int i = 1;
        int j = 0;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                platforms++;
                i++;
            }

            else if (arr[i] > dep[j]) {
                platforms--;
                j++;
            }

            if (platforms > result)
                result = platforms;
        }

        return result;
    }
}
