package com.leetcode.bfs.medium;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        System.out.println("----------------Test Case 1--------------------");
        String beginWord = "hit";
        String endWord="cog";
        List<String> wordList = new ArrayList<>();
        wordList.addAll(Arrays.asList("hot","dot","dog","lot","log","cog"));
        System.out.println("Result = "+ladderLength(beginWord ,endWord, wordList));
        System.out.println();
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet(wordList);
        Queue<String> queue = new LinkedList();
        Set<String> visited = new HashSet();
        queue.add(beginWord);
        visited.add(beginWord);

        int level = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i <n; i++) {
                String word = queue.poll();
                if (word.equals(endWord))
                    return level + 1;

                char[] ch = word.toCharArray();

                for (int j = 0; j < ch.length; j++) {
                    char backup = ch[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        ch[j] = c;
                        String nextWord = String.valueOf(ch);
                        if (!visited.contains(nextWord) && wordSet.contains(nextWord)) {
                            queue.add(nextWord);
                            System.out.println(nextWord+" ");
                            visited.add(nextWord);
                        }
                    }
                    ch[j] = backup;
                }
            }
            level++;
        }

        return 0;
    }
}
