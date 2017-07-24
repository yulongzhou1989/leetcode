package leetcode.singleLinkedList;

import common.ListNode;

public class RemoveDuplicateFromSortedList_83 {
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = head;
		ListNode next = head.next;
		
		while(next!=null){
			if(pre.val == next.val){
				pre.next = next.next;
			}else{
				pre = pre.next;
			}
            next = next.next;
		}
		
		return dummy.next;
    }
}
