package com.leetcode.miscellaneous;

public class NumbersAtMostNGivenDigitSet {
    public static void main(String[] args) {
        NumbersAtMostNGivenDigitSet o = new NumbersAtMostNGivenDigitSet();
        System.out.println("------------------Test Case 1-----------------");
        String [] digits1 = {"1", "3", "5","7"};
        int n = 100;
        System.out.println("Total Nums = "+o.atMostNGivenDigitSet(digits1 , n));
        System.out.println();
    }

    public int atMostNGivenDigitSet(String[] digits, int n) {
        String numString = String.valueOf(n);
        int numLength = numString.length();
        int noOfDigits = digits.length;

        int result = 0;
        
        for(int i = 1; i < numLength ; i++){
            result += Math.pow(noOfDigits, i);
        }

        for(int i = 0 ; i < numLength ; i++){
            boolean containsSameNumber = false;
            for(String digit : digits) {
                if(digit.charAt(0) < numString.charAt(i)){
                    result += Math.pow(noOfDigits, numLength - i -1);
                } else if(digit.charAt(0) == numString.charAt(i)){
                    containsSameNumber = true;
                    if(i == numLength -1){
                        result++;
                    }
                }
            }
            if(!containsSameNumber){
                return result;
            }

        }

        return result;

    }
}
