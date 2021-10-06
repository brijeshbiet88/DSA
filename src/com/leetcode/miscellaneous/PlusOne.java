package com.leetcode.miscellaneous;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        System.out.println("-----------------Test Case 1-----------------");
        int [] digits = {8 , 9 , 9 , 9};
        plusOne(digits);

        System.out.println("Print Array");
        for (int num : digits)
            System.out.print(num);
        System.out.println();

        System.out.println("-----------------Test Case 2-----------------");
        int [] digits2 = {1 ,2 , 3 , 4};
        plusOne(digits2);
        System.out.println("Print Array");
        for (int num : digits2)
            System.out.print(num);
        System.out.println();

        System.out.println("-----------------Test Case 3-----------------");
        int [] digits3 = {9 , 9};
        int [] result = plusOne(digits3);
        System.out.println("Print Array");
        for (int num : result)
            System.out.print(num);
        System.out.println();

    }

    public static int[] plusOne(int[] digits) {
        int lastNon9Digit = -1;
        int len = digits.length;
        for(int i = 0 ; i < len ; i++){
            if(digits[i] != 9){
                lastNon9Digit = i;
            }
        }
        int [] result = null;
        if(lastNon9Digit == -1){
            result = new int[len+1];
            Arrays.fill(result , 0);
            result[0] = 1;
            return result;
        }

        digits[lastNon9Digit] = digits[lastNon9Digit] + 1;

        for(int i = lastNon9Digit +1 ; i < len ; i++){
            digits[i] = 0;
        }

        return digits;
    }
}
