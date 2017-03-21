package leetcode.treesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.TreeNode;

public class FindModeInBinarySearchTree_google_501 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int max=0;
    Map<Integer, Integer> map;
    List<Integer> list;

    public int[] findMode(TreeNode root) {
        //in order search
        map = new HashMap<Integer, Integer>();
        list = new ArrayList<Integer>();
        inOrder(root);
        Integer [] res = list.toArray(new Integer [list.size()]);
        return res;
    }
    
    void inOrder(TreeNode root){
        if (root.left!=null) inOrder(root.left);
        if (root == null) return;
        if(!map.containsKey(root.val)){
            map.put(root.val, 1);
        }else {
            map.put(root.val, map.get(root.val)+1);
        }
        if (max==map.get(root.val)) list.add(root.val);
        else if (max<map.get(root.val)){
            list.clear();
            list.add(root.val);
        }
        if(root.right!=null) inOrder(root.right);
    }
}
