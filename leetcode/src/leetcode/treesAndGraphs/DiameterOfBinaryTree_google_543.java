package leetcode.treesAndGraphs;

import common.TreeNode;

public class DiameterOfBinaryTree_google_543 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

   /* public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int res = getHeight(root.left)+getHeight(root.right)+2;
        return Math.max(res,Math.max(diameterOfBinaryTree(root.left),diameterOfBinaryTree(root.right)));
    }
    
    private int getHeight(TreeNode root){
        if(root==null) return -1;
        else return Math.max(getHeight(root.left), getHeight(root.right))+1;
    }*/
	
	int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }
    
    private int maxDepth(TreeNode root){
        if(root==null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        max = Math.max(max, left+right);
        return Math.max(left, right)+1;
    }
}
