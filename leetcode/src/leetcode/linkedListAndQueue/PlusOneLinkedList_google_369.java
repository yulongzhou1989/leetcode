package leetcode.linkedListAndQueue;

import common.ListNode;

public class PlusOneLinkedList_google_369 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		n1.next = n2;
		System.out.println(plusOne(n1).next.val);
	}

	public static ListNode plusOne(ListNode head) {
		ListNode l = reverse(head);
		l = addOne(l);
		head = reverse(l);
		return head;
	}

	static ListNode reverse(ListNode l) {
		ListNode newHead = null;
		while (l != null) {
			ListNode next = l.next;
			l.next = newHead;
			newHead = l;
			l = next;
		}
		return newHead;
	}

	static ListNode addOne(ListNode l) {
		ListNode head = l;
		head.val = head.val+1;
		while (head.val== 10) {
			head.val = 0;
			if (head.next == null) {
				head.next = new ListNode(1);
				break;
			}
			head = head.next;
			head.val = head.val+1;
		}
		return l;
	}
}
