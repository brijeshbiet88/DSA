package com.leetcode.dp.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak2 {

	public static void main(String[] args) {
		System.out.println("-------------Test Case 1------------------");
		String s = "catsanddog";
		List <String> wordDict = new ArrayList<String>();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");
		List<String> list = wordBreak(s, wordDict);
		System.out.println("print Words ");
		for(String str : list) {
			System.out.println(str);
		}
		
		System.out.println();

	}

	public static List<String> wordBreak(String s, List<String> wordDict) {

		ArrayList<String> result = new ArrayList<String>();
		Map<String, List<String>> map = new HashMap();

		if (wordDict.contains(s)) {
			result.add(s);
		}

		if (map.containsKey(s))
			return map.get(s);

		for (int i = 1; i <= s.length(); i++) {
			String left = s.substring(0, i);

			if (wordDict.contains(left)) {
				List<String> subList = wordBreak(s.substring(i), wordDict);

				for (String subListStr : subList) {
					result.add(left + " " + subListStr);
				}
			}
		}
		map.put(s, result);
		return result;

	}

}
