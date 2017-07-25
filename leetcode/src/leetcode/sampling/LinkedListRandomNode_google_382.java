package leetcode.sampling;

import java.util.Random;

import common.ListNode;

public class LinkedListRandomNode_google_382 {
	public class Solution {
	    ListNode head;
		Random rand;
		
		/** @param head The linked list's head.
	        Note that the head is guaranteed to be not null, so it contains at least one node. */
	    public Solution(ListNode head) {
	        this.head = head;
			rand = new Random();
	    }
	    
	    /** Returns a random node's value. */
	    public int getRandom() {
	        //when random(n) == n, currently all node has the same possiblilty 1/n
			ListNode cur = head;
			int res = cur.val;
			for(int i=1;cur.next!=null;i++){
				cur = cur.next;
				if(rand.nextInt(i+1) == i) res = cur.val;
			}
			
			return res;
	    }
	}
}
