package com.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class AmbiguousCoordinates {

	public static void main(String[] args) {
		String s = "(123)";
		List <String> result = ambiguousCoordinates(s);
		result.forEach(System.out:: println);
		System.out.println();
		System.out.println();
		
		result.clear();
		s = "(100)";
		result = ambiguousCoordinates(s);
		result.forEach(System.out:: println);
		
		
		

	}
	
	 public static List<String> ambiguousCoordinates(String s) {
	        List<String> result = new ArrayList<String>();
	        
	        for(int i = 2; i < s.length() -1 ; i++) {
	        	for(String left : placeDecimal(s, 1, i)) {
	        		for(String right : placeDecimal(s, i, s.length() -1)) {
	        			result.add("("+ left + ", " + right + ")");
	        		}
	        	}
	        }
	        
	        return result;
	    }
	 
	 
	 private static List<String> placeDecimal (String s , int i , int j){
		 List<String> list = new ArrayList<String>();
		 
		 for(int d = 1; d <= j - i ; d++ ) {
			 String left = s.substring(i , i+ d);
			 String right = s.substring(i+d ,  j);
			 if((!left.startsWith("0") || left.equals("0")) && !right.endsWith("0")) {
				 list.add(left+ (d < j -i ? "." : "") + right);
			 }
			 
		 }
		 
		 return list;
	 }

}
