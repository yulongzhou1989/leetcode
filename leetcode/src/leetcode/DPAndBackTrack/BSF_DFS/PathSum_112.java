package leetcode.DPAndBackTrack.BSF_DFS;

import common.TreeNode;

public class PathSum_112 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode  tr = TreeNode.construct("1,2");
		System.out.println(hasPathSum(tr,1));
	}

	public static boolean hasPathSum(TreeNode root, int sum) {
        //return helper(root, 0, sum);
		if(root==null) return false;
        if(root.left==null && root.right==null && sum-root.val==0) return true;
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }
    
    //dfs
    public static boolean helper(TreeNode root, int curSum, int sum){
        if (root==null) return false;
        else if(root.left==null && root.right==null && curSum==sum) return true;
        else return helper(root.left, curSum+root.val, sum) || helper(root.right, curSum+root.val, sum);
    }
}
