package com.leetcode.slidingwindow.misc;

import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
    public static void main(String[] args) {
        System.out.println("---------------Test Case 1------------------");
        int [] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        double[] result = medianSlidingWindow(nums , k);
        System.out.println("Print Result ");
        for (double d : result)
            System.out.print(d+" ");
        System.out.println();

    }

    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    public static double[] medianSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        double[] result = new double[len - k + 1];

        if(k == 1) {
            for(int i = 0; i < len; i++) {
                result[i] = nums[i];
            }

            return result;
        }

        if(k == 2) {
            for(int i = 1; i < len; i++) {
                result[i - 1] = nums[i] / 2.0 + nums[i - 1] / 2.0;
            }

            return result;
        }

        for(int i = 0; i < len; i++) {
            if(maxHeap.size() == 0 || maxHeap.peek() >= nums[i]) {
                maxHeap.add(nums[i]);
            } else {
                minHeap.add(nums[i]);
            }

            rebalanceHeaps();

            if(i >= k - 1) {
                result[i - k + 1] = findMeadian();
                removeElement(nums[i - k + 1]);
            }
        }

        return result;
    }

    private static void removeElement(int num) {

        if(num <= maxHeap.peek()) {
            maxHeap.remove(num);
        } else {
            minHeap.remove(num);
        }

        rebalanceHeaps();
    }

    private static double findMeadian() {

        if(minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() / 2.0 + maxHeap.peek() / 2.0);
        }

        return maxHeap.peek();
    }

    private static void rebalanceHeaps() {

        if(maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if(maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }
}
