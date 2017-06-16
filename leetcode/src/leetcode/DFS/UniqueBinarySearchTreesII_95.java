package leetcode.DFS;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

public class UniqueBinarySearchTreesII_95 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//reference leetcode 96
	public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<>();
        return generate(1,n);
    }
	
	private List<TreeNode> generate(int start, int end){
		List<TreeNode> list = new ArrayList<>();
		if(start>end) {
			list.add(null);
			return list;
		}
		
		for(int i=start;i<=end;i++){
			List<TreeNode> leftSide = generate(start, i-1);
			List<TreeNode> rightSide = generate(i+1, end);
			for(TreeNode left:leftSide){
				for(TreeNode right:rightSide){
					TreeNode node = new TreeNode(i);
					node.left = left;
					node.right = right;
					list.add(node);
				}
			}
		}
		
		return list;
	}

}
