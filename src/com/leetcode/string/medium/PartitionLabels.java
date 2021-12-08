package com.leetcode.string.medium;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public static void main(String[] args) {
        PartitionLabels pl = new PartitionLabels();
        System.out.println("----------------Test Case 1-------------------");
        String s = "abbcacef";
        List<Integer> res = pl.partitionLabels(s);
        System.out.println("Print Result : ");
        res.forEach(num -> System.out.print(num+" "));
        System.out.println();

        System.out.println("----------------Test Case 2-------------------");
        s = "ababcbacadefegdehijhklij";
        List<Integer> res2 = pl.partitionLabels(s);
        System.out.println("Print Result : ");
        res2.forEach(num -> System.out.print(num+" "));
        System.out.println();

        System.out.println("----------------Test Case 3-------------------");
        s = "eccbbbbdec";
        List<Integer> res3 = pl.partitionLabels(s);
        System.out.println("Print Result : ");
        res3.forEach(num -> System.out.print(num+" "));

    }

    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<Integer>();
        int i = 0;
        int index = 0;
        while(i < s.length()){

            int j = i;
            index = s.indexOf(s.charAt(i),i+1);
            if(index == -1){
                res.add(1);
            }
            while(j < s.length() && j <= index){
                char ch = s.charAt(j);

                index = Math.max(index,s.indexOf(ch , j + 1));
                if(j == index){
                    res.add(j - i + 1);

                    break;
                }else {
                    j++;
                }
            }


            i = j + 1;

        }
        return res;
    }
}
