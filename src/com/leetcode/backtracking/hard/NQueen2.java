package com.leetcode.backtracking.hard;

import java.util.HashSet;
import java.util.Set;

public class NQueen2 {

        public static void main(String[] args) {
            System.out.println("----------------Test Case 1------------------");
            int n = 4;
            NQueen2 nQueen21 = new NQueen2();
            System.out.println("Total Valid Solutions = "+nQueen21.totalNQueens(n));
            System.out.println();

            System.out.println("----------------Test Case 2------------------");
            n = 5;
            NQueen2 nQueen22 = new NQueen2();
            System.out.println("Total Valid Solutions = "+nQueen22.totalNQueens(n));
            System.out.println();

            System.out.println("----------------Test Case 3------------------");
            n = 6;
            NQueen2 nQueen23 = new NQueen2();
            System.out.println("Total Valid Solutions = "+nQueen23.totalNQueens(n));
            System.out.println();

            System.out.println("----------------Test Case 4------------------");
            n = 7;
            NQueen2 nQueen24 = new NQueen2();
            System.out.println("Total Valid Solutions = "+nQueen24.totalNQueens(n));
            System.out.println();

            System.out.println("----------------Test Case 5------------------");
            n = 8;
            NQueen2 nQueen25 = new NQueen2();
            System.out.println("Total Valid Solutions = "+nQueen25.totalNQueens(n));
            System.out.println();
        }

        private Set<Integer> usedColIndex = new HashSet<Integer>();
        private Set<Integer> used135DegreeDiagonal = new HashSet<Integer>();
        private Set<Integer> used45DegreeDiagonal = new HashSet<Integer>();
        private int count = 0;

        public int totalNQueens(int n) {
            helper(n,0);
            return count;
        }
        public void helper( int n, int row) {
            if (row == n) {
                count++;
                return;
            } else {
                for (int col = 0; col < n; col++) {
                    if (isValid(row, col)) {
                        usedColIndex.add(col);
                        used135DegreeDiagonal.add(col + row);
                        used45DegreeDiagonal.add(row - col);
                        helper(n, row + 1);
                        usedColIndex.remove(col);
                        used135DegreeDiagonal.remove(col + row);
                        used45DegreeDiagonal.remove(row - col);
                    }
                }
            }

        }

        private boolean isValid(int row, int col){
            if(usedColIndex.contains(col) || used135DegreeDiagonal.contains(col+row) || used45DegreeDiagonal.contains(row-col)) {
                return false;
            } else {
                return true;
            }
        }
    }
