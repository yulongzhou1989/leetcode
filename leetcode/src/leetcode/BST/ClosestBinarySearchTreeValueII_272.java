package leetcode.BST;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.TreeNode;

public class ClosestBinarySearchTreeValueII_272 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		
		inOrder(root, target, s1, true);
		inOrder(root, target, s2, false);
		
		List<Integer> res = new ArrayList<>();
		while(k-->0){
			if(s1.isEmpty()){
				res.add(s2.pop());
			}else if(s2.isEmpty()){
				res.add(s1.pop());
			}else if(Math.abs(s1.peek()-target)<Math.abs(s2.peek()-target)){
				res.add(s1.pop());
			}else{
				res.add(s2.pop());
			}
		}
		
		return res;
	}
	
	private void inOrder(TreeNode root, double target, Stack<Integer> s, boolean isInOrder){
		if(root == null) return;
		
		inOrder(isInOrder?root.left:root.right, target, s, isInOrder);
		//early terminate
		if((isInOrder && root.val>=target) || (!isInOrder && root.val<target)) return;
		s.push(root.val);
		
		inOrder(isInOrder? root.right:root.left, target, s, isInOrder);
	}

}
