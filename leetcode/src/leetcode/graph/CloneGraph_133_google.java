package leetcode.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import common.UndirectedGraphNode;

public class CloneGraph_133_google {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if(node==null) return node;
		if(map.containsKey(node.label)) return map.get(node.label);
		UndirectedGraphNode cur = new UndirectedGraphNode(node.label);
        map.put(node.label, cur);
		for(UndirectedGraphNode n:node.neighbors){
			cur.neighbors.add(cloneGraph(n));
		}
		return cur;
    }
    
    
    //BFS
    public UndirectedGraphNode cloneGraph1(UndirectedGraphNode node) {
		if(node==null) return node;
		HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
		Queue<UndirectedGraphNode> queue = new LinkedList<>();
		queue.offer(node);//initial the queue
        UndirectedGraphNode res = new UndirectedGraphNode(node.label);
		map.put(node.label, res);
		
		while(!queue.isEmpty()){
			UndirectedGraphNode n = queue.poll();
			for(UndirectedGraphNode neighbor: n.neighbors){//create each node and save into map
				if(!map.containsKey(neighbor.label)){//avoid infinite loop
					UndirectedGraphNode cur = new UndirectedGraphNode(neighbor.label);
					map.put(cur.label, cur);
					queue.offer(neighbor);
				}
				//add 
				map.get(n.label).neighbors.add(map.get(neighbor.label));
			}
		}
		
		return res;
    }

}
