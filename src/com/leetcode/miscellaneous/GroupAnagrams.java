package com.leetcode.miscellaneous;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println("--------------Test Case 1----------------");
        String [] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = groupAnagrams(strs);
        System.out.println("Print Anagrams : ");
        result.forEach(list->{
            list.forEach(s-> System.out.print(s+" "));
            System.out.println();
        });
        System.out.println();

        System.out.println("--------------Test Case 2----------------");
        String [] strs2= {"ddddddddddg","dgggggggggg"};
        List<List<String>> result2 = groupAnagrams(strs2);
        System.out.println("Print Anagrams : ");
        result2.forEach(list->{
            list.forEach(s-> System.out.print(s+" "));
            System.out.println();
        });
        System.out.println();

    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        char [] charArr = new char[26];
        Map<String , ArrayList<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for(String str : strs){

            char [] letter = str.toCharArray();
            Arrays.sort(letter);
            String word = new String(letter);
            if(map.get(word) == null){
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(word , list);
            }else {
                map.get(word.toString()).add(str);
            }

        }

        map.forEach((k,v)->{
            result.add(v);
        });

        return result;
    }

}
