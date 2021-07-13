package com.leetcode.dp.medium;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

	public static void main(String[] args) {
		System.out.println();
		String s = "123";
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
		
		System.out.println();
		s = "2021";
		System.out.println(" No of Decoding Ways = " + numDecodings2(s));
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
	
	public static int numDecodings2(String s) {
		return decodeWaysHelper(s , 0); 
	}

	static Map <Integer , Integer> map = new HashMap();
	private static int decodeWaysHelper(String s, int i) {

		
		if (i >= s.length())
			return 1;

		if (s.charAt(i) == '0')
			return 0;
		
		if(map.containsKey(i))
			return map.get(i);

		int ways = decodeWaysHelper(s, i + 1);
			if (i + 2 <= s.length() && Integer.parseInt(s.substring(i, i + 2)) <= 26) {
				ways += decodeWaysHelper(s, i + 2);
			}

		map.put(i, ways);	
		return ways;
	}

}
