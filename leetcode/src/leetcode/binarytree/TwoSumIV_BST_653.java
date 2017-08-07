package leetcode.binarytree;

import java.util.HashSet;

import common.TreeNode;

public class TwoSumIV_BST_653 {
	public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
		inorder(root, set);
		for(int key : set){
			if(set.contains(k-key) && (k - key != key))
				return true;
		}
		
		return false;
    }
	
	private void inorder(TreeNode root, HashSet<Integer> set){
		if(root == null) return;
		inorder(root.left, set);
		set.add(root.val);
		inorder(root.right, set);
	}
}
