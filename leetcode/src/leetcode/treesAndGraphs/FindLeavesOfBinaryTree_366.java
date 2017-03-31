package leetcode.treesAndGraphs;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

public class FindLeavesOfBinaryTree_366 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, root);
        return res;
    }
    
    //helper find deepth from this node to the leef node
    private int helper(List<List<Integer>> res, TreeNode root){
        if(root==null) return -1;
        int level = Math.max(helper(res, root.left), helper(res, root.right))+1;
        if(res.size()<level+1){
            res.add(new ArrayList<Integer>());
        }
        res.get(level).add(root.val);
        return level;
    }
}
