package com.leetcode.list.medium;

import com.leetcode.list.ListNode;
import com.leetcode.list.ListUtil;

public class AddTwoNumbers {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		
		ListNode result = addTwoNumbers(l1, l2);
		System.out.println("Print Result After Addition : ");
		ListUtil.printList(result);
		
		
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode tail = head;
		int carry = 0;
		int currentSum = 0;
		while(l1 != null && l2 != null) {
			currentSum = carry + l1.val + l2.val;
			carry = currentSum /10;
			currentSum = currentSum % 10;
			tail.next = new ListNode(currentSum);
			tail = tail.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		
		while(l1 != null) {
			currentSum = carry + l1.val;
			carry = currentSum /10;
			currentSum = currentSum % 10;
			tail.next = new ListNode(currentSum);
			tail = tail.next;
			l1 = l1.next;
			
		}
		
		while(l2 != null) {
			currentSum = carry + l2.val;
			carry = currentSum /10;
			currentSum = currentSum % 10;
			tail.next = new ListNode(currentSum);
			tail = tail.next;
			l2 = l2.next;
			
		}
		
		if(carry > 0) {
			tail.next = new ListNode(carry);
		}
		
		return head.next;
        
    }
}
