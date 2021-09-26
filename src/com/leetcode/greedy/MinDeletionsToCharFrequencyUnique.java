package com.leetcode.greedy;

import java.util.HashSet;
import java.util.Set;

public class MinDeletionsToCharFrequencyUnique {
    public static void main(String[] args) {
        System.out.println("------------------Test Case 1----------------------");
        String s = "aaabbbcc";
        System.out.println("Min Deletions To Make Frequency Unique = "+minDeletions(s));
        System.out.println();
    }

    public static int minDeletions(String s) {
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
        }

        int res = 0;
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < count.length ; i++){
            while(count[i] > 0 && set.contains(count[i])){
                count[i]--;
                res++;
            }
            set.add(count[i]);

        }
        return res;
    }
}
