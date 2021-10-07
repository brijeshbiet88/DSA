package com.leetcode.string.medium;

public class PermutationInString {
    public static void main(String[] args) {
        System.out.println("----------------Test Case 1------------------");
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println("Is Permutation Palindrome ? "+checkInclusion(s1, s2));
        System.out.println();

        System.out.println("----------------Test Case 2------------------");
        s1 = "ab";
        s2 = "eidbsaooo";
        System.out.println("Is Permutation Palindrome ? "+checkInclusion(s1, s2));
        System.out.println();

        System.out.println("----------------Test Case 3------------------");
        s1 = "";
        s2 = "testempty";
        System.out.println("Is Permutation Palindrome ? "+checkInclusion(s1, s2));
        System.out.println();
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int[] s1map = new int[26];
        for (int i = 0; i < s1.length(); i++)
            s1map[s1.charAt(i) - 'a']++;

        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            int[] s2map = new int[26];
            for (int j = 0; j < s1.length(); j++) {
                s2map[s2.charAt(i + j) - 'a']++;
            }
            if (isMathching(s1map, s2map))
                return true;
        }
        return false;
    }

    public static boolean isMathching(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i])
                return false;
        }
        return true;
    }
}
