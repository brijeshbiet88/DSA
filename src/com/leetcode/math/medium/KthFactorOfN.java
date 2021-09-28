package com.leetcode.math.medium;

public class KthFactorOfN {
    public static void main(String[] args) {
        System.out.println("---------------Test Case 1-----------------");
        int n = 12;
        int k = 3;
        System.out.println("Kth Factor of n = "+kthFactor(n,k));
        System.out.println();

        System.out.println("---------------Test Case 2-----------------");
        n = 7;
        k = 2;
        System.out.println("Kth Factor of n = "+kthFactor(n,k));
        System.out.println();

        System.out.println("---------------Test Case 3-----------------");
        n = 4;
        k = 4;
        System.out.println("Kth Factor of n = "+kthFactor(n,k));
        System.out.println();

        System.out.println("---------------Test Case 4-----------------");
        n = 1;
        k = 1;
        System.out.println("Kth Factor of n = "+kthFactor(n,k));
        System.out.println();

        System.out.println("---------------Test Case 5-----------------");
        n = 1000;
        k = 3;
        System.out.println("Kth Factor of n = "+kthFactor(n,k));
        System.out.println();

    }

    public static int kthFactor(int n, int k) {
        for (int i = 1; i * i < n; i++) {
            if (n % i == 0 && --k == 0)
                return i;
        }
        for (int i = (int) Math.sqrt(n); i >= 1; i--) {
            if (n % i == 0 && --k == 0)
                return n / i;
        }
        return -1;
    }
}
