package com.leetcode.stack.medium;

import java.util.Stack;

public class BasicCalculator2 {
    public static void main(String[] args) {
        System.out.println("----------Test Case 1---------------");
        String s = "2 + 3 - 6 * 4";
        System.out.println("Result = "+calculate(s));
        System.out.println();

        System.out.println("----------Test Case 2---------------");
        s = "2+4/2-6*2/12 ";
        System.out.println("Result = "+calculate(s));
        System.out.println();

        System.out.println("----------Test Case 3---------------");
        s = "6/3*2+1";
        System.out.println("Result = "+calculate(s));
        System.out.println();

        System.out.println("----------Test Case 4---------------");
        s = "-2 + 8 + 4";
        System.out.println("Result = "+calculate2(s));
        System.out.println();

        System.out.println("----------Test Case 5---------------");
        s = "1/2*6-3*1+90";
        System.out.println("Result = "+calculate2(s));
        System.out.println();
    }

    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();

        char prevSign = '+';
        int no = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                no = no*10  + (c-'0');
            }

            if(isOperator(c) || i ==s.length()-1){
                if(prevSign == '+'){
                    stack.push(no);
                } else if(prevSign == '-'){
                    stack.push(-no);
                } else if(prevSign =='*'){
                    int top = stack.pop();

                    stack.push(top * no);

                } else if(prevSign =='/'){
                    int top = stack.pop();
                    stack.push(top/no);
                }
                no =0;
                prevSign =c;
            }
        }

        int res = 0;
        while(!stack.empty()){
            res += stack.pop();
        }
        return res;
    }

    private static boolean isOperator(char c){
        return c=='+' || c=='-'|| c=='/' || c=='*';
    }

    public  static int calculate2(String s) {
        if (s == null || s.isEmpty()) return 0;
        int length = s.length();
        int currentNumber = 0, lastNumber = 0, result = 0;
        char operation = '+';
        for (int i = 0; i < length; i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }
            if ("+-*/".indexOf(currentChar) != -1  || i == length - 1) {
                if (operation == '+' || operation == '-') {
                    result += lastNumber;
                    lastNumber = (operation == '+') ? currentNumber : -currentNumber;
                } else if (operation == '*') {
                    lastNumber = lastNumber * currentNumber;
                } else if (operation == '/') {
                    lastNumber = lastNumber / currentNumber;
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }
        result += lastNumber;
        return result;
    }
}
