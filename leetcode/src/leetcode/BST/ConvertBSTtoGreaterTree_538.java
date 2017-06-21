package leetcode.BST;

import common.TreeNode;

public class ConvertBSTtoGreaterTree_538 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int sum = 0;
	//reverse Inorder traveral
	public TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }
	
	private void convert(TreeNode root){
		if(root==null) return;
		convert(root.right);
		root.val += sum;
		sum = root.val;
		convert(root.left);
	}
}
