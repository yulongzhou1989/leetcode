package leetcode.list;

import common.ListNode;

public class RotateList_61 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode rotateRight(ListNode head, int k) {
		if(head==null) return null;
		
        ListNode cur = head;
		int len = 1;
		while(cur.next!=null){
			cur = cur.next;
			len++;
		}
		
		//join head and tail
		cur.next = head;
		
		for(int i=len-k%len;i>1;i--){//find the kth
			head = head.next;
		}
		
		cur = head.next;//set new head
		head.next = null;//break list
		
		return cur;
    }

}
