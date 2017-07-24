package leetcode.singleLinkedList;

import java.util.Stack;

import common.ListNode;

public class AddTwoNumbersII_445 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null && l2==null) return null;
		if(l1==null && l2!=null) return l2;
		if(l1!=null && l2==null) return l1;
        Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		
		ListNode h1 = l1;
		ListNode h2 = l2;
		while(h1!=null){
			s1.push(h1.val);
			h1 = h1.next;
		}
		while(h2!=null){
			s2.push(h2.val);
			h2 = h2.next;
		}
        
		int sum = 0;
		ListNode cur = new ListNode(0);
		while(!s1.isEmpty() || !s2.isEmpty()){
			if(!s1.isEmpty()){
				sum+=s1.pop();
			}
			if(!s2.isEmpty()){
				sum+=s2.pop();
			}
			
			cur.val = sum%10;
			ListNode head = new ListNode(sum/10);
			head.next = cur;
			cur = head;
			sum /=10;
		}
		
		return cur.val==0?cur.next:cur;
    }	
}
