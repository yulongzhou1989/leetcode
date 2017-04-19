package leetcode.treesAndGraphs;

import common.TreeNode;

public class ConstructBinaryTreeFromString_536 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(str2tree("-4(2(3)(1))(6(5)(7))"));
	}
	
	public static TreeNode str2tree(String s) {
		if(s.length()==0) return null;
		//get root val
		StringBuilder sb = new StringBuilder();
		int i=0;
		//if is number
		while(i<s.length() && (s.charAt(i) == '-' || (s.charAt(i)-'0'>=0 && s.charAt(i)-'0'<=9))){
			sb.append(s.charAt(i++));
		}
		int rootVal = Integer.valueOf(sb.toString());
		TreeNode n = new TreeNode(rootVal);
		//get left tree end index
		int parenDegree = 1, j=i+1;
		while(j<s.length() && parenDegree>0){
			if(s.charAt(j) == '(') parenDegree ++;
			else if(s.charAt(j) == ')') parenDegree --;
			j++;
		}
		
		n.left = i+1<s.length()?str2tree(s.substring(i+1,j-1)):null;
		n.right = j+1<s.length()?str2tree(s.substring(j+1, s.length()-1)):null;
		
		return n;
    }

}
