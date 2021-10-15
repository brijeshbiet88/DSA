package com.leetcode.dp.medium;

import java.util.HashMap;
import java.util.Map;

public class KnightProbability {
    public static void main(String[] args) {
        System.out.println("------------------Test Case 1-------------------");
        int n = 3, k = 2, row = 0, column = 0;
        System.out.println("Probability = "+knightProbability(n , k , row , column));
        System.out.println();

    }
    static int [][] moves = {{-1 , 2}, {-2 , 1},{-2,-1},{-1,-2},{1,-2},{2,-1},{2,1},{1,2}};
    static Map<String, Double> map = new HashMap<String,Double>();
    public static double knightProbability(int n, int k, int row, int column) {
        return findKnightProbability(n , k , row , column);
    }

    private  static double findKnightProbability(int n , int k , int row , int col){
        if(!isValid(n , row , col)) return 0;
        if(k == 0) return 1;

        String key = row+":"+col+":"+k;
        if(map.containsKey(key)){
            return map.get(key);
        }

        double probability = 0.0;
        for(int i = 0 ; i < moves.length ; i++){
            probability += findKnightProbability(n , k -1 , row + moves[i][0] , col+moves[i][1]) / 8.0;
        }

        map.put(key , probability);
        return probability;
    }

    private static boolean isValid(int n , int row , int col){
        if(row < 0 || row >=n || col < 0 || col >=n)
            return false;
        return true;
    }
}
