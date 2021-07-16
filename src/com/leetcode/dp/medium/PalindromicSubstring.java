package com.leetcode.dp.medium;

public class PalindromicSubstring {

	public static void main(String[] args) {
		System.out.println("------------------Test Case 1-------------------");
		String s = "aaba";
		System.out.println(" Number of Palindromes = "+ countSubstrings(s));
		System.out.println();
		
		System.out.println("------------------Test Case 2-------------------");
		s = "aaa";
		System.out.println(" Number of Palindromes = "+ countSubstrings(s));
		System.out.println();
	}

	public static int countSubstrings(String s) {
		int count = 0;
		
		for(int i = 0 ; i < s.length() ; i++) {
			count += countPalindromes( s , i , i) + countPalindromes(s, i, i+1);
		}
		
		return count ;
	}

	private static int countPalindromes(String s, int l, int r) {
		int count = 0;
		
		while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
			count++;
		}
		return count;
	}

}
