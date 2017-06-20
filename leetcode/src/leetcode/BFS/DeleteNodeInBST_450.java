package leetcode.BFS;

import common.TreeNode;

public class DeleteNodeInBST_450 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode deleteNode(TreeNode root, int key) {
		if(root==null) return null;
		if(root.val>key){
			deleteNode(root.left, key);
		}else if(root.val<key){
			deleteNode(root.right, key);
		}else if(root.left==null) 
			return root.right;
		else if(root.right==null) 
			return root.left;
		else{
			TreeNode node = findMin(root.right);
			root.val = node.val;
			root.right = deleteNode(root.right, node.val);
		}
		
		return root;
    }
	
	private TreeNode findMin(TreeNode root){
		if(root.left==null) return root;
		else return findMin(root.left);
	}
	

}
