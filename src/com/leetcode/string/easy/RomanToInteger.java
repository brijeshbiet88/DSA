package com.leetcode.string.easy;

public class RomanToInteger {

	public static void main(String[] args) {
		System.out.println("-------------Test Case 1------------------");
		String s = "MCMXCIV";
		System.out.println("Decimal of Roman "+s+" is "+romanToInt(s));
		System.out.println();
		
		System.out.println("-------------Test Case 2------------------");
		s = "LIV";
		System.out.println("Decimal of Roman "+s+" is "+romanToInt(s));
		System.out.println();

	}
	
	public static int romanToInt(String s) {

		int decimal = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);

			switch (c) {

			case 'I':
				decimal += (decimal >= 5 ? -1 : 1);
				break;

			case 'V':
				decimal += 5;
				break;

			case 'X':
				decimal += (decimal >= 50 ? -10 : 10);
				break;

			case 'L':
				decimal += 50;
				break;

			case 'C':
				decimal += (decimal >= 500 ? -100 : 100);
				break;

			case 'D':
				decimal += 500;
				break;

			case 'M':
				decimal += 1000;
				break;

			}

		}

		return decimal;

	}

}
