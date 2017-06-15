package leetcode.binarytree;

import common.TreeNode;

public class CountUnivalueSubtree_250 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int res = 0;
	public int countUnivalSubtrees(TreeNode root) {
	    if(root==null) return res;
        dfs(root);
		return res;
    }
	
	private boolean dfs(TreeNode root){
	    //System.out.println("val:"+root.val);
		if(root.left==null && root.right==null){
			res++;
			return true;
		} 
		else if(root.left==null){
			if(dfs(root.right) && root.val == root.right.val){
				res++;
				return true;
			}
		}
		else if(root.right==null){
			if(dfs(root.left) && root.val == root.left.val){
				res++;
				return true;
			}
		} else{
		    boolean leftResult = dfs(root.left);
		    boolean rightResult = dfs(root.right);
			if(leftResult && rightResult && root.val == root.left.val && root.val == root.right.val){
				res++;
				return true;
			}
		}
		return false;
	}

}
