package leetcode.sort.DivideAndConque;

import common.ListNode;

public class SortList_148 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode sortList(ListNode head) {
        //merge sort
		if(head==null || head.next == null) return head;
		
		ListNode slow = head;
		ListNode fast = head;
		ListNode pre = null;
		
		while(fast!=null && fast.next!=null){
			fast = fast.next.next;
			pre = slow;
			slow = slow.next;
		}
		//empty node after mid
		pre.next = null;
		//sort 2 different parts
		ListNode l1 = sortList(head);
		ListNode l2 = sortList(slow);
		
		return merge(l1, l2);
    }
	
	public ListNode merge(ListNode l1, ListNode l2){
		ListNode l = new ListNode(0);
		ListNode p = l;
		
		while(l1!=null && l2!=null){
			if(l1.val<l2.val){
				p.next = l1;
				l1 = l1.next;
			}
			else{
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
		}
		
		if(l1!=null) p.next = l1;
		if(l2!=null) p.next = l2;
		
		return l.next;
	}

}
