package leetcode.treesAndGraphs;

public class VerifyPreorderSerializationOfABinaryTree_google_331 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isValidSerialization(String preorder) {
        if(preorder==null || preorder.length()==0) return false;
		//get nodes
		String [] nodes = preorder.split(",");
		int diff = 1;
		//when meet "#" check peek, if is "#", pop "#" and it's parent, if is not number, return false, else push"#"
		//every node has indegree and outdegree, node not has 2 outdegree and 1 indegree, null node has 0 outdegree and 1 indegree
		for(String node:nodes){
			if(--diff<0) return false;
			if(!node.equals("#")) diff += 2;
		}
		
		return diff == 0;
    }
}
