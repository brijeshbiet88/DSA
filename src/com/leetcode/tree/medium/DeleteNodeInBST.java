package com.leetcode.tree.medium;

import com.leetcode.tree.TreeNode;

class DeleteNodeInBst {
     public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return root;
        }

        if(root.val < key){
            root.right = deleteNode(root.right, key);
            return root;
        }
        else if(root.val>key){
            root.left = deleteNode(root.left, key);
            return root;
        } else {
            if(root.left == null && root.right ==null){
                return null;
            }

            if(root.left ==null){
                return root.right;
            } else if(root.right == null){
                return root.left;
            } else {
                TreeNode nextMinNode = root.right;
                while(nextMinNode.left != null){
                    nextMinNode = nextMinNode.left;
                }

                nextMinNode.left = root.left;
                return root.right;
            }
        }
    }
}
