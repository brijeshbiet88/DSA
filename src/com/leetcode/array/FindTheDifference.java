package com.leetcode.array;

public class FindTheDifference {

	public static void main(String[] args) {
		String s = "abcd", t = "abcde";
		System.out.println("Difference : "+findTheDifference(s, t));

	}
	
	public static char findTheDifference(String s, String t) {

		int diff = 0;

		for (int i = 0; i < t.length(); i++) {
			diff += t.charAt(i);
		}

		for (int i = 0; i < s.length(); i++) {
			diff -= s.charAt(i);
		}

		return (char) diff;
	}

}
