package leetcode.design.objects;

import java.util.LinkedList;
import java.util.Queue;

import common.TreeNode;

public class CodeC1 {
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "[]";
		StringBuilder sb = new StringBuilder();
		//BFS search the tree
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		sb.append('[');
		while(!queue.isEmpty()){
			int level = queue.size();
			for(int i=0;i<level;i++){
				TreeNode tn = queue.poll();
				if(tn!=null) {
					sb.append(tn.val).append(',');
				}else{
					sb.append("null,");
					continue;
				}
				queue.offer(tn.left);
				queue.offer(tn.right);
			}
		}
		
		//remove last comma
		if(sb.length()>1) sb.deleteCharAt(sb.length()-1);
		sb.append(']');
		System.out.println(sb.toString());
		return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = data.substring(1);
		data = data.substring(0, data.length()-1);
		
		String [] vals = data.split(",");
		if(vals.length == 0) return null;		
		Integer rootVal = stringToInt(vals[0]);
		TreeNode root = rootVal==null?null:new TreeNode(rootVal);
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int pos = 1;
		//BFS iterate tree
		while(!queue.isEmpty()){
			int level = queue.size();
			for(int i=0;i<level;i++){
				TreeNode tr = queue.poll();
				if(tr == null) continue;
				Integer valLeft = stringToInt(vals[pos++]);
				tr.left = valLeft==null?null:new TreeNode(valLeft);
				Integer valRight = stringToInt(vals[pos++]);
				tr.right =valRight==null?null:new TreeNode(valRight);
				queue.offer(tr.left);
				queue.offer(tr.right);
			}
		}
		
		return root;
    }
    
    private Integer stringToInt(String s){
		if(s.length()==0 || s.equals("null")) return null;
		else return Integer.valueOf(s);
	}
}
