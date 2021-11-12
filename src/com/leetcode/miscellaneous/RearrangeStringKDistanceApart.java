package com.leetcode.miscellaneous;

import java.util.*;

public class RearrangeStringKDistanceApart {
    public static void main(String[] args) {
        System.out.println("-----------------Test Case 1-------------------");
        String str = "aabbcc";
        int k = 3;
        System.out.println("Rearrangement of String "+str+" with distance K = "+k+" is "+rearrangeString(str,k));
        System.out.println();

        System.out.println("-----------------Test Case 2-------------------");
        str = "aaabc";
        k = 3;
        System.out.println("Rearrangement of String "+str+" with distance K = "+k+" is "+rearrangeString(str,k));
        System.out.println();

        System.out.println("-----------------Test Case 3-------------------");
        str = "aaadbbcc";
        k = 2;
        System.out.println("Rearrangement of String "+str+" with distance K = "+k+" is "+rearrangeString(str,k));
        System.out.println();

    }

    public static String rearrangeString(String str, int k) {
        if(k==0)
            return str;

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else{
                map.put(c, 1);
            }
        }

        //sort the chars by frequency
        PriorityQueue<Character> queue = new PriorityQueue<Character>((a,b)->{
            if(map.get(b) != map.get(a)){
                return map.get(b) - map.get(a);
            }else{
                return a.compareTo(b);
            }
        });


        for(char c: map.keySet())
            queue.offer(c);

        StringBuilder sb = new StringBuilder();

        int len = str.length();

        while(!queue.isEmpty()){

            int cnt = Math.min(k, len);
            List<Character> temp = new ArrayList<Character>();

            for(int i = 0; i < cnt ; i++){
                if(queue.isEmpty())
                    return "";

                char c = queue.poll();
                sb.append(String.valueOf(c));

                map.put(c, map.get(c)-1);

                if(map.get(c)>0){
                    temp.add(c);
                }

                len--;
            }

            for(char c: temp)
                queue.offer(c);
        }

        return sb.toString();
    }

}
