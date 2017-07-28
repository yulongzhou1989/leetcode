package leetcode.treesAndGraphs;

import common.TreeNode;

public class BinaryTreeLongestConsecutiveSequence_298 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int max = 0;
	//max(left tree, right tree); 
	public int longestConsecutive(TreeNode root) {
        helper(root);
		return max;
    }
	
	private int helper(TreeNode root){
		if(root==null) return 0;
		int curMax = 1;
		if(root.left!=null){
            int left = helper(root.left);
            if(root.left.val==root.val+1)
                curMax = Math.max(curMax, left+1);
        }
		if(root.right!=null){
            int right = helper(root.right);
            if(root.right.val==root.val+1)
                curMax = Math.max(curMax, right+1);
        }
		max = Math.max(max, curMax);
		return curMax;
	}

	//DFS
//	private int max;
//    
//    public int longestConsecutive(TreeNode root) {
//        if (root == null) return 0;
//        max = 0;
//        helper(root, 0, root.val+1);
//        return max;
//    }
//    
//    public void helper (TreeNode n, int cur, int target){
//        if (n == null) return;
//        if (n.val == target) cur ++;
//        else cur = 1;
//        max = Math.max(cur, max);
//        
//        helper(n.left, cur, n.val+1);
//        helper(n.right, cur, n.val+1);
//    }
}
