package com.leetcode.miscellaneous;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyHashSet {
    private List<Integer>[] bucket;
    private int capacity;
    private double loadFactor;
    private int count ;

    public MyHashSet() {
        count = 0;
        capacity = 1000;
        loadFactor = 0.75;
        bucket = new LinkedList[capacity];
    }

    public void add(int key) {
        if (contains(key))
            return;
        if (loadFactor * capacity == count) {
            count = 0;
            capacity *= 2; // double the capacity
            List<Integer>[] oldBucket = bucket;
            bucket = new LinkedList[capacity];
            for (int i = 0; i < oldBucket.length; i++) {
                List<Integer> list = oldBucket[i];
                if (list != null) {
                    for (int entry : list)
                        this.add(entry);
                }
            }
        }

        int hash = key % capacity;
        if (bucket[hash] == null)
            bucket[hash] = new LinkedList<>();
        bucket[hash].add(key);
        ++count;
    }

    public void remove(int key) {
        int hash = key % capacity;
        List<Integer> list = bucket[hash];
        if (list != null) {
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()) {
                if (iterator.next() == key) {
                    iterator.remove();
                    --count;
                }
            }
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int hash = key % capacity;
        List<Integer> list = bucket[hash];
        if (list != null) {
            for (int k : list)
                if (k == key)
                    return true;
        }
        return false;
    }


}
