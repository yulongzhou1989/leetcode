package leetcode.treesAndGraphs;

import common.TreeNode;

public class MinDepthOfBinaryTree_111 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minDepth(TreeNode root) {
        if(root==null) return 0;
        return getMinHeight(root);
    }
    
    public int getMinHeight(TreeNode root){
        if(root.left==null && root.right==null) return 1;
        if(root.left==null) return getMinHeight(root.right)+1;
        else if(root.right==null) return getMinHeight(root.left)+1;
        else return Math.min(getMinHeight(root.right), getMinHeight(root.left))+1;
    }
}
