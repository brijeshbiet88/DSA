package com.leetcode.miscellaneous;

import java.util.Arrays;

public class CountUniqueCharsOfAllSubstrings {
    public static void main(String[] args) {
        System.out.println("----------------Test Case 1----------------");
        String s = "ABC";
        System.out.println("No of Unique Characters in All Substring of "+s+" = "+uniqueLetterString(s));
        System.out.println();

        System.out.println("----------------Test Case 2----------------");
        s = "ABA";
        System.out.println("No of Unique Characters in All Substring of "+s+" = "+uniqueLetterString(s));
        System.out.println();

        System.out.println("----------------Test Case 3----------------");
        s = "LEETCODE";
        System.out.println("No of Unique Characters in All Substring of "+s+" = "+uniqueLetterString(s));
        System.out.println();

        System.out.println("----------------Test Case 4----------------");
        s = "CODING";
        System.out.println("No of Unique Characters in All Substring of "+s+" = "+uniqueLetterString(s));
        System.out.println();

        System.out.println("----------------Test Case 5----------------");
        s = "PRACTICE";
        System.out.println("No of Unique Characters in All Substring of "+s+" = "+uniqueLetterString(s));
        System.out.println();
    }

    public static int uniqueLetterString(String s) {
        int len = s.length();
        int[] a = new int[26];

        int[] leftCount = new int[len];
        Arrays.fill(a,-1);

        int index;
        char [] strArr = s.toCharArray();
        for(int i = 0; i < len; i++){
            index = strArr[i] - 'A';
            leftCount[i] = a[index] == -1 ? i+1 : i - a[index];
            a[index] = i;
        }

        Arrays.fill(a,-1);

        int result = 0, right;
        for(int i = len-1; i >= 0; i--){
            index = strArr[i] - 'A';
            right = a[index] == -1 ? len - i : a[index] - i;
            result += right * leftCount[i];
            a[index] = i;
        }
        return result;
    }
}
