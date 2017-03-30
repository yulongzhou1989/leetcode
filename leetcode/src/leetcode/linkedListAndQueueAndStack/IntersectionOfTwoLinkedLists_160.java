package leetcode.linkedListAndQueueAndStack;

import common.ListNode;

public class IntersectionOfTwoLinkedLists_160 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //if one head is null, return null
        if (headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;
        //
        int lenA = 0, lenB = 0;
        //get the size of each node;
        while(a!=null || b!=null){
            if (a==b) return a;
            if (a!=null){
                a = a.next;
                lenA++;
            }
            if (b!=null){
                b = b.next;
                lenB++;
            }
        }
        //if lenA == lenB and not return yet means no intersection
        if (lenA == lenB) return null;
        //adjust the longer one to the same length;
        if (lenA>lenB) {
            int k = lenA-lenB;
            while(k>0){
                headA = headA.next;
                k--;
            }
        }else {
            int k = lenB-lenA;
            while(k>0){
                headB = headB.next;
                k--;
            }
        }
        
        //loop again check adjusted head has intersection or not 
        while (headA!=null && headB!=null){
            if (headA==headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
