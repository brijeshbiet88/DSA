package com.leetcode.slidingwindow.misc;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        MinimumWindowSubstring minWindow = new MinimumWindowSubstring();
        System.out.println("--------------------Test Case 1----------------------");
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("Min Window Sub String = "+minWindow.minWindow(s,t));
        System.out.println();

        System.out.println("--------------------Test Case 2----------------------");
        s = "TESTADOBECODEBANC";
        t = "ABC";
        System.out.println("Min Window Sub String = "+minWindow.minWindow(s,t));
        System.out.println();
    }

    public String minWindow(String s, String t) {
        int[] freq = new int[128];
        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        int low = 0, high = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();

        char [] chArr = s.toCharArray();
        int len = s.length();
        while (high < len) {
            char ch = chArr[high];
            if (freq[ch] > 0) {
                counter--;
            }
            freq[ch]--;
            high++;

            while (counter == 0) {
                if (minLen > high - low) {
                    minLen = high - low;
                    minStart = low;
                }

                char ch2 = chArr[low];
                freq[ch2]++;
                if (freq[ch2] > 0) counter++;
                low++;
            }

        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
