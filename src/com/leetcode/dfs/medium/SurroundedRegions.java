package com.leetcode.dfs.medium;

public class SurroundedRegions {
    public static void main(String[] args) {
        char [][] board = {{'X','X','X','X'}, {'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        solve(board);
        System.out.println("Print Result : ");
        System.out.println();
        for (int i = 0 ; i < board.length ; i++){
            for (int j = 0 ; j < board[0].length ; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void solve(char[][] board) {

        if(board == null || board.length <= 2 || board[0].length <= 2 ) {
            return;
        }

        int r = board.length , c = board[0].length;

        replace(board , 'O' , '*');

        for(int i = 0 ; i < c ; i++) {
            if(board[0][i] == '*')
                dfsUtil(board, 0, i, 'O', '*'); // First Row
        }

        for(int i = 0 ; i < c ; i++) {
            if(board[r-1][i] == '*')
                dfsUtil(board, r-1, i, 'O', '*'); // Last row
        }

        for(int i = 0 ; i < r ; i++) {
            if(board[i][0] == '*')
                dfsUtil(board, i, 0, 'O', '*'); // First Column
        }

        for(int i = 0 ; i < r ; i++) {
            if(board[i][c-1] == '*')
                dfsUtil(board, i, c-1, 'O', '*'); // Last Column
        }

        for(int i = 0 ; i < board.length ; i++) {
            for(int j = 0 ; j < board[0].length ; j++) {
                if(board[i][j] == '*') {
                    board[i][j] = 'X';
                }
            }
        }

    }


    private static void replace(char[][] board, char c, char d) {
        for(int i = 0 ; i < board.length ; i++) {
            for(int j = 0 ; j < board[0].length ; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = '*';
                }
            }
        }

    }


    public static void dfsUtil(char [][] board , int x , int y , char och , char sch) {
        int row = board.length;
        int col = board[0].length;

        if(x < 0 || x >= row || y < 0 || y >= col || board[x][y] != sch ) {
            return ;
        }


        board[x][y] = 'O';

        dfsUtil(board, x+1, y, och, sch);
        dfsUtil(board, x, y+1, och, sch);
        dfsUtil(board, x-1, y, och, sch);
        dfsUtil(board, x, y-1, och, sch);

    }
}
