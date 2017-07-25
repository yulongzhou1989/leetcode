package leetcode.list;

import common.ListNode;

public class ReverseLinkedListII_92 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        //1->2->3->4->5
        for(int i=0;i<m-1;i++){
            pre = pre.next;
        }
        ListNode start = pre.next;
        ListNode then = start.next;
        
        for(int i=0;i<n-m;i++){
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        
        return dummy.next;
    }
}
