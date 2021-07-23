package com.leetcode.list.easy;

import com.leetcode.list.ListNode;
import com.leetcode.list.ListUtil;

public class MergeTwoSortedList {

	public static void main(String[] args) {
		ListNode l1 = ListUtil.getEvenLinkedList();
		ListNode l2 = ListUtil.getOddLinkedList();
		ListNode merged = mergeTwoLists(l1, l2);
		System.out.println("Print Merged Lisned List :");
		ListUtil.printList(merged);

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
