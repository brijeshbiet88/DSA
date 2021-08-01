package com.leetcode.list.hard;

import java.util.PriorityQueue;

import com.leetcode.list.ListNode;
import com.leetcode.list.ListUtil;

public class MergeKSortedList {

	public static void main(String[] args) {
		ListNode list1 = new ListNode(4);

		ListNode node2 = new ListNode(6);
		ListNode node3 = new ListNode(7);
		ListNode node4 = new ListNode(8);
		
		list1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		
		ListNode list2 = new ListNode(2);

		ListNode node22 = new ListNode(4);
		ListNode node23 = new ListNode(5);
		ListNode node24 = new ListNode(5);
		
		list2.next = node22;
		node22.next = node23;
		node23.next = node24;
		
		ListNode list3 = new ListNode(1);

		ListNode node32 = new ListNode(2);
		ListNode node33 = new ListNode(5);
		
		list3.next = node32;
		node32.next = node33;
		
		ListNode [] lists = new ListNode[3];
		lists[0] = list1;
		lists[1] = list2;
		lists[2] = list3;
		
		ListNode head = mergeKLists(lists);

		System.out.println("print List After Merging ");
		ListUtil.printList(head);
	}
	
	public static ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node: lists)
            if (node != null)
                pq.offer(node);
        
        ListNode preHead = new ListNode();
        ListNode curr = preHead;
        while (!pq.isEmpty()) {
            curr.next = pq.poll();
            curr = curr.next;
            if (curr.next != null)
                pq.offer(curr.next);
        }
        return preHead.next;
	}

}
