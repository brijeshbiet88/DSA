package com.leetcode.backtracking.hard;

public class SudokoSolver {
    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solveSudoku(board);
        System.out.println("Print Solved Sudoko Board ");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void solveSudoku(char[][] board) {
        solve(board);
    }

    public static boolean solve(char [][] board){
        for (int i = 0 ; i < board.length ; i++) {
            for (int j = 0 ; j < board[0].length ; j++) {
                if(board[i][j] == '.'){

                    for(char c = '1' ; c <= '9' ; c++){
                        if(isValid(board , i , j , c)){
                            board[i][j] = c;

                            if(solve(board) == true)
                                return true;
                            else
                                board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValid(char [][] baord , int row , int col , char c){
        for (int i = 0 ; i < 9 ; i++){
            if(baord[i][col] == c)
                return false;
            if(baord[row][i] == c)
                return false;
            if(baord[3 * (row/3) + i/3][3 * (col/3) + i%3] == c)
                return false;
        }
        return true;
    }
}
