package com.leetcode.slidingwindow.misc;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    public static void main(String[] args) {
        System.out.println("----------------Test Case 1----------------");
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println("Moving Average = "+movingAverage.next(1));
        System.out.println("Moving Average = "+movingAverage.next(10));
        System.out.println("Moving Average = "+movingAverage.next(3));
        System.out.println("Moving Average = "+movingAverage.next(5));
        System.out.println();
    }

    Queue<Integer> queue ;
    int sum = 0;
    int size ;
    public MovingAverage(int size){
        queue = new LinkedList<Integer>();
        this.size = size;
        sum = 0;
    }

    public double next(int val){
        if(queue.size() >= size){
            sum -= queue.poll();
        }
        queue.add(val);
        sum += val;

        return (double) sum/queue.size();
    }
}
