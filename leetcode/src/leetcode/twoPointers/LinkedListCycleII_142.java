package leetcode.twoPointers;

import common.ListNode;

public class LinkedListCycleII_142 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode detectCycle(ListNode head) {
        if(head==null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                while(head!=slow){
                    //
                    head = head.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
    
    /*
    Cycle = length of the cycle, if exists.
C is the beginning of Cycle, S is the distance of slow pointer from C when slow pointer meets fast pointer.

Distance(slow) = C + S, Distance(fast) = 2 * Distance(slow) = 2 * (C + S). To let slow poiner meets fast pointer, only if fast pointer run 1 cycle more than slow pointer. Distance(fast) - Distance(slow) = Cycle
=> 2 * (C + S) - (C + S)	= Cycle
=>	C + S = Cycle
=>	C = Cycle - S
=> This means if slow pointer runs (Cycle - S) more, it will reaches C. So at this time, if there's another point2 running from head
=> After C distance, point2 will meet slow pointer at C, where is the beginning of the cycle.*/
}
