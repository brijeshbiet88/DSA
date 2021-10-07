package com.leetcode.list.medium;

import com.leetcode.list.ListNode;
import com.leetcode.list.ListUtil;

public class ReverseLL2 {
    public static void main(String[] args) {
        System.out.println("-----------------Test Case 1--------------------");
        ListNode head = ListUtil.getLinkedList();
        System.out.println("\nPrint List Before ");
        ListUtil.printList(head);
        int left = 2 , right = 4;
        head = reverseBetween(head , left , right);
        System.out.println("\nPrint List After ");
        ListUtil.printList(head);

        System.out.println();
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right || head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        ListNode leftHead = head;
        ListNode leftTail = head;
        int count = 1;
        while (count < left){
            leftTail = leftTail.next;
            count++;
        }

        ListNode mid = leftTail.next;
        leftTail.next = null;
        leftTail.next = reverse(mid , right - left+1);

        return dummy.next;
    }

    public static ListNode reverse(ListNode head , int n){

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        int count = 0;
        while(curr != null && count < n ){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        head.next = curr;

        return prev;
    }
}
