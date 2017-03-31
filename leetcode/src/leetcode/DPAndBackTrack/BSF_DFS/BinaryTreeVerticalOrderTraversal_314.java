package leetcode.DPAndBackTrack.BSF_DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import common.TreeNode;

public class BinaryTreeVerticalOrderTraversal_314 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        Queue<TreeNode> qNode = new LinkedList<TreeNode>();
        //use another q to save col of the node
        Queue<Integer> qCol = new LinkedList<Integer>();
        
        qNode.offer(root);
        qCol.offer(0);
        int max = 0, min = 0;

        while(!qNode.isEmpty()){
            //search each level            
            int level = qNode.size();
            
            for(int i=0;i<level;i++){
                TreeNode n = qNode.poll();
                Integer c = qCol.poll();
                if(n.left!=null){
                    qNode.offer(n.left);
                    qCol.offer(c-1);
                    min = Math.min(min, c-1);
                }
                if(n.right!=null){
                    qNode.offer(n.right);
                    qCol.offer(c+1);
                    max = Math.max(max, c+1);
                }
                if(!map.containsKey(c)){
                    map.put(c, new ArrayList<Integer>());
                }
                map.get(c).add(n.val);
            }
        }
        
        for(int i=min;i<=max;i++){
            res.add(map.get(i));
        }
        
        return res;
    }
}
