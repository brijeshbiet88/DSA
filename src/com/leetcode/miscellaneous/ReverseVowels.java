package com.leetcode.miscellaneous;

public class ReverseVowels {
    public static void main(String[] args) {
        System.out.println("----------------Test Case 1------------------");
        String s = "hello";
        System.out.println("Result = "+reverseVowels(s));
        System.out.println();

        System.out.println("----------------Test Case 2------------------");
        s = "Leetcode";
        System.out.println("Result = "+reverseVowels(s));
        System.out.println();

        System.out.println("----------------Test Case 3------------------");
        s = "peacock";
        System.out.println("Result = "+reverseVowels(s));
        System.out.println();

        System.out.println("----------------Test Case 4------------------");
        s = "cold";
        System.out.println("Result = "+reverseVowels(s));
        System.out.println();
    }

    public static String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        boolean left;
        boolean right;

        while (i <= j) {
            if ("aeiouAEIOU".contains(String.valueOf(arr[i]))) {
                left = true;
            } else {
                left = false;
                i++;
            }


            if ("aeiouAEIOU".contains(String.valueOf(arr[j]))) {
                right = true;
            } else {
                right = false;
                j--;
            }

            if (right && left) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        s = String.valueOf(arr);
        return s;

    }
    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
