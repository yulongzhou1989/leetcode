package leetcode.treesAndGraphs;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

public class BinaryTreeRightSideView_199 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(root, list, 0);
        return list;
    }
    
    public void traversal(TreeNode root, List<Integer> list, int level){
        if(root==null) return;
        if(level==list.size()){
            list.add(root.val);
        }
        traversal(root.right, list, level+1);
        traversal(root.left, list, level+1);
    }  
}
