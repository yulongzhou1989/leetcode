package leetcode.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import common.TreeNode;

public class FindDuplicateSubtrees_google_652 {
	//Time On, space Ologn
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		List<TreeNode> res = new ArrayList();
		if(root == null) return res;
		inOrder(root, new HashMap<>(), res);
		return res;
    }
	
	private String inOrder(TreeNode root, HashMap<String, Boolean> map, List<TreeNode> res){//map: true -> first insert, false, stored before
 		if(root == null) return "#";
		String cur = root.val + "," + inOrder(root.left, map, res) + "," + inOrder(root.right, map, res);
		if(map.containsKey(cur)) {
            if(map.get(cur)) {
                res.add(root);
                map.put(cur, false);//indicate already stored
            }
		} else {
			map.put(cur, true);
		}
		
		return cur;
	}
}
