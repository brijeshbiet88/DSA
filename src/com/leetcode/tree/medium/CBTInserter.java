package com.leetcode.tree.medium;

import com.leetcode.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class CBTInserter {

    public static void main(String[] args) {
        System.out.println("------------Test Case 1---------------");
        TreeNode root = new TreeNode(1);
        CBTInserter cbtInserter = new CBTInserter(root);
        System.out.println("Insert = "+cbtInserter.insert(2));
        System.out.println("Insert = "+cbtInserter.insert(3));
        System.out.println("Insert = "+cbtInserter.insert(4));
        System.out.println("Insert = "+cbtInserter.insert(5));
        System.out.println("Get Root = "+cbtInserter.get_root());
        System.out.println();
    }

    TreeNode root;
    Deque<TreeNode> deque;
    public CBTInserter(TreeNode root) {
        this.root = root;
        deque = new LinkedList();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        // BFS to populate deque
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null || node.right == null)
                deque.offerLast(node);
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }
    }

    public int insert(int v) {
        TreeNode node = deque.peekFirst();
        deque.offerLast(new TreeNode(v));
        if (node.left == null)
            node.left = deque.peekLast();
        else {
            node.right = deque.peekLast();
            deque.pollFirst();
        }

        return node.val;
    }

    public TreeNode get_root() {
        return root;
    }

}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */
