package leetcode.treesAndGraphs;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

public class BinaryTreePaths_google_257 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> binaryTreePaths(TreeNode root) {        
		List<String> res = new ArrayList<>();
		if(root==null) return res;
		
		//dfs search
		dfs(res, root, "");
		return res;
    }
	
	private void dfs(List<String> res, TreeNode root, String cur){
		String temp = cur.length()>0?(cur+"->"+root.val):root.val+"";
		if(root.left==null && root.right==null){
			res.add(temp);
		}
		if(root.left!=null) dfs(res, root.left, temp);
		if(root.right!=null) dfs(res, root.right, temp);
	}
}
