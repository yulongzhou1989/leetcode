package leetcode.singleLinkedList;

import common.ListNode;

public class PartitionList_86 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = new int [] {9,9,9,1,2,8};
		System.out.println(
				partition1(ListNode.fromArray(arr), 5).toString());
	}
	
	public static ListNode partition1(ListNode head, int target) {
		ListNode dummy1 = new ListNode(0);//for left part
		ListNode dummy2 = new ListNode(0);//for right part
		ListNode pre1 = dummy1;
		ListNode pre2 = dummy2;
		
		while(head != null){
			if(head.val < target){
				pre1.next = head;
				pre1 = pre1.next;
			} else {
				pre2.next = head;
				pre2 = pre2.next;
			}
			head = head.next;
		}
		
		pre1.next = dummy2.next;
		pre2.next = null;
		return dummy1.next;
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
