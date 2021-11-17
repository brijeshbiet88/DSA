package com.leetcode.array.medium;

import java.util.Arrays;

public class MeetingRoom {
    public static void main(String[] args) {
        System.out.println("----------------Test Case 1-------------------");
        int [][] meetings1 = {{0,30},{5,10},{15,20}};
        System.out.println("Can Attend All Meetings ? "+canAttendMeetings(meetings1));
        System.out.println();

        System.out.println("----------------Test Case 2-------------------");
        int [][] meetings2 = {{7,10},{2,4}};
        System.out.println("Can Attend All Meetings ? "+canAttendMeetings(meetings2));
        System.out.println();

        System.out.println("----------------Test Case 3-------------------");
        int [][] meetings3 = {{7,10},{2,4},{0,2},{10,15}};
        System.out.println("Can Attend All Meetings ? "+canAttendMeetings(meetings3));
        System.out.println();
    }

    public static boolean canAttendMeetings (int [][] meetings){
        if(meetings.length < 2) return true;
        Arrays.sort(meetings , (a,b)-> a[0] - b[0]);
        for (int i = 0 ; i < meetings.length - 1 ; i++){
            if(meetings[i][1] > meetings[i+1][0] )
                return false;
        }

        return true;
    }
}
