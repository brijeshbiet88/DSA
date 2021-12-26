package com.leetcode.heap.medium;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
        TopKFrequentWords topKFrequentWords = new TopKFrequentWords();
        System.out.println("--------------------Test Case 1------------------");
        String [] words = {"i","love","leetcode","i","love","coding"};
        int k = 2;
        List<String> result = topKFrequentWords.topKFrequent(words,k);
        System.out.println("Result");
        result.forEach(s-> System.out.print(s+" "));
        result.clear();
        System.out.println();

        System.out.println("--------------------Test Case 2------------------");
        String [] words2 = {"the","day","is","sunny","the","the","the","sunny","is","is"};
        k = 4;
        result = topKFrequentWords.topKFrequent(words2,k);
        System.out.println("Result");
        result.forEach(s-> System.out.print(s+" "));
        result.clear();
        System.out.println();

    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap();
        List<String> result = new ArrayList();

        for(String s : words){
            map.put(s, map.getOrDefault(s,0)+1);
        }

        PriorityQueue<String> minHeap = new PriorityQueue<>((a, b) -> map.get(a)==map.get(b) ?
                b.compareTo(a) : map.get(a) - map.get(b));

        for(String i:map.keySet()){
            minHeap.add(i);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        while(!minHeap.isEmpty()){
            result.add(0, minHeap.poll());
            k--;
        }
        return result;
    }
}

