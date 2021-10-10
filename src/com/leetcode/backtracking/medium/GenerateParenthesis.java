package com.leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        System.out.println("----------------Test Case 1-------------------");
        int n = 3;
        List<String> result = generateParenthesis(n);
        System.out.println("Print Parenthesis For n = "+n);
        result.forEach(s-> System.out.print(s+" , "));
        result.clear();
        System.out.println();

        System.out.println("----------------Test Case 2-------------------");
        n = 1;
        result = generateParenthesis(n);
        System.out.println("Print Parenthesis For n = "+n);
        result.forEach(s-> System.out.print(s+" , "));
        result.clear();
        System.out.println();

        System.out.println("----------------Test Case 3-------------------");
        n = 4;
        result = generateParenthesis(n);
        System.out.println("Print Parenthesis For n = "+n);
        result.forEach(s-> System.out.print(s+" , "));
        result.clear();
        System.out.println();
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        backTrack(result , "" , 0 , 0 , n);
        return result;
    }

    public static void backTrack(List<String> result , String s , int open , int close , int n){

        if(open > n || close > open)
            return;

        if(open == n && close == n){
            result.add(s);
            return;
        }

        if(open < n){
            backTrack(result , s+"(" , open + 1,close , n);
        }

        if(close < n){
            backTrack(result , s+")" , open,close + 1 , n);
        }


    }
}
