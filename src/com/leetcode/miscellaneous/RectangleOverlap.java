package com.leetcode.miscellaneous;

public class RectangleOverlap {
    public static void main(String[] args) {
        System.out.println("-------------Test Case 1---------------");
        int [] rec1 = {0 , 0 , 2 , 2};
        int [] rec2 = {1 , 1 , 3 , 3};
        System.out.println("Are Rectangles  Overlapping ? "+isRectangleOverlap(rec1 , rec2));
        System.out.println();
    }

    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        return rec1[0] < rec2[2] && rec1[1] < rec2[3]
                && rec2[0] < rec1[2] && rec2[1] < rec1[3];

        // x1 < x'2 && y1 < y'2 && x'1 < x2 && y'1 < y2;

    }
}
