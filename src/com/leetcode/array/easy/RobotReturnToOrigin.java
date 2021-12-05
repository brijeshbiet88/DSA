package com.leetcode.array.easy;

public class RobotReturnToOrigin {
    public static void main(String[] args) {
        System.out.println("-------------Test Case1 ---------------");
        String moves1 = "LDRRLRUULR";
        System.out.println("Can Return To Origin ? " + judgeCircle(moves1));
        System.out.println();

        System.out.println("-------------Test Case2 ---------------");
        String moves2 = "UD";
        System.out.println("Can Return To Origin ? " + judgeCircle(moves2));
        System.out.println();

        System.out.println("-------------Test Case3 ---------------");
        String moves3 = "LLRRUUDD";
        System.out.println("Can Return To Origin ? " + judgeCircle(moves3));
        System.out.println();
    }

    public static boolean judgeCircle(String moves) {
        int x = 0, y = 0;

        char[] strArr = moves.toCharArray();

        for (char ch : strArr) {
            if (ch == 'U') {
                y++;
            } else if (ch == 'D') {
                y--;
            } else if (ch == 'L') {
                x--;
            } else if (ch == 'R') {
                x++;
            }

        }

        return x == 0 && y == 0;
    }
}
