package leetcode.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import common.TreeNode;

public class PrintBinaryTree_655 {
	public List<List<String>> printTree(TreeNode root) {
		if(root == null) return new ArrayList<>();
		int h = getHeight(root);
        String [][] arr = new String [h][(1 << h) - 1];
        //initial array
        for(String [] a : arr){
            Arrays.fill(a, "");
        }
        
		fill(arr, 0, arr[0].length, root, 0);
		//convert array to arraylist
		List<List<String>> res = new ArrayList<>();
		for(String [] a : arr){
			res.add(Arrays.asList(a));
		}
		
		return res;
    }
	
	private void fill(String [][] arr, int l, int r, TreeNode root, int i){
		if(root == null) return;
		arr[i][(l + r) / 2] = "" + root.val;
 		fill(arr, l, (l + r) / 2, root.left, i + 1);
		fill(arr, (l + r + 1) / 2 , r, root.right, i + 1);
	}
	
	
	private int getHeight(TreeNode root){
		if(root == null) return 0;
		else return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}
}
