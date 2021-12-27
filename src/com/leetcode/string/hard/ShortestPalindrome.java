package com.leetcode.string.hard;

public class ShortestPalindrome {
    public static void main(String[] args) {
        ShortestPalindrome sp = new ShortestPalindrome();
        System.out.println("-----------------Test Case 1-------------------");
        String s = "abcbd";
        System.out.println("Shortest Palindrome for string s = "+s+" is -> "+sp.shortestPalindrome(s));
        System.out.println();

        System.out.println("-----------------Test Case 2-------------------");
        s = "aacecaaa";
        System.out.println("Shortest Palindrome for string s = "+s+" is -> "+sp.shortestPalindrome(s));
        System.out.println();

        System.out.println("-----------------Test Case 3-------------------");
        s = "abcd";
        System.out.println("Shortest Palindrome for string s = "+s+" is -> "+sp.shortestPalindrome(s));
        System.out.println();

        System.out.println("-----------------Test Case 4-------------------");
        s = "apqpaa";
        System.out.println("Shortest Palindrome for string s = "+s+" is -> "+sp.shortestPalindrome(s));
        System.out.println();

        System.out.println("-----------------Test Case 5-------------------");
        s = "";
        System.out.println("Shortest Palindrome for string s = "+s+" is -> "+sp.shortestPalindrome(s));
        System.out.println();
    }

    //The idea is to find the longest palindrome starting from the 1st character,
    // and then reverse the remaining part as the prefix to s
    public String shortestPalindrome(String s) {
        int i = 0, end = s.length() - 1, j = end;
        char chs[] = s.toCharArray();
        while(i < j) {
            if (chs[i] == chs[j]) {
                i++; j--;
            } else {
                i = 0;
                end--;
                j = end;
            }
        }
        return new StringBuilder(s.substring(end+1)).reverse().toString() + s;
    }
}
