package com.leetcode.string.easy;

public class ImplementStrstr {

	public static void main(String[] args) {
		String haystack = "hello" , needle = "ll";
		System.out.println("First occurence of needle in haystack = "+strStr(haystack, needle));

	}
	
	 public static int strStr(String haystack, String needle){
		    if (needle.isEmpty()) return 0;
		    
			int hslen = haystack.length();
		    int nlen  = needle.length();

		    for (int i = 0; i < hslen - nlen + 1; i++) {
		        if (haystack.substring(i, nlen + i).equals(needle))
		            return i;
		    }

		    return -1;
		}

}
