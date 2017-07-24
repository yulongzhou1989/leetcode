package leetcode.singleLinkedList;

import java.util.HashMap;

import common.ListNode;

public class ReniveDuplicateFromSortedListII_82 {
	
	//O1 space
	public ListNode deleteDuplicates1(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
		ListNode cur = head;
		ListNode pre = dummy;
		while(cur!=null){
			while(cur.next!=null && cur.val == cur.next.val){
				cur = cur.next;
			}
			if(pre.next == cur){//don't find duplicate
				pre = pre.next;
			}else{
				pre.next = cur.next;
			}
			cur = cur.next;
		}
		
		return dummy.next;
	}
	
	//On space, handle unsorted List
	public ListNode deleteDuplicates(ListNode head) {
        HashMap<Integer, Integer> map = new HashMap<>(); 
		ListNode cur = head;
		while(cur!=null){
			map.put(cur.val, map.getOrDefault(cur.val, 0) + 1);
			cur = cur.next;
		}
		ListNode dummy = new ListNode(0);
		cur = head;
		ListNode pre = dummy;
		while(cur!=null){
			if(map.get(cur.val)>1){
				pre.next = cur.next;
			}else{
				pre = pre.next;
			}
			cur = cur.next;
		}
		
		return dummy.next;
    }
}
