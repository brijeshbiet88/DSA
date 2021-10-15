package com.leetcode.backtracking.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak2 {
   static Map<String , List<String>> map = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("---------------Test Case 1-----------------");
        String s = "catsandcannot";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("can");
        wordDict.add("not");
        wordDict.add("cannot");
        List<String> result = wordBreak(s , wordDict);
        System.out.println("Print Results :");
        result.forEach(System.out::println);
        System.out.println();
    }


    public static List<String> wordBreak(String s, List<String> wordDict) {
        if(map.containsKey(s))
            return map.get(s);

        List<String> result = new ArrayList<String>();
        if(wordDict.contains(s)){
            result.add(s);
        }


        for(int i = 1 ; i <= s.length() ; i++){
            String left = s.substring(0,i);
            if(wordDict.contains(left)){
                List<String> nextList = wordBreak(s.substring(i) , wordDict);
                for(String word : nextList){
                    result.add(left+" "+word);
                }
            }
        }
        map.put(s,result);
        return result;
    }
}
