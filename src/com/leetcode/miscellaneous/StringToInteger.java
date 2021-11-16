package com.leetcode.miscellaneous;

public class StringToInteger {
    public static void main(String[] args) {
        System.out.println("-------------Test Case 1----------------");
        String s = " 342";
        int result = myAtoi(s);
        System.out.println("Integer of String "+s+" = "+result);
        System.out.println();

        System.out.println("-------------Test Case 2----------------");
        s = " 0032";
        result = myAtoi(s);
        System.out.println("Integer of String "+s+" = "+result);
        System.out.println();

        System.out.println("-------------Test Case 3----------------");
        s = "4193 with words";
        result = myAtoi(s);
        System.out.println("Integer of String "+s+" = "+result);
        System.out.println();

        System.out.println("-------------Test Case 4----------------");
        s = "words and 987";
        result = myAtoi(s);
        System.out.println("Integer of String "+s+" = "+result);
        System.out.println();

        System.out.println("-------------Test Case 5----------------");
        s = "-91283472332";
        result = myAtoi(s);
        System.out.println("Integer of String "+s+" = "+result);
        System.out.println();

        System.out.println("-------------Test Case 6----------------");
        s = "2147483648";
        result = myAtoi(s);
        System.out.println("Integer of String "+s+" = "+result);
        System.out.println();
    }

    public static int myAtoi(String str) {
        s = s.trim();
        int index = 0, sign = 1, total = 0, n = s.length();


        if (index < n && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            sign = s.charAt(index++) == '+' ? 1 : -1;
        }

        //3. Convert number and avoid overflow
        while (index < n) {
            int digit = s.charAt(index) - '0';
            if (digit < 0 || digit > 9) break;

            //check if total will be overflow after 10 times and add digit
            if (total > Integer.MAX_VALUE / 10 || total == Integer.MAX_VALUE / 10 && Integer.MAX_VALUE % 10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            total = 10 * total + digit;
            index++;
        }

        return sign * total;
    }
}
