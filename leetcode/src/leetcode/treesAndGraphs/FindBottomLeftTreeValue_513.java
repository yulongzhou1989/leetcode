package leetcode.treesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

import common.TreeNode;

public class FindBottomLeftTreeValue_513 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//DFS way
	int res = 0;
	int curDegree = Integer.MIN_VALUE;
	public int findBottomLeftValue(TreeNode root) {
		if(root==null) return res;
		dfs(root, 0);
		return res;
    }
	
	private void dfs(TreeNode root, int degree){
		if(root==null) return;
		if(root.right!=null) dfs(root.right, degree + 1);
		if(degree>curDegree){
			res = root.val;
			curDegree = degree;
		}
		if(root.left!=null) dfs(root.left, degree + 1);
	}

	//BFS way
	public int findBottomLeftValue1(TreeNode root) {
		int res = 0;
		if(root==null) return res;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()){
			int level = queue.size();
			for(int i=0;i<level; i++){
			    TreeNode tn = queue.poll();
			    if(i==0) res = tn.val;
				if(tn.left!=null) queue.offer(tn.left);
				if(tn.right!=null) queue.offer(tn.right);
			}
		}
		
		return res;
    }
}
