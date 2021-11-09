package com.leetcode.miscellaneous;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NoOfValidWordsInPuzzle {
    public static void main(String[] args) {
        String [] words = {"aaaa","asas","able","ability","actt","actor","access"};
        String [] puzzles = {"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};

        List<Integer> res = findNumOfValidWords(words , puzzles);
        System.out.println("Result ");
        res.forEach(num-> System.out.print(num+" "));
    }

    public static List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> wordCount = new HashMap();
        for (String word : words) {
            int mask = getBitmask(word);
            wordCount.put(mask, wordCount.getOrDefault(mask, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (String puzzle : puzzles) {
            int first = 1 << (puzzle.charAt(0) - 'a');
            int count = wordCount.getOrDefault(first, 0);

            int mask = getBitmask(puzzle.substring(1));

            for (int submask = mask; submask > 0; submask = (submask - 1) & mask) {
                count += wordCount.getOrDefault(submask | first, 0);
            }
            result.add(count);
        }
        return result;
    }

    private static int getBitmask(String word) {
        int mask = 0;
        for (char ch : word.toCharArray()) {
            mask = mask | (1 << (ch - 'a'));
        }
        return mask;
    }

}
