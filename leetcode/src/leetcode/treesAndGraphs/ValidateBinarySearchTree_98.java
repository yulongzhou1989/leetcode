package leetcode.treesAndGraphs;

import common.TreeNode;

public class ValidateBinarySearchTree_98 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	TreeNode preNode;
    public boolean isValidBST(TreeNode root) {
        preNode =null;
        return inOrder(root, preNode);
    }
    
    public boolean inOrder(TreeNode root, TreeNode prevNode){
        if(root==null) return true;
        if(!inOrder(root.left, preNode)) return false;
        if(preNode!=null && root.val<=preNode.val) return false;
        preNode = root;
        return inOrder(root.right, preNode);
    }
}
