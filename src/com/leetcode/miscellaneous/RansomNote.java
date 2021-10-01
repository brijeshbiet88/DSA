package com.leetcode.miscellaneous;

public class RansomNote {
    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aba";
        System.out.println("Can be Constructed ? "+canConstruct(ransomNote , magazine));

    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int [] fequency = new int[26];

        for(char ch : magazine.toCharArray())
            fequency[ch-'a']++;

        for(char ch : ransomNote.toCharArray())
        {
            if(fequency[ch-'a'] == 0)
                return false;
            fequency[ch-'a']--;
        }
        return true;
    }
}
