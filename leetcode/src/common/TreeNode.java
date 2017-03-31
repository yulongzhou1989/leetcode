package common;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int x) { val = x; }
	
	public static TreeNode createTreeNode(String s){
		if (s.equals("null")) return null;
		else return new TreeNode(Integer.parseInt(s));
	}

	public static TreeNode construct(String s){
		if (s.length()==0) return null;
		String [] arr = s.split(",");
		//bfs build tree
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		TreeNode root = createTreeNode(arr[0]);
		q.offer(root);
		int pos = 1;
		while(!q.isEmpty() && pos<arr.length){
			for(int i=0;i<q.size() && pos<arr.length;i++){
				TreeNode r = q.poll();
				r.left = createTreeNode(arr[pos++]);
				if (pos==arr.length) break;
				r.right = createTreeNode(arr[pos++]);
				if(r.left!=null)
					q.offer(r.left); 
				if(r.right!=null)
					q.offer(r.right);
			}
		}
		return root;
	}
}
