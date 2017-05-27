package leetcode.treesAndGraphs;

import common.TreeNode;

public class RecoveryBinarySearchTree_99 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//dfs search, find the 2 wrong number
    TreeNode node1 = null;
    TreeNode node2 = null;
    TreeNode preNode = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        traveral(root);
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }
    
    public void traveral(TreeNode node){
        if(node==null) return;
        traveral(node.left);
        
        if(node1==null && preNode.val>=node.val){
            node1 = preNode;
        }
        if(node1!=null && preNode.val>=node.val){
            node2 = node;
        }
        
        preNode=node;
        
        traveral(node.right);
    }
}
