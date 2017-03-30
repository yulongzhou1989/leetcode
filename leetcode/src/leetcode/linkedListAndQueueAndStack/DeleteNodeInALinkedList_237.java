package leetcode.linkedListAndQueueAndStack;

import common.ListNode;

public class DeleteNodeInALinkedList_237 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(0);
		ListNode n2 = new ListNode(1);
		n1.next = n2;
		deleteNode(n1);
		System.out.println(n1.val);
	}
	
	public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
