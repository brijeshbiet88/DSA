package com.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAndReplacePattern {

	public static void main(String[] args) {
		System.out.println("-------------------Test Case 1-------------------");
		String[] words = { "abc", "deq", "mee", "aqq", "dkd", "ccc" };
		String pattern = "abb";
		List<String> matchingPattern = findAndReplacePattern(words, pattern);
		System.out.println("Print All Matching Pattern With Pattern: " + pattern);
		matchingPattern.forEach(System.out::println);

		System.out.println();
		System.out.println();
		matchingPattern.clear();
		
		
		System.out.println("-------------------Test Case 2-------------------");
		String[] words2 = { "a", "b", "c" };
	    pattern = "a";
		matchingPattern = findAndReplacePattern(words2, pattern);
		System.out.println("Print All Matching Pattern With Pattern: " + pattern);
		matchingPattern.forEach(System.out::println);

		System.out.println();
		System.out.println();

	}

	public static List<String> findAndReplacePattern(String[] words, String pattern) {
		List<String> matchingPattern = new ArrayList<String>();
		Map<Character, Character> bijection = new HashMap<Character, Character>();
		Map<Character, Character> revBijection = new HashMap<Character, Character>();
		for (String word : words) {
			if (pattern.length() == word.length()) {
				addIfMatchingPattern(bijection, revBijection, matchingPattern, word, pattern);

			}
			bijection.clear();
			revBijection.clear();

		}

		return matchingPattern;

	}

	private static void addIfMatchingPattern(Map<Character, Character> map, Map<Character, Character> revMap,
			List<String> matchingPattern, String word, String pattern) {

		int i = 0;
		int count = 0;
		while (i < pattern.length()) {

			if (map.get(pattern.charAt(i)) != null) {

				if (map.get(pattern.charAt(i)) == word.charAt(i) && revMap.get(word.charAt(i)) == pattern.charAt(i)) {
					count++;
				}

			}

			else if (revMap.get(word.charAt(i)) == null) {

				map.put(pattern.charAt(i), word.charAt(i));
				revMap.put(word.charAt(i), pattern.charAt(i));
				count++;
			}
			i++;
		}
		if (count == pattern.length())
			matchingPattern.add(word);
	}

}
