package leetcode.treesAndGraphs;

import common.TreeNode;

public class SumRootToLeafNumbers_129 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int sum = 0;
	
	public int sumNumbers(TreeNode root) {
		if(root==null) return 0;
		getSum(root, 0);
		return sum;
    }
	
	private void getSum(TreeNode root, int pre){
		//base
		if(root.left==null && root.right == null){
			sum+= pre*10 + root.val;
		}
		
		if(root.left!=null) getSum(root.left,  pre*10 + root.val);
		if(root.right!=null) getSum(root.right,  pre*10 + root.val);
	}

}
