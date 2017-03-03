package leetcode.linkedListAndQueue;

import java.util.Stack;

import common.ListNode;

public class ReverseLinkedList_206 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		n1.next = n2;
		System.out.println(reverseList(n1).val);
	}

	public static ListNode reverseList(ListNode head) {
		if (head == null) return null;
		
        Stack<Integer> stack = new Stack<Integer> ();
        ListNode n = head;
        while(n!=null){
            stack.push(n.val);
            n = n.next;
        }
     
        head = n = new ListNode(stack.pop());
        while (!stack.isEmpty()){
        	n.next = new ListNode(stack.pop());
        	n = n.next;
        }
        return head;
    }
	
	public ListNode reverseList1(ListNode head){
		ListNode newHead = null;
		while(head!=null){
			ListNode next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;
		}
		return newHead;
	}
	
	public ListNode reverseList2(ListNode head){
		return reverseListInt(head, null);
	}
	
	private ListNode reverseListInt(ListNode head, ListNode newHead){
		if (head == null)
			return newHead;
		ListNode next = head.next;
		head.next = newHead;
		return reverseListInt(next, head);
	}
}
