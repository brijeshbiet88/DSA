package com.leetcode.stack.easy;

import java.util.Stack;

public class BackSpaceStringCompare {
    public static void main(String[] args) {
        System.out.println("--------------------Test Case 1---------------------");
        String s = "";
        String t = "";
        System.out.println("Are Strings "+s+" and "+t +" Equal ? "+backspaceCompare(s,t));
        System.out.println();
    }

    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = new Stack();
        Stack<Character> s2 = new Stack();

        char [] sChars = s.toCharArray();
        char [] tChars = t.toCharArray();
        for (int i = 0 ; i < sChars.length ; i++){
            if(sChars[i] == '#'){
                if(!s1.isEmpty())
                s1.pop();
            }else {
                s1.push(sChars[i]);
            }
        }

        for (int i = 0 ; i < tChars.length ; i++){
            if(tChars[i] == '#'){
                if(!s2.isEmpty())
                    s2.pop();
            }else {
                s2.push(tChars[i]);
            }
        }

        while (!s1.isEmpty() && !s2.isEmpty()){
            if(s1.pop() != s2.pop()){
                return false;
            }
        }

        if(s1.isEmpty() && s2.isEmpty())
            return  true;
        return false;
    }
}
