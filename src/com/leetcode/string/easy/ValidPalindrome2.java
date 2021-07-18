package com.leetcode.string.easy;

public class ValidPalindrome2 {

	public static void main(String[] args) {
		String s = "aba";
		System.out.println("Is String "+ s +" Palindrome After Deleting At most 1 Character "+ validPalindrome(s));
		System.out.println();
		
		s = "abca";
		System.out.println("Is String "+ s +" Palindrome After Deleting At most 1 Character "+ validPalindrome(s));
		System.out.println();
		
		s = "abc";
		System.out.println("Is String "+ s +" Palindrome After Deleting At most 1 Character "+ validPalindrome(s));
		System.out.println();

	}

	
	public static boolean validPalindrome(String s) {
      
		
		if (s.length() <= 2) {
			return true;
		}
		int i = 0, j = s.length() - 1;
		while (i < j) {

			if (s.charAt(i) != s.charAt(j)) {
				if(isPalindrome(s.substring(i, j)) || isPalindrome(s.substring(i+1, j+1)) )
					return true;
				return false;
			}
			
			i++;
			j--;

		}
		return true;
	
    }
    private static boolean isPalindrome(String s) {
		int i = 0 , j = s.length() - 1;
		while(i < j) {
			if(s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}
