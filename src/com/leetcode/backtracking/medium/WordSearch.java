package com.leetcode.backtracking.medium;

public class WordSearch {
    public static void main(String[] args) {
        System.out.println("---------------Test Case 1--------------------");
        char [][] board = {{'A','B','C','E'},
                           {'S','F','C','S'},
                           {'A','D','E','E'}};
        String word = "ABCCEDF";
        System.out.println("Does The Word "+word+" exists in Board ? "+exist(board , word));
        System.out.println();

        System.out.println("-------------Test Case 2------------------------");
        word = "ASFBA";
        System.out.println("Does The Word "+word+" exists in Board ? "+exist(board , word));
        System.out.println();

    }

    public static boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length ; i++) {
            for(int j = 0 ; j < board[0].length ; j++) {
                if(word.charAt(0) == board[i][j] && exist(board, i , j , word , 0))
                    return true;
            }
        }
        return false;
    }

    private static boolean exist(char[][] board, int i, int j, String word, int pos) {


        if (pos == word.length())
            return true;

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return false;

        char temp = board[i][j];
        if (word.charAt(pos) != board[i][j])
            return false;

        board[i][j] = '*';

        if (exist(board, i + 1, j, word, pos+1) || exist(board, i - 1, j, word, pos+1) || exist(board, i, j + 1, word, pos+1)
                || exist(board, i, j - 1, word, pos+1))
            return true;

        board[i][j] = temp;
        return false;

    }
}
