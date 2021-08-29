package com.leetcode.heap.medium;

import java.util.PriorityQueue;

public class KthLargestElementInArray {
    public static void main(String[] args) {
        System.out.println("-----------------Test case 1------------------");
        int [] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(k+"th Largest Element = "+findKthLargest(nums , k));
        System.out.println();
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> b - a);
        for(int num : nums){
            heap.add(num);
        }
        int kthLargest = 0;
        for(int i = 0 ; i < k ; i++){
            kthLargest = heap.poll();
        }
        return kthLargest;
    }
}
