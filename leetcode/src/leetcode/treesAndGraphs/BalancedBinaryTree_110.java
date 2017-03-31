package leetcode.treesAndGraphs;

import common.TreeNode;

public class BalancedBinaryTree_110 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
// O(NlogN)
//	public boolean isBalanced(TreeNode root) {
//        if(root ==null) return true;
//        int heightOff = getHeight(root.left)-getHeight(root.right);
//        if(Math.abs(heightOff)>1) return false;
//        else return isBalanced(root.left) && isBalanced(root.right);
//    }
//    
//    private int getHeight(TreeNode root){
//        if (root == null) return -1;
//        else return Math.max(getHeight(root.left),getHeight(root.right))+1;
//    }
	
	//O(N) time, O(H) space
	public boolean isBalanced(TreeNode root) {
        return getHeight(root)!=Integer.MIN_VALUE;
    }
    
    private int getHeight(TreeNode root){
        if (root == null) return -1;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if(leftHeight == Integer.MIN_VALUE || rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if(Math.abs(leftHeight-rightHeight)>1) return Integer.MIN_VALUE;
        else return Math.max(getHeight(root.right), getHeight(root.left))+1;
    }
	
}
