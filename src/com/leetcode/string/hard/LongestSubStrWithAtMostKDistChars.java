package com.leetcode.string.hard;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStrWithAtMostKDistChars {
    public static void main(String[] args) {
        System.out.println("------------Test Case 1-----------------");
        String s = "eceba";
        int k = 2;
        System.out.println("Length of Longest Substring K Distinct Char of Str "+s+" is = "+lengthOfLongestSubstringDistinctK(s,k));
        System.out.println();

        System.out.println("------------Test Case 2-----------------");
        s = "aa";
        k = 1;
        System.out.println("Length of Longest Substring K Distinct Char of Str "+s+" is = "+lengthOfLongestSubstringDistinctK(s,k));
        System.out.println();
    }

    public static int lengthOfLongestSubstringDistinctK(String s , int k){
        if(s == null || s.length() == 0) return 0;
        int maxLen = 0;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        int low = 0;
        int high = 0;
        int len = s.length();
        char [] ch = s.toCharArray();
        for (high = 0 ; high < len ; high++){
            char c = ch[high];
            map.put(c, map.getOrDefault(c,0) + 1);
            while (map.size() > k){
                if(low <= high && map.get(ch[low]) > 0){
                    map.put(ch[low] , map.get(ch[low]) - 1);
                }

                if(map.get(ch[low]) == 0){
                    map.remove(ch[low]);
                }
                low++;
            }
            maxLen = Math.max(maxLen , high - low + 1);
        }


        return maxLen;
    }
}
