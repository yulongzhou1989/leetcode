package leetcode.treesAndGraphs;

import common.TreeLinkNode;

public class PopulatingNextRightPointersInEachNodeII_117 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void connect(TreeLinkNode root) {
		//horizental iterate tree, tempChild is keeping the head of next row 
		TreeLinkNode tempChild = new TreeLinkNode(0);
		while(root!=null){
			TreeLinkNode currChild = tempChild;
			while(root!=null){
				if(root.left!=null){
					currChild.next = root.left;
					currChild = currChild.next;
				}
				if(root.right!=null){
					currChild.next = root.right;
					currChild = currChild.next;
				}
				root = root.next;
			}
			//switch to next line
			root = tempChild.next;
			//the same function with new TreeLinkNode(0)
			tempChild.next = null;
		}
    }

}
