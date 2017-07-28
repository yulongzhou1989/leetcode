package leetcode.treesAndGraphs;

import common.TreeNode;

public class BinaryTreeLongestConsecutiveSequeneceII_google_549 {

	int max = 0;
	public int longestConsecutive(TreeNode root) {
        helper(root);
		return max;
    }
	
	//a[0]->increase, a[1] decrease
	public int [] helper(TreeNode root){
		if(root==null) return new int [] {};
		int incMax = 1, decMax=1;
		if(root.left!=null){
			int [] res = helper(root.left);
			//increase
			if(root.left.val-1 == root.val){
				incMax = Math.max(incMax, res[0]+1);
			}
			if(root.left.val+1 == root.val){
				decMax = Math.max(decMax, res[1]+1);
			}
		}
		if(root.right!=null){
			int [] res = helper(root.right);
			//increase
			if(root.right.val-1 == root.val){
				incMax = Math.max(incMax, res[0]+1);
			}
			if(root.right.val+1 == root.val){
				decMax = Math.max(decMax, res[1]+1);
			}
		}
		
		int curMax = incMax+decMax-1;
		max = Math.max(curMax, max);
		
		return new int [] {incMax, decMax};
	}
}
