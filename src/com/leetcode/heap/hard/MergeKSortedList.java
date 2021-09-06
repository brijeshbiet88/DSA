package com.leetcode.heap.hard;

import com.leetcode.list.ListNode;
import com.leetcode.list.ListUtil;

import java.util.PriorityQueue;

public class MergeKSortedList {
    public static void main(String[] args) {
        System.out.println("----------------Test Case 1---------------------");
        ListNode l1 = ListUtil.getEvenLinkedList();
        ListNode l2 = ListUtil.getOddLinkedList();
        ListNode l3 = ListUtil.getLinkedList();

        ListNode [] lists = new ListNode[3];
        lists[0] = l1;
        lists[1] = l2;
        lists[2] = l3;

        ListNode result = mergeKLists(lists);
        System.out.println("Print Resultant List : ");
        ListUtil.printList(result);
        System.out.println();
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b)-> a.val - b.val);
        for (ListNode list : lists)
            if(list != null)
             minHeap.add(list);

        while (minHeap.size() > 0){
            current.next = minHeap.poll();
            current = current.next;
            if(current.next != null)
                minHeap.add(current.next);
        }
        return dummy.next;
    }
}
