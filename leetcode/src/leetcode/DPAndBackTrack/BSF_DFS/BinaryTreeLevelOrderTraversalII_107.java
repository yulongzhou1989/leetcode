package leetcode.DPAndBackTrack.BSF_DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import common.TreeNode;

public class BinaryTreeLevelOrderTraversalII_107 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null) return res;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            int level = q.size();
            List<Integer> temp = new ArrayList<Integer>();
            for(int i=0;i<level;i++){
                TreeNode n = q.poll();
                if(n.left!=null) q.offer(n.left);
                if(n.right!=null) q.offer(n.right);
                temp.add(n.val);
            }
            res.add(0, temp);
        }
        
        return res;
    }
}
