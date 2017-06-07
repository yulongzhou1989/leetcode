package leetcode.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import common.TreeNode;

public class FindLargestValueInEachTreeRow_515 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//dfs way
	public List<Integer> largestValues1(TreeNode root) {
        //dfs seach tree (deepth)
		List<Integer> res = new ArrayList<>();
		getLargest(root, 0, res);
		return res;
    }
	
	public void getLargest(TreeNode root, int degree, List<Integer> res){
		if(root==null) return;
		if(res.size()== degree){
			res.add(root.val);
		}else{
			res.set(degree, Math.max(root.val, res.get(degree)));
		}
		if(root.left!=null) getLargest(root.left, degree+1, res);
		if(root.right!=null) getLargest(root.right, degree+1, res);
	}
	//bfs way
	public List<Integer> largestValues(TreeNode root) {
        //bfs search tree
		List<Integer> list = new ArrayList<>();
		if(root==null) return list;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty()){
			int level = queue.size();
			int max = Integer.MIN_VALUE;
			for(int i=0;i<level;i++){
				TreeNode node = queue.poll();
				max = Math.max(max, node.val);
				if(node.left!=null) queue.offer(node.left);
				if(node.right!=null) queue.offer(node.right);
			}
			list.add(max);
		}
		
		return list;
    }

}
