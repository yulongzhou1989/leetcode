package leetcode.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import common.TreeNode;

public class AverageOfLevelsInBinaryTree_637 {
	public List<Double> averageOfLevels(TreeNode root) {
		//bfs search tree
		List<Double> list = new ArrayList<>();
		if(root==null) return list;
		bfs(root, list);
		return list;
    }
	
	private void bfs(TreeNode root,List<Double> list){
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty()){
			int level = queue.size();
			double sum = 0;
			for(int i=0;i<level;i++){
				TreeNode node = queue.poll();
				//System.out.println(node.val + "," + level+","+i);
                sum += node.val;
				if(node.left!=null) queue.offer(node.left);
				if(node.right!=null) queue.offer(node.right);
			}
			list.add(sum/level);
		}
	}
}
