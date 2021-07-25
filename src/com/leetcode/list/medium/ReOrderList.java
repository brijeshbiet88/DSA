package com.leetcode.list.medium;

import com.leetcode.list.ListNode;
import com.leetcode.list.ListUtil;

public class ReOrderList {

	public static void main(String[] args) {
		ListNode head = ListUtil.getLinkedList();
		System.out.println("Print List Before Reordering ");
		ListUtil.printList(head);
		System.out.println();
		reorderList(head);
		System.out.println("Print List After Reordering ");
		ListUtil.printList(head);

	}

	public static void reorderList(ListNode head) {
		if(head == null || head.next == null) return;
		
		ListNode slow = head , fast = slow.next;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		ListNode preMiddle = slow;
		ListNode secondHalf = slow.next;
		slow.next = null;
		secondHalf = ListUtil.reverse(secondHalf);
		
		ListNode secNext = null;
		ListNode firsNext = null;
		ListNode temp = head;
		
		while(secondHalf != null) {
			firsNext = temp.next;
			temp.next = secondHalf;
			secNext = secondHalf.next;
			secondHalf.next = firsNext;
			temp = firsNext;
			secondHalf = secNext;
		}

	}
}
