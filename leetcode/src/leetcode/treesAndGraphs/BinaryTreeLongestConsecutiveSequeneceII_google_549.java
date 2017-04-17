package leetcode.treesAndGraphs;

import common.TreeNode;

public class BinaryTreeLongestConsecutiveSequeneceII_google_549 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int maxInterval = 0;
	public int longestConsecutive(TreeNode root) {
        helper(root);
        return maxInterval;
    }
	
	private int [] helper(TreeNode root){
		if(root==null) return new int [] {0,0};
		int incr = 1, dcr = 1;
		//search tree left node
		if(root.left!=null){
			int [] l = helper(root.left);
			if(root.val == root.left.val+1)
				dcr = l[1] + 1;
			else if(root.val == root.left.val-1)
				incr = l[0] + 1;
		}
		//search tree right node, get the max decrease for right node and left node
		if(root.right!=null){
			int [] l = helper(root.right);
			if(root.val == root.right.val+1)
				dcr = Math.max(dcr, l[1]+1);
			if(root.val == root.right.val -1)
				incr = Math.max(incr, l[0]+1);
		}
		maxInterval = Math.max(maxInterval, dcr+incr-1);
		
		return new int [] {incr, dcr};
	}
}
