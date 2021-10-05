package com.leetcode.miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class MaxConcatenateStr {
    public static void main(String[] args) {
        System.out.println("----------------Test Case 1------------------");
        List<String> arr = new ArrayList<>();
        arr.add("un");arr.add("iq");arr.add("ue");
        int maxLenUniqueChar = maxLength(arr);
        System.out.println("Max Length of Concatenated String with Unique Charcaters = "+maxLenUniqueChar);
        System.out.println();
    }
    public static int maxLength(List<String> arr) {
        List<String> result = new ArrayList<>();
        result.add("");
        for (String str : arr) {
            if (!isUnique(str))
                continue;
            List<String> tempList = new ArrayList<>();
            for (String s : result) {
                String temp = s + str;
                if (isUnique(temp))
                    tempList.add(temp);
            }
            result.addAll(tempList);
        }
        int maxLength = 0;
        for (String str : result)
            maxLength = Math.max(maxLength, str.length());
        return maxLength;
    }

    public static boolean isUnique(String str) {
        if (str.length() > 26)
            return false;

        boolean[] usedChar = new  boolean [26];
        char[] arr = str.toCharArray();
        for (char ch : arr) {
            if (usedChar[ch - 'a']){
                return false;
            } else {
                usedChar[ch -'a'] = true;
            }
        }
        return true;
    }
}
