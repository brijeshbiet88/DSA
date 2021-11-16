package com.leetcode.miscellaneous;

public class MinRemoveToMakeValidParenthesis {
    public static void main(String[] args) {
        System.out.println("------------Test case 1---------------");
        String s = "lee(t(c)o)de)";
        System.out.println("Result  = "+minRemoveToMakeValid(s));
        System.out.println();

        System.out.println("------------Test case 2---------------");
        s = "a)b(c)d";
        System.out.println("Result  = "+minRemoveToMakeValid(s));
        System.out.println();

        System.out.println("------------Test case 3---------------");
        s = "))((";
        System.out.println("Result  = "+minRemoveToMakeValid(s));
        System.out.println();

        System.out.println("------------Test case 4---------------");
        s = "(a(b(c)d)";
        System.out.println("Result  = "+minRemoveToMakeValid(s));
        System.out.println();

        System.out.println("------------Test case 5---------------");
        s = "a)b(c)d))((";
        System.out.println("Result  = "+minRemoveToMakeValid(s));
        System.out.println();

    }

    public static String minRemoveToMakeValid(String s) {
        int open = 0;
        char ch[] = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(') {
                open++;
            } else if (ch[i] == ')') {
                if (open == 0) {
                    ch[i] = '*';
                } else {
                    open--;
                }
            }
        }

        for (int i = ch.length - 1; i >= 0 && open > 0; i--) {
            if (ch[i] == '(') {
                ch[i] = '*';
                open--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] != '*') {
                sb.append(ch[i]);
            }
        }

        return sb.toString();
    }
}

