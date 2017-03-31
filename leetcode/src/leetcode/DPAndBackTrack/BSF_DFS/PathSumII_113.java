package leetcode.DPAndBackTrack.BSF_DFS;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

public class PathSumII_113 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(root, sum, res, new ArrayList<Integer>());
        return res;
    }
    
    public void helper(TreeNode root, int sum, List<List<Integer>> res, List<Integer> temp){
        if (root==null) return;
        if (root.right==null && root.left==null && sum-root.val==0){
            temp.add(root.val);
            res.add(new ArrayList<Integer>(temp));
            temp.remove(temp.size()-1);
            return;
        }
        temp.add(root.val);
        helper(root.left, sum-root.val, res, temp);
        helper(root.right, sum-root.val, res, temp);
        temp.remove(temp.size()-1);
    }
}
