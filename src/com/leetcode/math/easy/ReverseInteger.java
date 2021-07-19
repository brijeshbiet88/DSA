package com.leetcode.math.easy;

public class ReverseInteger {

	public static void main(String[] args) {
		int x = 123;
		System.out.println("Reverse of "+x+" is "+reverse(x));
		
		x = -145;
		System.out.println("Reverse of "+x+" is "+reverse(x));
	}

	public static int reverse(int x) {

		int rev = 0 , rem =0;
		while(x != 0) {
			rem = x % 10;
			x = x/10;
			if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && rem > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && rem < -8)) return 0;
			rev = rev *10 + rem;
		}
		
		return rev;
	}
}
