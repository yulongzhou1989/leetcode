package leetcode.BST;

import common.TreeNode;

public class KthSmallestElementInBST_google_230 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int count;
    int number = 0;
    
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inOrder(root);
        return number;
    }
    
    //inorder search
    void inOrder(TreeNode root){
        if (root.left != null) inOrder(root.left);
        count--;
        if (root!=null && count == 0) {
            number = root.val;
        }
        if (root.right != null) inOrder(root.right);
    }

}
