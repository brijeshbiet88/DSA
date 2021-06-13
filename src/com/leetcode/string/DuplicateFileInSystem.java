package com.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DuplicateFileInSystem {

	public static void main(String[] args) {
		String [] paths = {"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"};
		List<List<String>> listOfList = findDuplicate(paths);
		System.out.println("Print All files With Same content");
		
		for(int i = 0 ; i < listOfList.size() ; i++) {
			List<String> list = listOfList.get(i);
			System.out.println();
			list.forEach(System.out:: println);
		}
	}

	public  static List<List<String>> findDuplicate(String[] paths) {
		Map<String , List<String>> map = new HashMap();
		
		for(String path : paths) {
			String [] tokens = path.split(" ");
			String dir = tokens[0];
			
			for(int i = 1 ; i < tokens.length ; i++) {
				int index = tokens[i].indexOf('(');
				String fileName = tokens[i].substring(0 , index);
				String content = tokens[i].substring(index + 1, tokens[i].length() -1 );
				map.computeIfAbsent(content, l -> new ArrayList()).add(dir+ "/" + fileName);
			}
		}
		return map.values().stream().filter(g -> g.size() > 1).collect(Collectors.toList());
    }
}
