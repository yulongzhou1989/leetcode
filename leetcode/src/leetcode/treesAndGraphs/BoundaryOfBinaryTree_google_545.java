package leetcode.treesAndGraphs;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

public class BoundaryOfBinaryTree_google_545 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    List<Integer> res;
    
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        res = new ArrayList<Integer>();
        if(root==null) return res;
        res.add(root.val);
        getLeft(root.left);
        getLeaf(root.left);
        getLeaf(root.right);
        getRight(root.right);
        return res;
    }
    
    private void getLeft(TreeNode root){
        if(root==null || (root.left==null && root.right==null)) return;
        res.add(root.val);
        getLeft(root.left!=null?root.left:root.right);
    }
    
    private void getRight(TreeNode root){
        if(root==null || (root.left==null && root.right==null)) return;
        getRight(root.right!=null?root.right:root.left);
        res.add(root.val);
    }
    
    private void getLeaf(TreeNode root){
        if(root == null) return;
        if(root.left == null && root.right == null) res.add(root.val);
        getLeaf(root.left);
        getLeaf(root.right);
    }
}
