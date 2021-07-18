package com.leetcode.string.easy;

public class StringAddition {

	public static void main(String[] args) {
		System.out.println("-----------------Test Case 1----------------------");
		String num1 = "1457" , num2 = "344";
		System.out.println("String Addition = "+addStrings(num1, num2));
		System.out.println();
		
		System.out.println("-----------------Test Case 2----------------------");
		num1 = "456" ;
		num2 = "77";
		System.out.println("String Addition = "+addStrings(num1, num2));
		System.out.println();

	}
	
	  public static String addStrings(String num1, String num2) {
	        StringBuilder addition = new StringBuilder();

	        int carry = 0;
	        int digit1 = num1.length() - 1;
	        int digit2 = num2.length() - 1;
	        while (digit1 >= 0 || digit2 >= 0) {
	            int x1 = digit1 >= 0 ? num1.charAt(digit1) - '0' : 0;
	            int x2 = digit2 >= 0 ? num2.charAt(digit2) - '0' : 0;
	            int value = (x1 + x2 + carry) % 10;
	            carry = (x1 + x2 + carry) / 10;
	            addition.append(value);
	            digit1--;
	            digit2--;    
	        }
	        
	        if (carry != 0)
	            addition.append(carry);
	        
	        return addition.reverse().toString();
	    }

}
