package leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

public class BinaryTreePostorderTraversal_145 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
		dfs(res, root);
		return res;
    }
	
	private void dfs(List<Integer> res, TreeNode root){
		if(root==null) return;
		dfs(res, root.left);
		dfs(res, root.right);
		res.add(root.val);
	}
}
