package com.leetcode.miscellaneous;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println("---------------Test Case 1------------------");
        String s = "xabcbayyycd";
        System.out.println("Longest Palindromic SubString = "+longestPalindrome(s));
        System.out.println();

        System.out.println("---------------Test Case 2------------------");
        s = "babad";
        System.out.println("Longest Palindromic SubString = "+longestPalindrome(s));
        System.out.println();

        System.out.println("---------------Test Case 3------------------");
        s = "a";
        System.out.println("Longest Palindromic SubString = "+longestPalindrome(s));
        System.out.println();

        System.out.println("---------------Test Case 4------------------");
        s = "";
        System.out.println("Longest Palindromic SubString = "+longestPalindrome(s));
        System.out.println();

        System.out.println("---------------Test Case 5------------------");
        s = "ac";
        System.out.println("Longest Palindromic SubString = "+longestPalindrome(s));
        System.out.println();
    }

    public static String longestPalindrome(String s) {
        String result = "";
        int n = s.length();
        for (int i = 0; i < n; i++) {
            String odd = expandPalindrome(s, i, i);
            String even = expandPalindrome(s, i, i + 1);
            if (result.length() < odd.length()) {
                result = odd;
            }

            if (result.length() < even.length()) {
                result = even;
            }
        }

        return result;
    }

    private static String expandPalindrome(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }
}
