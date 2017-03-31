package leetcode.DPAndBackTrack.BSF_DFS;

import java.util.HashMap;
import java.util.Map;

import common.TreeNode;

public class PathSumIII_437 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//O(NlogN) to O(N*N) time
//	public int pathSum(TreeNode root, int sum) {
//        if (root == null) return 0;
//        return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
//    }
//    
//    private int helper (TreeNode root, int sum){
//        int res = 0;
//        if (root==null) return res;
//        if (root.val ==sum) res++;
//        res += helper(root.left, sum-root.val);
//        res += helper(root.right, sum-root.val);
//        
//        return res;
//    }
	
	//O(N) time, O(N) space
	public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        map.put(0,1);
        return helper(root, 0, sum, map);
    }
    
    private int helper (TreeNode root, int curSum, int target, Map<Integer, Integer> map){
        if(root==null) return 0;
        curSum+=root.val;
        
        int res = map.getOrDefault(curSum-target,0);
        map.put(curSum, map.getOrDefault(curSum, 0)+1);
        res += helper(root.left, curSum, target, map)+helper(root.right, curSum, target, map);
        map.put(curSum, map.get(curSum)-1);
        return res;
    }
}
