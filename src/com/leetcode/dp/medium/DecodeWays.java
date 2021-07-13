package com.leetcode.dp.medium;


public class DecodeWays {

	public static void main(String[] args) {
		System.out.println();
		String s = "212121";
		System.out.println(" No of Decoding Ways = " + numDecodings(s));
		System.out.println();
		
		System.out.println();
		s = "10";
		System.out.println(" No of Decoding Ways = " + numDecodings(s));
		System.out.println();
		
		System.out.println();
		s = "2101";
		System.out.println(" No of Decoding Ways = " + numDecodings(s));
		System.out.println();
		
		System.out.println();
		s = "101";
		System.out.println(" No of Decoding Ways = " + numDecodings(s));
		System.out.println();
	}

	public static int numDecodings(String s) {
		int [] dp = new int [s.length() + 1];
		
		dp[0] = 1;
		dp[1] = s.charAt(0) == '0' ? 0 : 1;
		
		for(int i = 2 ; i <= s.length() ; i++) {
			
			int oneDigit = Integer.valueOf(s.substring(i-1 , i));
			int twoDigit = Integer.valueOf(s.substring(i-2 , i));
			
			if(oneDigit >= 1)
				dp[i] += dp[i-1];
			
			if(twoDigit >= 10 && twoDigit <= 26)
				dp[i] += dp[i-2];
		}
		
		return dp[s.length()];
	}

}
