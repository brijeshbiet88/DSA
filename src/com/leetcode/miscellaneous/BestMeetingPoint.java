package com.leetcode.miscellaneous;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestMeetingPoint {

    static int ROW = 3;
    static int COL = 5;

    public static void main(String[] args)
    {
        int grid[][] = {{1, 0, 1, 0, 1},
                {0, 1, 0, 0, 0},
                {0, 1, 1, 0, 0}};
        System.out.println(minTotalDistance(grid));
    }

    static int minTotalDistance(int grid[][]) {
        if (ROW == 0 || COL == 0)
            return 0;

        List<Integer> vertical = new ArrayList<Integer>();
        List<Integer> horizontal = new ArrayList<Integer>();

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (grid[i][j] == 1) {
                    vertical.add(i);
                    horizontal.add(j);
                }
            }
        }

        Collections.sort(vertical);
        Collections.sort(horizontal);

        int size = vertical.size() / 2;
        int x = vertical.get(size);
        int y = horizontal.get(size);

        int distance = 0;
        for (int i = 0; i < ROW; i++)
            for (int j = 0; j < COL; j++)
                if (grid[i][j] == 1)
                    distance += Math.abs(x - i) + Math.abs(y - j);

        return distance;

    }
}
