package com.leetcode.list.easy;

import com.leetcode.list.ListNode;
import com.leetcode.list.ListUtil;

public class RemoveElement {

	public static void main(String[] args) {
		ListNode l1 = ListUtil.getLinkedList();
		
		ListNode head = new ListNode(2);
		head.next = l1;
		int val = 2;
		System.out.println("Print List Before Removing "+val);
		ListUtil.printList(head);
		System.out.println();
		
		head = removeElements(head, val);
		
		System.out.println("Print List After Removing "+val);
		ListUtil.printList(head);
		System.out.println();
		
	}

	public static ListNode removeElements(ListNode head, int val) {
		if(head == null) return head;
		
		while(head != null && head.val == val) {
			head = head.next;
		}
		
		ListNode prev = null, curr = head;
		
		while(curr != null) {
			if(curr.val == val) {
				prev.next = curr.next;
				curr = curr.next;
			}else {
				prev = curr;
				curr = curr.next;
			}
			
		}
		
		return head;

	}

}
