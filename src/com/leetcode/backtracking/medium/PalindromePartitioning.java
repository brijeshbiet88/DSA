package com.leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        System.out.println("--------------Test Case 1-------------------");
        String s = "aab";
        List<List<String>> list = partition(s);
        System.out.println("Print List of Palindrome Substrings ");
        printResult(list);
        System.out.println();

        System.out.println("--------------Test Case 2-------------------");
        s = "abc";
        List<List<String>> list2 = partition(s);
        System.out.println("Print List of Palindrome Substrings ");
        printResult(list2);
        System.out.println();

        System.out.println("--------------Test Case 3-------------------");
        s = "teeth";
        List<List<String>> list3 = partition(s);
        System.out.println("Print List of Palindrome Substrings ");
        printResult(list3);
        System.out.println();

    }

    private static void printResult(List<List<String>> list) {
        list.forEach(l->{
                System.out.print(l+" ");
            System.out.println();
        });
    }

    public static List<List<String>> partition(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        List<List<String>> result = new ArrayList<List<String>>();
        dfs(0, result, new ArrayList<String>(), s , dp);
        return result;
    }

    static void dfs(int start, List<List<String>> result, List<String> currentList, String s , boolean[][] dp) {
        if (start >= s.length()) result.add(new ArrayList<>(currentList));
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(start) == s.charAt(i) && (i - start <= 2 || dp[start + 1][i - 1])) {
                dp[start][i] = true;
                currentList.add(s.substring(start, i + 1));
                dfs(i +1 , result , currentList , s , dp);
                currentList.remove(currentList.size() - 1);
            }
        }
    }

}
