package com.leetcode.backtracking.medium;

import java.util.HashSet;
import java.util.Set;

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
        System.out.println("No of Possible tile with "+tiles+" = "+numTilePossibilities2(tiles));
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

    private static void backtrack(Set<String> set , String tiles, StringBuilder sb , boolean[] visited){
        if(sb.length()!=0){            //checking the length of temporary string if its not equal add it our set.
                set.add(sb.toString());     //function to convert string builder to String
        }
        for(int i=0 ;i<tiles.length() ;i++){
            if(visited[i]) continue;       //checks if the character is already visited if not then simply add it ot our tempory string and mark it true
            else{
                visited[i]=true;
                sb.append(tiles.charAt(i));
            }
            backtrack(set,tiles ,sb ,visited);    // then again backtrack
            sb.deleteCharAt(sb.length()-1);   // while returning back delete the last character and mark it false again
            visited[i]=false;
        }

    }

    public static int numTilePossibilities2(String tiles) {
        Set<String> set = new HashSet<String>();
        boolean[] visited = new boolean[tiles.length()];
        backtrack(set ,tiles ,new StringBuilder(), visited);
        return set.size();  // return the size of set as set will not allow duplicacy so it will give required no. of elements
    }
}
