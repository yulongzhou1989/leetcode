package leetcode.treesAndGraphs;

import common.TreeNode;

public class InvertBinaryTree_226 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(temp);
        return root;
    }

}
