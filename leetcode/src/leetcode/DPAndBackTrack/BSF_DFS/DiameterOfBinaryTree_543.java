package leetcode.DPAndBackTrack.BSF_DFS;

import common.TreeNode;

public class DiameterOfBinaryTree_543 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        return getHeight(root.left)+getHeight(root.right)+2;
    }
    
    private int getHeight(TreeNode root){
        if(root==null) return -1;
        else return Math.max(getHeight(root.left), getHeight(root.right))+1;
    }

}
