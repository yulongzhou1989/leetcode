package leetcode.BST;

import common.TreeNode;

public class ClosestBinarySearchTreeValue_270 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode left = new TreeNode(1);
		TreeNode root = new TreeNode(8);
		root.left = left;
		System.out.println(closestValue(root, 6.0));
	}
	
	public static int closestValue1(TreeNode root, double target) {
        if (root == null) return 0;
        return helper(root, target);
    }

    static int helper(TreeNode root, double target){
        TreeNode nextNode = root.val<target?root.right:root.left;
        if (nextNode == null) return root.val;
        int nextVal = helper(nextNode, target);
        return Math.abs(root.val-target)<Math.abs(nextVal-target)?root.val:nextVal;
    }
    
    public static int closestValue(TreeNode root, double target) {
    	if (root == null) return 0;
    	int ret = root.val;
    	
    	while(root!=null){
    		if (Math.abs(target-root.val)<Math.abs(target-ret)){
    			ret = root.val;
    		}
    		root = root.val > target? root.left:root.right;
    	}
    	return ret;
    }

}
