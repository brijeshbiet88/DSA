package com.leetcode.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeeFreeTime {

    public static void main(String[] args) {
        System.out.println("-------------Test Case 1-------------------");
        List<List<Interval>> scheduleList1 = new ArrayList<List<Interval>>();

        List<Interval> schedule1 = new ArrayList<>();
        Interval interval1 = new Interval(1,3);
        Interval interval2 = new Interval(6,7);
        schedule1.add(interval1);
        schedule1.add(interval2);

        List<Interval> schedule2 = new ArrayList<>();
        Interval interval3 = new Interval(2,4);
        schedule2.add(interval3);

        List<Interval> schedule3 = new ArrayList<>();
        Interval interval4 = new Interval(2,5);
        Interval interval5 = new Interval(9,12);
        schedule3.add(interval4);
        schedule3.add(interval5);

        scheduleList1.add(schedule1);
        scheduleList1.add(schedule2);
        scheduleList1.add(schedule3);

        List<Interval> employeeFreeTime = employeeFreeTime(scheduleList1);
        System.out.println("Print Employee Free Times ");
        employeeFreeTime.forEach((interval -> System.out.println(interval.start+","+interval.end)));

        System.out.println();
    }

    public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        if(schedule == null || schedule.size() == 0) return null;
        List<Interval> list = new ArrayList<>();
        for (List<Interval> l : schedule) {
            list.addAll(l);
        }
        List<Interval> merged = merge(list);
        if(merged.size() == 1) return null;
        List<Interval> result=new ArrayList<>();
        for(int i = 1;i < merged.size() ; i++){
            Interval prev = merged.get(i-1);
            Interval cur = merged.get(i);
            if(prev.end < cur.start){
                result.add(new Interval(prev.end , cur.start));
            }
        }
        return result;
    }

    private static List<Interval> merge(List<Interval> intervals) {
        if (intervals == null) return null;
        if (intervals.size() == 0) return intervals;
        if (intervals.size() == 1) return intervals;

        intervals.sort(Comparator.comparingInt(interval -> interval.start));

       / List<Interval> result = new ArrayList<>();
        for (Interval intrvl : intervals) {
            if (result.size() == 0)
                result.add(intrvl);
            else {
                Interval lastInterval = result.get(result.size() - 1);
                if (lastInterval.end >= intrvl.start) {
                    Interval interval = new Interval(Math.min(lastInterval.start, intrvl.start),
                            Math.max(lastInterval.end, intrvl.end));
                    result.add(interval);
                    result.remove(result.size() - 2);
                } else
                    result.add(intrvl);
            }
        }
        return result;
    }
}

    class Interval {
        int start;
        int end;
        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
