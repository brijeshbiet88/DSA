package com.leetcode.list.medium;

import com.leetcode.list.ListNode;
import com.leetcode.list.ListUtil;

public class RemoveNthNodeFromEnd {

	public static void main(String[] args) {
		ListNode head = ListUtil.getLinkedList();
		System.out.println("Print List Before Removing ");
		ListUtil.printList(head);
		System.out.println();
		head = removeNthFromEnd(head, 2);
		System.out.println("Print List After Removing ");
		ListUtil.printList(head);

	}

	 public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode tmp = head;
		int len = 0;
		while(tmp != null) {
			tmp = tmp.next;
			len++;
		}
		if(len == n) {
			return head.next;
		}
		int count = 0;
		tmp = head;
		while(count < (len -n -1)) {
			tmp = tmp.next;
			count++;
		}
		tmp.next = tmp.next.next;
		
	     return head;   
	 }
}
