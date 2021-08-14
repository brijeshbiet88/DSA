package com.leetcode.tree.medium;

import com.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UniqueBST2 {

    static private HashMap<String, List<TreeNode>> map;

    public static void main(String[] args) {
        int n = 5;
        System.out.println("No of Unique BST "+generateTrees(n).size());
    }

    public static List<TreeNode> generateTrees(int n) {
        map = new HashMap<>();
        List<TreeNode> list = generateTreesHelper(1, n);
        return list;

    }

    private static List<TreeNode> generateTreesHelper(int start, int end){
        List<TreeNode> answer = new ArrayList<>();
        if(start > end){
            answer.add(null);
            return answer;
        }else if(start == end){
            answer.add(new TreeNode(start));
            return answer;
        }
        String str = start + ":" + end;
        if(map.containsKey(str)){
            return map.get(str);
        }
        for(int i = start; i <= end; i++){
            List<TreeNode> left = generateTreesHelper(start, i-1);
            List<TreeNode> right = generateTreesHelper(i+1, end);
            for(TreeNode leftNode : left){
                for(TreeNode rightNode : right){
                    TreeNode node = new TreeNode(i);
                    TreeNode leftNodeClone = cloneTree(leftNode);
                    TreeNode rightNodeClone = cloneTree(rightNode);
                    node.left = leftNodeClone;
                    node.right = rightNodeClone;
                    answer.add(node);
                }
            }
        }
        map.put(str, answer);
        return answer;
    }

    private static TreeNode cloneTree(TreeNode root) {
        if (root == null) return null;
        TreeNode newNode = new TreeNode(root.val);
        newNode.left = cloneTree(root.left);
        newNode.right = cloneTree(root.right);
        return newNode;
    }

}
