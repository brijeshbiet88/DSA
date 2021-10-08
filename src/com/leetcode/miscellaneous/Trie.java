package com.leetcode.miscellaneous;

import java.util.HashMap;
import java.util.Map;

class Trie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println("Search = "+trie.search("apple"));
        System.out.println("Search = "+trie.search("app"));
        System.out.println("Search = "+trie.startsWith("app"));
        trie.insert("app");
        System.out.println("Search = "+trie.startsWith("app"));

    }

    TrieNode root ;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode trieNode = root;
        char [] words = word.toCharArray();
        for(int i = 0 ; i < words.length ; i++){
            if(trieNode.map.containsKey(words[i])){
                trieNode = trieNode.map.get(words[i]);
            }else{
                trieNode.map.put(words[i] , new TrieNode(words[i]));
                trieNode = trieNode.map.get(words[i]);
            }

        }
        trieNode.isLast = true;
    }

    public boolean search(String word) {
        TrieNode trieNode = root;
        char [] words = word.toCharArray();
        for(int i = 0 ; i < words.length ; i++){
            if(trieNode.map.containsKey(words[i])){
                trieNode = trieNode.map.get(words[i]);
            }else{
                return false;
            }
        }

        return trieNode.isLast == true;
    }

    public boolean startsWith(String prefix) {
        TrieNode trieNode = root;
        char [] words = prefix.toCharArray();
        for(int i = 0 ; i < words.length ; i++){
            if(trieNode.map.containsKey(words[i])){
                trieNode = trieNode.map.get(words[i]);
            }else{
                return false;
            }
        }

        return true;
    }
}

class TrieNode{

    public char ch ;
    boolean isLast;
    public Map<Character , TrieNode> map ;
    public TrieNode(char ch){
        this.ch = ch;
        map = new HashMap<Character , TrieNode>();
        isLast = false;
    }

    public TrieNode(){

        map = new HashMap<Character , TrieNode>();
    }
}
