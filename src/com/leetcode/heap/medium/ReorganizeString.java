package com.leetcode.heap.medium;

import com.sun.deploy.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {
    public static void main(String[] args) {
        System.out.println("-----------------Test Case 1-----------------");
        String s = "aab";
        System.out.println("Original String "+ s +" Reorganized String = "+reorganizeString(s));
        System.out.println();

        System.out.println("-----------------Test Case 2-----------------");
        s = "aaab";
        System.out.println("Original String "+ s +" Reorganized String = "+reorganizeString(s));
        System.out.println();

        System.out.println("-----------------Test Case 3-----------------");
        s = "aaabbb";
        System.out.println("Original String "+ s +" Reorganized String = "+reorganizeString(s));
        System.out.println();

        System.out.println("-----------------Test Case 4-----------------");
        s = "aaabbcbb";
        System.out.println("Original String "+ s +" Reorganized String = "+reorganizeString(s));
        System.out.println();
    }

    public static String reorganizeString(String s) {
        Map<Character , Integer> countMap = new HashMap<>();
        for(char ch : s.toCharArray()){
            countMap.put(ch  , countMap.getOrDefault(ch , 0) + 1);
        }
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> countMap.get(b) - countMap.get(a));
        maxHeap.addAll(countMap.keySet());
        StringBuilder sb = new StringBuilder();
        while (maxHeap.size() > 1){
            char current = maxHeap.poll();
            char next = maxHeap.poll();
            sb.append(current);
            sb.append(next);
            countMap.put(current , countMap.get(current) -1);
            countMap.put(next , countMap.get(next) -1);
            if(countMap.get(current) > 0)
                maxHeap.add(current);
            if(countMap.get(next) > 0)
                maxHeap.add(next);
        }

        while(!maxHeap.isEmpty()){
            char lastChar = maxHeap.poll();
            if(countMap.get(lastChar) > 1)
                return "";
            sb.append(lastChar);
        }

        return sb.toString();
    }
}
