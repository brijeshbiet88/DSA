package com.leetcode.miscellaneous;

import java.util.*;

public class RandomizedSet {
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(" Op 1 = "+randomizedSet.remove(0));
        System.out.println(" Op 2 = "+randomizedSet.remove(0));
        System.out.println(" Op 1 = "+randomizedSet.insert(0));
        System.out.println(" Op 1 = "+randomizedSet.getRandom());
        System.out.println(" Op 1 = "+randomizedSet.remove(0));
        System.out.println(" Op 1 = "+randomizedSet.insert(0));
    }

        Map<Integer,Integer> map ;
        List<Integer> list ;
        public RandomizedSet() {
            map = new HashMap<Integer,Integer>();
            list = new ArrayList<Integer>();
        }

        public boolean insert(int val) {
            if(map.containsKey(val))
                return false;
            map.put(val, list.size());
            list.add(val);
            return true;

        }

        public boolean remove(int val) {
            if(map.containsKey(val)){
                int index = map.get(val);
                map.remove(val);
                if(index == list.size() -1){
                    list.remove(list.size()-1);
                    return true;
                }
                int lastVal = list.get(list.size()-1);
                map.put(lastVal,index);
                Collections.swap(list, index,  list.size()-1);
                list.remove(list.size() - 1);
                return true;
            }
            return false;
        }

        public int getRandom() {
            Random rand = new Random();
            int index = rand.nextInt(list.size());
            return list.get(index);
        }
    }