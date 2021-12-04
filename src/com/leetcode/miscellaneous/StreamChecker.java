package com.leetcode.miscellaneous;

public class StreamChecker {
    public static void main(String[] args) {
        System.out.println("-----------------Test Case 1-------------------");
        String [] words = {"cd" , "f", "kl", "god" , "go"};
        StreamChecker streamChecker = new StreamChecker(words);
        System.out.println("Add a "+streamChecker.query('a'));
        System.out.println("Add c "+streamChecker.query('c'));
        System.out.println("Add d "+streamChecker.query('d'));
        System.out.println("Add f "+streamChecker.query('f'));
        System.out.println("Add j "+streamChecker.query('j'));
        System.out.println("Add k "+streamChecker.query('k'));
        System.out.println("Add l "+streamChecker.query('l'));
        System.out.println("Add g "+streamChecker.query('g'));
        System.out.println("Add o "+streamChecker.query('o'));
        System.out.println("Add d "+streamChecker.query('d'));

        System.out.println();
    }

    private class TrieNode{
        private TrieNode[] children = null;
        private boolean isLeaf;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }

    private TrieNode root = null;

    private StringBuilder queryString = null;

    public StreamChecker(String[] words) {
        root = new TrieNode();
        queryString = new StringBuilder();
        for(String word : words) {
            addWord(word);
        }
    }


    private void addWord(String word){
        TrieNode node = root;
        for(int i = word.length()-1; i>=0 ; i--){
            char c = word.charAt(i);
            int index = c - 'a';
            if(node != null && node.children[index] == null){
                TrieNode newNode = new TrieNode();
                node.children[index] = newNode;
            }
            node = node.children[index];
        }
        node.isLeaf = true;
    }

    public boolean query(char letter) {
        queryString.append(letter);
        return search(queryString.toString());
    }

    private boolean search(String queryStr){
        TrieNode node = root;
        for(int i=queryStr.length()-1;i>=0;i--){
            char c = queryStr.charAt(i);
            int index = c - 'a';

            if(node != null && node.children[index] != null){
                node = node.children[index];
                if(node.isLeaf){
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }
}
