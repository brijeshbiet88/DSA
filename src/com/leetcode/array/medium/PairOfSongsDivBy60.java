package com.leetcode.array.medium;

import java.util.HashMap;
import java.util.Map;

public class PairOfSongsDivBy60 {

	public static void main(String[] args) {
		System.out.println("-------------Test Case 1 -------------------");
		int [] time = {30,20,150,100,40};
		System.out.println("Total No of Pairs of Songs With Total Duration Divisible By 60 = "+numPairsDivisibleBy60(time));
		System.out.println();
		
		System.out.println("-------------Test Case 2 -------------------");
		int [] time2 = {30,90,150,210};
		System.out.println("Total No of Pairs of Songs With Total Duration Divisible By 60 = "+numPairsDivisibleBy60(time2));
		System.out.println();
		
		System.out.println("-------------Test Case 3 -------------------");
		int [] time3 = {60,60 , 60};
		System.out.println("Total No of Pairs of Songs With Total Duration Divisible By 60 = "+numPairsDivisibleBy60(time3));
		System.out.println();
	}
	
	public static int numPairsDivisibleBy60(int[] time) {
		  int remainders[] = new int[60];
	        int count = 0;
	        for (int t: time) {
	            if (t % 60 == 0) { // check if a%60==0 && b%60==0
	                count += remainders[0];
	            } else { // check if a%60+b%60==60
	                count += remainders[60 - t % 60];
	            }
	            remainders[t % 60]++; // remember to update the remainders
	        }
	        return count;
	}

}
