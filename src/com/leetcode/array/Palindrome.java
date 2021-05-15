package com.leetcode.array;

public class Palindrome {

	public static void main(String[] args) {
		int x = 1221;
		System.out.println(" Is 121 Palindrome: "+ isPalindrome(x));

	}
	
	 public static boolean isPalindrome(int x) {
		 
		 if(x < 0 || (x != 0 && x % 10 == 0 ) ) {
			 return false;
		 }
	        
		 int result = 0;
		 
		 while( x > result) {
			 result = result*10 + x % 10;
			 x = x /10;
		 }
		 
		 
		 return (x == result || result/10 == x );  
	 }

}
