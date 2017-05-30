package leetcode.sort;

import common.ListNode;

public class MergeKSortedList_google_23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode mergeKLists(ListNode[] lists) {
        return partition(lists, 0, lists.length-1);
    }
	
	public ListNode partition(ListNode[] lists, int start, int end){
		if(start==end) return lists[start];
		else if(start<end){
			int q = (start+end)/2;
			ListNode list1 = partition(lists, start, q);
			ListNode list2 = partition(lists, q+1, end);
			return merge(list1, list2);
		} else{
			return null;
		}
	}
	
	public ListNode merge(ListNode list1, ListNode list2){
		if(list1 == null) return list2;
		if(list2 == null) return list1;
		if(list1.val<list2.val){
			list1.next = merge(list1.next, list2);
			return list1;
		} else {
			list2.next = merge(list1, list2.next);
			return list2;
		}
	}
}
