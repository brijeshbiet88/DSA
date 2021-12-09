package com.leetcode.tree.medium;

import com.leetcode.list.ListNode;
import com.leetcode.list.ListUtil;
import com.leetcode.tree.TreeNode;
import com.leetcode.tree.TreeUtil;

public class SortedListToBST {

    public static void main(String[] args) {
        SortedListToBST sortedListToBST = new SortedListToBST();
        System.out.println("---------------Test Case 1------------------");
        ListNode head = ListUtil.getLinkedList();
        TreeNode root = sortedListToBST.sortedListToBST(head);
        System.out.println("Print List : ");
        ListUtil.printList(head);
        System.out.println("\nPrint BST : ");
        TreeUtil.traverseLevelByLevel(root);

        System.out.println();
    }

    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)
            return null;
        return bst(head,null);
    }

    private TreeNode bst(ListNode head,ListNode tail)
    {
        ListNode fast = head;
        ListNode slow = head;

        if(head == tail)
            return null;

        while(fast!=tail && fast.next!=tail)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode treeHead = new TreeNode(slow.val);
        treeHead.left =  bst(head,slow);
        treeHead.right = bst(slow.next,tail);

        return treeHead;
    }
}
