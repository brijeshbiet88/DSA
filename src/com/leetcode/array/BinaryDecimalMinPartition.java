package com.leetcode.array;

public class BinaryDecimalMinPartition {

	public static void main(String[] args) {
		String num = "32";
		System.out.println("Min Partitions : "+minPartitions(num));

	}
	
	public static int minPartitions(String n) {
		int result = 0;
		
		char [] num = n.toCharArray();
		
		for(int i = 0 ; i < num.length ; i++) {
			result = Math.max(result, num[i]-'0');
		}
		
		return result ;
	}

}
