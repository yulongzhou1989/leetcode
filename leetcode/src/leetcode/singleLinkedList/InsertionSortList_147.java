package leetcode.singleLinkedList;

import common.ListNode;

public class InsertionSortList_147 {
	public ListNode insertionSortList(ListNode head) {
        if(head == null) return head;
		ListNode dummy = new ListNode(0);
		//dummy.next = head;
		ListNode pre = dummy;//start of the sorted list
		ListNode cur = head;//node need to be moved

		while(cur!=null){
			ListNode next = cur.next;//next node will be inserted
			while(pre.next!=null && pre.next.val<cur.val){//find place to insert
				pre = pre.next;
			}
			//insert cur to pre and pre.next
			cur.next = pre.next;
			pre.next = cur;
			cur = next;
			pre = dummy;
		}
		
		return dummy.next;
    }
}
