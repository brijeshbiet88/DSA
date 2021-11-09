package com.leetcode.string.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharacterByFrequency {
    public static void main(String[] args) {
        System.out.println("---------------Test case 1----------------");
        String s = "tree";
        System.out.println("Result = "+frequencySort(s));
        System.out.println();

        System.out.println("---------------Test case 2----------------");
        s = "Missisippi";
        System.out.println("Result = "+frequencySort(s));
        System.out.println();
    }

    public static String frequencySort(String s) {
        Map<Character , Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch , map.getOrDefault(ch , 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b)-> map.get(b) - map.get(a));
        int count = 0;
        maxHeap.addAll(map.keySet());
        StringBuilder sb = new StringBuilder();
        while(!maxHeap.isEmpty()){
            char ch = maxHeap.poll();
            int frequency = map.get(ch);
            count = 0;
            while(count < frequency){
                count++;
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
