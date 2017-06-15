package leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

public class BinaryTreePreorderTraversal_144 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
		dfs(list, root);
		return list;
    }
	
	private void dfs(List<Integer> list, TreeNode root){
		if(root==null) return;
		list.add(root.val);
		dfs(list, root.left);
		dfs(list, root.right);
	}
}
