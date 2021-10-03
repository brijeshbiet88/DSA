package com.leetcode.backtracking.hard;

import java.util.HashMap;

public class DungeonGame {
    public static void main(String[] args) {
        System.out.println("------------------Test Case 1---------------");
        int [][] dungeon = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        int minHealth = calculateMinimumHP(dungeon);
        System.out.println("Min Health = "+minHealth);
        System.out.println();

        System.out.println("------------------Test Case 2---------------");
        int [][] dungeon2 = {{0}};
        minHealth = calculateMinimumHP(dungeon2);
        System.out.println("Min Health = "+minHealth);
        System.out.println();

        System.out.println("------------------Test Case 3---------------");
        int [][] dungeon3 = {{-2,-7,7},{-8,-10,1},{10,30,-5}};
        minHealth = calculateMinimumHP(dungeon3);
        System.out.println("Min Health = "+minHealth);
        System.out.println();
    }

    public static int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0)
            return 0;
        HashMap<String,Integer> hm = new HashMap<>();
        return calculateMinHealthHelper(0,0,dungeon , hm);
    }

    private static int calculateMinHealthHelper(int i, int j, int[][] dungeon, HashMap<String, Integer> hm) {
        if(i >= dungeon.length || j >= dungeon[0].length)
            return Integer.MAX_VALUE;

        String key = i+":"+j;
        if(hm.containsKey(key))
            return hm.get(key);

        int next = Math.min(calculateMinHealthHelper(i+1, j, dungeon, hm) , calculateMinHealthHelper(i, j+1, dungeon, hm));

        if(next == Integer.MAX_VALUE)
            next = 1;

        int result = Math.max(next - dungeon[i][j] , 1);
        hm.put(key , result);
        return result;
    }
}
