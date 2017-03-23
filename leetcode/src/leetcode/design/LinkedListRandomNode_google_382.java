package leetcode.design;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import common.ListNode;

public class LinkedListRandomNode_google_382 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public class Solution {

	    List<Integer> list;
	    /** @param head The linked list's head.
	        Note that the head is guaranteed to be not null, so it contains at least one node. */
	    public Solution(ListNode head) {
	        list = new ArrayList<Integer>();
	        while(head!=null){
	            list.add(head.val);
	            head = head.next;
	        }
	    }
	    
	    /** Returns a random node's value. */
	    public int getRandom() {
	        Random rand = new Random();
	        int index = rand.nextInt(list.size());
	        return list.get(index);
	    }
	}

}
