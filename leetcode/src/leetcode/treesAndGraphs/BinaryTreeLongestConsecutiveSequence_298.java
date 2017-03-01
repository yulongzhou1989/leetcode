package leetcode.treesAndGraphs;

import common.TreeNode;

public class BinaryTreeLongestConsecutiveSequence_298 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//DFS
	private int max;
    
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        max = 0;
        helper(root, 0, root.val+1);
        return max;
    }
    
    public void helper (TreeNode n, int cur, int target){
        if (n == null) return;
        if (n.val == target) cur ++;
        else cur = 1;
        max = Math.max(cur, max);
        
        helper(n.left, cur, n.val+1);
        helper(n.right, cur, n.val+1);
    }
}
