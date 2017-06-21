package leetcode.BST;

import common.TreeNode;

public class InOrderSuccessorInBST_285 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//successor
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root==null) return null;
		
		if(root.val<=p.val){
			return inorderSuccessor(root.right, p);
		} else{
			TreeNode left = inorderSuccessor(root.left, p);
			return left!=null?left:root;
		}
    }
	
	//predecessor
	public TreeNode inOrderPredecessor(TreeNode root, TreeNode p){
		if(root==null) return null;
		
		if(root.val>=p.val){
			return inOrderPredecessor(root.left, p);
		}else{
			TreeNode right = inOrderPredecessor(root.right, p);
			return right!=null?right:root;
		}
	}
}
