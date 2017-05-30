package leetcode.DFS;

import common.TreeLinkNode;

public class PopulatingNextRightPointersInEachNode_116 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void connect(TreeLinkNode root) {
        if(root==null) return;
        if(root.left!=null){
            root.left.next = root.right;
            if(root.next!=null)
                root.right.next= root.next.left;
        }
        connect(root.left);
        connect(root.right);
    }
}
