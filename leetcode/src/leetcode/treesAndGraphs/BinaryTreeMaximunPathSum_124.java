package leetcode.treesAndGraphs;

import common.TreeNode;

public class BinaryTreeMaximunPathSum_124 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    int maxPath = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
        getMaxSum(root);
		return maxPath;
    }
	
	private int getMaxSum(TreeNode node){
		if(node==null) return 0;
		int left = Math.max(0,getMaxSum(node.left));
		int right = Math.max(0, getMaxSum(node.right));
		maxPath = Math.max(maxPath, left+right+node.val);
		return Math.max(left,right)+node.val;
	}
}
