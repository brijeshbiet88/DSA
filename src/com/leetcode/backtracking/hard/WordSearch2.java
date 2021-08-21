package com.leetcode.backtracking.hard;

import java.util.*;

public class WordSearch2 {
    public static void main(String[] args) {
        System.out.println("---------------Test Case 1--------------------");
        char [][] board = {{'o','a','n','n'},
                           {'e','t','a','e'},
                           {'i','h','k','r'},
                           {'i','f','l','v'}};
        String [] words = {"oath" , "pea", "eat","rain"};
        List<String> result = findWords(board ,words);
        System.out.println("Print All the words ");
        result.forEach(word->{
            System.out.print(word+" ");
        });
        System.out.println();
    }

    public static List<String> findWords(char[][] board, String[] words) {
        List<String > result = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for(int i = 0; i < board.length ; i++) {
            for(int j = 0 ; j < board[0].length ; j++) {
                dfs(board , i , j , root , result);
            }
        }
        return result;
    }

    static class TrieNode{
        TrieNode [] children = new TrieNode[26];
        String word;
    }

    public static TrieNode buildTrie(String [] words){
        TrieNode root = new TrieNode();
        for(String w : words){
            TrieNode current = root;
            for(char c : w.toCharArray()){
                int i = c - 'a';
                if(current.children[i] == null)
                    current.children[i] = new TrieNode();
                    current = current.children[i];

            }
            current.word = w;
        }
        return  root;
    }

    private static void dfs(char [][] board , int i , int j , TrieNode root , List<String> result){
        char c = board[i][j];
        if(c == '$' || root.children[c - 'a'] == null)
            return;
        root = root.children[c - 'a'];
        if(root.word != null){
            result.add(root.word);
            root.word = null;
        }
        board[i][j] = '$';


        if(i > 0)
            dfs(board, i-1, j, root, result);
        if(j > 0)
            dfs(board, i, j-1, root, result);
        if(i < board.length - 1)
            dfs(board, i+1, j, root, result);
        if(j < board[0].length -1 )
            dfs(board, i, j+1, root, result);

        board[i][j] = c;

    }
}
