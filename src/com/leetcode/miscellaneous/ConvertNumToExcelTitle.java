package com.leetcode.miscellaneous;

public class ConvertNumToExcelTitle {
    public static void main(String[] args) {
        System.out.println("-------------------Test Case 1-------------------");
        int num = 26;
        System.out.println("Conversion of Num "+num+" to excel = "+convertToTitle(num));
        System.out.println();

        System.out.println("-------------------Test Case 2-------------------");
        num = 2147483647;
        System.out.println("Conversion of Num "+num+" to excel = "+convertToTitle(num));
        System.out.println();

        System.out.println("-------------------Test Case 3-------------------");
        num = 1;
        System.out.println("Conversion of Num "+num+" to excel = "+convertToTitle(num));
        System.out.println();

        System.out.println("-------------------Test Case 4-------------------");
        num = 28;
        System.out.println("Conversion of Num "+num+" to excel = "+convertToTitle(num));
        System.out.println();

        System.out.println("-------------------Test Case 5-------------------");
        num = 701;
        System.out.println("Conversion of Num "+num+" to excel = "+convertToTitle(num));
        System.out.println();
    }

    public static String convertToTitle(int columnNumber) {

        int num = columnNumber;
        StringBuilder sb = new StringBuilder();
        while(num > 0) {
            int rem = (num - 1) % 26;
            num = (num -1) /26;
            sb.append((char)('A'+ rem));
        }
        return sb.reverse().toString();
    }
}
