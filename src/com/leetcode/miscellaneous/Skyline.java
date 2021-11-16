package com.leetcode.miscellaneous;

import java.util.*;

public class Skyline {
    public static void main(String[] args) {
        System.out.println("--------------Test Case 1-----------------");
        int [][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        List<List<Integer>> result = getSkyline(buildings);
        System.out.println("Print Result : ");
        result.forEach(skyLine->{
            System.out.println(skyLine.get(0)+" "+skyLine.get(1));
        });
        System.out.println();
    }

    public static List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> buildLines = new ArrayList<>();
        for (int[] points : buildings) {
            // build[0, 1, 2]
            // build[left, right, height]
            buildLines.add(new int[] { points[0], -points[2] });
            buildLines.add(new int[] { points[1], points[2] });
        }
        // From left to right again from small to large
        // buildLines[0, 1]
        // buildLines[bound, height]
        Collections.sort(buildLines, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.add(0);
        int preHighest = 0;
        for (int[] points : buildLines) {
            if (points[1] < 0) {
                maxHeap.add(-points[1]);
            } else {
                maxHeap.remove(points[1]);
            }
            int curHeight = maxHeap.peek();
            if (curHeight != preHighest) {
                res.add(Arrays.asList(points[0], curHeight));
                preHighest = curHeight;
            }
        }
        return res;
    }
}
