package com.leetcode.stackqueue;

public class HitCounter {

    public static void main(String[] args) {
        System.out.println("------------Test Case 1-------------------");
        HitCounter hitCounter = new HitCounter();
        System.out.println("Hits in Last 5 seconds At t = 1 "+hitCounter.getHits(1));
        hitCounter.hit(1);
        hitCounter.hit(1);
        hitCounter.hit(1);
        hitCounter.hit(2);
        hitCounter.hit(4);
        hitCounter.hit(5);

        System.out.println("Hits in Last 5 seconds At t = 5 "+hitCounter.getHits(5));
        hitCounter.hit(6);
        hitCounter.hit(8);

        System.out.println("Hits in Last 5 seconds At t = 10 "+hitCounter.getHits(10));

        hitCounter.hit(10);
        hitCounter.hit(11);

        System.out.println("Hits in Last 5 seconds At t = 15 "+hitCounter.getHits(15));

        System.out.println();
    }

    private Hit start = new Hit(0);
    private Hit tail = start;
    private int count = 0;

    /** Initialize your data structure here. */
    public HitCounter() {

    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if (tail.timestamp == timestamp) {
            tail.count ++;
            count ++;
        } else {
            tail.next = new Hit(timestamp);
            tail = tail.next;
            count ++;
        }
       // getHits(timestamp);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (start.next != null && timestamp - start.next.timestamp >= 5) { // 5 seconds
            count -= start.next.count;
            start.next = start.next.next;
        }
        if (start.next == null) tail = start;
        return count;
    }
}

class Hit {
    int timestamp;
    int count;
    Hit next;
    Hit(int timestamp) {
        this.timestamp = timestamp;
        this.count = 1;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
