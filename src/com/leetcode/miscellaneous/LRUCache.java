package com.leetcode.miscellaneous;

import java.util.HashMap;
import java.util.Map;

    public class LRUCache {
        public static void main(String[] args) {
            LRUCache cache = new LRUCache(2);
            cache.put(1,1);
            cache.put(2,2);
            System.out.println("Get 1 = "+cache.get(1));
            cache.put(3,3);
            System.out.println("Get 2 = "+cache.get(2));
            cache.put(4,4);
            System.out.println("Get 1 = "+cache.get(1));
            System.out.println("Get 3 = "+cache.get(3));
            System.out.println("Get 4 = "+cache.get(4));
         }


        Map<Integer , Node> map ;
        int capacity ;
        Node head ;
        Node last;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<Integer,Node>();
            head = new Node(-1 , -1);
            last = new Node(-1 , -1);
            head.next = last;
            last.prev = head;
        }

        public int get(int key) {
            Node node = map.get(key);
            if(node == null)
                return -1;

            remove(node);
            insert(node);
            return node.value;
        }

        public void put(int key, int value) {
            if(map.containsKey(key)){
                remove(map.get(key));
            }
            if(map.size() == capacity){
                remove(last.prev);
            }

            insert(new Node(key , value));
        }

        private void insert(Node node){
            map.put(node.key , node);
            node.next = head.next;
            head.next.prev = node;
            node.prev = head;
            head.next = node;
        }

        private void remove(Node node){
            map.remove(node.key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    class Node {
        int key ;
        int value ;
        Node next;
        Node prev;

        public Node(int key , int value){
            this.key = key;
            this.value = value;
        }
    }
