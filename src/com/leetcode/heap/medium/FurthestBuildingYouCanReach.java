package com.leetcode.heap.medium;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class FurthestBuildingYouCanReach {
    public static void main(String[] args) {
        int [] heights = {4,12,2,7,3,18,20,3,19};
        int bricks = 7;
        int ladder = 2;
        System.out.println("Furthest Building To reach = "+furthestBuilding(heights , bricks , ladder));

        int [] heights2 = {4,11,2,3,4,5,6,7,8};
        bricks = 7;
        ladder = 1;
        System.out.println("Furthest Building To reach = "+furthestBuilding(heights2 , bricks , ladder));
    }

    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        Queue<Integer> minHeap = new PriorityQueue();
        for (int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i + 1] - heights[i];
            if (diff <= 0)
                continue;
            minHeap.add(diff);
            if (minHeap.size() > ladders)
                bricks -= minHeap.poll();
            if (bricks < 0)
                return i;
        }

        return heights.length - 1;
    }
}
