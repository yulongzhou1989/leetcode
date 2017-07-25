package leetcode.singleLinkedList;

import common.ListNode;

public class PartitionList_86 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode partition(ListNode head, int x) {
        ListNode part1 = new ListNode(0);
		ListNode part2 = new ListNode(0);
		ListNode cur1 = part1;
		ListNode cur2 = part2;
		//if the node val < x append it to part1, else append to part2
		while(head!=null){
			if(head.val<x){
				cur1.next = head;
				cur1 = cur1.next;
			}
			else{
				cur2.next = head;
				cur2 = cur2.next;
			}
			head = head.next;
		}
		cur1.next = part2.next;
		cur2.next = null; //clear tail
		return part1.next;
    }

}
