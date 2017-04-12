package leetcode.treesAndGraphs;

import common.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostOrderTraversal_106 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(0,postorder.length-1, 0, inorder.length-1, inorder, postorder);
    }
    
    public TreeNode helper(int pStart, int pEnd, int inStart, int inEnd, int [] inorder, int [] postorder){
        if(pStart>pEnd) return null;
        TreeNode tn = new TreeNode(postorder[pEnd]);
        int inIndex = 0;
        for(int i=inStart;i<=inEnd;i++){
            if(tn.val == inorder[i]){
                inIndex = i;
                break;
            }
        }
        
        tn.right = helper(pEnd-inEnd+inIndex,pEnd-1, inIndex+1, inEnd, inorder, postorder);
        tn.left = helper(pStart,pStart+inIndex-inStart-1, inStart, inIndex-1, inorder, postorder);
        return tn;
    }
}
