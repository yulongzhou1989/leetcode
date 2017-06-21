package leetcode.BST;

import java.util.Stack;

public class VerifyPreorderSequenceInBinarySearchTree_255 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = new int [] {9,2,1,3,11,10,12};
		System.out.println(verifyPreorder(arr));
	}
	
	//O1 space
	public static boolean verifyPreorder(int[] preorder) {
		int low = Integer.MIN_VALUE;
		int i=-1;
		for(int p:preorder){
			if(p<low)
				return false;
			while(i>=0 && p>preorder[i]){
				low = preorder[i--];//use index mock stack
			}
			preorder[++i] = p;
		}
		
		return true;
    }
	
	//On space
	public boolean verifyPreorder1(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
		int low = Integer.MIN_VALUE;
		for(int p:preorder){
			if(p<low)
				return false;
			while(!stack.isEmpty() && p>stack.peek()){
				low = stack.pop();
			}
			stack.push(p);
		}
		
		return true;
    }
}
