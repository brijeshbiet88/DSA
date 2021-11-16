package com.leetcode.tree.hard;

import com.leetcode.tree.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SerializeDeserializenaryTree {
    public static void main(String[] args) {
        SerializeDeserializenaryTree obj = new SerializeDeserializenaryTree();
        List<Node> ls1 = new ArrayList<Node>();
        Node ls1Node1 = new Node(2,null);
        Node ls1Node2 = new Node(3,null);
        Node ls1Node3 = new Node(4,null);
        ls1.add(ls1Node1);ls1.add(ls1Node2);ls1.add(ls1Node3);
        Node root = new Node(1, ls1);


        List<Node> ls2 = new ArrayList<Node>();
        Node ls2Node1 = new Node(5,null);
        Node ls2Node2 = new Node(6,null);
        ls2.add(ls2Node1);ls2.add(ls2Node2);

        root.children.get(0).children = ls2;

        List<Node> ls3 = new ArrayList<Node>();
        Node ls3Node1 = new Node(7,null);
        ls3.add(ls3Node1);

        root.children.get(1).children = ls3;

        List<Node> ls4 = new ArrayList<Node>();
        Node ls4Node1 = new Node(8,null);
        ls4.add(ls4Node1);

        root.children.get(2).children = ls4;

        String serilizedNaryTree = obj.serialize(root);
        System.out.println("Serialized Tree = "+serilizedNaryTree);

        Node deserializedNode = obj.deserialize(serilizedNaryTree);
        boolean isSame = serilizedNaryTree.equals(obj.serialize(deserializedNode));
        System.out.println("Are Both Same ? "+isSame);
        return;

    }

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        List<String> ls = new LinkedList<String>();
        serial(root, ls);

        return String.join(",", ls);
    }

    private void serial(Node root, List<String> ls){
        if(root == null){
            return;
        }

        ls.add(String.valueOf(root.val));
        if(root.children != null) {
            ls.add(String.valueOf(root.children.size()));
            for (Node child : root.children) {
                serial(child, ls);
            }
        }else{
            ls.add("0");
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data == null || data.length() == 0){
            return null;
        }

        LinkedList<String> que = new LinkedList<String>();
        que.addAll(Arrays.asList(data.split(",")));
        return deserial(que);
    }

    private Node deserial(LinkedList<String> que){
        int val = Integer.valueOf(que.poll());
        int size = Integer.valueOf(que.poll());

        Node root = new Node(val, new ArrayList<Node>());
        for(int i = 0; i<size; i++){
            root.children.add(deserial(que));
        }

        return root;
    }
}
