package com.leetcode.backtracking.medium;

import java.util.HashSet;

public class ValidSudoko {
    public static void main(String[] args) {
        char [][] board =
        {{'5','3','.','.','7','.','.','.','.'}
        ,{'6','.','.','1','9','5','.','.','.'}
        ,{'.','9','8','.','.','.','.','6','.'}
        ,{'8','.','.','.','6','.','.','.','3'}
        ,{'4','.','.','8','.','3','.','.','1'}
        ,{'7','.','.','.','2','.','.','.','6'}
        ,{'.','6','.','.','.','.','2','8','.'}
        ,{'.','.','.','4','1','9','.','.','5'}
        ,{'.','.','.','.','8','.','.','7','9'}};

        System.out.println("Is The Sudoko Valid ? "+isValidSudoku(board));

    }

    public static boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();
        for (int i = 0 ; i < board.length ; i++)
            for(int j = 0 ; j < board[0].length ; j++){
                char currentValue = board[i][j];
                if(currentValue != '.'){
                  if(!seen.add(currentValue+" Found In Row" + i)||
                    !seen.add(currentValue+" Found In Col" + j)||
                    !seen.add(currentValue+" Found In Sub Box" + i/3 +" , " +j/3))
                      return false;
                }
            }

        return true;
    }
}
