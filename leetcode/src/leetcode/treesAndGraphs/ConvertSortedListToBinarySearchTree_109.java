package leetcode.treesAndGraphs;

import common.ListNode;
import common.TreeNode;

public class ConvertSortedListToBinarySearchTree_109 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode sortedListToBST(ListNode head) {
		if(head==null) return null;
		return getBST(head, null);
    }
	
	private TreeNode getBST(ListNode start, ListNode end){
		if(start==end) return null;
		//make a fast node and a slow node
		//fast node run twice each time and slow node run one step
		//when fast meet end, slow is at middle
		ListNode slow = start;
		ListNode fast = start;
		while(fast!=end && fast.next!=end){
			slow = slow.next;
			fast = fast.next.next;
		}
		
		TreeNode node = new TreeNode(slow.val);
		node.left = getBST(start, slow);
		node.right = getBST(slow.next, end);
		
		return node;
	}
}
