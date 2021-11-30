package com.leetcode.backtracking.medium;

public class LetterTiles {
    public static void main(String[] args) {
        System.out.println("-----------------Test case 1-----------------");
        String tiles = "AAB";
        System.out.println("No of Possible tile with "+tiles+" = "+numTilePossibilities(tiles));
        System.out.println();

        System.out.println("-----------------Test case 2-----------------");
        tiles = "AAABBC";
        System.out.println("No of Possible tile with "+tiles+" = "+numTilePossibilities(tiles));
        System.out.println();

        System.out.println("-----------------Test case 3-----------------");
        tiles = "AB";
        System.out.println("No of Possible tile with "+tiles+" = "+numTilePossibilities(tiles));
        System.out.println();

        System.out.println("-----------------Test case 4-----------------");
        tiles = "ABB";
        System.out.println("No of Possible tile with "+tiles+" = "+numTilePossibilities(tiles));
        System.out.println();

        System.out.println("-----------------Test case 5-----------------");
        tiles = "ABC";
        System.out.println("No of Possible tile with "+tiles+" = "+numTilePossibilities(tiles));
        System.out.println();
    }

    public static int numTilePossibilities(String tiles) {
        if(tiles.length() == 0)
            return 0;
        int[] count = new int[26];

        for(char c : tiles.toCharArray())
            count[c-'A']++;
        return dfs(count);
    }

    private static int dfs(int[] array){
        int sum = 0;

        for(int i=0; i<26; i++){
            if(array[i] == 0)
                continue;

            sum++;
            array[i]--;
            sum += dfs(array);
            array[i]++;
        }
        return sum;
    }

}
