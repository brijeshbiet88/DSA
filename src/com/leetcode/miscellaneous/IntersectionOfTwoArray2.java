package com.leetcode.miscellaneous;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoArray2 {
    public static void main(String[] args) {
        System.out.println("---------------Test Case 1------------------");
        int [] nums1 = {9,4,9,8,4};
        int [] nums2 = {4,9,9,5};
        int [] res = intersect(nums1 , nums2);
        System.out.println("Intersection ");
        for (int num : res)
            System.out.print(num+" ");
        System.out.println();
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList();
        Map<Integer,Integer> freq1 = new HashMap();
        Map<Integer,Integer> freq2 = new HashMap();

        for(int num : nums1){
            freq1.put(num , freq1.getOrDefault(num , 0) + 1);
        }

        for(int num : nums2){
            freq2.put(num , freq2.getOrDefault(num , 0) + 1);
        }

        for(int num : freq1.keySet()){
            if(freq2.containsKey(num)){
                int min = Math.min(freq1.get(num), freq2.get(num));
                while(min-- > 0)
                    list.add(num);
            }
        }

        return list.stream().mapToInt(i -> i).toArray();

    }
}
