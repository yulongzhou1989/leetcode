package leetcode.graph;

import java.util.HashMap;

import common.UndirectedGraphNode;

public class CloneGraph_133_google {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		return dfs(node);
    }
	
	private UndirectedGraphNode dfs(UndirectedGraphNode node){
		if(node==null) return null;
		if(map.containsKey(node.label)) return map.get(node.label);
		UndirectedGraphNode cur = new UndirectedGraphNode(node.label);
		map.put(cur.label, cur);
		for(UndirectedGraphNode neighbor: node.neighbors){
			cur.neighbors.add(dfs(neighbor));
		}
		
		return cur;
	}

}
