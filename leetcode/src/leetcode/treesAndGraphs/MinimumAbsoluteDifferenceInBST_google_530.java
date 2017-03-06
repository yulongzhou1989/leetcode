package leetcode.treesAndGraphs;

import common.TreeNode;

public class MinimumAbsoluteDifferenceInBST_google_530 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	int minDiff = Integer.MAX_VALUE;
    TreeNode pre;
    
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return minDiff;
    }
    
    //inOrder traverse 
    public void inOrder(TreeNode root){
        if (root == null) return;
        inOrder(root.left);
        if (pre != null){
            minDiff = Math.min(minDiff, Math.abs(pre.val - root.val));
        }
        pre = root;
        inOrder(root.right);
    }

}
