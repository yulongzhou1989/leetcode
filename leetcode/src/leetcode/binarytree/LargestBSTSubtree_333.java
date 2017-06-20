package leetcode.binarytree;

import common.TreeNode;

public class LargestBSTSubtree_333 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	class Result {
		int count;
		int min;
		int max;
		
		public Result(int count, int min, int max){
			this.count = count;
			this.min = min;
			this.max = max;
		}
	}
	
	int res = 0;
	public int largestBSTSubtree(TreeNode root) {
        dfs(root);
		return res;
    }
	
	//return -1 mean invalid BST
	private Result dfs(TreeNode root){
		if(root==null) return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
		Result left = dfs(root.left);
		Result right = dfs(root.right);
		if((root.val<=left.max) || (root.val>=right.min) || left.count==-1 || right.count == -1)
			return new Result(-1, 0, 0);
		int count = left.count + right.count + 1;
		res = Math.max(res, count);
		//in case the default max value
		return new Result(count, Math.min(left.min, root.val), Math.max(right.max, root.val));
	}
	
	

}
