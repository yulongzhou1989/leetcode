package leetcode.design;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

public class SerializeAndDeserializeBST_449 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public class Codec {

	    final Character sper = ',';
		StringBuilder sb;
		
		// Encodes a tree to a single string.
	    public String serialize(TreeNode root) {
			sb = new StringBuilder();
			postOrder(root);
			System.out.println(sb.toString());
			return sb.toString();
	    }

	    // Decodes your encoded data to tree.
	    public TreeNode deserialize(String data) {
			List<Integer> list = new ArrayList<>();
	        for(int i=0;i<data.length();i++){
				if(data.charAt(i) == sper) continue;
				int num = 0;
				while(i<data.length() && Character.isDigit(data.charAt(i))){
					num = num*10 + (data.charAt(i)-'0');
					i++;
				}
				list.add(num);
			}
			
			//System.out.println(Arrays.toString(list.toArray()));
			return deserialize(list, 0, list.size()-1);
	    }
		
		private TreeNode deserialize(List<Integer> list, int start, int end){
			if(start > end) return null;
			if(start == end) return new TreeNode(list.get(start));
			//System.out.println("start:"+start+", end:"+end);
			TreeNode node = new TreeNode(list.get(start));
			int i=start+1;
			while(i<=end && list.get(i)<list.get(start)){
				i++;
			}
			node.left = deserialize(list, start+1, i-1);
			node.right = deserialize(list, i, end);
			return node;
		}
		
		private void postOrder(TreeNode root){
			if(root==null) return;
			sb.append(root.val);
			sb.append(sper);
			if(root.left!=null) postOrder(root.left);
			if(root.right!=null) postOrder(root.right);
		}
	}

}
