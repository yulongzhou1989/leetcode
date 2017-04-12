package leetcode.linkedListAndQueueAndStack;

import java.util.Stack;

import common.ListNode;

public class PalindromeLinkedList_234 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//On space
	public boolean isPalindrome1(ListNode head) {
        ListNode slow = head;
		ListNode fast = head;
		Stack<Integer> stack = new Stack<>();
		//find middle point
		while(fast!=null && fast.next!=null){
			stack.push(slow.val);
			slow = slow.next;
			fast = fast.next.next;
		}
		//if fast is not null, odd number list, let slow move one step forward 
		if(fast!=null){
			slow = slow.next;
		}
		//continue run slow and compare with head of stack
		while(!stack.isEmpty() && slow!=null && stack.peek()== slow.val) {
			slow = slow.next;
			stack.pop();
		}
		
		return stack.size() == 0;
    }
	
	//O1 space
	public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
		ListNode fast = head;
		//find middle point
		while(fast!=null && fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}
		//if fast is not null, odd number list, let slow move one step forward 
		if(fast!=null){
			slow = slow.next;
		}
		//reverse slow
		slow = reverse(slow);
		ListNode h = head;
		//continue run slow and compare with head of stack
		while(slow!=null) {
			if(h.val != slow.val) return false;
			slow = slow.next;
			h = h.next;
		}
		
		return true;
    }
	
	private ListNode reverse(ListNode head){
		ListNode prev = null;
		while(head!=null){
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
}
