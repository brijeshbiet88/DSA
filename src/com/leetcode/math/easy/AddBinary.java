package com.leetcode.math.easy;

public class AddBinary {

	public static void main(String[] args) {
		String a = "1011" , b = "1110";
		System.out.println(" Addition of "+a+" and "+b+" = "+addBinary(a, b));
		System.out.println();
	}

	  public static String addBinary(String a, String b) {
	         StringBuilder result = new StringBuilder();
			int i = a.length() - 1;
			int j = b.length() -1 ;
			int carry = 0;
			int sum = 0;
			while(i >= 0 || j >= 0) {
				sum = carry;
				if(i >= 0)
				sum += a.charAt(i--)-'0';
				if(j >= 0)
				sum += b.charAt(j--)-'0';
				result.append(sum%2);
				carry = sum/2;
			}
			if(carry != 0)
				result.append(carry);
			
			return result.reverse().toString();
	    }
}
