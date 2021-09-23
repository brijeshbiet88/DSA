package com.leetcode.greedy;

import java.util.Stack;

public class RemoveKDigits {
    public static void main(String[] args) {
        System.out.println("--------------Test Case 1--------------------");
        String num =  "1432219";
        int k = 3;
        System.out.println("Result = "+removeKdigits(num , k));
        System.out.println();

        System.out.println("--------------Test Case 1--------------------");
        num =  "10200";
        k = 1;
        System.out.println("Result = "+removeKdigits2(num , k));
        System.out.println();

    }

    public static String removeKdigits2(String num, int k) {
        int digits = num.length() - k;
        if (num.length() <= k) return "0";
        int top = -1, start = 0;
        char[] st = num.toCharArray();
        for (int i = 0; i < st.length; i++) {
            while (top >= 0 && st[top] > st[i] && k > 0) {
                top--;
                k--;
            }
            top++;
            st[top] = st[i];
        }
        while (start <= top && st[start] == '0') start++;

        String ans = "";
        for(int i = start; i <digits; i++)
            ans = ans + st[i];

        if(ans.equals("")) return "0";
        return ans;
    }

    public static String removeKdigits(String num, int k) {
        int n = num.length();
        Stack<Character> s = new Stack<>();

        for (char c : num.toCharArray()){

            while (!s.empty() && k > 0 && s.peek() > c){
                s.pop();
                k--;
            }

            if(!s.isEmpty() || c != '0')
                s.push(c);

        }

        while (!s.isEmpty() && k-- > 0){
            s.pop();
        }
        if(s.isEmpty()) return "0";
        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()){
            sb.append(s.pop());
        }

        return sb.reverse().toString();
    }
}
