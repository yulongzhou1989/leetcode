package leetcode.singleLinkedList;

import common.ListNode;

public class ReverseLinkedList_206 {
	public ListNode reverseList1(ListNode head) {
		return reverseList(head, null);
	}
	
	private ListNode reverseList(ListNode head, ListNode newHead){
		if(head==null) return newHead;
		ListNode next = head.next;
		head.next = newHead;
		return reverseList(next, head);
	}
	
	public ListNode reverseList(ListNode head) {
		if(head == null) return null;
		ListNode newHead = null;
		while(head!=null){
			ListNode next = head.next;
			head.next = newHead;
			newHead = head;
			head = head.next;
		}
		
		return newHead;
	}
}
