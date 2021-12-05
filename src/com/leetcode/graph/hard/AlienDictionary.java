package com.leetcode.graph.hard;

import java.util.*;

public class AlienDictionary {
    public static void main(String[] args) {
        System.out.println("------------------Test Case 1--------------------");
        String [] words = {"wrt","wrf","er","ett","rftt"};
        System.out.println("Lexicographically Sorted Characters = "+alienOrder(words));
        System.out.println();

        System.out.println("------------------Test Case 2--------------------");
        String [] words2 = {"z","x"};
        System.out.println("Lexicographically Sorted Characters = "+alienOrder(words2));
        System.out.println();

        System.out.println("------------------Test Case 3--------------------");
        String [] words3 = {"z","x","z"};
        System.out.println("Lexicographically Sorted Characters = "+alienOrder(words3));
        System.out.println();
    }

    public static String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        int[] inDegree = new int[26];
        buildGraph(words, graph, inDegree);

        String order = topologicalSort(graph, inDegree);
        return order.length() == graph.size() ? order : "";
    }

    private static void buildGraph(String[] words, Map<Character, Set<Character>> graph, int[] inDegree) {
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.put(c, new HashSet<>());
            }
        }

        for (int i = 1; i < words.length; i++) {
            String first = words[i - 1];
            String second = words[i];
            int length = Math.min(first.length(), second.length());

            for (int j = 0; j < length; j++) {
                char parent = first.charAt(j);
                char child = second.charAt(j);
                if (parent != child) {
                    if (!graph.get(parent).contains(child)) {
                        graph.get(parent).add(child);
                        inDegree[child - 'a']++;
                    }
                    break;
                }
            }
        }
    }

    private static String topologicalSort(Map<Character, Set<Character>> graph, int[] inDegree) {
        Queue<Character> queue = new LinkedList<>();
        for (char c : graph.keySet()) {
            if (inDegree[c - 'a'] == 0) {
                queue.offer(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            for (char neighbor : graph.get(c)) {
                inDegree[neighbor - 'a']--;
                if (inDegree[neighbor - 'a'] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return sb.toString();
    }


}
