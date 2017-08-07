package leetcode.binarytree;

import common.TreeNode;

public class MaximumBinaryTree_654 {
	public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0) return null;
		return construct(nums, 0, nums.length - 1);
    }
	
    //On*n time, On space
	private TreeNode construct(int [] nums, int s, int e){
		if(s > e) return null;
		if(s == e) return new TreeNode(nums[s]);
		
		int maxIndex = s;
		for(int i = s; i <= e; i++){
			if(nums[i] > nums[maxIndex])
				maxIndex = i;
		}
        
        //System.out.println(maxIndex + "," + s + "," + e);
		
		TreeNode root = new TreeNode(nums[maxIndex]);
		root.left = construct(nums, s, maxIndex - 1);
		root.right = construct(nums, maxIndex + 1, e);
		
		return root;
	}
}
