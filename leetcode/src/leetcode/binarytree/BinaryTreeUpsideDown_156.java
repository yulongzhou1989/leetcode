package leetcode.binarytree;

import common.TreeNode;

public class BinaryTreeUpsideDown_156 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root==null || root.left==null) return root;
        TreeNode node = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return node;
    }
}
