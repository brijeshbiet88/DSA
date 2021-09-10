package com.leetcode.slidingwindow.misc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        System.out.println("--------------Test Case 1-------------------");
        int [] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        int [] result = maxSlidingWindow(nums , k);
        for (int num : result)
            System.out.print(num+" ");
        System.out.println();
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        List<Integer> result = new ArrayList();
        LinkedList<Integer> indexes = new LinkedList();

        for (int i = 0; i < len; i++) {
            while (indexes.size() > 0 && indexes.getFirst() <= i - k)
                indexes.removeFirst();
            while (indexes.size() > 0 && nums[i] >= nums[indexes.getLast()])
                indexes.removeLast();
            indexes.addLast(i);
            if (i >= k - 1)
                result.add(nums[indexes.getFirst()]);
        }

        return result.stream().mapToInt(x -> x).toArray();
    }
}
