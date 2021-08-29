package com.leetcode.heap.medium;

import java.util.PriorityQueue;

public class KClosestPointToOrigin {
    public static void main(String[] args) {
        System.out.println("-----------------Test Case 1------------------");
        int [][] points = {{3 ,3},{5 , -1} , {-2, 4}};
        int k = 2;
        int [][] closesetPoints = kClosest(points,k);
        System.out.println("Print K closest points ");
        for(int [] point : closesetPoints)
            System.out.println(point[0]+","+point[1]);
        System.out.println();
    }

    public static int[][] kClosest(int[][] points, int k) {
        int [][] result = new int[k][2];
        PriorityQueue<int []> maxHeap = new PriorityQueue<>((a,b) -> (b[0]*b[0]+b[1]*b[1]) - (a[0]*a[0]+a[1]*a[1]));
        for(int [] point : points) {
            maxHeap.add(point);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }

        while(k-- > 0){
            result[k] = maxHeap.poll();
        }

        return result;
    }
}
