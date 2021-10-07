package com.leetcode.miscellaneous;

public class PalindromePermutation {
    public static void main(String[] args) {
        System.out.println("----------------Test Case 1------------------");
        String s = "abbcc";
        System.out.println("Is Permutation Palindrome ? "+isPermutationPalindrome(s));
        System.out.println();

        System.out.println("----------------Test Case 2------------------");
        s = "abbccd";
        System.out.println("Is Permutation Palindrome ? "+isPermutationPalindrome(s));
        System.out.println();

        System.out.println("----------------Test Case 3------------------");
        s = "";
        System.out.println("Is Permutation Palindrome ? "+isPermutationPalindrome(s));
        System.out.println();

        System.out.println("----------------Test Case 4------------------");
        s = "abbccbbddd";
        System.out.println("Is Permutation Palindrome ? "+isPermutationPalindrome(s));
        System.out.println();

        System.out.println("----------------Test Case 5------------------");
        s = "starters";
        System.out.println("Is Permutation Palindrome ? "+isPermutationPalindrome(s));
        System.out.println();

    }


    public static boolean isPermutationPalindrome(String s){
        int count = 0;
        int [] frequency = new int [26];
        char [] chArr = s.toCharArray();
        for(int i = 0 ; i < chArr.length ; i++){
            frequency[chArr[i]-'a']++;
        }
        for(int i = 0 ; i < 26 ; i++){
            count = frequency[i] % 2 == 0 ? count : count+1;
        }

        return count <= 1;
    }
}
