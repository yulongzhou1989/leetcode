package leetcode.singleLinkedList;

import common.ListNode;

public class ReverseNodesInKGroup_25 {
	public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
		int i=0;
		for(;cur!=null && i<k;i++){//find the kth node
			cur = cur.next;
		}
		
		if(i==k){
			cur = reverseKGroup(cur, k);//reverse k node
			while(i-->0){
				ListNode next = head.next;
				head.next = cur;
				cur = head;
				head = next;
			}
		} else {
            return head;
        }
		
		return cur;
    }
}
