package leetcode.DPAndBackTrack.BSF_DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import common.TreeNode;

public class BinaryTreeLevelOrderTraversal_102 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode  tr = TreeNode.construct("3,9,20,null,null,15,7");
		System.out.println(levelOrder(tr));
	}
	
	 public static List<List<Integer>> levelOrder(TreeNode root) {
	        if(root ==  null) return new ArrayList<List<Integer>>();
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        Queue<TreeNode> q = new LinkedList<TreeNode>();
	        q.offer(root);
	        while(!q.isEmpty()){
	            //q.size is the level
	            List<Integer> temp = new ArrayList<Integer>();
	            int level = q.size();
	            for(int i=0;i<level;i++){
	                TreeNode n = q.poll();
	                if(n.left!=null) q.offer(n.left);
	                if(n.right!=null) q.offer(n.right);
	                temp.add(n.val);
	            }
	            res.add(temp);
	        }
	        return res;
	    }

}
