package com.leetcode.list.medium;

import com.leetcode.list.ListNode;
import com.leetcode.list.ListUtil;

public class SortList {

	public static void main(String[] args) {
		ListNode head = new ListNode(4);

		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(1);
		ListNode node4 = new ListNode(3);
		
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		head = sortList(head);
		System.out.println("Print List After Sorting ");
		ListUtil.printList(head);
	}
	
	public static ListNode sortList(ListNode head) {
		 if (head == null || head.next == null)
	            return head;
	        ListNode mid = getMiddle(head);
	        ListNode left = sortList(head);
	        ListNode right = sortList(mid);
	        return merge(left, right);
        
    }
	
	 public static ListNode merge(ListNode list1, ListNode list2) {
	        ListNode dummyHead = new ListNode();
	        ListNode tail = dummyHead;
	        while (list1 != null && list2 != null) {
	            if (list1.val < list2.val) {
	                tail.next = list1;
	                list1 = list1.next;
	                tail = tail.next;
	            } else {
	                tail.next = list2;
	                list2 = list2.next;
	                tail = tail.next;
	            }
	        }
	        tail.next = (list1 != null) ? list1 : list2;
	        return dummyHead.next;
	    }

	    public static ListNode getMiddle(ListNode head) {
	        ListNode midPrev = null;
	        while (head != null && head.next != null) {
	            midPrev = (midPrev == null) ? head : midPrev.next;
	            head = head.next.next;
	        }
	        ListNode mid = midPrev.next;
	        midPrev.next = null;
	        return mid;
	    }

}
