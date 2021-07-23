package com.leetcode.list.easy;

import com.leetcode.list.ListNode;
import com.leetcode.list.ListUtil;

public class ReverseList {

	public static void main(String[] args) {
		ListNode head = ListUtil.getLinkedList();
		System.out.println("Print List Before Reversing : ");
		ListUtil.printList(head);
		ListNode revHead = reverseList(head);
		System.out.println("Print List After Reversing : ");
		ListUtil.printList(revHead);
	}
	
	public static ListNode reverseList(ListNode head) {
		if (head == null)
			return head;

		ListNode prev = null;
		ListNode curr = head;
		ListNode next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		return prev;

	}

}
