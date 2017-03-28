package leetcode.treesAndGraphs;

import common.TreeNode;

public class SameTree_google_100 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//left tree and right tree are same
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q == null) return true;
        if((p==null && q!=null) || (p!=null && q==null) || p.val!=q.val) return false;
       return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
   }
}
