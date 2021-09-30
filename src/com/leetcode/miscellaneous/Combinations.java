package com.leetcode.miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        System.out.println("-----------------Test Case 1-------------------");
        int n = 4 , k = 2;
        List<List<Integer>> result = combine(n,k);
        System.out.println("Print Result ");
        result.forEach(list->{
            list.forEach(element -> System.out.print(element+" "));
            System.out.println();
        });
        System.out.println();
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (n <= 0 || n < k)
            return result;

        List<Integer> item = new ArrayList<Integer>();
        dfs(n, k, 1, item, result);

        return result;
    }

    private static void dfs(int n, int k, int start, List<Integer> item, List<List<Integer>> res) {
        if (item.size() == k) {
            res.add(new ArrayList<Integer>(item));
            return;
        }

        for (int i = start; i <= n; i++) {
            item.add(i);
            dfs(n, k, i + 1, item, res);
            item.remove(item.size() - 1);
        }
    }
}
