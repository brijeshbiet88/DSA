package com.leetcode.string.medium;

import java.util.List;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        System.out.println("--------------Test Case 1-------------------");
        String s = "   Hello   World  ";
        System.out.println("Result = "+reverseWords(s));
        System.out.println();

        System.out.println("--------------Test Case 2-------------------");
        s = "the sky is blue";
        System.out.println("Result = "+reverseWords(s));
        System.out.println();

        System.out.println("--------------Test Case 3-------------------");
        s = "  Bob    Loves  Alice   ";
        System.out.println("Result = "+reverseWords(s));
        System.out.println();

        System.out.println("--------------Test Case 4-------------------");
        s = "Alice does not even like bob";
        System.out.println("Result = "+reverseWords(s));
        System.out.println();

        System.out.println("--------------Test Case 5-------------------");
        s = "a good   example";
        System.out.println("Result = "+reverseWords(s));
        System.out.println();
    }

    public static String reverseWords(String s) {
        String [] strArr = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i = strArr.length -1 ; i >= 0 ; i--){
            if(strArr[i].trim().length() > 0){
                sb.append(strArr[i].trim());
                sb.append(" ");
            }
        }

        return sb.toString().trim();
    }
}
