package com.leetcode.slidingwindow.misc;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstrMinKRepeatingChars {
    public static void main(String[] args) {
        System.out.println("-------------------Test Case 1-----------------------");
        String s = "ababbc";
        int k = 2;
        System.out.println("Longest Substring Length = "+longestSubstring(s,k));
        System.out.println();
    }

    public static int longestSubstring(String s, int k) {
        return helper(s, 0, s.length(), k);
    }

    public static int helper(String s, int left, int right, int k) {
        if (right < k) return 0;
        int[] countMap = new int[26];

        for (int i = left; i < right; i++)
            countMap[s.charAt(i) - 'a']++;
        for (int mid = left; mid < right; mid++) {
            if (countMap[s.charAt(mid) - 'a'] >= k) continue;
            int midNext = mid + 1;
            while (midNext < right && countMap[s.charAt(midNext) - 'a'] < k) midNext++;
            return Math.max(helper(s, left, mid, k),
                    helper(s, midNext, right, k));
        }
        return (right - left);
    }
}
