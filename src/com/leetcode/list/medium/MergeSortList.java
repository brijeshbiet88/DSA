package com.leetcode.list.medium;

import com.leetcode.list.ListNode;
import com.leetcode.list.ListUtil;

public class MergeSortList {
    public static void main(String[] args) {
        System.out.println("-------------Test Case 1-----------------");
        ListNode head1 = new ListNode(5);
        head1.next = new ListNode(1);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);

        System.out.println("print List Before Sorting :");
        ListUtil.printList(head1);
        head1 = sortList(head1);
        System.out.println("print List After Sorting :");
        ListUtil.printList(head1);
        System.out.println();

        System.out.println("-------------Test Case 2-----------------");
        ListNode head2 = new ListNode(7);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(6);

        System.out.println("print List Before Sorting :");
        ListUtil.printList(head2);
        head2 = sortList(head2);
        System.out.println("print List After Sorting :");
        ListUtil.printList(head2);
        System.out.println();
    }

    private static ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode mid = findMiddle(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        ListNode left = sortList(l1);
        ListNode right = sortList(l2);
        return mergeTwoLists(left , right);
    }

    public static ListNode findMiddle(ListNode head){
        if(head == null || head.next == null) return null;

        ListNode temp = head;
        int len = 0;
        while(temp != null){
            temp = temp.next;
            len++;
        }
        len = len % 2 == 0 ? len/2 : len/2 + 1;
        temp = head;
        for (int i = 0 ; i < len - 1 ; i++){
            temp = temp.next;
        }
        return temp;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode head = new ListNode(0);
        ListNode tail = head;

        while(l1 != null && l2 != null) {

            if(l1.val < l2.val) {
                tail.next = l1;
                tail = tail.next;
                l1 = l1.next;
            }else {
                tail.next = l2;
                tail = tail.next;
                l2 = l2.next;
            }

            if(l1 == null)
                tail.next = l2;
            else
                tail.next = l1;

        }

        return head.next;
    }
}
