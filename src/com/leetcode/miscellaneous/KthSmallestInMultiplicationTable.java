package com.leetcode.miscellaneous;

public class KthSmallestInMultiplicationTable {
    public static void main(String[] args) {
        System.out.println("-----------------Test Case 1--------------------");
        int k = 5 , m = 3 , n = 3;
        System.out.println("Kth Smallest = "+findKthNumber(m,n,k));
        System.out.println();

        System.out.println("-----------------Test Case 2--------------------");
        k = 6 ;
        m = 3 ;
        n = 2;
        System.out.println("Kth Smallest = "+findKthNumber(m,n,k));
        System.out.println();
    }

    public static int findKthNumber(int m, int n, int k) {
        int low = 1, high = m * n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (!inRange(mid, m, n, k)) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    public static boolean inRange(int x, int m, int n, int k) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(x / i, n);
        }
        return count >= k;
    }
}
