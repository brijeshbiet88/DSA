package com.leetcode.array.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoom2 {
    public static void main(String[] args) {
        System.out.println("------------Test Case 1--------------");
        Interval i1 = new Interval(0,30);
        Interval i2 = new Interval(5,10);
        Interval i3 = new Interval(15,20);
        Interval [] intervals = new Interval[3];
        intervals[0] = i1;
        intervals[1] = i2;
        intervals[2] = i3;
        System.out.println("Minimum Room Required = "+meetingRooms(intervals));
        System.out.println();

        System.out.println("------------Test Case 2--------------");
        Interval i21 = new Interval(7,10);
        Interval i22 = new Interval(2,4);
        Interval [] intervals2 = new Interval[2];
        intervals2[0] = i21;
        intervals2[1] = i22;
        System.out.println("Minimum Room Required = "+meetingRooms(intervals2));
        System.out.println();
    }

    public static int meetingRooms(Interval [] intervals){
        if(intervals == null || intervals.length == 0) return 0;

        Arrays.sort(intervals, (a,b)-> a.start - b.start);
        PriorityQueue<Interval> minHeap = new PriorityQueue<>((a,b)-> a.end - b.end);
        minHeap.add(intervals[0]);

        for (int i = 1 ; i < intervals.length ; i++){
            Interval current = intervals[i];
            Interval earliest = minHeap.poll();
            if(current.start >= earliest.end){
                earliest.end = current.end;
            }else {
                minHeap.add(current);
            }
            minHeap.add(earliest);
        }

        return minHeap.size();
    }
}

class Interval{
    public int start;
    public int end;

    public Interval(){
        start = 0;
        end = 0;
    }

    public Interval(int start , int end){
        this.start = start;
        this.end = end;
    }
}
