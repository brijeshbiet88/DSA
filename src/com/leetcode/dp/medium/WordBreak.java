package com.leetcode.dp.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {

	public static void main(String[] args) {
		System.out.println("-----------------Test Case 1--------------------");
		String s = "applepenapple";
		List<String> wordDict = new ArrayList<String>();
		wordDict.add("apple");
		wordDict.add("pen");
		System.out.println(" Can Word be Broken ? "+wordBreak(s, wordDict));
		System.out.println();
		
		
		System.out.println("-----------------Test Case 2--------------------");
		s = "catsandog";
		wordDict.clear();
		wordDict.add("cats");
		wordDict.add("sand");
		wordDict.add("and");
		wordDict.add("dog");
		System.out.println(" Can Word be Broken ? "+wordBreak(s, wordDict));
		System.out.println();
	}
	
	static Map<String , Boolean> map = new HashMap();
	
	public static boolean wordBreak(String s, List<String> wordDict) {
       if(wordDict.contains(s))
    	   return true;
       if(map.containsKey(s))
    	   return map.get(s);
       for(int i = 1 ; i <= s.length() ; i++) {
    	   String left = s.substring(0 , i);
    	   if(wordDict.contains(left) && wordBreak(s.substring(i), wordDict)) {
    		   map.put(s, true);
    		   return true;
    	   }
       }
       map.put(s, false);
       return false;
    }

}
