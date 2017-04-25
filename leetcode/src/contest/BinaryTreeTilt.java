package contest;

import common.TreeNode;

public class BinaryTreeTilt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int sum = 0;
    public int findTilt(TreeNode root) {
        if(root==null) return sum;
        helper(root);
        return sum;
    }
    
    //return sum of certain degree
    private int helper(TreeNode root){
        if(root.left==null && root.right==null ) return root.val;
        int left = 0, right = 0;
        if(root.left!=null) {
            left = helper(root.left);
        }
        if(root.right!=null){
            right = helper(root.right);
        }
        sum += Math.abs(right-left);
        return left+right+root.val;
    }
}
