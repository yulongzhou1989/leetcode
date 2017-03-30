package leetcode.DPAndBackTrack.BSF_DFS;

import common.TreeNode;

public class SymmetricTree_101 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        //DFS search
        return helper(root.right,root.left);
    }
    
    private boolean helper(TreeNode left,TreeNode right){
        if(left==null && right==null) return true;
        if(left==null || right==null) return false;
        return (left.val == right.val) && helper(left.left,right.right) && helper(right.left, left.right);
    }

}
