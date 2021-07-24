package com.leetcode.list.easy;


import com.leetcode.list.ListNode;
import com.leetcode.list.ListUtil;

public class IntersectionOfTwoList {

	public static void main(String[] args) {
		ListNode headA = ListUtil.getLinkedList();
		
		ListNode headB = new ListNode(4);
		ListNode node2 = new ListNode(6);
		
		headB.next = node2;
		node2.next = headA.next.next;
		ListNode intersection = getIntersectionNode(headA, headB);
		System.out.println("Intersection Node = "+intersection.val);
		

	}
	
	  public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	       
	        int l1 = 0 , l2 = 0;
	        
	        ListNode tmp1 = headA;
	        while(tmp1 != null){
	            l1++;
	            tmp1 = tmp1.next;
	        }
	        
	        ListNode tmp2 = headB;
	        while(tmp2 != null){
	            l2++;
	            tmp2 = tmp2.next;
	        }
	        
	        tmp1 = headA;
	        tmp2 = headB;
	        
	        int count = 0;
	        if(l1 > l2){
	            while(count < (l1-l2)){
	                tmp1 = tmp1.next;
	                count++;
	            }
	        }else{
	          while(count < (l2-l1)){
	                tmp2 = tmp2.next;
	              count++;
	          }
	            
	        }
	            
	        while(tmp1 != null){
	            if(tmp1 == tmp2){
	                return tmp1;
	            }
	            
	            tmp1 = tmp1.next;
	            tmp2 = tmp2.next;
	        }    
	            
	        return tmp1;
	    }

}
