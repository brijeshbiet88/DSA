package com.leetcode.tree.medium;

import com.leetcode.tree.TreeNode;
import com.leetcode.tree.TreeUtil;

public class CousinsInBT {
    static TreeNode xParent = null , yParent = null;
    static private int xDepth = -1 , yDepth = -2;

    public static void main(String[] args) {
        System.out.println("-----------Test Case 1------------------");
        TreeNode root = TreeUtil.getTree();
        int x = 4;
        int y = 5;
        System.out.println("Are x = "+x +" and y = "+y+" cosuins ? "+isCousins(root,x,y) );
        System.out.println();

        System.out.println("-----------Test Case 2------------------");
        x = 4;
        y = 6;
        System.out.println("Are x = "+x +" and y = "+y+" cosuins ? "+isCousins(root,x,y) );
        System.out.println();

        System.out.println("-----------Test Case 3------------------");
        x = 1;
        y = 3;
        System.out.println("Are x = "+x +" and y = "+y+" cosuins ? "+isCousins(root,x,y) );
        System.out.println();
    }


    public static boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return true;
        isCousinsHelper(root , x , y , 0 , null);
        return xDepth == yDepth && xParent != yParent;

    }

    public static void isCousinsHelper(TreeNode root , int x , int y , int depth , TreeNode parent){
        if(root == null) return;
        else if(root.val == x) {
            xParent = parent;
            xDepth =  depth;
        }
        else if(root.val == y) {
            yParent = parent;
            yDepth =  depth;
        }
        else{
            isCousinsHelper(root.left,x,y,depth+1,root);
            isCousinsHelper(root.right,x,y,depth+1,root);
        }

    }
}
