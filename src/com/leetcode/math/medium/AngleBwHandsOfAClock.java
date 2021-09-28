package com.leetcode.math.medium;

public class AngleBwHandsOfAClock {
    public static void main(String[] args) {
        System.out.println("-------------Test Case 1--------------");
        int hour = 12;
        int minutes = 30;
        System.out.println("Angle Between Hands of Clock = "+angleClock(hour,minutes));
        System.out.println();

        System.out.println("-------------Test Case 2--------------");
        hour = 3;
        minutes = 30;
        System.out.println("Angle Between Hands of Clock = "+angleClock(hour,minutes));
        System.out.println();

        System.out.println("-------------Test Case 3--------------");
        hour = 3;
        minutes = 15;
        System.out.println("Angle Between Hands of Clock = "+angleClock(hour,minutes));
        System.out.println();

        System.out.println("-------------Test Case 4--------------");
        hour = 4;
        minutes = 50;
        System.out.println("Angle Between Hands of Clock = "+angleClock(hour,minutes));
        System.out.println();

        System.out.println("-------------Test Case 5--------------");
        hour = 12;
        minutes = 0;
        System.out.println("Angle Between Hands of Clock = "+angleClock(hour,minutes));
        System.out.println();
    }

    public static double angleClock(int hour, int minutes) {
        double hourHandMovementInAngle = (hour%12)*30 + (double)minutes/2;
        double minsHandMovementInAngle = minutes*6;
        double angle ;

        if(minsHandMovementInAngle - hourHandMovementInAngle > 180) {
            angle = Math.abs(hourHandMovementInAngle - minsHandMovementInAngle);
        }
        else {
            angle = Math.abs(minsHandMovementInAngle - hourHandMovementInAngle);
        }

        return angle <= 180 ? angle : 360-angle;
    }
}
