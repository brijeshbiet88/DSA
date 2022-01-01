package com.leetcode.dp.hard;

public class BurstBaloons {
    public static void main(String[] args) {
        BurstBaloons burstBaloons = new BurstBaloons();
        System.out.println("---------------Test case 1-----------------");
        int [] a1 = {3,1,5,8};
        System.out.println("Max Coins = "+burstBaloons.maxCoins(a1));
        System.out.println();

        System.out.println("---------------Test case 2-----------------");
        int [] a2 = {1,5,3,8};
        System.out.println("Max Coins = "+burstBaloons.maxCoins(a2));
        System.out.println();

        System.out.println("---------------Test case 3-----------------");
        int [] a3 = {5 , 2 , 3 ,2};
        System.out.println("Max Coins = "+burstBaloons.maxCoins(a3));
    }

    public int maxCoins(int[] arr) {
        return burstBalloons(arr, 0, arr.length - 1, new Integer[arr.length][arr.length]);
    }

    private int burstBalloons(int[] arr, int left, int right, Integer[][] dp) {
        if(left < 0 || right < 0 ||left >= arr.length || right >= arr.length) return 0;

        if(dp[left][right] != null) return dp[left][right];
        int max = 0;
        int prev = left - 1 >= 0 ? arr[left - 1] : 1;
        int next = right + 1 < arr.length ? arr[right + 1] : 1;

        for(int i = left; i <= right; i++) {
            max = Math.max(max, burstBalloons(arr, left, i - 1, dp) + (prev * arr[i] * next) + burstBalloons(arr, i + 1, right, dp));
        }

        return dp[left][right] = max;
    }
}
