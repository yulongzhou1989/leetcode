package leetcode.singleLinkedList;

import common.ListNode;

public class RemoveLinkedListElement_203 {
	public ListNode removeElements(ListNode head, int val) {
        if(head==null) return null;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
        ListNode cur = head;
		
		while(cur!=null){
			if(cur.val == val){
				pre.next = cur.next;
			}else{
				pre = pre.next;
			}
			cur = cur.next;
		}
		
		return dummy.next;
    }
}
