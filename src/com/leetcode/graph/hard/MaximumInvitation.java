package com.leetcode.graph.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumInvitation {
    public static void main(String[] args) {
        MaximumInvitation maximumInvitation = new MaximumInvitation();
        System.out.println("--------------Test Case 1------------------");
        int [] favourites1 = {2,2,1,2};
        System.out.println("Maximum Invitation = "+maximumInvitation.maximumInvitations(favourites1));
        System.out.println();

        System.out.println("--------------Test Case 2------------------");
        int [] favourites2 = {1,2,0};
        System.out.println("Maximum Invitation = "+maximumInvitation.maximumInvitations(favourites2));
        System.out.println();

        System.out.println("--------------Test Case 3------------------");
        int [] favourites3 = {3,0,1,4,1};
        System.out.println("Maximum Invitation = "+maximumInvitation.maximumInvitations(favourites3));
        System.out.println();
    }

    public int maximumInvitations(int[] favorite) {
        List<Integer>[] list = new ArrayList[favorite.length];
        for (int i = 0; i < favorite.length; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < favorite.length; i++) {
            list[favorite[i]].add(i);
        }
        int max = 0, visited[] = new int[favorite.length];
        for (int i = 0; i < favorite.length; i++) {
            max += i < favorite[i] || favorite[favorite[i]] != i ? 0
                    : maximumInvitations(i, favorite[i], list) + maximumInvitations(favorite[i], i, list);
        }
        for (int i = 0, j; (j = i) < favorite.length; i++) {
            if (visited[i] == 0) {
                Map<Integer, Integer> map = new HashMap<>();
                for (int k = 0; visited[j] == 0; visited[j] = 1, map.put(j, k++), j = favorite[j]) {
                }
                max = Math.max(max, map.size() - map.getOrDefault(j, map.size()));
            }
        }
        return max;
    }

    private int maximumInvitations(int i, int j, List<Integer>[] list) {
        int max = 0;
        for (int k : list[i]) {
            max = Math.max(max, k == j ? 0 : maximumInvitations(k, j, list));
        }
        return 1 + max;
    }
}
