package leetcode.twoPointers;

import common.ListNode;

public class LinkedListCycler_141 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//one move one step, the other move 2 steps, judge if meet
	public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode h1 = head;
        ListNode h2 = head;
        
        while(h2.next!=null && h2.next.next!=null){
            h1 = h1.next;
            h2 = h2.next.next;
            if (h1 == h2) return true;
        }
        
        return false;
    }
}
