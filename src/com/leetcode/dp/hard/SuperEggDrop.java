package com.leetcode.dp.hard;

public class SuperEggDrop {

	public static void main(String[] args) {
		int k =2 , n = 10;
		System.out.println(" Min Attempts to Find The Floor = "+superEggDrop(k, n) );

	}
	
    public static  int superEggDrop(int k, int n) {
        
        int lo = 1, hi = n;
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            if (f(mi, k, n) < n)
                lo = mi + 1;
            else
                hi = mi;
        }

        return lo;
    }

    public static int f(int x, int K, int N) {
        int ans = 0, r = 1;
        for (int i = 1; i <= K; ++i) {
            r = r * (x-i+1);
            r = r / i;
            ans += r;
            if (ans >= N) break;
        }
        return ans;
    }

}
