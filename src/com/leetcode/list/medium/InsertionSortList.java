package com.leetcode.list.medium;

import com.leetcode.list.ListNode;
import com.leetcode.list.ListUtil;

public class InsertionSortList {
    public static void main(String[] args) {
        InsertionSortList insertionSortList = new InsertionSortList();
        System.out.println("--------------Test Case 1------------------");
        ListNode head1 = ListUtil.getOddPalindromeList();
        System.out.println("Print Original List :");
        ListUtil.printList(head1);
        System.out.println();
        insertionSortList.insertionSortList(head1);
        System.out.println("Print Sorted List :");
        ListUtil.printList(head1);
        System.out.println();
        System.out.println();

        System.out.println("--------------Test Case 2------------------");
        ListNode head2 = ListUtil.getEvenPalindromeList();
        System.out.println("Print Original List :");
        ListUtil.printList(head2);
        System.out.println();
        insertionSortList.insertionSortList(head2);
        System.out.println("Print Sorted List :");
        ListUtil.printList(head2);
        System.out.println();
        System.out.println();
    }

    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode curr = head;
        ListNode next = null;

        while(curr != null){
            next = curr.next;

            while(prev.next != null && prev.next.val <= curr.val){
                prev = prev.next;
            }

            curr.next = prev.next;
            prev.next = curr;
            curr = next;
            prev = dummy;
        }

        return dummy.next;
    }
}
