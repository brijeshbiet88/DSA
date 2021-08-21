package com.leetcode.backtracking.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueen {

    public static void main(String[] args) {
        System.out.println("--------------Test Case 1--------------------");
        int n = 4;
        List<List<String>> board = solveNQueens(n);
        board.forEach(row -> System.out.print(row));
        System.out.println();

    }

    public static List<List<String>> solveNQueens(int n) {
        char [][] board = new char [n][n];
        for (int i = 0 ; i < n ; i++)
            Arrays.fill(board[i] , '.');

        List<List<String>> result = new ArrayList();
        backtrack(board , n , 0 , result);
        return result;
    }

    private static void backtrack(char [][] board , int n , int row , List<List<String>> result){

        if(row == n){
            result.add(createBoard(board));
            return;
        }

        for(int col = 0 ; col < n ; col++){
            if(isSafe(board , row , col)){
                board[row][col] = 'Q';
                backtrack(board, n, row + 1, result);
                board[row][col] = '.';
            }
        }
    }

    private static List<String> createBoard(char[][] board) {

        List<String> result = new ArrayList();
        for (int i = 0 ; i < board.length ; i++){
            StringBuilder sb = new StringBuilder();
            for (int j = 0 ; j < board[0].length ; j++){
                sb.append(board[i][j]);
            }
            result.add(sb.toString());
        }
    return result;
    }

    public static boolean isSafe(char [][] board , int row , int col){
        // column check
        for(int i = row -1 ; i >= 0 ; i--)
        if(board[i][col] == 'Q')
            return false;

        //diagonal Check
        for (int i = row -1 , j = col -1 ; i >= 0 && j >=0 ; i-- , j--){
            if(board[i][j] == 'Q')
                return false;
        }
        //anti diagonal Check
        for (int i = row -1 , j = col + 1 ; i >= 0 && j < board.length ; i-- , j++){
            if(board[i][j] == 'Q')
                return false;
        }

        return true;
    }
}
