package leetcode.treesAndGraphs;

import common.TreeNode;

public class FlatternBinaryTreeToLinkedList_114 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	TreeNode preNode=null;
    public void flatten(TreeNode root) {
        if(root==null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = preNode;
        root.left = null;
        preNode = root;
    }

}
