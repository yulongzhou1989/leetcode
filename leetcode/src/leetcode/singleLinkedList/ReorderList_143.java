package leetcode.singleLinkedList;

import common.ListNode;

public class ReorderList_143 {
	public void reorderList(ListNode head) {
        if(head == null) return;
        ListNode p1 = head, p2=head;
		while(p2.next!=null && p2.next.next!=null){//find the middle point
			p1 = p1.next;
			p2 = p2.next.next;
		}
		
		//1->2->3->4->5->6->7
		//reverse
		ListNode mid = p1;
		ListNode pre = p1.next;
		ListNode newHead = null;
		while(pre!=null){
			ListNode next = pre.next;
			pre.next = newHead;
			newHead = pre;
			pre = next;
		}
		mid.next = null;
		
		//1->2->3->4 7->6->5
		p1 = head;
		p2 = newHead;
		while(p1!=null && p2!=null){
			ListNode p1Next = p1.next;
			ListNode p2Next = p2.next;
			p1.next = p2;
			p2.next = p1Next;
			p1 = p1Next;
			p2 = p2Next;
		}
    }
}
