package leetcode.treesAndGraphs;

import common.TreeNode;

public class ConvertSortedArrayToBianrySearchTree_108 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
    
    private TreeNode helper(int [] nums, int start, int end){
        if(start > end) return null;
        int mid = (start+end)/2;
        TreeNode tr = new TreeNode(nums[mid]);
        tr.left = mid>start?helper(nums, start, mid-1):null;
        tr.right = mid<end?helper(nums, mid+1, end):null;
        return tr;
    }
}
