package leetcode.StringArray;

import common.TreeNode;

public class BattleshipsInABoard_419 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while((root.val-p.val)*(root.val-q.val)>0){
            root = p.val<root.val?root.left:root.right;
        }
        return root;
    }
}
