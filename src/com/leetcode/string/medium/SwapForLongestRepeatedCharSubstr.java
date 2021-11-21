package com.leetcode.string.medium;

public class SwapForLongestRepeatedCharSubstr {
    public static void main(String[] args) {
        System.out.println("----------------Test Case 1-------------------");
        String s = "ababa";
        System.out.println("Longest Repeated Substring with one swap = "+maxRepOpt1(s));
        System.out.println();

        System.out.println("----------------Test Case 2-------------------");
        s = "aaabaaa";
        System.out.println("Longest Repeated Substring with one swap = "+maxRepOpt1(s));
        System.out.println();

        System.out.println("----------------Test Case 3-------------------");
        s = "aaabbaaa";
        System.out.println("Longest Repeated Substring with one swap = "+maxRepOpt1(s));
        System.out.println();

        System.out.println("----------------Test Case 4-------------------");
        s = "aaaaa";
        System.out.println("Longest Repeated Substring with one swap = "+maxRepOpt1(s));
        System.out.println();

        System.out.println("----------------Test Case 5-------------------");
        s = "abcdef";
        System.out.println("Longest Repeated Substring with one swap = "+maxRepOpt1(s));
        System.out.println();

    }

    public static int maxRepOpt1(String s) {
        int[] frequency = new int[26];
        char[] ch = s.toCharArray();
        for(int i = 0; i < ch.length; i++)
            frequency[ch[i]-'a']++;

        int max = 0;

        for(int i = 0; i < ch.length; i++){
            char curr = ch[i];
            int j = i, count = 0, diff = 0;
            while(j < ch.length && (curr == ch[j] || diff == 0) && count < frequency[curr-'a']){
                if(curr != ch[j])
                    diff++;

                    count++;
                    j++;
            }
            max = Math.max(max, count);
        }
        for(int i = ch.length-1; i >= 0; i--){
            char curr = ch[i];
            int j = i, count = 0, diff = 0;
            while(j >= 0 && (curr == ch[j] || diff == 0) && count < frequency[curr-'a']){
                if(curr != ch[j])
                    diff++;

                    count++;
                    j--;
            }
            max = Math.max(max, count);
        }
        return max;
    }

}
