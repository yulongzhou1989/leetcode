package leetcode.DPAndBackTrack.BSF_DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import common.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal_103 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode  tr = TreeNode.construct("3,9,20,null,null,15,7");
		System.out.println(zigzagLevelOrder(tr));
	}
	
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        boolean flip = false;
        while(!q.isEmpty()){
            int level = q.size();
            List<Integer> list= new ArrayList<Integer>();
            for(int i=0;i<level;i++){
                TreeNode n = q.poll();
                if(n.left!=null) q.offer(n.left);
                if(n.right!=null) q.offer(n.right);
                if(flip)
                    list.add(0,n.val);
                else 
                    list.add(n.val);
            }
            flip = flip?false:true;
            res.add(list);
        }
        return res;
    }

}
