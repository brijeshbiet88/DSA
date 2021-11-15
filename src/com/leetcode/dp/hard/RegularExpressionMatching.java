package com.leetcode.dp.hard;

public class RegularExpressionMatching {
    public static void main(String[] args) {
        System.out.println("-------------Test Case 1------------------");
        String s = "aa";
        String p = "a";
        System.out.println("Is Pattern "+p+" matching with String "+s+" ? "+isMatch(s,p));
        System.out.println();

        System.out.println("-------------Test Case 2------------------");
        s = "aa";
        p = "a*";
        System.out.println("Is Pattern "+p+" matching with String "+s+" ? "+isMatch(s,p));
        System.out.println();

        System.out.println("-------------Test Case 3------------------");
        s = "aab";
        p = "c*a*b";
        System.out.println("Is Pattern "+p+" matching with String "+s+" ? "+isMatch(s,p));
        System.out.println();

        System.out.println("-------------Test Case 4------------------");
        s = "mississippi";
        p = "mis*is*p*.";
        System.out.println("Is Pattern "+p+" matching with String "+s+" ? "+isMatch(s,p));
        System.out.println();

        System.out.println("-------------Test Case 3------------------");
        s = "aab";
        p = "c*a*b";
        System.out.println("Is Pattern "+p+" matching with String "+s+" ? "+isMatch(s,p));
        System.out.println();
    }

    public static boolean isMatch(String s, String p) {
        char [] text = s.toCharArray();
        char [] pattern = p.toCharArray();
        boolean T[][] = new boolean[text.length + 1][pattern.length + 1];

        T[0][0] = true;

        for (int i = 1; i < T[0].length; i++) {
            if (pattern[i-1] == '*') {
                T[0][i] = T[0][i - 2];
            }
        }

        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                if (pattern[j - 1] == '.' || pattern[j - 1] == text[i - 1]) {
                    T[i][j] = T[i-1][j-1];
                } else if (pattern[j - 1] == '*')  {
                    T[i][j] = T[i][j - 2];
                    if (pattern[j-2] == '.' || pattern[j - 2] == text[i - 1]) {
                        T[i][j] = T[i][j] | T[i - 1][j];
                    }
                } else {
                    T[i][j] = false;
                }
            }
        }
        return T[text.length][pattern.length];
    }
}
