package leetcode.treesAndGraphs;

import common.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length-1, inorder, preorder);
    }
    
    // Preorder traversing implies that PRE[0] is the root node.
    // Then we can find this PRE[0] in IN, say it's IN[5].
    // Now we know that IN[5] is root, so we know that IN[0] - IN[4] is on the left side, IN[6] to the end is on the right side.
    private TreeNode helper(int pre, int inStart, int inEnd, int [] inorder, int [] preorder){
        if(pre>=preorder.length || inStart>inEnd) return null;
        TreeNode root = new TreeNode(preorder[pre]);
        int inIndex=0;
        for(int i=inStart;i<=inEnd;i++){
            if(inorder[i] == root.val)
                inIndex = i;
        }
        root.left = helper(pre+1, inStart, inIndex-1, inorder, preorder);
        root.right = helper(pre+inIndex-inStart+1, inIndex+1, inEnd, inorder, preorder);
        
        return root;
    }

}
